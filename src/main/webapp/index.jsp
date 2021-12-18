<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Time - Money</title>
    <style>
        .style {
            text-align: center;
            font-family: "Century Gothic", serif;
            margin-bottom: 10px;
        }

        .title {
            background-color: lightgray;
        }
    </style>
</head>
<body>
<div class="style">
    <h1>
        <%= "Time - Money App" %>
    </h1>
    <hr/>
    <%--  --------------------------------------------- Ввод данных ----------------------------------------------  --%>

    <div class="title">
        <h3>Ввод данных</h3>
    </div>

    <form action="new-employee" method="get">
        <input type="hidden" name="actionName" value="new-emp">
        <button class="style">Добавить нового сотрудника</button>
    </form>

    <form action="new-department" method="get">
        <input type="hidden" name="actionName" value="new-dep">
        <button class="style">Добавить новый департамент</button>
    </form>

    <form action="new-role" method="get">
        <input type="hidden" name="actionName" value="new-role">
        <button class="style">Добавить новую роль</button>
    </form>

    <form action="new-salary-type" method="get">
        <input type="hidden" name="actionName" value="new-salary-type">
        <button class="style">Добавить новую методику расчета ЗП</button>
    </form>

    <%--  ------------------------------------------ Отображение данных ------------------------------------------  --%>
    <div class="title">
        <h3>Отображение данных</h3>
    </div>
    <form action="show-all-employee" method="post">
        <input type="hidden" name="actionName" value="show-all-emp">
        <button class="style">Показать всех сотрудников</button>
    </form>

    <form action="show-all-department" method="post">
        <input type="hidden" name="actionName" value="show-all-dep">
        <button class="style">Показать все департаменты</button>
    </form>

    <form action="show-all-role" method="post">
        <input type="hidden" name="actionName" value="show-all-role">
        <button class="style">Показать все роли</button>
    </form>

    <form action="show-all-salary-type" method="post">
        <input type="hidden" name="actionName" value="show-all-salary-type">
        <button class="style">Показать все методики расчета ЗП</button>
    </form>

    <form action="show-all-working-hours" method="post">
        <input type="hidden" name="actionName" value="show-all-working-hours">
        <button class="style">Показать рабочие часы всех сотрудников</button>
    </form>
    <%--  --------------------------------------- Изменение методов работы ---------------------------------------  --%>
    <div class="title">
        <h3>Изменение времени работы</h3>
    </div>

    <form action="indicate-preferred-working-hours-for-emp" method="post">
        <input type="hidden" name="actionName" value="indicate-preferred-working-hours-for-emp">
        <button class="style">Указать предпочтительное время работы для сотрудника</button>
    </form>

    <form action="indicate-preferred-working-hours-for-dep" method="post">
        <input type="hidden" name="actionName" value="indicate-preferred-working-hours-for-dep">
        <button class="style">Указать предпочтительное время работы для департамента</button>
    </form>

    <hr width="150px">

    <form action="update-working-hours-for-emp" method="post">
        <input type="hidden" name="actionName" value="update-working-hours-for-emp">
        <button class="style">Изменить действующее время работы сотрудника</button>
    </form>

    <form action="update-working-hours-for-dep" method="post">
        <input type="hidden" name="actionName" value="update-working-hours-for-dep">
        <button class="style">Изменить действующее время работы департамента</button>
    </form>

    <%--  -------------------------------------- Отчеты о прибыли | убытках --------------------------------------  --%>
    <div class="title">
        <h3>Отчеты о прибыли | убытках</h3>
    </div>
    <form action="show-general-report" method="post">
        <input type="hidden" name="actionName" value="show-general-report">
        <button class="style">Предоставить общий отчет о прибыли|убытках</button>
    </form>

    <form action="show-emp-report" method="post">
        <input type="hidden" name="actionName" value="show-emp-report">
        <button class="style">Предоставить отчет о прибыли|убытках по каждому сотруднику</button>
    </form>

    <form action="show-dep-report" method="post">
        <input type="hidden" name="actionName" value="show-dep-report">
        <button class="style">Предоставить отчет о прибыли|убытках по каждому департаменту</button>
    </form>

    <hr/>
    <hr/>

</div>
</body>
</html>

<%--    <a href="hello-servlet">Hello Servlet</a>--%>