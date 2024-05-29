package com.baidu.controller;

import com.baidu.pojo.*;
import com.baidu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExhibitionService exhibitionService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ReviewService reviewService;

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public boolean login(User user, HttpSession session) {
        System.out.println(user);
        if (userService.login(user)==null) {
            return false;
        }
        User user1=userService.getUserByUsername(user.getUsername());
        session.setAttribute("user", user1);
        System.out.println("user1:"+user1);
        List<Exhibition> exhibitions=exhibitionService.getAllExhibition();
        session.setAttribute("exhibitions",exhibitions);
        return true;
    }

    //注册
    @RequestMapping("/check")
    @ResponseBody
    public boolean register(User user){
        System.out.println(user);
        if(userService.checkUsername(user.getUsername())!=null){
            return false;
        }else if(userService.checkEmail(user.getEmail())!=null){
            return false;
        }else{
            userService.register(user);
            return true;
        }

    }

    //获取展会信息
    @RequestMapping("/exhibition")
    public String getExhibition(HttpServletRequest request){
        List<Exhibition> exhibitions=exhibitionService.getAllExhibition();
        request.setAttribute("exhibitions",exhibitions);
        return "exhibition";
    }

    //展会评论
    @RequestMapping("/review")
    public String review(HttpServletRequest request,Integer eid){
        System.out.println(eid);
        List<Review> reviews=ticketService.getReviewByEid(eid);
        Exhibition exhibition=exhibitionService.getExhibitionByEid(eid);
        request.setAttribute("comments",reviews);
        request.setAttribute("eName",exhibition.getEName());
        return "review";
    }

    //根据展会名称进行模糊查询
    @RequestMapping("/search")
    public String search(HttpServletRequest request,String input){
        System.out.println(input);
        String a=input;
        List<Exhibition> exhibitions=exhibitionService.getExhibitionByLike(a);
        request.setAttribute("exhibitions",exhibitions);
        return "exhibition";
    }

    //根据展会id获取票务信息
    @RequestMapping("/ticket")
    public String ticket(HttpServletRequest request,Integer eid){
        System.out.println(eid);
        Ticket ticket=ticketService.getTicketByEid(eid);
        String eName=exhibitionService.getExhibitionByEid(eid).getEName();
        request.setAttribute("eName",eName);
        request.setAttribute("ticket",ticket);
        return "buy";
    }

    //加入订单
    @RequestMapping("/buyTicket")
    public String buyTicket(Order order){
        System.out.println(order);
        boolean flag=orderService.buyTicket(order);
        if (flag){
            System.out.println("购买成功");
        }else {
            System.out.println("购买失败");
        }
        return "exhibition";
    }

    //获取订单信息
    @RequestMapping("/order")
    public String order(HttpServletRequest request,Integer uid){
        System.out.println(uid);
        List<Order> orders=orderService.getAllOrderByUserId(uid);
        List<String> eNames=new ArrayList<>();
        for(Order order:orders){
            String eName=exhibitionService.getENameByTid(order.getTid());
//            System.out.println(eName);
            eNames.add(eName);
        }
        request.setAttribute("orders",orders);
        request.setAttribute("eNames",eNames);
        return "order";
    }

    //删除订单
    @RequestMapping("/deleteByOid")
    public String deleteByOid(HttpServletRequest request,Integer oid,String status){
        System.out.println(oid+"  "+status);
        boolean flag=orderService.deleteOrder(oid,status);
        if (flag){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        User user=(User)request.getSession().getAttribute("user");
        return "redirect:/user/order?uid="+user.getUid();
    }

    //评论
    @RequestMapping("/comment")
    @ResponseBody
    public boolean comment(HttpServletRequest request,Review review){
        System.out.println(review);
        boolean flag=reviewService.addReview(review);
        if (flag){
            System.out.println("评论成功");
        }else {
            System.out.println("评论失败");
        }
        return flag;
    }

    //更新用户信息
    @RequestMapping("/update")
    @ResponseBody
    public Integer update(User user){
        System.out.println(user);
        if (userService.checkUsername(user.getUsername())!=null&&!userService.getUserByUid(user.getUid()).getUsername().equals(user.getUsername())){
            return 0;
        }else if (userService.checkEmail(user.getEmail())!=null&&!userService.getUserByUid(user.getUid()).getEmail().equals(user.getEmail())){
            return 1;
        }else {
            userService.updateUser(user);
            return 2;
        }
    }

    //用户列表
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request){
        List<User> users=userService.getAllUser();
        request.setAttribute("users",users);
        return "userList";
    }

    //删除用户
    @RequestMapping("/deleteUserById")
    public String deleteUserById(Integer uid){
        System.out.println(uid);
        boolean flag=userService.deleteUserById(uid);
        if (flag){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        return "redirect:/user/userList";
    }

    //支付
    @RequestMapping("/toPay")
    @ResponseBody
    public boolean toPay(Order order,HttpServletRequest request){
        System.out.println(order);
        User user=((User)request.getSession().getAttribute("user"));
        //更新用户余额
        double money=user.getMoney()-order.getTotalPrice();
        if (money<0){
            return false;
        }
        user.setMoney(money);
        userService.payMoney(user);
        //更新订单状态
        order.setStatus("已支付");
        orderService.updateOrder(order);
        return true;
    }
}
