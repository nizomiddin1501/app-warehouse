package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.Supplier;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.SupplierRepository;
import uz.developers.appwarehouse.service.SupplierService;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;


    @Override
    public List<Supplier> getSuppliers() {
       return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplier(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            return optionalSupplier.get();
        }
        return new Supplier();
    }

    @Override
    public Result addSupplier(Supplier supplier) {
        boolean existsByName = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (existsByName) {
            return new Result("Such supplier already exist",false);
        }
        Supplier savedSupplier = new Supplier();
        savedSupplier.setName(supplier.getName());
        savedSupplier.setPhoneNumber(supplier.getPhoneNumber());

        supplierRepository.save(savedSupplier);
        return new Result("Supplier is saved",true);

    }

    @Override
    public Result editSupplier(Integer id, Supplier supplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isEmpty()) {
            return new Result("Such supplier is not found",false);
        }
        boolean exists = supplierRepository.existsByPhoneNumberAndIdNot(supplier.getPhoneNumber(), supplier.getId());
        if (exists) {
            return new Result("Such supplier already exist",false);
        }

        Supplier editedSupplier = optionalSupplier.get();
        editedSupplier.setName(supplier.getName());
        editedSupplier.setPhoneNumber(supplier.getPhoneNumber());

        supplierRepository.save(editedSupplier);
        return new Result("Supplier is edited",false);
    }

    @Override
    public Result deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
        return new Result("Supplier is deleted",true);
    }
}
