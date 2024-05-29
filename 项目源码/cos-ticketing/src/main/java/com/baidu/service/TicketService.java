package com.baidu.service;

import com.baidu.pojo.Review;
import com.baidu.pojo.Ticket;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TicketService {

    //������չ������鿴���û��Ը�չ��ĸ�������
    public List<Review> getReviewByEid(Integer eid);


    //����չ��id��ȡƱ����Ϣ
    public Ticket getTicketByEid(Integer eid);
}
