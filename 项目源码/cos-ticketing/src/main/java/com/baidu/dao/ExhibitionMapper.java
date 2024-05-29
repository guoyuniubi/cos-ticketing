package com.baidu.dao;

import com.baidu.pojo.Exhibition;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExhibitionMapper {
    //用户浏览展会发布时间及内容，当前余票、订票等。
    //@Select("select eName,eTime,ePlace,eIntroduce,tSurplus from exhibition join ticket where exhibition.tid=ticket.tid")
    public List<Exhibition> getAllExhibition();

    //根据展会名称进行模糊查询
//    @Select("select * from exhibition where eName like CONCAT('%',#{input},'%')")
    public List<Exhibition> getExhibitionByLike(String input);



    //根据展会id查询展会信息
    @Select("select * from exhibition where eid=#{eid}")
    public Exhibition getExhibitionByEid(Integer eid);

    //根据票id查询展会名称
    @Select("select eName from exhibition,ticket where exhibition.tid=ticket.tid and ticket.tid=#{tid};")
    public String getENameByTid(Integer tid);

}
