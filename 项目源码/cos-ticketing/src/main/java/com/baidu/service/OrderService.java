package com.baidu.service;

import com.baidu.pojo.Order;

import java.util.List;

public interface OrderService {
    //根据用户id查询订单
    public List<Order> getAllOrderByUserId(Integer userId);

    //买票
    public boolean buyTicket(Order order);

    //根据订单号修改未成交订单
    public boolean updateOrder(Order order);

    //删除未成交订单
    public boolean deleteOrder(Integer oid,String status);
}
