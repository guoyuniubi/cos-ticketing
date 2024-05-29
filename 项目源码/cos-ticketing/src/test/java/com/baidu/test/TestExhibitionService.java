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

    @Test//�û����չ�ᷢ��ʱ�估���ݣ���ǰ��Ʊ�ȡ�
    public void testGetAllExhibition(){
        exhibitionService.getAllExhibition().forEach(System.out::println);
    }

    @Test//�û�����չ��
    public void testGetExhibitionByLike(){
        exhibitionService.getExhibitionByLike("��չ").forEach(System.out::println);
    }



    @Test//����չ��id��ѯչ����Ϣ
    public void testGetExhibitionByEid(){
        System.out.println(exhibitionService.getExhibitionByEid(1));
    }

    @Test//����Ʊid��ѯչ������
    public void testGetENameByTid(){
        System.out.println(exhibitionService.getENameByTid(1));
    }

}
