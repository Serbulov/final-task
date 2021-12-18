<%--
  Created by IntelliJ IDEA.
  User: Глеб
  Date: 10.12.2021
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление новой методики расчета ЗП</title>
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
    <h1>Добавление новой методики расчета ЗП</h1>
    <hr/>
    <hr/>
    <form action="add-new-salary-type" method="get">
        <input type="hidden" name="actionName" value="add-new-salary-type">
        <label for="salary-type-name">Тип методики расчета ЗП </label>
        <input class="style" id="salary-type-name" type="text" name="salary-type-name">
        <br/>
        <br/>
        <button class="style">Добавить</button>
    </form>
</div>
</body>
</html>
