package uz.developers.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.appwarehouse.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

    boolean existsByName(String name);

    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Integer id);

    boolean existsByNameAndIdNot(String name, Integer id);





}
