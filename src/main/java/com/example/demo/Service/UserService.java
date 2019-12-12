package com.example.demo.Service;

import com.example.demo.Entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface UserService {

    /****************************create*****************************************/

    User save(User user);

    /****************************read*****************************************/

    List<User> findByUserNameAndAge(String userName,int age);

    Optional <User> findById(Long id);

    List<User> findByDateOfBirth(LocalDate date);

    List<User> findAll();

    /*****************************update****************************************/

    int updateUserNameById(String userName, Long id);

    /*****************************delete****************************************/

    void deleteById(Long id);

}