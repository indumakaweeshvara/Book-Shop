package lk.ijse.Bookshop.dto.tm;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UserTM {
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
