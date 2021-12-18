<%--
  Created by IntelliJ IDEA.
  User: Глеб
  Date: 10.12.2021
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление нового департамента</title>
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
    <h1>Добавление нового департамента</h1>
    <hr/>
    <hr/>
    <form action="add-new-dep" method="get">
        <input type="hidden" name="actionName" value="add-new-dep">
        <label for="department-name">Название департамента </label>
        <input class="style" id="department-name" type="text" name="department-name">
        <br/>
        <br/>
        <button class="style">Добавить</button>
    </form>
</div>
</body>
</html>
