package lk.ijse.tdm;

import jakarta.persistence.*;
import lk.ijse.entity.Registration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PaymentTM {

    private int paymentId;
    private int registrationId;
    private double amount;
    private Date paymentDate;
    private String paymentMethod;
}
