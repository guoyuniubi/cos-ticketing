<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 23996
  Date: 2023/12/27
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/exhibition.css">
    <script src="../js/jquery-3.5.1.min.js"></script>
</head>
<body>
<div class="container">

    <div class="header">
        <div class="logo">
            <img src="/img/lo.jpg" alt="展会订票网站">
        </div>
        <ul class="nav">
            <li><a href="/pages/main.jsp">首页</a></li>
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

    <div class="search">
        <!-- 搜索框 -->
        <input type="text" placeholder="请输入展会名称">
        <button>搜索</button>
    </div>
    <div class="main">



        <!-- 主体 -->
        <c:forEach items="${exhibitions}" var="exhibition">
            <div class="card">
                <!-- 卡片 -->
                <img src='/img/${exhibition.getEImgName()}.jpg' alt="展会图片">
                <h3>${exhibition.getEName()}</h3>
                <p>简述：${exhibition.getEIntroduce()}</p>
                <p>时间：<fmt:formatDate value="${exhibition.getETime()}" pattern="yyyy-MM-dd hh:mm"/></p>
                <p>地点：${exhibition.getEPlace()}</p>
                <p>票价：${exhibition.getTicket().getTPrice()}</p>
                <p>剩余票数：${exhibition.getTicket().getTSurplus()}</p>

                <a href="/user/ticket?eid=${exhibition.getEid()}">立即订票</a>
                <h5><a href="/user/review?eid=${exhibition.eid}" methods="post">查看评论</a></h5>
            </div>
        </c:forEach>

    </div>
</div>
</body>
<script>
    let btn = document.querySelector(".search button");
    let input = document.querySelector(".search input");
    btn.onclick = function () {
        let name = input.value;
        if (name == null || name == "") {
            alert("请输入展会名称");
            return;
        }
        window.location.href = "/user/search?input=" + name;
    }
</script>
</html>
