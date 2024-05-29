package com.baidu.test;

import com.baidu.pojo.Order;
import com.baidu.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestOrderService {

    @Autowired
    private OrderService orderService;

    @Test//测试根据用户id查询订单
    public void testGetAllOrderByUserId() {
        orderService.getAllOrderByUserId(1).forEach(System.out::println);
    }

    @Test//测试买票
    public void testBuyTicket() {
        Order order = new Order();
        order.setONum(1);
        order.setTid(1);
        order.setUid(1);
        order.setOTime(new Date());
        order.setTotalPrice(49.8);
        System.out.println(orderService.buyTicket(order));
    }

    @Test//测试根据订单号修改未成交订单
    public void testUpdateOrder() {
        Order order = new Order();
        order.setONum(2);
        order.setOTime(new Date());
        order.setTotalPrice(99.6);
        order.setOid(3);
        order.setStatus("已成交");
        System.out.println(orderService.updateOrder(order));
    }

    @Test//测试删除未成交订单
    public void testDeleteOrder() {
        System.out.println(orderService.deleteOrder(4,"未成交"));
    }
}
