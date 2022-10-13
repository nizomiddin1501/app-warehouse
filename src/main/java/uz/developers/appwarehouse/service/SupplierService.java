package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.Supplier;
import uz.developers.appwarehouse.payload.Result;

import java.util.List;

public interface SupplierService {



    //get all
    List<Supplier> getSuppliers();

    //get by id
    Supplier getSupplier(Integer id);

    //post
    Result addSupplier(Supplier supplier);

    //put
    Result editSupplier(Integer id, Supplier supplier);

    //delete
    Result deleteSupplier(Integer id);
}
