<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="template_header.jsp"/>

    <div class="row">
        <div class="col-xs-1"></div>
        <div class="col-xs-11">

            <form name="loginForm" method="POST" action="controller">
                <input type="hidden" name="command" value="login"/>
                Логин:<br/>
                <input type="text" name="login" value=""/>

                <br/>Пароль:<br/>
                <input type="password" name="password" value=""/>

                <div>Войти как <br/>
                    <label><input type="radio" name="adminflag" value="администратор">
                        администратор</label>
                    <br/>
                    <label><input type="radio" name="adminflag" value="клиент" checked="true"/>
                        клиент</label>
                </div>

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
        <div class="col-xs-1"></div>
    </div>

<jsp:include page="template_footer.jsp"/>