package com.baidu.dao;

import com.baidu.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderMapper {
    //根据用户id查询订单
    public List<Order> getAllOrderByUserId(Integer userId);

    //买票
    @Insert("insert into `order`(oNum,tid,uid,oTime,totalPrice) " +
            " values(#{oNum},#{tid},#{uid},#{oTime},#{totalPrice})")
    public boolean buyTicket(Order order);

    //根据订单号修改未成交订单
    @Update("update `order` set oNum=#{oNum},totalPrice=#{totalPrice},oTime=#{oTime},status=#{status} " +
            " where oid=#{oid}")
    public boolean updateOrder(Order order);

    //删除未成交订单
    @Delete("delete from `order` where oid=#{oid} and status=#{status};")
    public boolean deleteOrderByOid(@Param("oid") Integer oid,@Param("status") String status);
}
