package com.baidu.service.impl;

import com.baidu.dao.ExhibitionMapper;
import com.baidu.pojo.Exhibition;
import com.baidu.pojo.Review;
import com.baidu.service.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitionServiceImpl implements ExhibitionService {

    @Autowired
    ExhibitionMapper exhibitionMapper;

    @Override//用户浏览展会发布时间及内容，当前余票等。
    public List<Exhibition> getAllExhibition() {
        return exhibitionMapper.getAllExhibition();
    }

    @Override//根据展会名称进行模糊查询
    public List<Exhibition> getExhibitionByLike(String input) {
        return exhibitionMapper.getExhibitionByLike(input);
    }



    @Override//根据展会id查询展会信息
    public Exhibition getExhibitionByEid(Integer eid) {
        return exhibitionMapper.getExhibitionByEid(eid);
    }

    //根据票id查询展会名称
    public String getENameByTid(Integer tid){
        return exhibitionMapper.getENameByTid(tid);
    }


}
