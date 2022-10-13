package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.*;
import uz.developers.appwarehouse.payload.OutputDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.*;
import uz.developers.appwarehouse.service.OutputService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OutputServiceImpl implements OutputService {

    @Autowired
    OutputRepository outputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CurrencyRepository currencyRepository;


    @Override
    public List<Output> getOutputs() {
       return outputRepository.findAll();
    }

    @Override
    public Output getOutput(Integer id) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (optionalOutput.isPresent()) {
            return optionalOutput.get();
        }
        return new Output();
    }

//    private Timestamp date;
//    private Integer warehouseId;
//    private Integer supplierId;
//    private Integer clientId;
//    private Integer currencyId;
//    private String factureNumber;
//    private String code;
    @Override
    public Result addOutput(OutputDto outputDto) {
        Output savedOutput = new Output();
        savedOutput.setDate(outputDto.getDate());

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        if (optionalWarehouse.isEmpty()) {
            return new Result("Such warehouse is not found",false);
        }
        Optional<Supplier> optionalSupplier = supplierRepository.findById(outputDto.getSupplierId());
        if (optionalSupplier.isEmpty()) {
            return new Result("Such supplier is not found",false);
        }
        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (optionalClient.isEmpty()) {
            return new Result("Such client is not found",false);
        }
        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (optionalCurrency.isEmpty()) {
            return new Result("Such currency is not found",false);
        }

        boolean existsByCode = outputRepository.existsByCode(outputDto.getCode());
        if (existsByCode) {
            return new Result("Such output already exist",false);
        }

        savedOutput.setWarehouse(optionalWarehouse.get());
        savedOutput.setSupplier(optionalSupplier.get());
        savedOutput.setClient(optionalClient.get());
        savedOutput.setCurrency(optionalCurrency.get());

        savedOutput.setFactureNumber(outputDto.getFactureNumber());
        savedOutput.setCode(outputDto.getCode());

        outputRepository.save(savedOutput);
        return new Result("Output is saved",true);
    }

    @Override
    public Result editOutput(Integer id, OutputDto outputDto) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (optionalOutput.isEmpty()) {
            return new Result("Such output is not found",false);
        }
        boolean existsByCode = outputRepository.existsByCode(outputDto.getCode());
        if (existsByCode) {
            return new Result("Such output is already exist",false);
        }

        Output editedOutput = optionalOutput.get();
        editedOutput.setDate(outputDto.getDate());
        editedOutput.setFactureNumber(outputDto.getFactureNumber());
        editedOutput.setCode(outputDto.getCode());

        outputRepository.save(editedOutput);
        return new Result("Output is edited",true);
    }

    @Override
    public Result deleteOutput(Integer id) {
        outputRepository.deleteById(id);
        return new Result("Output is deleted",true);
    }
}
