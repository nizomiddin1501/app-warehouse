package uz.developers.appwarehouse.payload;

import lombok.Data;
import uz.developers.appwarehouse.entity.Currency;
import uz.developers.appwarehouse.entity.Supplier;
import uz.developers.appwarehouse.entity.Warehouse;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class InputDto {

    private LocalDateTime date;

    private Integer warehouseId;
    private Integer supplierId;
    private Integer currencyId;

    private String factureNumber;

    private String code;

}
