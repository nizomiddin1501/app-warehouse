package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.Input;
import uz.developers.appwarehouse.entity.Output;
import uz.developers.appwarehouse.payload.OutputDto;
import uz.developers.appwarehouse.payload.Result;

import java.util.List;

public interface OutputService {

    //get all
    List<Output> getOutputs();

    //get by id
    Output getOutput(Integer id);

    //post
    Result addOutput(OutputDto outputDto);

    //put
    Result editOutput(Integer id, OutputDto outputDto);

    //delete
    Result deleteOutput(Integer id);
}
