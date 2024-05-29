package com.baidu.service;

import com.baidu.pojo.Exhibition;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExhibitionService {
    //�û����չ�ᷢ��ʱ�估���ݣ���ǰ��Ʊ����Ʊ�ȡ�
    public List<Exhibition> getAllExhibition();

    //����չ�����ƽ���ģ����ѯ
    public List<Exhibition> getExhibitionByLike(String input);



    //����չ��id��ѯչ����Ϣ
    public Exhibition getExhibitionByEid(Integer eid);

    //����Ʊid��ѯչ������
    public String getENameByTid(Integer tid);
}
