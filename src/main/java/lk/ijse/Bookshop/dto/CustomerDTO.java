package lk.ijse.Bookshop.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDTO {
    private String Cust_Id;
    private String Cust_Name;
    private Integer Contact;
    private String Address;
    private String User_Id;
}
