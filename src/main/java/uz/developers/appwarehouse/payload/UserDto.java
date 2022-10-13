package uz.developers.appwarehouse.payload;

import lombok.Data;
import uz.developers.appwarehouse.entity.Warehouse;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
public class UserDto {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String code;

    private String password;

    private Set<Warehouse> warehouses;
}
