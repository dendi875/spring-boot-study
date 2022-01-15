package com.zq.mapper;

import com.zq.enums.UserSexEnum;
import com.zq.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll() {
        List<User> users = userMapper.getAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void getOne() {
        User user = userMapper.getOne(1L);
        System.out.println(user);
    }

    @Test
    public void insert() {
        userMapper.insert(new User("aaaaa", "123456", UserSexEnum.MAN));
        userMapper.insert(new User("bbbbb", "123456", UserSexEnum.MAN));
        userMapper.insert(new User("ccccc", "123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void update() {
        User user = userMapper.getOne(2L);
        user.setNickName("小张");
        userMapper.update(user);

        Assert.assertTrue("小张".equals(userMapper.getOne(2L).getNickName()));
    }
}