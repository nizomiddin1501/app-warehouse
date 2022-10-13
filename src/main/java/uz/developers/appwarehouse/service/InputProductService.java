package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.Input;
import uz.developers.appwarehouse.entity.InputProduct;
import uz.developers.appwarehouse.payload.InputProductDto;
import uz.developers.appwarehouse.payload.Result;

import java.util.List;

public interface InputProductService {


    //get by id
    InputProduct getInputProduct(Integer id);

    //get all
    List<InputProduct> getInputProducts();

    //post
    Result addInputProduct(InputProductDto inputProductDto);

    //put
    Result editInputProduct(Integer id, InputProductDto inputProductDto);

    //delete
    Result deleteInputProduct(Integer id);
}
