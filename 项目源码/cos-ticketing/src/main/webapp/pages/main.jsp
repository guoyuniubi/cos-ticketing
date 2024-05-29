<%@ page import="com.baidu.pojo.Exhibition" %>
<%@ page import="java.util.List" %>
<%@ page import="com.baidu.service.ExhibitionService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>展会订票网站</title>
    <link rel="stylesheet" href="/css/header.css">
    <style>

        /*.clear {*/
        /*    clear: both;*/
        /*}*/

        /*.banner {*/
        /*    width: 100%;*/
        /*    height: 300px;*/
        /*    margin: 20px 0;*/
        /*}*/

        .banner img {
            width: 100%;
            height: 100%;
        }

        .content {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .item {
            width: 43%;
            height: 310px;
            margin: 20px 0;
            position: relative;
        }

        .item img {
            width: 100%;
            height: 100%;
        }

        .item .info {
            position: absolute;
            bottom: 0;
            left: 0;
            right: 0;
            background: rgba(0, 0, 0, 0.5);
            color: white;
            padding: 10px;
        }

        .item .info h3 {
            margin: 0;
        }

        .item .info p {
            margin: 5px 0;
        }

        .item .info a {
            display: inline-block;
            background: blue;
            color: white;
            padding: 5px 10px;
            text-decoration: none;
        }

        .footer {
            width: 100%;
            height: 100px;
            background: gray;
            color: white;
            text-align: center;
            line-height: 100px;
        }
        .carousel {
            width: 100%;
            height: 500px;
            overflow: hidden;
            position: relative;
        }

        .slide {
            width: 100%;
            height: 100%;
            position: absolute;
            transition: opacity 1s;
        }

        .slide:nth-child(2) {
            left: 100%;
        }

        .slide:nth-child(3) {
            left: 200%;
        }

        .carousel .slide.active {
            opacity: 1;
        }

        .carousel .slide.prev {
            left: -100%;
        }

        .carousel .slide.next {
            left: 0;
        }
    </style>
</head>
<body>
<div class="all">
<div class="container">

    <div class="header">
        <div class="logo">
            <img src="/img/lo.jpg" alt="展会订票网站">
        </div>
        <ul class="nav">
            <li><a href="./main.jsp">首页</a></li>
            <li><a href="/user/exhibition">展会</a></li>
            <li><a href="/user/order?uid=${user.getUid()}">我的订单</a></li>
            <li><a href="#">充值中心</a></li>
            <li><a href="/pages/userDetail.jsp">个人中心</a></li>
            <li><a href="../login.jsp">登录/注册</a></li>
            <c:if test="${user.rid==1}">
                <li>
                    <a href="#">管理列表</a>
                    <ul>
                        <li><a href="/user/userList">用户管理</a></li>
                        <li><a href="#">展会管理</a></li>
                        <li><a href="#">门票管理</a></li>
                    </ul>
                </li>
            </c:if>
        </ul>
    </div>


<%--    <div class="clear"></div>--%>
    <div class="carousel">
        <img class="slide" src="/img/banner3.jpg" alt="事件1">
        <img class="slide" src="/img/banner1.jpg" alt="事件2">
        <img class="slide" src="/img/banner2.jpg" alt="事件3">
    </div>
    <div class="content">
        <c:forEach items="${exhibitions}" var="exhibition">
        <div class="item">
            <img src='/img/${exhibition.getEImgName()}.jpg' alt="展会图片">
            <div class="info">
                <h3>${exhibition.getEName()}</h3>
                <p>简述：${exhibition.getEIntroduce()}</p>
                <p>时间：<fmt:formatDate value="${exhibition.getETime()}" pattern="yyyy-MM-dd hh:mm"/></p>
                <p>地点：${exhibition.getEPlace()}</p>
                <a href="/user/ticket?eid=${exhibition.getEid()}">立即订票</a>
            </div>
        </div>
        </c:forEach>
    </div>
</div>
<div class="footer">
    © 2023 cos展会订票网站. All rights reserved.
</div>
</div>
</body>
<script>
    let currentSlide = 0;
    const slides = document.querySelectorAll('.slide');

    function showSlide(n) {
        slides.forEach(slide => slide.classList.remove('active', 'prev', 'next'));
        slides[n].classList.add('active');
        if (n === 0) {
            slides[2].classList.add('prev');
            slides[1].classList.add('next');
        } else if (n === 1) {
            slides[0].classList.add('prev');
            slides[2].classList.add('next');
        } else {
            slides[1].classList.add('prev');
            slides[0].classList.add('next');
        }
    }

    function nextSlide() {
        currentSlide = (currentSlide + 1) % 3;
        showSlide(currentSlide);
    }

    function prevSlide() {
        currentSlide = (currentSlide - 1 + 3) % 3;
        showSlide(currentSlide);
    }

    setInterval(nextSlide, 4000);
</script>
</html>
