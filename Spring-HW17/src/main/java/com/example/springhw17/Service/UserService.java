package com.example.springhw17.Service;

import com.example.springhw17.ApiException.ApiException;
import com.example.springhw17.Model.User;
import com.example.springhw17.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> getAllUser() {
        return userRepository.findAll();

    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, User user) {

        User oldUser = userRepository.getById(id);

        if (oldUser == null) {
            return false;
        }

        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        oldUser.setEmail(user.getEmail());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());

        userRepository.save(oldUser);
        return true;
    }

    public boolean deleteUser(Integer id) {
        User oldUser = userRepository.getById(id);

        if (oldUser == null) {
            return false;
        }
        userRepository.delete(oldUser);
        return true;
    }

    public User getUserByUserName(String username,String password){
        User user=userRepository.findUserByUsernameAndPassword(username,password);

        if (user==null){
            throw  new ApiException("username not found");
        }
        return user;
    }

    public User getUserByEmail(String email){
        User user=userRepository.findUserByEmail(email);

        if (user==null){
            throw new ApiException("email not found");
        }
        return user;
    }

    public List<User> getUserByRole(String role){
        List<User> users= userRepository.pleaseGetUser(role);

        if (users==null){
            throw new ApiException("role not found");
        }
        return users;
    }

    public List<User> getUserByAge(Integer age){
        List<User> users=userRepository.pleaseGetUserByAge(age);

        if (users==null){
            throw new ApiException("not found");
        }
        return users;
    }
}



