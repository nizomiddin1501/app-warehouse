package uz.developers.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.appwarehouse.entity.Input;
import uz.developers.appwarehouse.entity.User;
import uz.developers.appwarehouse.payload.InputDto;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.payload.UserDto;
import uz.developers.appwarehouse.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping
    public Result addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @PutMapping("/{id}")
    public Result editUser(@PathVariable Integer id, @RequestBody UserDto userDto){
        return userService.editUser(id,userDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }






}
