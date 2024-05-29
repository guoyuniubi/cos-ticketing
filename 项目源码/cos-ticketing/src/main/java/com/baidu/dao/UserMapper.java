package com.baidu.dao;


import com.baidu.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    //登录
    @Select("select * from user where username=#{username} and password=#{password}")
    public User login(User user);

    //注册
    @Insert("insert into user(username,password,email) values(#{username},#{password},#{email})")
    public boolean register(User user);

    //查询所有用户
    //@Select("select * from user")
    //public List<User> getAllUser();

    //所有用户信息包括角色
    public List<User> getAllUser();

    //查看自己的信息,根据用户名
    @Select("select * from user where username=#{username}")
    public User getUserByUsername(String username);

    //查看自己的信息,根据用户id
    @Select("select * from user where uid=#{uid}")
    public User getUserByUid(Integer uid);

    //修改自己的信息
    @Update("update user set username=#{username},password=#{password},email=#{email} where uid=#{uid}")
    public void updateUser(User user);


    //可以在展会下面查看到用户对该展会的个人评价
//    @Select("select user.username,rContent from review,user,exhibition where review.uid=user.uid and review.eid=exhibition.eid and exhibition.eid=#{eid}")
    public List<User> getAllUserReview(Integer eid);

    //充值中心：可以查看自己账户余额
    @Select("select uid,username,money from user where uid=#{uid}")
    public User getMoneyByUid(Integer uid);

    //充值中心：可以充值
    @Update("update user set money=#{money} where uid=#{uid}")
    public boolean recharge(User user);

    //验证用户名是否存在
    @Select("select * from user where username=#{username}")
    public User checkUsername(String username);

    //验证邮箱是否存在
    @Select("select * from user where email=#{email}")
    public User checkEmail(String email);

    //根据用户id删除用户
    @Delete("delete from user where uid=#{uid}")
    public boolean deleteUserById(Integer uid);

    //更改余额
    @Update("update user set money=#{money} where uid=#{uid}")
    public boolean updateMoney(User user);
}
