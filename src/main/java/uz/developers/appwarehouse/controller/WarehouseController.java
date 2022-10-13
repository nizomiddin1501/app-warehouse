package uz.developers.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.developers.appwarehouse.entity.Warehouse;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @PostMapping
    public Result addWarehouseController(@RequestBody Warehouse warehouse){
        return warehouseService.addWarehouseService(warehouse);
    }
}
