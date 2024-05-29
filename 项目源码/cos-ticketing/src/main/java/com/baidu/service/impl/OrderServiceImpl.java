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

    //根据用户id查询订单
    @Override
    public List<Order> getAllOrderByUserId(Integer userId) {
        return orderMapper.getAllOrderByUserId(userId);
    }

    //买票
    @Override
    public boolean buyTicket(Order order) {
        if (order == null) return false;
        if (order.getONum()<=0) return false;
        return orderMapper.buyTicket(order);
    }

    //根据订单号修改未成交订单
    @Override
    public boolean updateOrder(Order order) {
        if (order == null) return false;
        if (order.getONum()<=0) return false;
        if(order.getStatus().equals("已成交")) return false;
        return orderMapper.updateOrder(order);
    }

    //删除未成交订单
    @Override
    public boolean deleteOrder(Integer oid, String status) {
        if (oid == null) return false;
        if (status == null) return false;
        if (status.equals("已成交")) return false;
        return orderMapper.deleteOrderByOid(oid,status);
    }


}
