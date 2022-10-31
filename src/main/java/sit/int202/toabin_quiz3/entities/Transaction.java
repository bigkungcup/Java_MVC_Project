package sit.int202.toabin_quiz3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
//Teeradet Panklai 63130500061
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "transactions")
@NamedQueries({
        @NamedQuery(name = "Transaction.FindByAccount",query = "SELECT t FROM Transaction t WHERE t.accountNo = :param ORDER BY t.tranDate ASC")
})
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tran_date")
    private Date tranDate;

    private int qty;

    private int price;

    private int amount;

    @ManyToOne
    @JoinColumn(name = "accounts_mobile_no")
    private Account accountNo;

    @ManyToOne
    @JoinColumn(name = "drink_id")
    private Drink drinkId;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", tranDate=" + tranDate +
                ", qty=" + qty +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}