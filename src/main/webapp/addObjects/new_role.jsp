<%--
  Created by IntelliJ IDEA.
  User: Глеб
  Date: 10.12.2021
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление новой роли</title>
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
    <h1>Добавление новой роли</h1>
    <hr/>
    <hr/>
    <form action="add-new-role" method="get">
        <input type="hidden" name="actionName" value="add-new-role">

        <label for="role-name">Название роли </label>
        <input class="style" id="role-name" type="text" name="role-name">
        <br/>
        <label for="role-function-area">Функциональная область</label>
        <select class="style" id="role-function-area" name="role-function-area">
            <option>Управление</option>
            <option>Развитие</option>
            <option>Услуги</option>
            <option>Спрос</option>
        </select>
        <br/>
        <br/>
        <button class="style">Добавить</button>
    </form>
</div>
</body>
</html>
