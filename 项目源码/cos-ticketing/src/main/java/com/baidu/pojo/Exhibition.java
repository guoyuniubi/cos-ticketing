package com.baidu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exhibition {
    private Integer eid;
    private String eName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eTime;
    private String ePlace;
    private String eIntroduce;
    private String eImgName;
    private Integer tid;
    private Ticket ticket;

}
