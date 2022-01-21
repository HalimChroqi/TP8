package cigma.pfe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "TFactures")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Facture() {}

    public Facture(Date date, Double amount) {
        this.date = date;
        this.amount = amount;

    }

    @Column
    private Date date;

    @Column
    private Double amount;

    @Override
    public String toString() {
        return "Facture{" +
            "id=" + id +
            ", date='" + date + '\'' +
                ", amount='" + amount + '\'' +
            '}';
    }
}