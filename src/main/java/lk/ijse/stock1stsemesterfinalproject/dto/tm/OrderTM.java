package lk.ijse.stock1stsemesterfinalproject.dto.tm;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class OrderTM {

    private String Order_Id;
    private String Description;
    private Integer Order_qty;
    private String Cust_Id;
}
