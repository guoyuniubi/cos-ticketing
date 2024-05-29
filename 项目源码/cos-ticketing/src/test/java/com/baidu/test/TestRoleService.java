package com.baidu.test;

import com.baidu.pojo.Role;
import com.baidu.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestRoleService {

    @Autowired
    private RoleService roleService;

    @Test
    public void TestGetAllRole(){
        List<Role> list=roleService.getAllRole();
        list.forEach(System.out::println);
    }
}
