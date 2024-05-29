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

    @Override//�û����չ�ᷢ��ʱ�估���ݣ���ǰ��Ʊ�ȡ�
    public List<Exhibition> getAllExhibition() {
        return exhibitionMapper.getAllExhibition();
    }

    @Override//����չ�����ƽ���ģ����ѯ
    public List<Exhibition> getExhibitionByLike(String input) {
        return exhibitionMapper.getExhibitionByLike(input);
    }



    @Override//����չ��id��ѯչ����Ϣ
    public Exhibition getExhibitionByEid(Integer eid) {
        return exhibitionMapper.getExhibitionByEid(eid);
    }

    //����Ʊid��ѯչ������
    public String getENameByTid(Integer tid){
        return exhibitionMapper.getENameByTid(tid);
    }


}
