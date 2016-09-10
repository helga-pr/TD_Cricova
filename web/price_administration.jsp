<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="template_header.jsp"/>

<div class="row">
    <div class="col-xs-1">
        <h3>Администрирование</h3>

    </div>

    <div class="col-xs-7">
        <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
            <input type="hidden" name="command" value="change_price_by_criteria"/>
            <input type="submit" value="Составить прайс согласно выбранным критериям" class="btn"/>

            <select name="wineTypeSelected"><%--Тип (тихое или игристое) вина выбрать--%>
                <%--Тип вина:--%>
                <option selected>все типы вин</option>
                <c:forEach var="enumUnit" items="${wineTypeEnum}">
                    <option>${enumUnit.getValueToString()}</option>
                </c:forEach>
            </select>

            <select name="wineAgeSelected"><%--Выдержку вина выбрать--%>
                <%--Выдержка вина:--%>
                <option selected>все вина по выдержке</option>
                <c:forEach var="enumUnit" items="${wineAgeEnum}">
                    <option>${enumUnit.getValueToString()}</option>
                </c:forEach>
            </select>

            <select name="wineColorSelected"><%--Цвет вина выбрать--%>
                <%--Цвет вина:--%>
                <option selected>все вина по цвету</option>
                <c:forEach var="enumUnit" items="${wineColorEnum}">
                    <option>${enumUnit.getValueToString()}</option>
                </c:forEach>
            </select>

            <p></p>

            <select name="wineSugarSelected"><%--Содержание сахара вина выбрать--%>
                <%--Содержание сахара в вине:--%>
                <option selected>все вина по содерж. сахара</option>
                <c:forEach var="enumUnit" items="${wineSugarEnum}">
                    <option>${enumUnit.getValueToString()}</option>
                </c:forEach>
            </select>

            <select name="wineSpiritSelected"><%--Крепость вина выбрать--%>
                <%--Содержание спирта в вине:--%>
                <option selected>все вина по крепости</option>
                <c:forEach var="enumUnit" items="${wineSpiritEnum}">
                    <option>${enumUnit.getValueToString()}</option>
                </c:forEach>
            </select>

            <select name="wineCollectionSelected"><%--Коллекцию вина выбрать--%>
                <%--Вино из коллекции:--%>
                <option selected>вина из всех коллекций</option>
                <c:forEach var="enumUnit" items="${wineCollectionEnum}">
                    <option>${enumUnit.getValueToString()}</option>
                </c:forEach>
            </select>
        </form>

    </div>

    <div class="col-xs-2">
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