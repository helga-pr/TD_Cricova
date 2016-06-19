<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <style> <%@include file="../css/bootstrap.css" %> </style>

    <style>
        [class*="col-"] {
            background-color: #eee;
            border-right: 2px solid #fff;
            text-align: center;
            padding-top: 15px;
            padding-bottom: 15px;
            font-size: 2rem;
        }

        body {
            background: url(../resources/podgorii cer albastru departare vertical.jpg);
            background-size: 100%;
        }
    </style>
    <title>Торговый Дом &quotКрикова&quot</title>
</head>
<body class="main-background">
<div class="container-fluid">

    <form name="index" method="POST" action="Controller">
        <div class="row">
            <div class="col-xs-10">Торговый Дом &quotКрикова&quot</div>
            <div class="col-xs-2">
                <input type="hidden" name="command" value="login"/>
                <input type="submit" value="Log in"/>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <h3> Страница с текстом и картинками </h3>
            </div>
            <div class="col-xs-5">
                <div class="row">
                    <div class="col-xs-12">Колонка 1</div>
                    <div class="col-xs-6">Колонка 1-1</div>
                    <div class="col-xs-6">Колонка 1-2</div>
                </div>
            </div>
            <div class="col-xs-6 col-xs-offset-1">Колонка 2</div>

            <div class="col-xs-12">
                <h4> Контакты </h4>
            </div>
        </div>
    </form>
</div>


<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>

</body>
</html>