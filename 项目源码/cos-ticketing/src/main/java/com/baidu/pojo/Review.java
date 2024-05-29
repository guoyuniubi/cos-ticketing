package com.baidu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private Integer rid;
    private String rContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rTime;
    private Integer uid;
    private Integer eid;
    private User user;
}
