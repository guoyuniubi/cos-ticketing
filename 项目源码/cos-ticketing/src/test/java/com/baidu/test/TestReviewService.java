package com.baidu.test;

import com.baidu.pojo.Review;
import com.baidu.service.ReviewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestReviewService {
    @Autowired
    ReviewService reviewService;

    //ÆÀÂÛ
    @Test
    public void testAddReview(){
        Review review = new Review();
        review.setRContent("test");
        review.setRTime(new java.sql.Date(new java.util.Date().getTime()));
        review.setEid(1);
        review.setUid(1);
        System.out.println(reviewService.addReview(review));
    }
}
