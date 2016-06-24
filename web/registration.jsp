<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>

    <title>Торговый Дом &quotКрикова&quot</title>

</head>
<body>

<div class="conteiner-fluid">

    <h1>Торговый Дом &quotКрикова&quot</h1>

    <br/>

    <div class="row">
        <div class="col-xs-1"></div>
        <div class="col-xs-11">

            <form name="loginForm" method="POST" action="controller">
                <input type="hidden" name="command" value="new_client"/>
                Логин:<br/>
                <input type="text" name="login" value="your e-mail"/>
                <br/>
                <br/>Пароль:<br/>
                <input type="password" name="password" value=""/>
                <br/>
                <br/>Повторите Пароль:<br/>
                <input type="password" name="password" value=""/>
                <br/>

                <br/>
                ${errorLoginPassMessage}
                <br/>
                ${wrongAction}
                <br/>
                ${nullPage}
                <br/>
                <input type="submit" value="Log in"/>
            </form>

        </div>
    </div>
    <div class="row">
        <div class="col-xs-2"></div>
        <div class="col-xs-8">
            <h4 class="bg-primary"> Контакты: </h4>
            <h4>Офис в г. Минске...; тел./факс 8-017-356-**-**; сайт www.td_cricova.com;</h4>
            <h4>Торговые представители в регионах: </h4>

            <h4>Брест: +375-29-***-**-**; Гродно: +375-29-***-**-**; Витебск: +375-29-***-**-**; </h4>
        </div>
        <div class="col-xs-2"></div>
    </div>
</div>

<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

</body>
</html>