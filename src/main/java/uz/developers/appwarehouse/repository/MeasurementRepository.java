package uz.developers.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.appwarehouse.entity.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {

    boolean existsByName(String name);

}
