package uz.developers.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.appwarehouse.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    boolean existsByNameAndCategoryId(String name, Integer category_id);

    boolean existsByCode(String code);
}
