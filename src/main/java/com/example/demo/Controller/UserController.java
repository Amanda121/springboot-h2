package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


/**
 * @Description:
 * POST - Create a new resource
 * GET - Read a resource
 * PUT - Update an existing resource
 * DELETE - Delete a resource
 * Tomcat by default is not enabled for HTTP PUT command.
 * 只要让地址栏的参数可以传入函数里面，就能执行修改、新增、删除操作，method用RequestMethod.GET即可
 * 用PUT、POST、DELETE会报405错误，因为输入到地址栏默认使用GET方法
 * 注解@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)主要是解决请求日期无法转成LocalDate的问题
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    /*****************************create*************************************/

    @RequestMapping(value = "/saveUser/{userName}/{age}/{date}",method = RequestMethod.GET)
    @Transactional
    public User saveUser(@PathVariable String userName,
                         @PathVariable int age,
                         @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        User user = new User();//Id是自增长的，不需要传
        user.setAge(age);
        user.setUserName(userName);
        user.setDateOfBirth(date);
        return userService.save(user);
    }

    /*****************************Read***** ********************************/

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public Optional <User> findById(@PathVariable(name = "id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/findByDateOfBirth/{date}", method = RequestMethod.GET)
    public List<User> findByDateOfBirth(@PathVariable(name = "date")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return userService.findByDateOfBirth(date);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/findByUserNameAndAge/{userName}/{age}")
    public List <User> findByUserNameAndAge(@PathVariable(name = "userName")String userName,
                                            @PathVariable(name = "age")int age){
        return userService.findByUserNameAndAge(userName,age);
    }

    /*****************************update*************************************/

    @RequestMapping(value = "/updateUserNameById/{userName}/{id}")
    public int updateUserNameById(@PathVariable(value = "userName")String userName,
                                  @PathVariable(value = "id")Long id){
        return userService.updateUserNameById(userName,id);
    }
    /*****************************delete*************************************/

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.GET)
    @Transactional
    public String deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return "SUCCESS";
    }

}