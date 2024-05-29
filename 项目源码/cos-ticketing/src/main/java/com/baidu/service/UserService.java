package com.baidu.service;

import com.baidu.pojo.Exhibition;
import com.baidu.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    //��¼
    public User login(User user);

    //ע��
    public boolean register(User user);

    //��ѯ�����û�
    public List<User> getAllUser();

    //�鿴�Լ�����Ϣ,�����û���
    public User getUserByUsername(String username);

    //�鿴�Լ�����Ϣ,�����û�id
    public User getUserByUid(Integer uid);

    //�޸��Լ�����Ϣ
    public String updateUser(User user);

    //������չ������鿴���û��Ը�չ��ĸ�������
    public List<User> getAllUserReview(Integer eid);

    //�鿴�Լ��˻����
    public User getMoneyByUid(Integer uid);

    //��ֵ
    public boolean recharge(User user);

    //��֤�û����Ƿ����
    public User checkUsername(String username);

    //��֤�����Ƿ����
    public User checkEmail(String email);

    //�����û�idɾ���û�
    public boolean deleteUserById(Integer uid);

    //��Ǯ
    public boolean payMoney(User user);

}
