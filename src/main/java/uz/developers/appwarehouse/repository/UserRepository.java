package uz.developers.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.appwarehouse.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {



}
