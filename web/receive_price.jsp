<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    <link href="css/bootstrap.css" rel="stylesheet">
    <style> <%@include file="css/bootstrap.css" %> </style>

    <style>
        [class*="col-"] {

            text-align: center;
            padding-top: 15px;
            padding-bottom: 15px;
            font-size: 2rem;
        }

        body {
            background: url(resources/podgorii_cer_albastru_departare_vertical.jpg);
            background-size: 80%;
        }
    </style>
    <title>Торговый Дом &quotКрикова&quot</title>
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
            Пользователь:<br/> ${fio}<br/> (${login})
        </div>

        <div class="col-xs-2">
            <form name="administrationForm" method="POST" action="controller">
                <input type="hidden" name="command" value="logout"/>
                <input type="submit" value="Log out"/>
            </form>
            <form name="changeUserInfo" method="POST" action="controller">
                <input type="hidden" name="command" value="change_user_info"/>
                <input type="submit" value="Изменить данные профиля" class="btn-link"/>
            </form>


        </div>
    </div>

    <div class="row">
        <div class="col-xs-2">

            <form name="loginForm" method="POST" action="controller">
                <input type="hidden" name="command" value="receive_price"/>
                <br/>e-mail:<br/>
                <input type="text" name="new_email" value=${login}/>

                <div>Использовать мой зарегистрированный e-mail
                    <input type="checkbox" checked="checked" name="my_email_flag"/>
                </div>

                ${info} ${errorLoginPassMessage} ${wrongAction} ${nullPage}
                <br/>
                <input type="submit" value="Получить прайс продукции"/>

            </form>

        </div>
        <div class="col-xs-10">
            <%--таблица товаров (price)--%>
            <%--<table class="table table-bordered table-hover table-striped">--%>
            <table class="table table-hover table-striped">
                <%--<tr>--%>
                <%--<th></th>--%>
                <%--<th></th>--%>
                <%--<th></th>--%>
                <%----%>
                <%--</tr>--%>
                <foreach var="wine" items="${winesPrice}">
                    <tr>
                        <td>${wine.getImage()}</td>
                        <%--<td>${wine.getName}</td>--%>
                        <td>${wine.toString()}</td>
                        <td>${wine.getPrice()}</td>
                        <td>${wine.getAnnotation()}</td>

                    </tr>
                </foreach>

            </table>
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

</div>
</body>
</html>