package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.Currency;
import uz.developers.appwarehouse.entity.Input;
import uz.developers.appwarehouse.entity.Supplier;
import uz.developers.appwarehouse.entity.Warehouse;
import uz.developers.appwarehouse.payload.InputDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.CurrencyRepository;
import uz.developers.appwarehouse.repository.InputRepository;
import uz.developers.appwarehouse.repository.SupplierRepository;
import uz.developers.appwarehouse.repository.WarehouseRepository;
import uz.developers.appwarehouse.service.InputService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InputServiceImpl implements InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;


    @Override
    public List<Input> getInputes() {
       return inputRepository.findAll();
    }

    @Override
    public Input getInput(Integer id) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (optionalInput.isPresent()) {
          return optionalInput.get();
        }
        return new Input();
    }

    @Override
    public Result addInput(InputDto inputDto) {
        Input input = new Input();
        input.setDate(inputDto.getDate());

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if (optionalWarehouse.isEmpty()) {
            return new Result("Such warehouse is not found",false);
        }
        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (optionalSupplier.isEmpty()) {
            return new Result("Such supplier is not found",false);
        }
        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (optionalCurrency.isEmpty()) {
            return new Result("Such currency is not found",false);
        }
        boolean existsByCode = inputRepository.existsByCode(inputDto.getCode());
        if (existsByCode) {
            return new Result("Such input already exist",false);
        }

        input.setWarehouse(optionalWarehouse.get());
        input.setSupplier(optionalSupplier.get());
        input.setCurrency(optionalCurrency.get());

        input.setFactureNumber(inputDto.getFactureNumber());
        input.setCode(inputDto.getCode());

        inputRepository.save(input);
        return new Result("Input is saved",true);
    }

    @Override
    public Result editInput(Integer id, InputDto inputDto) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (optionalInput.isEmpty()) {
            return new Result("Such Input is not found",false);
        }
        boolean existsByCode = inputRepository.existsByCode(inputDto.getCode());
        if (existsByCode) {
            return new Result("Such input already exist",false);
        }
        Input input = optionalInput.get();
        input.setDate(inputDto.getDate());
        input.setFactureNumber(inputDto.getFactureNumber());
        input.setCode(inputDto.getCode());

        inputRepository.save(input);
        return new Result("Input is edited",true);
    }

    @Override
    public Result deleteInput(Integer id) {
       inputRepository.deleteById(id);
        return new Result("Input is deleted",true);
    }
}
