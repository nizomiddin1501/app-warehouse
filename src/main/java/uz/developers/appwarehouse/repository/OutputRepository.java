package uz.developers.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.appwarehouse.entity.Output;

public interface OutputRepository extends JpaRepository<Output,Integer> {

    boolean existsByCode(String code);



}
