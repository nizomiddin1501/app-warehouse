package uz.developers.appwarehouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.appwarehouse.entity.User;
import uz.developers.appwarehouse.payload.Result;
import uz.developers.appwarehouse.payload.UserDto;
import uz.developers.appwarehouse.repository.UserRepository;
import uz.developers.appwarehouse.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getUsers() {
       return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return new User();
    }

    @Override
    public Result addUser(UserDto userDto) {
        User savedUser = new User();
        //todo userDto dan keladigan warehouseId listini generatsiya qilish kerak
        //todo put da ham
        return null;
    }

//    private String firstName;
//    private String lastName;
//    private String phoneNumber;
//    private String code;
//    private String password;
//    private Integer warehouseId;
    @Override
    public Result editUser(Integer id, UserDto userDto) {
        return null;
    }

    @Override
    public Result deleteUser(Integer id) {
        userRepository.deleteById(id);
        return new Result("User is deleted",true);
    }
}
