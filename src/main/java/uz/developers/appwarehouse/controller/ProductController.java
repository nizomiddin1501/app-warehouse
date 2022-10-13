package uz.developers.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.appwarehouse.entity.Input;
import uz.developers.appwarehouse.entity.Product;
import uz.developers.appwarehouse.payload.InputDto;
import uz.developers.appwarehouse.payload.ProductDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
    }

    @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }
    @PutMapping("/{id}")
    public Result editProduct(@PathVariable Integer id, @RequestBody ProductDto productDto ){
        return productService.editProduct(id,productDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }
}
