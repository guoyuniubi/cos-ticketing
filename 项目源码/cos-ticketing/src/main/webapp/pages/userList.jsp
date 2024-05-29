<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 23996
  Date: 2023/12/28
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        * {
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f0f8ff; /* 添加了背景颜色 */
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ccc;
        }

        th {
            background-color: #f0f0f0;
            color: #0000ff; /* 添加了标题颜色 */
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #e0e0e0;
        }

        .delete-button {
            background-color: #ff0000;
            color: #ffffff;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }

        .delete-button a{
            text-decoration: none;
            color: #ffffff;
        }

        .back-button {
            background-color: #0000ff;
            color: #ffffff;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
            margin: 10px;
        }
    </style>
    <title>用户管理</title>
</head>
<body>
<h1 style="color: #ff00ff">用户管理</h1> <!-- 添加了标题颜色 -->
<table>
    <tr>
        <th>用户ID</th>
        <th>用户名</th>
        <th>邮箱</th>
        <th>密码</th>
        <th>余额</th>
        <th>权限</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr>
            <td>${user.uid}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.money}</td>
            <td>${user.role.roleName}</td>
            <td><button class="delete-button" ><a href="/user/deleteUserById?uid=${user.uid}" class="del" onclick="return confirm('是否确定删除') ">删除</a>&nbsp;</button></td>
        </tr>
    </c:forEach>
</table>
<button class="back-button" onclick="window.history.back()">返回</button>
</body>
</html>

