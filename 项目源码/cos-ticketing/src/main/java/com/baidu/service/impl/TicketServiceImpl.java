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

    @Override//������չ������鿴���û��Ը�չ��ĸ�������
    public List<Review> getReviewByEid(Integer eid) {
        return ticketMapper.getReviewByEid(eid);
    }

    //����չ��id��ȡƱ����Ϣ
    public Ticket getTicketByEid(Integer eid){
        return ticketMapper.getTicketByEid(eid);
    }

}

