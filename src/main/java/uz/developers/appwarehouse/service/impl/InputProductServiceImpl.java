package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.Input;
import uz.developers.appwarehouse.entity.InputProduct;
import uz.developers.appwarehouse.entity.Product;
import uz.developers.appwarehouse.payload.InputProductDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.InputProductRepository;
import uz.developers.appwarehouse.repository.InputRepository;
import uz.developers.appwarehouse.repository.ProductRepository;
import uz.developers.appwarehouse.service.InputProductService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InputProductServiceImpl implements InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;

    @Override
    public InputProduct getInputProduct(Integer id) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (optionalInputProduct.isPresent()) {
            return optionalInputProduct.get();
        }
        return new InputProduct();
    }

    @Override
    public List<InputProduct> getInputProducts() {
        return inputProductRepository.findAll();
    }

    @Override
    public Result addInputProduct(InputProductDto inputProductDto) {
        InputProduct inputProduct = new InputProduct();
        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        if (optionalProduct.isEmpty()) {
            return new Result("Such product is not found", false);
        }
        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
        if (optionalInput.isEmpty()) {
            return new Result("Such input is not found", false);
        }
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setExpireDate(inputProductDto.getExpireDate());

        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setInput(optionalInput.get());

        inputProductRepository.save(inputProduct);
        return new Result("InputProduct is saved", true);
    }

    @Override
    public Result editInputProduct(Integer id, InputProductDto inputProductDto) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (optionalInputProduct.isEmpty()) {
            return new Result("Such InputProduct is not found",false);
        }
        InputProduct inputProduct = optionalInputProduct.get();
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setExpireDate(inputProductDto.getExpireDate());

        inputProductRepository.save(inputProduct);
        return new Result("InputProduct is edited",true);
    }

    @Override
    public Result deleteInputProduct(Integer id) {
        inputProductRepository.deleteById(id);
        return new Result("InputProduct is deleted",true);
    }
}
