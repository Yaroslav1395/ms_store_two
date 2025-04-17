package sakhno.springframework.ms_store_two_notification_service.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import sakhno.springframework.ms_store_two_notification_service.kafka.order.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentSuccessEmail(String destinationEmail, String customerName, BigDecimal amount, String orderReference) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, UTF_8.name());
        helper.setFrom("sakhno.yaroslav.13.95@gmail.com");
        final String templateName = EmailTemplates.PAYMENT_CONFIRMATION.getTemplateName();

        Map<String, Object> data = new HashMap<>();
        data.put("customerName", customerName);
        data.put("amount", amount);
        data.put("orderReference", orderReference);

        Context context = new Context();
        context.setVariables(data);
        helper.setSubject(EmailTemplates.PAYMENT_CONFIRMATION.getSubject());
        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            helper.setText(htmlTemplate, true);
            helper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info(String.format("INFO - Email successfully sent to %s with template %s", destinationEmail, templateName));
        }catch (MessagingException e) {
            log.warn("WARNING - Cannot send email to {} with template {}", destinationEmail, templateName);

        }
    }

    @Async
    public void sendOrderConfirmationEmail(String destinationEmail, String customerName, BigDecimal amount,
                                           String orderReference, List<Product> products) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, UTF_8.name());
        helper.setFrom("sakhno.yaroslav.13.95@gmail.com");
        final String templateName = EmailTemplates.ORDER_CONFIRMATION.getTemplateName();

        Map<String, Object> data = new HashMap<>();
        data.put("customerName", customerName);
        data.put("totalAmount", amount);
        data.put("orderReference", orderReference);
        data.put("products", products);

        Context context = new Context();
        context.setVariables(data);
        helper.setSubject(EmailTemplates.ORDER_CONFIRMATION.getSubject());
        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            helper.setText(htmlTemplate, true);
            helper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info(String.format("INFO - Email successfully sent to %s with template %s", destinationEmail, templateName));
        }catch (MessagingException e) {
            log.warn("WARNING - Cannot send email to {} with template {}", destinationEmail, templateName);
        }
    }
}
