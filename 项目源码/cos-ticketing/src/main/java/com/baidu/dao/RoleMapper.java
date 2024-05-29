package com.baidu.dao;

import com.baidu.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface RoleMapper {
    @Select("select * from role ")
    public List<Role> getAllRole();
}
