package hibernate_rachunek;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

//- dataDodania
//- nazwaKlienta
//- czyOpłacony
//- dataWydania
//- dataIGodzinaOpłacenia
//- kwotaNaRachunku (suma wartości produktów)
//- zbiór produktów (relacja bazodanowa - osobna tabela)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice implements IBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    @Column(name = "dateOfCreation")
    private LocalDateTime DateOfCreation;

    @Column(nullable = false)
    private String clientName;

    @Column(name ="ifPaid", nullable = false, columnDefinition = "tinyint default 0")
    private boolean ifPaid;

    private LocalDateTime dataOfRelease;
    private LocalDateTime dataOfPayment;

    @Formula(value = "(SELECT SUM(p.price * p.stock) from priduct p where p.invoice_id = id")
    private Double billValue;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    private Set<Product> productList;

}
