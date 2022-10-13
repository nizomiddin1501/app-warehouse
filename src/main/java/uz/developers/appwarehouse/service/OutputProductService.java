package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.Output;
import uz.developers.appwarehouse.entity.OutputProduct;
import uz.developers.appwarehouse.payload.OutputProductDto;
import uz.developers.appwarehouse.payload.Result;

import java.util.List;

public interface OutputProductService {


    //get all
    List<OutputProduct> getOutputProducts();

    //get by id
    OutputProduct getOutputProduct(Integer id);

    //post
    Result addOutputProduct(OutputProductDto outputProductDto);

    //put
    Result editOutputProduct(Integer id, OutputProductDto outputProductDto);

    //delete
    Result deleteOutputProduct(Integer id);
}
