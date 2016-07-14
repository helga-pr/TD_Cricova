<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>

    <title>Торговый Дом &quotКрикова&quot</title>

</head>
<body class="main-background">
<div class="container-fluid">

    <div id="header" class="row">
        <div class="col-xs-2">
            <img src="resources/Shampanskoe-2.jpg" id="logo" alt="Cricova" class="img-circle img-responsive">
        </div>

        <div class="col-xs-8">
            <h1>Торговый Дом &quotКрикова&quot</h1>
        </div>
        <div class="col-xs-2"></div>
    </div>

    <div class="row">
        <div class="col-xs-1"></div>

        <div class="col-xs-11">
            <form class="form-horizontal" name="loginForm" method="POST" action="controller">
                <div class="col-xs-6">
                    <div class="row">
                        <div class="form-group">
                            <input type="hidden" name="command" value="new_client"/>
                            <label for="inputLogin" class="col-sm-4 control-label">Логин</label>

                            <div class="col-sm-8">
                                <input id="inputLogin" class="form-control" type="text" name="login"
                                       placeholder="your e-mail"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputPassword" class="col-sm-4 control-label">Пароль</label>

                            <div class="col-sm-8">
                                <input type="password" id="inputPassword" name="password"
                                       placeholder="Введите пароль"
                                       class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="repeatPassword" class="col-sm-4 control-label">Повторите Пароль</label>

                            <div class="col-sm-8">
                                <input type="password" id="repeatPassword" name="passwordRepeat"
                                       placeholder="Введите пароль еще раз" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputLastName" class="col-sm-4 control-label">Фамилия</label>

                            <div class="col-sm-8">
                                <input id="inputLastName" class="form-control" type="text"
                                       name="client_lastname"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputName" class="col-sm-4 control-label">Имя</label>

                            <div class="col-sm-8">
                                <input id="inputName" class="form-control" type="text" name="client_name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputMiddleName" class="col-sm-4 control-label">Отчество</label>

                            <div class="col-sm-8">
                                <input id="inputMiddleName" class="form-control" type="text"
                                       name="client_middlename"/>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="col-xs-1"></div>

                <div class="col-xs-5">
                    <div class="row">
                        <label class="col-sm-12">Моя организация:</label>
                    </div>

                    <div class="row">
                        <div class="form-group">
                            <label for="inputCompanyUnp" class="col-sm-4 control-label">УНП организации: </label>

                            <div class="col-sm-8">
                                <input id="inputCompanyUnp" class="form-control" type="text" name="company_unp"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputCompanyName" class="col-sm-4 control-label">Наименование: </label>

                            <div class="col-sm-8">
                                <input id="inputCompanyName" class="form-control" type="text" name="company_name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputCompanyNotes" class="col-sm-4 control-label">О моей
                                организации: </label>

                            <div class="col-sm-8">
                                <input id="inputCompanyNotes" class="form-control" type="text"
                                       name="company_notes"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputClientContacts" class="col-sm-4 control-label">
                                Мои контакты (тел., e-mail и т.п.) </label>

                            <div class="col-sm-8">
                                <input id="inputClientContacts" class="form-control" type="text"
                                       name="client_contacts"/>
                            </div>
                        </div>

                    </div>

                </div>
                ${errorLoginPassMessage}
                <br/>
                ${wrongAction}
                <br/>
                ${nullPage}
                <br/>

                <div class="row">
                    <input type="submit" value="Зарегистрироваться"/>
                </div>
            </form>
        </div>
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