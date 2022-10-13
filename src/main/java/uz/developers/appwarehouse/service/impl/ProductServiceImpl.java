package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.Attachment;
import uz.developers.appwarehouse.entity.Category;
import uz.developers.appwarehouse.entity.Measurement;
import uz.developers.appwarehouse.entity.Product;
import uz.developers.appwarehouse.payload.ProductDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.repository.AttachmentRepository;
import uz.developers.appwarehouse.repository.CategoryRepository;
import uz.developers.appwarehouse.repository.MeasurementRepository;
import uz.developers.appwarehouse.repository.ProductRepository;
import uz.developers.appwarehouse.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;

    @Override
    public List<Product> getProducts() {
       return productRepository.findAll();
    }

    @Override
    public Product getProduct(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return new Product();
    }

    @Override
    public Result addProduct(ProductDto productDto) {
        boolean exists = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (exists) {
            return new Result("There is such product in this category", false);
        }

        //categoryni tekshirish
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new Result("There is not such category", false);
        }

        //photoni tekshirish
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (optionalAttachment.isEmpty()) {
            return new Result("There is not such photo", false);
        }

        //measurementga tekshirish
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (optionalMeasurement.isEmpty()) {
            return new Result("There is not such measurement", false);
        }

        //todo code ni generatsiya qilish kerak;
        boolean existsByCode = productRepository.existsByCode(productDto.getCode());
        if (existsByCode) {
            return new Result("Such code ever been exist", false);
        }

        // saqlash

        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode(productDto.getCode());
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());

        productRepository.save(product);
        return new Result("Product is saved", true);

    }

    @Override
    public Result editProduct(Integer id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return new Result("Such product is not found", false);
        }

        boolean existsByCode = productRepository.existsByCode(productDto.getCode());
        if (existsByCode) {
            return new Result("Product is already exist", false);
        }

        Product editedProduct = optionalProduct.get();
        editedProduct.setName(productDto.getName());
        editedProduct.setCode(productDto.getCode());

        productRepository.save(editedProduct);
        return new Result("Product is edited",true);


    }

    @Override
    public Result deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return new Result("Product is deleted",true);
    }
}
