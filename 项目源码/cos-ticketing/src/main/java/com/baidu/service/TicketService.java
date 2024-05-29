package com.baidu.service;

import com.baidu.pojo.Review;
import com.baidu.pojo.Ticket;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TicketService {

    //可以在展会下面查看到用户对该展会的个人评价
    public List<Review> getReviewByEid(Integer eid);


    //根据展会id获取票务信息
    public Ticket getTicketByEid(Integer eid);
}
