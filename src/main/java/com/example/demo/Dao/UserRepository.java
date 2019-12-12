package com.example.demo.Dao;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{

    /******************************create***************************************/
    @Override
    User save(User user);

    /******************************read***************************************/

    Optional <User> findById(Long id);

    @Query("select u from User u where u.userName = :userName and u.age = :age")
    List<User> findByUserNameAndAge(@Param("userName") String userName,
                                    @Param("age") int age);

    List<User> findByDateOfBirth(@Param("date") LocalDate date);

    @Override
    @Query(value = "select * from user",nativeQuery = true)
    List<User> findAll();

    /****************************update*****************************************/

    @Modifying
    @Query("update User u set u.userName = ?1 where u.id = ?2")
    int updateUserNameById(String userName, Long id);

    /****************************delete*****************************************/
    @Override
    @Modifying
    @Query(value = "delete from user where id = ?1", nativeQuery = true)
    void deleteById(Long id);

}
