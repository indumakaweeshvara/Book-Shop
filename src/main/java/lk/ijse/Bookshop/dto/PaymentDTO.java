package lk.ijse.Bookshop.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private String paymentId;
    private double amount;
    private int contact;
    private LocalDate paymentDate;
    private String orderId;
}
