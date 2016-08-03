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

<%--  для установления кодировки получаемых из веб-форм параметров --%>
<%
    String paramEncoding = application.getInitParameter("PARAMETER_ENCODING");
    request.setCharacterEncoding(paramEncoding);

%>

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
    </div>

    <div class="row">
        <div class="col-xs-2"></div>
        <div class="col-xs-8">
            <h3> Изменение данных профиля </h3>
            <h4>Заполните поля данных о себе, которые желаете изменить и нажмите кнопку "Изменить"</h4>

            <h3>Изменить имя:</h3>

            <div class="row">
                <form class="form-horizontal" name="userOfficeChangeName" method="POST"
                      action="controller" accept-charset="utf-8">

                    <div class="form-group">
                        <label for="newName" class="col-sm-5 control-label">Имя</label>
                        <input type="text" id="newName" name="new_name"
                               placeholder=${userName}
                                       class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="inputNewMiddleName" class="col-sm-5 control-label">Отчество</label>
                        <input type="text" id="inputNewMiddleName" name="new_middle_name"
                               placeholder=${userMiddleName}
                                       class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="inputNewLastName" class="col-sm-5 control-label">Фамилия</label>
                        <input type="text" id="inputNewLastName" name="new_last_name"
                               placeholder=${userLastName} class="form-control">
                    </div>

                    <input type="submit" value="Изменить имя" class="btn-warning btn-primary">

                </form>
            </div>

            <h3>Изменить пароль:</h3>

            <div class="row">
                <form class="form-horizontal" name="userOfficeChangePassword" method="POST"
                      action="controller" accept-charset="utf-8">

                    <div class="form-group">
                        <label for="oldPassword" class="col-sm-5 control-label">Старый пароль</label>
                        <input type="password" id="oldPassword" name="new_password"
                               placeholder="Старый пароль"
                               class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="newPassword" class="col-sm-5 control-label">Новый пароль</label>
                        <input type="password" id="newPassword" name="new_middle_name"
                               placeholder="Новый пароль"
                               class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="repeatPassword" class="col-sm-5 control-label">Повторите
                            пароль</label>
                        <input type="password" id="repeatPassword" name="new_last_name"
                               placeholder="Повторите пароль" class="form-control">
                    </div>

                    <input type="submit" value="Изменить пароль" class="btn-warning btn-primary">
                </form>
            </div>

            <h3>${updateUserDataMessage}</h3>

            <form class="form-horizontal" name="changeContactData" method="POST" action="controller"
                  accept-charset="utf-8">
                <h3>Изменить мои контактные данные</h3>

                <div class="form-group">
                    <label for="changeMyContacts" class="control-label">
                        Мои контактные данные:
                    </label>
                    <input type="text" id="changeMyContacts" name="change_my_contacts"
                           placeholder=${userContacts} class="form-control">
                    <input type="submit" value="Изменить мои контакты" class="btn-warning btn-primary">
                </div>
                <div class="form-group">
                    <label for="changeCompanyNotes" class="control-label">
                        О компании:
                    </label>
                    <input type="text" id="changeCompanyNotes" name="change_company_notes"
                           placeholder=${companyNotes} class="form-control">
                    <input type="submit" value="Изменить информацию о компании" class="btn-warning btn-primary">
                </div>

            </form>
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


    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>

</div>
</body>
</html>