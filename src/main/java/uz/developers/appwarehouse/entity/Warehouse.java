package uz.developers.appwarehouse.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.developers.appwarehouse.entity.template.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Warehouse extends AbsEntity {



}
