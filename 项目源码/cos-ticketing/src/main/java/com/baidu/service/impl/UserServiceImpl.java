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

    @Override//��¼
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override//ע��
    public boolean register(User user) {
        List<User> users=userMapper.getAllUser();
        for (User u:users){
            if (u.getUsername().equals(user.getUsername())||u.getEmail().equals(user.getEmail())){
                return false;
            }
        }
        return userMapper.register(user);
    }

    @Override//��ѯ�����û�
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override//�鿴�Լ�����Ϣ,�����û���
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override//�鿴�Լ�����Ϣ,�����û�id
    public User getUserByUid(Integer uid) {
        return userMapper.getUserByUid(uid);
    }

    @Override//�޸��Լ�����Ϣ
    public String updateUser(User user) {
        List<User> users=userMapper.getAllUser();
        for (User u:users){
            if(u.getUid().equals(user.getUid())){
                continue;
            }
            if (u.getUsername().equals(user.getUsername())){
                return "�û����Ѵ���";
            }
        }
        userMapper.updateUser(user);
        return "�޸ĳɹ�";
    }

    @Override//������չ������鿴���û��Ը�չ��ĸ�������
    public List<User> getAllUserReview(Integer eid) {
        return userMapper.getAllUserReview(eid);
    }


    @Override//�鿴�Լ��˻����
    public User getMoneyByUid(Integer uid) {
        return userMapper.getMoneyByUid(uid);
    }

    @Override//��ֵ
    public boolean recharge(User user) {
        return userMapper.recharge(user);
    }

    @Override//��֤�û����Ƿ����
    public User checkUsername(String username) {
        return userMapper.checkUsername(username);
    }

    @Override//��֤�����Ƿ����
    public User checkEmail(String email) {
        return userMapper.checkEmail(email);
    }

    @Override//ɾ���û�
    public boolean deleteUserById(Integer uid) {
        return userMapper.deleteUserById(uid);
    }

    @Override//��Ǯ
    public boolean payMoney(User user) {
        return userMapper.updateMoney(user);
    }

}
