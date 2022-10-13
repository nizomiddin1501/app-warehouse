package uz.developers.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.appwarehouse.entity.Input;
import uz.developers.appwarehouse.entity.Output;
import uz.developers.appwarehouse.payload.InputDto;
import uz.developers.appwarehouse.payload.OutputDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {

    @Autowired
    OutputService outputService;


    @GetMapping
    public List<Output> getOutputs(){
        return outputService.getOutputs();
    }
    @GetMapping("/{id}")
    public Output getOutput(@PathVariable Integer id){
        return outputService.getOutput(id);
    }

    @PostMapping
    public Result addOutput(@RequestBody OutputDto outputDto){
        return outputService.addOutput(outputDto);
    }

    @PutMapping("/{id}")
    public Result editOutput(@PathVariable Integer id, @RequestBody OutputDto outputDto){
        return outputService.editOutput(id,outputDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteOutput(@PathVariable Integer id){
        return outputService.deleteOutput(id);
    }


}
