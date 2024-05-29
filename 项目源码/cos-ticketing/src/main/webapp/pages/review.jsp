<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 23996
  Date: 2023/12/27
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/reviews.css">
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
                        <li><a href="#">用户管理</a></li>
                        <li><a href="#">展会管理</a></li>
                        <li><a href="#">门票管理</a></li>
                    </ul>
                </li>
            </c:if>
        </ul>
    </div>

    <h3>${eName}</h3>
    <div class="comments">
        <!-- 评论 -->
        <c:if test="${comments.size()==0}">
            <div class="comment">
                <!-- 评论 -->
                <div class="comment-header">
                    <!-- 评论头部 -->
                    <img src=""  class="comment-avatar">
                    <span class="comment-name">暂无评论</span>
                    <span class="comment-time">暂无评论</span>
                </div>
                <div class="comment-content">
                    <!-- 评论内容 -->
                    暂无评论
                </div>
            </div>
        </c:if>
        <c:forEach items="${comments}" var="comment" varStatus="v" >

            <div class="comment">
                <!-- 评论 -->
                <div class="comment-header">
                    <!-- 评论头部 -->
                    <img src="user1.jpg" alt="用户${v.index+1}" class="comment-avatar">
                    <span class="comment-name">${comment.user.getUsername()}</span>
                    <span class="comment-time"><fmt:formatDate value="${comment.getRTime()}" pattern="yyyy-MM-dd HH:mm"/></span>
                </div>
                <div class="comment-content">
                    <!-- 评论内容 -->
                    ${comment.getRContent()}
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
