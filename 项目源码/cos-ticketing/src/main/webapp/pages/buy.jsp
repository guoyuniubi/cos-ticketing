<%--
  Created by IntelliJ IDEA.
  User: 23996
  Date: 2023/12/27
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/buy.css">
</head>
<body>
<div class="container">
    <div class="title">购票页面</div>
    <div class="ticket">
        <div class="ticket-name">${eName}</div>
        <div class="ticket-price">${ticket.getTPrice()}</div>
    </div>
    <div class="quantity">
        <div class="quantity-label">数量：</div>
        <input class="quantity-input" type="number" id="quantity" value="1" min="1" max="10" onchange="updateTotal()">
    </div>
    <div class="total">
        <div class="total-label">总价：</div>
        <div class="total-value" id="total">￥${ticket.getTPrice()}</div>
    </div>
    <button class="button">加入订单</button>
</div>
<script>
    // 获取元素
    let quantity = document.getElementById("quantity");
    let total = document.getElementById("total");

    // 定义一个函数，根据数量更新总价
    function updateTotal() {
        // 获取数量的值
        let quantityValue = parseInt(quantity.value);
        // 计算总价
        let totalValue = quantityValue * ${ticket.getTPrice()};
        totalValue = totalValue.toFixed(2);
        // 显示总价
        total.innerHTML = "￥" + totalValue;
    }

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

    let button = document.querySelector(".button");
    button.addEventListener("click", function () {
        let b=confirm("确定购买吗？");
        if(b===false){
            return
        }else {
            let quantityValue = parseInt(quantity.value);
            let totalValue = quantityValue * ${ticket.getTPrice()};
            let nowTime = new Date();
            totalValue = totalValue.toFixed(2);
            url = "/user/buyTicket?uid=${user.getUid()}&tid=${ticket.getTid()}&oNum=" + quantityValue + "&totalPrice=" + totalValue + "&oTime=" + getNowTime();
            window.location.href = url;
        }
    })

</script>
</body>
</html>

