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
            Личный кабинет<br/>пользователя:<br/> ${fio}<br/> (${login})
        </div>

        <div class="col-xs-2">
            <form name="userOfficeLogOut" method="POST" action="controller">
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

            <div class="row">
                <div class="col-xs-1"></div>

                <div class="col-xs-11">

                    <form class="form-horizontal" name="userOfficeChangeName" method="POST" action="controller">
                        <div class="form-group">
                            <label for="newName" class="col-sm-4 control-label">Старый Пароль</label>

                            <div class="col-sm-8">
                                <input type="text" id="newName" name="new_name"
                                       placeholder="Введите новое имя"
                                       class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputNewMiddleName" class="col-sm-4 control-label">Новое отчество</label>

                            <div class="col-sm-8">
                                <input type="text" id="inputNewMiddleName" name="new_middle_name"
                                       placeholder="Введите новое отчество"
                                       class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputNewLastName" class="col-sm-4 control-label">Новая фамилия</label>

                            <div class="col-sm-8">
                                <input type="text" id="inputNewLastName" name="new_last_name"
                                       placeholder="Введите новую фамилию" class="form-control">
                            </div>
                        </div>

                    </form>
                </div>
            </div>

            <div class="col-xs-4">Изменить пароль</div>

            <div class="row">
                <div class="col-xs-1"></div>

                <div class="col-xs-11">

                    <form class="form-horizontal" name="userOfficeChangePassword" method="POST" action="controller">
                        <div class="form-group">
                            <label for="inputOldPassword" class="col-sm-4 control-label">Старый Пароль</label>

                            <div class="col-sm-8">
                                <input type="password" id="inputOldPassword" name="old_password"
                                       placeholder="Введите старый пароль"
                                       class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputNewPassword" class="col-sm-4 control-label">Новый Пароль</label>

                            <div class="col-sm-8">
                                <input type="password" id="inputNewPassword" name="new_password"
                                       placeholder="Введите новый пароль"
                                       class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="repeatPassword" class="col-sm-4 control-label">Повторите новый Пароль</label>

                            <div class="col-sm-8">
                                <input type="password" id="repeatPassword" name="passwordRepeat"
                                       placeholder="Введите новый пароль еще раз" class="form-control">
                            </div>
                        </div>

                    </form>
                </div>
            </div>

            <div class="col-xs-2"></div>
        </div>

        <div class="row">
            <div class="col-xs-2"></div>
            <div class="col-xs-4">Изменить контактные данные</div>

            <div class="row">
                <div class="col-xs-1"></div>

                <div class="col-xs-11">

                    <form class="form-horizontal" name="loginForm" method="POST" action="controller">

                    </form>
                </div>
            </div>

            <div class="col-xs-4">Изменить заметки о моей фирме</div>

            <div class="row">
                <div class="col-xs-1"></div>

                <div class="col-xs-11">

                    <form class="form-horizontal" name="loginForm" method="POST" action="controller">

                    </form>
                </div>
            </div>

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