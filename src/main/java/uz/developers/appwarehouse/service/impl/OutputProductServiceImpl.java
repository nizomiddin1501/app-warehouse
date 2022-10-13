package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.Output;
import uz.developers.appwarehouse.entity.OutputProduct;
import uz.developers.appwarehouse.entity.Product;
import uz.developers.appwarehouse.payload.OutputProductDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.OutputProductRepository;
import uz.developers.appwarehouse.repository.OutputRepository;
import uz.developers.appwarehouse.repository.ProductRepository;
import uz.developers.appwarehouse.service.OutputProductService;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductServiceImpl implements OutputProductService {

    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputRepository outputRepository;

    @Override
    public List<OutputProduct> getOutputProducts() {
       return outputProductRepository.findAll();
    }

    @Override
    public OutputProduct getOutputProduct(Integer id) {
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (optionalOutputProduct.isPresent()) {
            return optionalOutputProduct.get();
        }
        return new OutputProduct();
    }

//    private Integer productId;
//    private Double amount;
//    private Double price;
//    private Integer outputId;
    @Override
    public Result addOutputProduct(OutputProductDto outputProductDto) {
        OutputProduct savedOutputProduct = new OutputProduct();

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getOutputId());
        if (optionalProduct.isEmpty()) {
            return new Result("Such product is not found",false);
        }
        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (optionalOutput.isEmpty()) {
            return new Result("Such output is not found",false);
        }
        savedOutputProduct.setProduct(optionalProduct.get());
        savedOutputProduct.setAmount(outputProductDto.getAmount());
        savedOutputProduct.setPrice(outputProductDto.getPrice());
        savedOutputProduct.setOutput(optionalOutput.get());

        outputProductRepository.save(savedOutputProduct);

        return new Result("OutputProduct is saved",true);


    }

    @Override
    public Result editOutputProduct(Integer id, OutputProductDto outputProductDto) {
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (optionalOutputProduct.isEmpty()) {
            return new Result("OutputProduct is not found",false);
        }
        OutputProduct editedOutputProduct = optionalOutputProduct.get();
        editedOutputProduct.setAmount(outputProductDto.getAmount());
        editedOutputProduct.setPrice(outputProductDto.getPrice());

        outputProductRepository.save(editedOutputProduct);
        return new Result("OutputProduct is edited",true);
    }

    @Override
    public Result deleteOutputProduct(Integer id) {
        outputProductRepository.deleteById(id);
        return new Result("OutputProduct is deleted",true);
    }
}
