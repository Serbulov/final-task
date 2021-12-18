<%--
  Created by IntelliJ IDEA.
  User: Глеб
  Date: 12.12.2021
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить время работы департамента</title>
    <style>
        .style {
            text-align: center;
            font-family: "Century Gothic", serif;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="style">
    <h1>Изменить действующее рабочее время департамента</h1>
    <hr/>
    <hr/>
    <form method="get">
        <input type="hidden" name="actionName" value="change-current-working-hours-for-dep">
        <label for="departmentID">Департамент</label>
        <select class="style" id="departmentID" name="departmentID">
            <option value="2">Отдел управления</option>
            <option value="3">Бизнес отдел</option>
            <option value="4">Группа по управлению ИТ</option>
            <option value="5">Комитет по работе с клиентами</option>
        </select>
        <br/>

        <label for="working-hours">Время работы</label>
        <select class="style" id="working-hours" name="working-hours">
            <option value="2400">24:00 - 09:00</option>
            <option value="100">01:00 - 10:00</option>
            <option value="200">02:00 - 11:00</option>
            <option value="300">03:00 - 12:00</option>
            <option value="400">04:00 - 13:00</option>
            <option value="500">05:00 - 14:00</option>
            <option value="600">06:00 - 15:00</option>
            <option value="700">07:00 - 16:00</option>
            <option value="800">08:00 - 17:00</option>
            <option value="900">09:00 - 18:00</option>
            <option value="1000">10:00 - 19:00</option>
            <option value="1100">11:00 - 20:00</option>
            <option value="1200">12:00 - 21:00</option>
            <option value="1300">13:00 - 22:00</option>
            <option value="1400">14:00 - 23:00</option>
            <option value="1500">15:00 - 24:00</option>
            <option value="3000">Работать офлайн</option>
        </select>
        <br/>
        <br/>
        <button class="style">Изменить</button>
    </form>
</div>
</body>
</html>
