package com.baidu.test;

import com.baidu.service.ExhibitionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestExhibitionService {
    @Autowired
    ExhibitionService exhibitionService;

    @Test//用户浏览展会发布时间及内容，当前余票等。
    public void testGetAllExhibition(){
        exhibitionService.getAllExhibition().forEach(System.out::println);
    }

    @Test//用户搜索展会
    public void testGetExhibitionByLike(){
        exhibitionService.getExhibitionByLike("漫展").forEach(System.out::println);
    }



    @Test//根据展会id查询展会信息
    public void testGetExhibitionByEid(){
        System.out.println(exhibitionService.getExhibitionByEid(1));
    }

    @Test//根据票id查询展会名称
    public void testGetENameByTid(){
        System.out.println(exhibitionService.getENameByTid(1));
    }

}
