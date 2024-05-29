<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>信息修改</title>
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        #up {
            margin: 20px;
            text-align: right;
        }

        #up a {
            color: #333;
            text-decoration: none;
        }

        #up a:hover {
            color: #666;
        }

        #down {
            margin: 20px auto;
            width: 1000px;
            border: 1px solid #ccc;
            padding: 20px;
            background-color: #fff;
        }

        table {
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        .in {
            width: 300px;
        }

        .mySpan {
            color: red;
            margin-left: 10px;
        }

        .btn {
            display: flex;
            justify-content: center;
        }

        .btn1,
        .btn2 {
            width: 100px;
            height: 40px;
            margin: 10px;
            border: none;
            border-radius: 5px;
            color: #fff;
            font-weight: bold;
            cursor: pointer;
        }

        .btn1 {
            background-color: #00a0e9;
        }

        .btn2 {
            background-color: #f40;
        }
    </style>
    <script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".btn1").click(function () {
                var uid = $("[name='id']").val();
                var username = $("input[name='username']").val();
                var email = $("input[name='email']").val();
                var password = $("input[name='password']").val();
                $.ajax({
                    url: "/user/update",
                    type: "post",
                    data: {
                        "uid": uid,
                        "username": username,
                        "email": email,
                        "password": password,
                    },
                    success: function (data) {
                        if (data==0) {
                            alert("修改的用户名已存在，请重新修改");

                        } else if(data==1){
                            alert("修改的邮箱已存在，请重新修改");
                        }
                        else {
                            alert("修改成功");
                            window.location.href = "/login.jsp";
                        }
                    }
                });
            });
        });
    </script>
</head>

<body>
<div id="up">
    <ul>
        <li><span><a href="#">信息修改</a></span></li>
    </ul>
</div>
<div id="down">

    <table width="1000px">
        <input type="hidden" name="id" value="${user.uid}">
        <tr>
            <td>用户名称：</td>
            <td><input type="text" name="username" value="${user.username}"  class="in" /><span
                    class="mySpan"></span></td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td><input type="text" name="email" value="${user.email}"  class="in" /></td>
        </tr>
        <tr>
            <td>用户密码：</td>
            <td><input type="password" name="password" value="${user.password}"  class="in" /></td>
        </tr>


        <tr>
            <td>余额:</td>
            <td>
                <input type="text" name="money" value="${user.money}" disabled class="in" />
            </td>
        </tr>

    </table>
    <div class="btn">
        <input type="button" value="确认修改" class="btn1">

        <input type="button" value="返回" class="btn2"  onclick="window.history.back()"/>
    </div>
</div>
</body>

</html>