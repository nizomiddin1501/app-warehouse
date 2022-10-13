package uz.developers.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.appwarehouse.entity.Currency;
import uz.developers.appwarehouse.entity.Input;
import uz.developers.appwarehouse.payload.InputDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.service.InputService;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;


    @GetMapping
    public List<Input> getInputs(){
        return inputService.getInputes();
    }
    @GetMapping("/{id}")
    public Input getInput(@PathVariable Integer id){
        return inputService.getInput(id);
    }

    @PostMapping
    public Result addInput(@RequestBody InputDto inputDto){
        return inputService.addInput(inputDto);
    }

    @PutMapping("/{id}")
    public Result editInput(@PathVariable Integer id, @RequestBody InputDto inputDto){
        return inputService.editInput(id,inputDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteInput(@PathVariable Integer id){
        return inputService.deleteInput(id);
    }





}
