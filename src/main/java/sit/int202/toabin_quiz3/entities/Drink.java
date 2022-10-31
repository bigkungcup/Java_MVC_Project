package sit.int202.toabin_quiz3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drink ;

    @Enumerated(EnumType.STRING)
    @Column(name="drink_type")
    private DrinkType drinkType ;

    private Integer price ;

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", drink='" + drink + '\'' +
                ", drinkType='" + drinkType + '\'' +
                ", price=" + price +
                '}';
    }
}

