package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.Currency;
import uz.developers.appwarehouse.entity.Input;
import uz.developers.appwarehouse.payload.InputDto;
import uz.developers.appwarehouse.payload.Result;

import java.util.List;

public interface InputService {

    //get all
    List<Input> getInputes();

    //get
    Input getInput(Integer id);

    //post
    Result addInput(InputDto inputDto);

    //put
    Result editInput(Integer id, InputDto inputDto);

    //delete
    Result deleteInput(Integer id);
}
