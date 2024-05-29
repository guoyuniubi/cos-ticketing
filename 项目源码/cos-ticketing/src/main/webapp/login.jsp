<%--
  Created by IntelliJ IDEA.
  User: 23996
  Date: 2023/12/20
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login/register</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="./css/login.css">
    <script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () { //当页面的标签元素加载完成后，执行function中的代码
            $(".signUp").click(function () {
                let username = $("#username").val();
                let email = $("#email").val();
                let password = $("#password").val();
                // alert("value:"+value);
                //发送ajax的请求
                //$.ajax,$.get,$.post,$.getJSON
                $.ajax({
                    url:"/user/check",//请求的url
                    type:"post",//请求的方式
                    data:{"username":username,"email":email,"password":password},//请求的参数
                    dataType:"json",//表示服务器返回的数据类型
                    success:function (data) {//请求成功后的回调函数,data表示服务器返回的数据
                        if(data){
                            alert("注册成功")
                        }else {
                            alert("账号或者邮箱已存在")
                        }
                    }
                })
            });
            $("[name=loginForm]").submit(function (e){
                e.preventDefault();
                let username = $(".loginName").val();
                let password = $(".loginPass").val();
                $.ajax({
                    url:"/user/login",//请求的url
                    type:"post",//请求的方式
                    data:{"username":username,"password":password},//请求的参数
                    dataType:"json",//表示服务器返回的数据类型
                    success:function (data) {//请求成功后的回调函数,data表示服务器返回的数据
                        if(data){
                            window.location.href="/pages/main.jsp"
                        }else {
                            $(".error").html("账号或者密码错误")
                        }
                    }
                })
                }
            );
        })
    </script>
</head>

<body>
<!-- login/register container -->

<div class="container">
    <!-- register -->
<%--    <form name="register" action="/user/register" method="post">--%>
        <div class="form-container sign-up-container">
            <div class="form">
                <h2>sign up</h2>
                <input type="text" name="username" id="username" placeholder="Username..." required>
                <input type="email" name="email" id="email" placeholder="Email..." required>
                <input type="password" name="password" id="password" placeholder="Password..." required>
                <button class="signUp" >sign up</button>
            </div>
        </div>
<%--    </form>--%>
    <!-- login -->
    <form action="/pages/main.jsp" method="post" name="loginForm">
        <div class="form-container sign-in-container">
            <div class="form">
                <h2>sign in</h2>
                <input type="username" name="username" class="loginName" placeholder="Username..." required>
                <input type="password" name="password" class="loginPass" placeholder="Password..." required>
                <span class="error"></span>
                <a href="#" class="forget-password">forget your password</a>
                <button class="signIn">sign in</button>
            </div>
        </div>
    </form>
    <!-- overlay container -->
    <div class="overlay_container">
        <div class="overlay">
            <!-- overlay left -->
            <div class="overlay_panel overlay_left_container">
                <h2>welcome back!</h2>
                <p>To keep connected with us please login with your personal info</p>
                <button id="sign-in">sign in</button>
            </div>
            <!-- overlay right -->
            <div class="overlay_panel overlay_right_container">
                <h2>hello friend!</h2>
                <p>Enter your personal details and start journey with us</p>
                <button id="sign-up">sign up</button>
            </div>
        </div>
    </div>
</div>


<script src="./js/login.js"></script>
</body>

</html>
