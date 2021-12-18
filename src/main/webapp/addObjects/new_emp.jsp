<%--
  Created by IntelliJ IDEA.
  User: Глеб
  Date: 07.12.2021
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление нового сотрудника</title>
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
    <h1>Добавление нового сотрудника</h1>
    <hr/>
    <hr/>

    <form action="add-new-emp" method="post">
        <input type="hidden" name="actionName" value="add-new-emp">

        <label for="firstName">Имя </label>
        <input class="style" id="firstName" type="text" name="firstName">

        <br/>
        <label for="lastName">Фамилия </label>
        <input class="style" id="lastName" type="text" name="lastName">
        <br/>

        <label for="department-name">Департамент</label>
        <select class="style" id="department-name" name="department-name">
            <option value="1">Офис CIO</option>
            <option value="2">Отдел управления</option>
            <option value="3">Бизнес отдел</option>
            <option value="4">Группа по управлению ИТ</option>
            <option value="5">Комитет по работе с клиентами</option>
        </select>
        <br/>

        <label for="role-name">Роль</label>
        <select class="style" id="role-name" name="role-name">
            <option value="1">CIO (ИТ-директор)</option>
            <option value="2">Менеджер по развитию бизнеса</option>
            <option value="3">Менеджер по Информационной Безопасности</option>
            <option value="4">Менеджер по Качеству</option>
            <option value="5">Архитектор решений для корпораций</option>
            <option value="6">Финансовый аналитик</option>
            <option value="7">Менеджер по работе с поставщиками</option>
            <option value="8">Юрисконсульт</option>
            <option value="9">Менеджер по снабжению</option>
            <option value="10">Владелец Проекта</option>
            <option value="11">Специалист по целевому маркетингу</option>
            <option value="12">Руководитель Проекта</option>
            <option value="13">Бизнес-лид</option>
            <option value="14">Руководитель Услуг</option>
            <option value="15">Сервис-менеджер</option>
            <option value="16">Менеджер по коммуникациям через соц. сети</option>
            <option value="17">Менеджер по взаимоотношениям с бизнесом (BRM)</option>
            <option value="18">Ответственный за бизнес-процесс</option>
            <option value="19">Бизнес-аналитик</option>
        </select>
        <br/>

        <label for="salary">Зарплата </label>
        <input class="style" id="salary" type="number" name="salary">
        <br/>

        <label for="salary-type">Тип методики расчета ЗП</label>
        <select class="style" id="salary-type" name="salary-type">
            <option value="1">Базовый оклад (160 рабочих часов)</option>
            <option value="2">Почасовая оплата</option>
            <option value="3">Базовый оклад + процент от ежемесячных продаж</option>
        </select>
        <br/>
        <br/>
        <button class="style">Добавить</button>
    </form>
</div>
</body>
</html>
