package uz.developers.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.appwarehouse.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
