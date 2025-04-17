package sakhno.springframework.ms_store_two_order_service.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "customer_line")
public class OrderLineEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    private Integer productId;
    private double quantity;
}
