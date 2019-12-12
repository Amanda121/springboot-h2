package com.example.demo.Service.Impl;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


/**
 * @Description:
 * @author: Alan
 * @Date: 2018/12/1 11:44
 */
@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**************************create********************************/
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    /**************************read********************************/

    @Override
    public List<User> findByDateOfBirth(@Param("date") LocalDate date) {
        return userRepository.findByDateOfBirth(date);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List <User> findByUserNameAndAge(String userName, int age) {
        return userRepository.findByUserNameAndAge(userName,age);
    }

    @Override
    public Optional <User> findById(Long id) {
        return userRepository.findById(id);
    }


    /**************************update********************************/

    @Override
    public int updateUserNameById(String userName, Long id) {
        return userRepository.updateUserNameById(userName,id);
    }

    /**************************delete********************************/
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
