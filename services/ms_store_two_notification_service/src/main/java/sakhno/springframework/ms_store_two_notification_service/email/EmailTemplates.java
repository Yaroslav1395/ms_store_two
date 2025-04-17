package sakhno.springframework.ms_store_two_notification_service.email;

import lombok.Getter;

@Getter
public enum EmailTemplates {
    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment successfully processed"),
    ORDER_CONFIRMATION("order-confirmation.html", "Order successfully processed");

    private final String templateName;
    private final String subject;

    EmailTemplates(String templateName, String subject) {
        this.templateName = templateName;
        this.subject = subject;
    }
}
