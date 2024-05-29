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

    @Test//���Ը����û�id��ѯ����
    public void testGetAllOrderByUserId() {
        orderService.getAllOrderByUserId(1).forEach(System.out::println);
    }

    @Test//������Ʊ
    public void testBuyTicket() {
        Order order = new Order();
        order.setONum(1);
        order.setTid(1);
        order.setUid(1);
        order.setOTime(new Date());
        order.setTotalPrice(49.8);
        System.out.println(orderService.buyTicket(order));
    }

    @Test//���Ը��ݶ������޸�δ�ɽ�����
    public void testUpdateOrder() {
        Order order = new Order();
        order.setONum(2);
        order.setOTime(new Date());
        order.setTotalPrice(99.6);
        order.setOid(3);
        order.setStatus("�ѳɽ�");
        System.out.println(orderService.updateOrder(order));
    }

    @Test//����ɾ��δ�ɽ�����
    public void testDeleteOrder() {
        System.out.println(orderService.deleteOrder(4,"δ�ɽ�"));
    }
}
