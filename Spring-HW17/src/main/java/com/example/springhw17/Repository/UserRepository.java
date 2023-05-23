package com.example.springhw17.Repository;

import com.example.springhw17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {



    User findUserByUsernameAndPassword(String username,String password);

    User findUserByEmail(String email);

    @Query("select s from User s where s.role =?1 ")
    List<User> pleaseGetUser(String role);

    @Query("select s from User s where  s.age >= ?1")
    List<User> pleaseGetUserByAge(Integer age);


}
