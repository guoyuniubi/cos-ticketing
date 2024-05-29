<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 23996
  Date: 2023/12/27
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/order.css">
    <script src="/js/jquery-3.5.1.min.js"></script>
    <title>我的购票订单</title>
    <script>
        function fillZero (str) {
            let realNum;
            if (str < 10) {
                realNum = '0' + str;
            } else {
                realNum = str;
            }
            return realNum;
        }
        function getNowTime () {
            let now = new Date();
            let year = now.getFullYear(); //获取完整的年份(4位,1970-????)
            let month = now.getMonth() + 1; //获取当前月份(0-11,0代表1月)
            let today = now.getDate(); //获取当前日(1-31)
            let hour = now.getHours(); //获取当前小时数(0-23)
            let minute = now.getMinutes(); //获取当前分钟数(0-59)
            let second = now.getSeconds(); //获取当前秒数(0-59)
            let nowTime = ''
            nowTime = year + '-' + fillZero(month) + '-' + fillZero(today) + ' ' + fillZero(hour) + ':' +
                fillZero(minute) + ':' + fillZero(second)
            return nowTime
        }
        $(function () {
            $(".submit").click(function () {
                var textarea = $(this).prev();
                var oid = textarea.attr("id").split("-")[2];
                var eid = textarea.attr("id").split("-")[3];
                var uid = textarea.attr("id").split("-")[4];
                var comment = $("#comment-text-" + oid + "-" + eid+ "-" +uid).val();
                var rTime = getNowTime();
                $.ajax({
                    url: "/user/comment",
                    type: "post",
                    data: {
                        uid: uid,
                        rContent: comment,
                        eid: eid,
                        rTime: rTime
                    },
                    success: function (data) {
                        if (data) {
                            alert("您的评论已提交，感谢您的反馈！");
                            $("#comment-form-" + oid).hide();
                        } else {
                            alert("评论失败");
                        }
                    }
                })
            })

            $(".pay-button").click(function () {
                if (confirm("是否确定支付？") == false) {
                    return;
                }
                var order_info = $(this).parent().prev();
                var oid= order_info.children("input").val();
                var totalPrice = order_info.children("span").eq(2).text().split("￥")[1];
                var oNum = order_info.children("span").eq(1).text().split("：")[1];
                var oTime = getNowTime();
                $.ajax({
                    url: "/user/toPay",
                    type: "post",
                    data: {
                        oid: oid,
                        totalPrice: totalPrice,
                        oNum: oNum,
                        oTime: oTime
                    },
                    success: function (data) {
                        if (data) {
                            alert("支付成功");
                            window.location.reload();
                        } else {
                            alert("余额不足");
                        }
                    }
                })
            })
        })

    </script>
</head>
<body>
<div class="container">
    <div class="title">我的购票订单</div>
    <c:forEach items="${orders}" var="order" varStatus="v">
    <div class="order">
        <div class="order-info">
            <input hidden value="${order.oid}">
            <span>订单号：20211230000${order.oid}</span>
            <span>购票数量：${order.getONum()}</span>
            <span>总金额：￥${order.getTotalPrice()}</span>
            <span>下单时间：<fmt:formatDate value="${order.getOTime()}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
            <span class="ticket-type concert">${eNames.get(v.index)}</span>
            <span class="order-status unpaid">${order.getStatus()}</span>
        </div>
        <div class="order-actions">
            <button>
                <a href="/user/deleteByOid?oid=${order.oid}&status=${order.getStatus()}" onclick="return confirm('是否确定删除')">删除订单</a>
            </button>
            <button>
            <a href="#" <c:if test="${order.getStatus() == '已支付'}">
                disabled
            </c:if>>修改订单</a>
            </button>
            <c:if test="${order.getStatus() == '未支付'}">
            <button class="pay-button">
                支付订单
            </button>
        </div>
            </c:if>
        <c:if test="${order.getStatus() == '已支付'}">
        <button class="comment-button" onclick="showCommentForm('${order.oid}')">发表评论</button>
    </div>
    <div class="comment-form" id="comment-form-${order.oid}">
        <textarea id="comment-text-${order.oid}-${order.tid}-${user.uid}" placeholder="请输入您的评论内容"></textarea>
        <button  class="submit">提交</button>
    </div>
    </c:if>

    </div>
    </c:forEach>
</div>
</body>
<script>
    function showCommentForm(orderId) {
        var commentForm = document.getElementById("comment-form-" + orderId);
        commentForm.style.display = "block";
    }

</script>
</html>
