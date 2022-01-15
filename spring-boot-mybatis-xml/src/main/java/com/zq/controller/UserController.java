package com.zq.controller;

import com.zq.mapper.UserMapper;
import com.zq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        return userMapper.getAll();
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        return userMapper.getOne(id);
    }

    @RequestMapping("/add")
    public void add(User user) {
        userMapper.insert(user);
    }

    @RequestMapping("/update")
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }
}
