package uz.developers.appwarehouse.service;

import uz.developers.appwarehouse.entity.User;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.payload.UserDto;

import java.util.List;

public interface UserService {


    //get all
    List<User> getUsers();

    //get by id
    User getUser(Integer id);

    //post
    Result addUser(UserDto userDto);

    //put
    Result editUser(Integer id, UserDto userDto);

    //delete
    Result deleteUser(Integer id);
}
