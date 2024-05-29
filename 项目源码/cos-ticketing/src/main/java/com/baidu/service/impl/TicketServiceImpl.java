package com.baidu.service.impl;

import com.baidu.dao.TicketMapper;
import com.baidu.pojo.Review;
import com.baidu.pojo.Ticket;
import com.baidu.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketMapper ticketMapper;

    @Override//可以在展会下面查看到用户对该展会的个人评价
    public List<Review> getReviewByEid(Integer eid) {
        return ticketMapper.getReviewByEid(eid);
    }

    //根据展会id获取票务信息
    public Ticket getTicketByEid(Integer eid){
        return ticketMapper.getTicketByEid(eid);
    }

}

