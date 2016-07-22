<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    <link href="css/bootstrap.css" rel="stylesheet">

    <title>Личный кабинет</title>
</head>

<body class="main-background">
<div class="container-fluid">

    <div id="header" class="row">
        <div class="col-xs-2">

            <img src="resources/Shampanskoe-2.jpg" id="logo" alt="Cricova" class="img-circle img-responsive">

        </div>
        <div class="col-xs-6">
            <h1>Торговый Дом &quotКрикова&quot</h1>
        </div>

        <div class="col-xs-2">
            Личный кабинет<br/>пользователя:<br/> ${clientname}<br/> (${login})
        </div>

        <div class="col-xs-2">
            <form name="userOffice" method="POST" action="controller">
                <input type="hidden" name="command" value="logout"/>
                <input type="submit" value="Выход"/>
            </form>

        </div>

        <div class="row">
            <div class="col-xs-2"></div>
            <div class="col-xs-8">
                <h3> Изменение данных профиля </h3>
            </div>
            <div class="col-xs-2"></div>
        </div>

        <div class="row">
            <div class="col-xs-2"></div>
            <div class="col-xs-4">Изменить имя</div>
            <div class="col-xs-4">Изменить пароль</div>
            <div class="col-xs-2"></div>
        </div>

        <div class="row">
            <div class="col-xs-2"></div>
            <div class="col-xs-4">Изменить контактные данные</div>
            <div class="col-xs-4">Изменить заметки о моей фирме</div>
            <div class="col-xs-2"></div>
        </div>

        <div id="footer" class="row">
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

</div>


<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

</body>
</html>