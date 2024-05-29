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

    //��¼
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

    //ע��
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

    //��ȡչ����Ϣ
    @RequestMapping("/exhibition")
    public String getExhibition(HttpServletRequest request){
        List<Exhibition> exhibitions=exhibitionService.getAllExhibition();
        request.setAttribute("exhibitions",exhibitions);
        return "exhibition";
    }

    //չ������
    @RequestMapping("/review")
    public String review(HttpServletRequest request,Integer eid){
        System.out.println(eid);
        List<Review> reviews=ticketService.getReviewByEid(eid);
        Exhibition exhibition=exhibitionService.getExhibitionByEid(eid);
        request.setAttribute("comments",reviews);
        request.setAttribute("eName",exhibition.getEName());
        return "review";
    }

    //����չ�����ƽ���ģ����ѯ
    @RequestMapping("/search")
    public String search(HttpServletRequest request,String input){
        System.out.println(input);
        String a=input;
        List<Exhibition> exhibitions=exhibitionService.getExhibitionByLike(a);
        request.setAttribute("exhibitions",exhibitions);
        return "exhibition";
    }

    //����չ��id��ȡƱ����Ϣ
    @RequestMapping("/ticket")
    public String ticket(HttpServletRequest request,Integer eid){
        System.out.println(eid);
        Ticket ticket=ticketService.getTicketByEid(eid);
        String eName=exhibitionService.getExhibitionByEid(eid).getEName();
        request.setAttribute("eName",eName);
        request.setAttribute("ticket",ticket);
        return "buy";
    }

    //���붩��
    @RequestMapping("/buyTicket")
    public String buyTicket(Order order){
        System.out.println(order);
        boolean flag=orderService.buyTicket(order);
        if (flag){
            System.out.println("����ɹ�");
        }else {
            System.out.println("����ʧ��");
        }
        return "exhibition";
    }

    //��ȡ������Ϣ
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

    //ɾ������
    @RequestMapping("/deleteByOid")
    public String deleteByOid(HttpServletRequest request,Integer oid,String status){
        System.out.println(oid+"  "+status);
        boolean flag=orderService.deleteOrder(oid,status);
        if (flag){
            System.out.println("ɾ���ɹ�");
        }else {
            System.out.println("ɾ��ʧ��");
        }
        User user=(User)request.getSession().getAttribute("user");
        return "redirect:/user/order?uid="+user.getUid();
    }

    //����
    @RequestMapping("/comment")
    @ResponseBody
    public boolean comment(HttpServletRequest request,Review review){
        System.out.println(review);
        boolean flag=reviewService.addReview(review);
        if (flag){
            System.out.println("���۳ɹ�");
        }else {
            System.out.println("����ʧ��");
        }
        return flag;
    }

    //�����û���Ϣ
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

    //�û��б�
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request){
        List<User> users=userService.getAllUser();
        request.setAttribute("users",users);
        return "userList";
    }

    //ɾ���û�
    @RequestMapping("/deleteUserById")
    public String deleteUserById(Integer uid){
        System.out.println(uid);
        boolean flag=userService.deleteUserById(uid);
        if (flag){
            System.out.println("ɾ���ɹ�");
        }else {
            System.out.println("ɾ��ʧ��");
        }
        return "redirect:/user/userList";
    }

    //֧��
    @RequestMapping("/toPay")
    @ResponseBody
    public boolean toPay(Order order,HttpServletRequest request){
        System.out.println(order);
        User user=((User)request.getSession().getAttribute("user"));
        //�����û����
        double money=user.getMoney()-order.getTotalPrice();
        if (money<0){
            return false;
        }
        user.setMoney(money);
        userService.payMoney(user);
        //���¶���״̬
        order.setStatus("��֧��");
        orderService.updateOrder(order);
        return true;
    }
}
