package com.baidu.service.impl;

import com.baidu.dao.OrderMapper;
import com.baidu.pojo.Order;
import com.baidu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    //�����û�id��ѯ����
    @Override
    public List<Order> getAllOrderByUserId(Integer userId) {
        return orderMapper.getAllOrderByUserId(userId);
    }

    //��Ʊ
    @Override
    public boolean buyTicket(Order order) {
        if (order == null) return false;
        if (order.getONum()<=0) return false;
        return orderMapper.buyTicket(order);
    }

    //���ݶ������޸�δ�ɽ�����
    @Override
    public boolean updateOrder(Order order) {
        if (order == null) return false;
        if (order.getONum()<=0) return false;
        if(order.getStatus().equals("�ѳɽ�")) return false;
        return orderMapper.updateOrder(order);
    }

    //ɾ��δ�ɽ�����
    @Override
    public boolean deleteOrder(Integer oid, String status) {
        if (oid == null) return false;
        if (status == null) return false;
        if (status.equals("�ѳɽ�")) return false;
        return orderMapper.deleteOrderByOid(oid,status);
    }


}
