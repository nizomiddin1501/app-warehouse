package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.Warehouse;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.WarehouseRepository;
import uz.developers.appwarehouse.service.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;

    @Override
    public Result addWarehouseService(Warehouse warehouse) {
        return null;
    }
}
