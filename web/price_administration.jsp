<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <div class="col-xs-2">
        Управление прайсами продукции
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
    </div>

    <div class="col-xs-8">
        <%--таблица товаров (price)--%>
        <table class="table table-bordered table-hover table-striped">
            <%--<table class="table table-hover table-striped">--%>
            <tr>
                <th></th>
                <th>Вид</th>
                <th>Наименование</th>
                <th>Цена, руб. (без НДС)</th>
                <th>Описание</th>

            </tr>
            <c:forEach var="wine" items="${winesPrice}">
                <tr>
                    <td>
                        <input type="radio" name="changedProductId" value=${wine.getId()}/>
                    </td>
                    <td>${wine.getImage()}</td>
                        <%--название и основные характеристики--%>
                    <td>${wine.toString()}</td>
                    <td>${wine.getPrice()}</td>
                    <td>${wine.getAnnotation()}</td>

                </tr>
            </c:forEach>

        </table>

    </div>
    <div class="col-xs-2"></div>
</div>


<jsp:include page="template_footer.jsp"/>