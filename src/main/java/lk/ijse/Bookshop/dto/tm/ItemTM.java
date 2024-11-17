package lk.ijse.Bookshop.dto.tm;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ItemTM {
    private String Item_Id;
    private String Item_Name;
    private Integer Qty;
    private Double Price;
}
