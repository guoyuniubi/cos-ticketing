package com.baidu.test;

import com.baidu.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestTicketService {
    @Autowired
    TicketService ticketService;

    @Test//用户根据展会id查询展会评论
    public void testGetAllExhibitionReview(){
        ticketService.getReviewByEid(1).forEach(System.out::println);
    }

    @Test//用户根据展会id查询展会票务信息
    public void testGetTicketByEid(){
        System.out.println(ticketService.getTicketByEid(1));
    }

}
