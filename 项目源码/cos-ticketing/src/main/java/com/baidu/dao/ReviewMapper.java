package com.baidu.dao;

import com.baidu.pojo.Review;
import org.apache.ibatis.annotations.Insert;

public interface ReviewMapper {

    //ÆÀÂÛ
    @Insert("insert into review(rContent,rTime,eid,uid) values(#{rContent},#{rTime},#{eid},#{uid})")
    public boolean addReview(Review review);
}
