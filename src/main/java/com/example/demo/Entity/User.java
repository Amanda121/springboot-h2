package com.example.demo.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * @Description: SpringBoot自动配置会探测到我们使用了H2数据库，它会根据实体类自动创建数据表
 * @author: Alan
 * @Date: 2018/11/30 22:33
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//主键

    @Column(nullable = false)
    private String userName;//名

    @Column(nullable = false)
    private int age;//年龄

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;//出生日期

    public User() {
    }

    public User(Long id, String userName,int age, LocalDate dateOfBirth) {
        this.id = id;
        this.age = age;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}