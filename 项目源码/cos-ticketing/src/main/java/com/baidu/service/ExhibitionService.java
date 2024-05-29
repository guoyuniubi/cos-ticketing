package com.baidu.service;

import com.baidu.pojo.Exhibition;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExhibitionService {
    //用户浏览展会发布时间及内容，当前余票、订票等。
    public List<Exhibition> getAllExhibition();

    //根据展会名称进行模糊查询
    public List<Exhibition> getExhibitionByLike(String input);



    //根据展会id查询展会信息
    public Exhibition getExhibitionByEid(Integer eid);

    //根据票id查询展会名称
    public String getENameByTid(Integer tid);
}
