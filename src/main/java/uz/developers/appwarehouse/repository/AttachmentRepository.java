package uz.developers.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.appwarehouse.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {


}
