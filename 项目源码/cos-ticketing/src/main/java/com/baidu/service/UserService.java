package com.baidu.service;

import com.baidu.pojo.Exhibition;
import com.baidu.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    //登录
    public User login(User user);

    //注册
    public boolean register(User user);

    //查询所有用户
    public List<User> getAllUser();

    //查看自己的信息,根据用户名
    public User getUserByUsername(String username);

    //查看自己的信息,根据用户id
    public User getUserByUid(Integer uid);

    //修改自己的信息
    public String updateUser(User user);

    //可以在展会下面查看到用户对该展会的个人评价
    public List<User> getAllUserReview(Integer eid);

    //查看自己账户余额
    public User getMoneyByUid(Integer uid);

    //充值
    public boolean recharge(User user);

    //验证用户名是否存在
    public User checkUsername(String username);

    //验证邮箱是否存在
    public User checkEmail(String email);

    //根据用户id删除用户
    public boolean deleteUserById(Integer uid);

    //扣钱
    public boolean payMoney(User user);

}
