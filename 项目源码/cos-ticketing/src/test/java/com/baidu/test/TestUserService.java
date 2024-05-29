package com.baidu.test;

import com.baidu.pojo.User;
import com.baidu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestUserService {

    @Autowired
    UserService userService;

    @Test//测试登录,登录成功返回用户信息
    public void testLogin() {
        User user = new User();
        user.setUsername("gy");
        user.setPassword("1234");
        user.setRid(1);
        System.out.println(userService.login(user));
    }

    @Test//测试查询所有用户
    public void testGetAllUser() {
        //测试查询所有用户
        List<User> users = userService.getAllUser();
        users.forEach(System.out::println);
    }

    @Test//测试注册,注册成功返回true
    public void testRegister() {
        //测试查询所有用户
        List<User> users = userService.getAllUser();
        users.forEach(System.out::println);
        User user = new User();
        user.setUsername("zjh");
        user.setPassword("1234");
        user.setEmail("12345@qq.com");
        System.out.println(userService.register(user));
    }

    @Test//根据用户名查询信息
    public void testGetUserByUsername() {
        System.out.println(userService.getUserByUsername("gy"));
    }

    @Test//修改自己的信息
    public void testUpdateUser() {
        User user = new User();
        user.setUid(1);
        user.setUsername("gy");
        user.setPassword("1234");
        user.setEmail("12345@qq.com");
        System.out.println(userService.updateUser(user));
    }

    @Test//查看所以用户对该展会的个人评价
    public void testGetAllUserReview() {
        List<User> users = userService.getAllUserReview(1);
        users.forEach(System.out::println);
    }

    @Test//查看自己账户余额
    public void testGetMoneyByUsername() {
        System.out.println(userService.getMoneyByUid(1));
    }

    @Test//充值
    public void testRecharge() {
        User user = new User();
        user.setUid(1);
        user.setMoney(1000010);
        System.out.println(userService.recharge(user));
    }

    @Test//验证用户名是否存在,和验证邮箱是否存在
    public void testCheckUsernameAndEmail() {
        System.out.println(userService.checkUsername("gy"));
        System.out.println(userService.checkEmail("12345@qq.com"));
    }

    @Test//扣款
public void testPayMoney() {
        User user = new User();
        user.setUid(1);
        user.setMoney(1000000);
        System.out.println(userService.payMoney(user));
    }


}