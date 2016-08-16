<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="template_header.jsp"/>

<div class="row">
    <div class="col-xs-8"><h3> Страница с текстом и картинками </h3></div>
    <div class="col-xs-2">
        <form name="index" method="POST" action="controller">
            <input type="hidden" name="command" value="to_login_page"/>
            <input type="submit" value="Log in"/>

        </form>


        <form name="newClientForm" method="POST" action="controller">
            <input type="hidden" name="command" value="no_registration"/>
            <input type="submit" value="Зарегистрироваться" class="btn-link"/>

            <div> ${errorLoginPassMessage} ${wrongAction} ${nullPage}</div>

        </form>

    </div>
</div>
</div>

<div class="row">
    <div class="col-xs-10"></div>
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

<jsp:include page="template_footer.jsp"/>