package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.Warehouse;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.WarehouseRepository;
import uz.developers.appwarehouse.service.WarehouseService;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;

    @Override
    public List<Warehouse> getWarehouses() {
       return warehouseRepository.findAll();
    }

    @Override
    public Warehouse getWarehouse(Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()) {
            return optionalWarehouse.get();
        }
        return new Warehouse();
    }

    @Override
    public Result addWarehouse(Warehouse warehouse) {
        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName) {
            return new Result("Such warehouse is already exist",false);
        }
        warehouseRepository.save(warehouse);
        return new Result("Warehouse is saved",true);
    }

    @Override
    public Result editWarehouse(Integer id, Warehouse warehouse) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isEmpty()) {
            return new Result("Warehouse is not found",false);
        }
        Warehouse editedWarehouse = optionalWarehouse.get();
        editedWarehouse.setName(warehouse.getName());
        warehouseRepository.save(editedWarehouse);
        return new Result("Warehouse is edited",true);
    }

    @Override
    public Result deleteWarehouse(Integer id) {
        warehouseRepository.deleteById(id);
        return new Result("Warehouse is deleted",true);
    }
}
