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

    @Test//���Ե�¼,��¼�ɹ������û���Ϣ
    public void testLogin() {
        User user = new User();
        user.setUsername("gy");
        user.setPassword("1234");
        user.setRid(1);
        System.out.println(userService.login(user));
    }

    @Test//���Բ�ѯ�����û�
    public void testGetAllUser() {
        //���Բ�ѯ�����û�
        List<User> users = userService.getAllUser();
        users.forEach(System.out::println);
    }

    @Test//����ע��,ע��ɹ�����true
    public void testRegister() {
        //���Բ�ѯ�����û�
        List<User> users = userService.getAllUser();
        users.forEach(System.out::println);
        User user = new User();
        user.setUsername("zjh");
        user.setPassword("1234");
        user.setEmail("12345@qq.com");
        System.out.println(userService.register(user));
    }

    @Test//�����û�����ѯ��Ϣ
    public void testGetUserByUsername() {
        System.out.println(userService.getUserByUsername("gy"));
    }

    @Test//�޸��Լ�����Ϣ
    public void testUpdateUser() {
        User user = new User();
        user.setUid(1);
        user.setUsername("gy");
        user.setPassword("1234");
        user.setEmail("12345@qq.com");
        System.out.println(userService.updateUser(user));
    }

    @Test//�鿴�����û��Ը�չ��ĸ�������
    public void testGetAllUserReview() {
        List<User> users = userService.getAllUserReview(1);
        users.forEach(System.out::println);
    }

    @Test//�鿴�Լ��˻����
    public void testGetMoneyByUsername() {
        System.out.println(userService.getMoneyByUid(1));
    }

    @Test//��ֵ
    public void testRecharge() {
        User user = new User();
        user.setUid(1);
        user.setMoney(1000010);
        System.out.println(userService.recharge(user));
    }

    @Test//��֤�û����Ƿ����,����֤�����Ƿ����
    public void testCheckUsernameAndEmail() {
        System.out.println(userService.checkUsername("gy"));
        System.out.println(userService.checkEmail("12345@qq.com"));
    }

    @Test//�ۿ�
public void testPayMoney() {
        User user = new User();
        user.setUid(1);
        user.setMoney(1000000);
        System.out.println(userService.payMoney(user));
    }


}