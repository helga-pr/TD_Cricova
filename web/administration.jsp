<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>


    <title>Торговый Дом &quotКрикова&quot</title>

</head>
<body>
<div class="container-fluid">

    <div class="row">
        <div class="col-xs-6">
            <h3>Администрирование</h3>

        </div>

        <div class="col-xs-4">
            Администратор: ${user}

        </div>

        <div class="col-xs-2">
            <form name="administrationForm" method="POST" action="controller">
                <input type="hidden" name="command" value="logout"/>
                <input type="submit" value="Log out"/>
            </form>
        </div>
    </div>


    <div class="row">
        <div class="col-xs-4">
            <form name="administrationForm" method="POST" action="controller">
                <input type="hidden" name="command" value="show_price"/>
                <input type="submit" value="Прайс продукции" class="btn btn-info"/>
            </form>
            <br/><br/>

            <form name="administrationForm" method="POST" action="controller">
                <input type="hidden" name="command" value="change_product"/>
                <input type="submit" value="Изменить пункт прайса" class="btn btn-warning"/>
            </form>
            <br/><br/>

            <form name="administrationForm" method="POST" action="controller">
                <input type="hidden" name="command" value="add_product"/>
                <input type="submit" value="Добавить пункт прайса" class="btn btn-warning"/>
            </form>
            <br/><br/>

            <form name="administrationForm" method="POST" action="controller">
                <input type="hidden" name="command" value="delete_product"/>
                <input type="submit" value="Удалить пункт прайса" class="btn btn-danger"/>
            </form>
            <br/><br/>


        </div>
        <div class="col-xs-1"></div>
        <div class="col-xs-7">


        </div>
    </div>


    <div class="row">
        <div class="col-xs-2"></div>
        <div class="col-xs-8">

        </div>
        <div class="col-xs-2"></div>
    </div>

    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</div>
</div>
</body>
</html>