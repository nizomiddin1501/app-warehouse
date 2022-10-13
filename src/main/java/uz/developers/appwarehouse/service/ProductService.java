package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.Input;
import uz.developers.appwarehouse.entity.Product;
import uz.developers.appwarehouse.payload.ProductDto;
import uz.developers.appwarehouse.payload.Result;

import java.util.List;

public interface ProductService {


    //get all
    List<Product> getProducts();

    //get by id
    Product getProduct(Integer id);

    //post
    Result addProduct(ProductDto productDto);

    //put
    Result editProduct(Integer id, ProductDto productDto);

    //delete
    Result deleteProduct(Integer id);
}
