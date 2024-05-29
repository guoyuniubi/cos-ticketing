package com.baidu.dao;

import com.baidu.pojo.Exhibition;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExhibitionMapper {
    //�û����չ�ᷢ��ʱ�估���ݣ���ǰ��Ʊ����Ʊ�ȡ�
    //@Select("select eName,eTime,ePlace,eIntroduce,tSurplus from exhibition join ticket where exhibition.tid=ticket.tid")
    public List<Exhibition> getAllExhibition();

    //����չ�����ƽ���ģ����ѯ
//    @Select("select * from exhibition where eName like CONCAT('%',#{input},'%')")
    public List<Exhibition> getExhibitionByLike(String input);



    //����չ��id��ѯչ����Ϣ
    @Select("select * from exhibition where eid=#{eid}")
    public Exhibition getExhibitionByEid(Integer eid);

    //����Ʊid��ѯչ������
    @Select("select eName from exhibition,ticket where exhibition.tid=ticket.tid and ticket.tid=#{tid};")
    public String getENameByTid(Integer tid);

}
