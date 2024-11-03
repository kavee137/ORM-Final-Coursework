package lk.ijse.dto;

import lk.ijse.entity.User;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class StudentDTO {
    private int studentId;
    private String name;
    private String address;
    private String phone;
    private Date regDate;
    private User user;
}
