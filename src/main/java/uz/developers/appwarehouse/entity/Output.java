package uz.developers.appwarehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.developers.appwarehouse.entity.Supplier;
import uz.developers.appwarehouse.entity.Warehouse;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Output {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp date;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Currency currency;

    private String factureNumber;

    @Column(unique = true,nullable = false)
    private String code;





}
