package uz.developers.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.appwarehouse.entity.Output;
import uz.developers.appwarehouse.entity.OutputProduct;
import uz.developers.appwarehouse.payload.OutputDto;
import uz.developers.appwarehouse.payload.OutputProductDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.service.OutputProductService;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {

    @Autowired
    OutputProductService outputProductService;

    @GetMapping
    public List<OutputProduct> getOutputs(){
        return outputProductService.getOutputProducts();
    }
    @GetMapping("/{id}")
    public OutputProduct getOutputProduct(@PathVariable Integer id){
        return outputProductService.getOutputProduct(id);
    }

    @PostMapping
    public Result addOutputProduct(@RequestBody OutputProductDto outputProductDto){
        return outputProductService.addOutputProduct(outputProductDto);
    }

    @PutMapping("/{id}")
    public Result editOutputProduct(@PathVariable Integer id, @RequestBody OutputProductDto outputProductDto){
        return outputProductService.editOutputProduct(id,outputProductDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteOutputProduct(@PathVariable Integer id){
        return outputProductService.deleteOutputProduct(id);
    }

}
