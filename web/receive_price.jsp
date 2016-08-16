<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="template_header.jsp"/>

<div class="row">
    <div class="col-xs-8"></div>
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

<jsp:include page="template_footer.jsp"/>