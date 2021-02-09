package com.yyh.controller;

import com.yyh.dao.UserRepository;
import com.yyh.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id){
        //userRepository.findById(id)会返回一个Optional对象是java8的新特性，主要是为了避免空值
        //也可以userRepository.findById(id).get()
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @GetMapping("/user")//应该用post方式的，但为了测试方便，使用get
    public User saveUser(User user){
        User saveUser = userRepository.save(user);
        //对于spring data jpa的save方法
        //如果没有指定id字段，就是添加操作
        //如果指定了id字段，就是修改操作(先查询记录是否存在，若存在，则更新,不存在就是添加操作)
        return saveUser;
    }
    @GetMapping("/user/delete/{id}")
    public void deleteById(@PathVariable("id") Long id){
        userRepository.deleteById(id);
    }
}
