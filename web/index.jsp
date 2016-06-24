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
            background-size: 100%;
        }
    </style>
    <title>Торговый Дом &quotКрикова&quot</title>
</head>
<body class="main-background">
<div class="container-fluid">

    <form name="index" method="POST" action="controller">
        <div class="row">
            <div class="col-xs-10">
                <h1>Торговый Дом &quotКрикова&quot</h1>
            </div>
            <div class="col-xs-2">
                <input type="hidden" name="command" value="to_login_page"/>
                <input type="submit" value="Log in"/>
            </div>
        </div>
    </form>

    <div class="row">
        <div class="col-xs-2"></div>
        <div class="col-xs-8">
            <h3> Страница с текстом и картинками </h3>
        </div>
        <div class="col-xs-2"></div>
    </div>

    <div class="row">
        <div class="col-xs-2"></div>
        <div class="col-xs-4">Article-1-picture</div>
        <div class="col-xs-4">Article-1-text</div>
        <div class="col-xs-2"></div>
    </div>

    <div class="row">
        <div class="col-xs-2"></div>
        <div class="col-xs-4">Article-2-picture</div>
        <div class="col-xs-4">Article-2-text</div>
        <div class="col-xs-2"></div>
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

</div>


<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

</body>
</html>