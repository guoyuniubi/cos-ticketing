package com.baidu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String email;
    private double money;
    private Integer rid;
    private Role role;
    List<Order> orders;
    List<Review> reviews;
}
