package sit.int202.toabin_quiz3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//Teeradet Panklai 63130500061
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "accounts")
@Entity
public class Account {
    @Id
    @NonNull
    @Column(name = "mobile_no")
    private String mobileNo;

    @NonNull
    @Column(name = "pin_code")
    private String pinCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_buy")
    private Date lastBuy;

    @NonNull
    @Column(name = "total_amount")
    private int totalAmount;

    @OneToMany(mappedBy = "accountNo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @Override
    public String toString() {
        return "Account{" +
                "mobileNo='" + mobileNo + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", lastBuy=" + lastBuy +
                ", totalAmount=" + totalAmount +
                ", transactions=" + transactions +
                '}';
    }
}