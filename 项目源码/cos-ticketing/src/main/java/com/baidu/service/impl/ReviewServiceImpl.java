package com.baidu.service.impl;

import com.baidu.dao.ReviewMapper;
import com.baidu.pojo.Review;
import com.baidu.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    //ÆÀÂÛ
    public boolean addReview(Review review) {
        return reviewMapper.addReview(review);
    }
}
