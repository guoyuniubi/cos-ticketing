package com.baidu.service;

import com.baidu.pojo.Order;

import java.util.List;

public interface OrderService {
    //�����û�id��ѯ����
    public List<Order> getAllOrderByUserId(Integer userId);

    //��Ʊ
    public boolean buyTicket(Order order);

    //���ݶ������޸�δ�ɽ�����
    public boolean updateOrder(Order order);

    //ɾ��δ�ɽ�����
    public boolean deleteOrder(Integer oid,String status);
}
