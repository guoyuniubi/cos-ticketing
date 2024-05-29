package com.baidu.dao;

import com.baidu.pojo.Review;
import com.baidu.pojo.Ticket;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TicketMapper {

    //可以在展会下面查看到用户对该展会的个人评价
//    @Select("select user.username,rContent " +
//            "from review,user,exhibition\n" +
//            "where review.uid=user.uid and review.eid=exhibition.eid and exhibition.eid=#{eid};")
    public List<Review> getReviewByEid(Integer eid);

    //根据展会id获取票务信息
    @Select("select ticket.tid,tPrice from exhibition,ticket where exhibition.tid=ticket.tid and exhibition.eid=#{eid};")
    public Ticket getTicketByEid(Integer eid);

}
