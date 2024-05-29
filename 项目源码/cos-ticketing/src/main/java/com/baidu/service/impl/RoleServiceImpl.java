package com.baidu.service.impl;

import com.baidu.dao.RoleMapper;
import com.baidu.pojo.Role;
import com.baidu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> getAllRole() {
       return roleMapper.getAllRole();
    }
}
