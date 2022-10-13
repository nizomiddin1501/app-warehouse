package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.Warehouse;
import uz.developers.appwarehouse.payload.Result;

import java.util.List;

public interface WarehouseService {

    //get all
    List<Warehouse> getWarehouses();

    //get by id
    Warehouse getWarehouse(Integer id);

    //post
    Result addWarehouse(Warehouse warehouse);

    //put
    Result editWarehouse(Integer id, Warehouse warehouse);

    //delete
    Result deleteWarehouse(Integer id);
}
