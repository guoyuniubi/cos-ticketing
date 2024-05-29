package com.baidu.service.impl;

import com.baidu.dao.UserMapper;
import com.baidu.pojo.Exhibition;
import com.baidu.pojo.User;
import com.baidu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userMapper")
    UserMapper userMapper;

    @Override//登录
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override//注册
    public boolean register(User user) {
        List<User> users=userMapper.getAllUser();
        for (User u:users){
            if (u.getUsername().equals(user.getUsername())||u.getEmail().equals(user.getEmail())){
                return false;
            }
        }
        return userMapper.register(user);
    }

    @Override//查询所有用户
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override//查看自己的信息,根据用户名
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override//查看自己的信息,根据用户id
    public User getUserByUid(Integer uid) {
        return userMapper.getUserByUid(uid);
    }

    @Override//修改自己的信息
    public String updateUser(User user) {
        List<User> users=userMapper.getAllUser();
        for (User u:users){
            if(u.getUid().equals(user.getUid())){
                continue;
            }
            if (u.getUsername().equals(user.getUsername())){
                return "用户名已存在";
            }
        }
        userMapper.updateUser(user);
        return "修改成功";
    }

    @Override//可以在展会下面查看到用户对该展会的个人评价
    public List<User> getAllUserReview(Integer eid) {
        return userMapper.getAllUserReview(eid);
    }


    @Override//查看自己账户余额
    public User getMoneyByUid(Integer uid) {
        return userMapper.getMoneyByUid(uid);
    }

    @Override//充值
    public boolean recharge(User user) {
        return userMapper.recharge(user);
    }

    @Override//验证用户名是否存在
    public User checkUsername(String username) {
        return userMapper.checkUsername(username);
    }

    @Override//验证邮箱是否存在
    public User checkEmail(String email) {
        return userMapper.checkEmail(email);
    }

    @Override//删除用户
    public boolean deleteUserById(Integer uid) {
        return userMapper.deleteUserById(uid);
    }

    @Override//扣钱
    public boolean payMoney(User user) {
        return userMapper.updateMoney(user);
    }

}
