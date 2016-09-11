<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="template_header.jsp"/>

<div class="row">
    <div class="col-xs-6">
        <h3>Администрирование</h3>

    </div>

    <div class="col-xs-4">
        Администратор: ${login}

    </div>

    <div class="col-xs-2">
        <form name="administrationForm" method="POST" action="controller">
            <input type="hidden" name="command" value="logout"/>
            <input type="submit" value="Log out"/>
        </form>
    </div>
</div>


<div class="row">
    <div class="col-xs-2"></div>
    <div class="col-xs-2">
        <form name="administrationForm" method="POST" action="controller">
            <input type="hidden" name="command" value="show_price"/>
            <input type="submit" value="Прайс продукции" class="btn btn-info"/>
        </form>
        <br/><br/>

        <form name="administrationForm" method="POST" action="controller">
            <input type="hidden" name="command" value="change_page_view"/>
            <input type="submit" value="Изменить страницу сайта" class="btn btn-warning"/>
        </form>

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

<jsp:include page="template_footer.jsp"/>