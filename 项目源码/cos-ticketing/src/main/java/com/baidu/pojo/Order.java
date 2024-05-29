package com.baidu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer oid;
    private String status;
    private Integer oNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date oTime;
    private double totalPrice;
    private Integer uid;
    private Integer tid;
    private Ticket ticket;
    private Exhibition exhibition;
}
