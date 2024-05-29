package com.baidu.dao;


import com.baidu.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    //��¼
    @Select("select * from user where username=#{username} and password=#{password}")
    public User login(User user);

    //ע��
    @Insert("insert into user(username,password,email) values(#{username},#{password},#{email})")
    public boolean register(User user);

    //��ѯ�����û�
    //@Select("select * from user")
    //public List<User> getAllUser();

    //�����û���Ϣ������ɫ
    public List<User> getAllUser();

    //�鿴�Լ�����Ϣ,�����û���
    @Select("select * from user where username=#{username}")
    public User getUserByUsername(String username);

    //�鿴�Լ�����Ϣ,�����û�id
    @Select("select * from user where uid=#{uid}")
    public User getUserByUid(Integer uid);

    //�޸��Լ�����Ϣ
    @Update("update user set username=#{username},password=#{password},email=#{email} where uid=#{uid}")
    public void updateUser(User user);


    //������չ������鿴���û��Ը�չ��ĸ�������
//    @Select("select user.username,rContent from review,user,exhibition where review.uid=user.uid and review.eid=exhibition.eid and exhibition.eid=#{eid}")
    public List<User> getAllUserReview(Integer eid);

    //��ֵ���ģ����Բ鿴�Լ��˻����
    @Select("select uid,username,money from user where uid=#{uid}")
    public User getMoneyByUid(Integer uid);

    //��ֵ���ģ����Գ�ֵ
    @Update("update user set money=#{money} where uid=#{uid}")
    public boolean recharge(User user);

    //��֤�û����Ƿ����
    @Select("select * from user where username=#{username}")
    public User checkUsername(String username);

    //��֤�����Ƿ����
    @Select("select * from user where email=#{email}")
    public User checkEmail(String email);

    //�����û�idɾ���û�
    @Delete("delete from user where uid=#{uid}")
    public boolean deleteUserById(Integer uid);

    //�������
    @Update("update user set money=#{money} where uid=#{uid}")
    public boolean updateMoney(User user);
}
