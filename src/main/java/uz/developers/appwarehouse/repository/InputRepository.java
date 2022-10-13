package uz.developers.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.appwarehouse.entity.Input;

public interface InputRepository extends JpaRepository<Input,Integer> {

    boolean existsByCode(String code);


}
