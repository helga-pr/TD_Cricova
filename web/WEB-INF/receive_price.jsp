﻿<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="template_header.jsp"/>

<div class="row">

    <div class="col-xs-1">

        Выбор критерия:
    </div>
    <div class="col-xs-8">

        <div class="row">
            <div class="col-xs-4">
                <%--Тип (тихое или игристое) вина выбрать--%>
                <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                    <input type="hidden" name="command" value="change_price_by_criteria"/>
                    <select name="wineTypeSelected" class="small">
                        <%--Тип вина:--%>
                        <%--по умолчанию все вина выводятся в таблицу из БД--%>
                        <option selected>все типы вин</option>
                        <%--Если выбран какой-то один тип вина
                        то таблица обнавляется (устанавливается "фильтр")
                        и в строке выбора остается выбранный элемент после обновления таблицы
                        --%>
                        <c:forEach var="enumUnit" items="${wineTypeEnum}">
                            <c:choose>
                                <c:when test="${enumUnit.getValue() == chosenCriteria}">
                                    <option selected>${enumUnit.getValue()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option>${enumUnit.getValue()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button>
                </form>
            </div>


            <%--Содержание сахара вина выбрать--%>
            <div class="col-xs-4">
                <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                    <input type="hidden" name="command" value="change_price_by_criteria"/>
                    <select name="wineSugarSelected" class="small">
                        <%--Содержание сахара в вине:--%>
                        <option selected>все вина по содерж. сахара</option>
                        <%--Если выбран какой-то один тип вина
                            то таблица обнавляется (устанавливается "фильтр")
                            и в строке выбора остается выбранный элемент после обновления таблицы--%>
                        <c:forEach var="enumUnit" items="${wineSugarEnum}">
                            <c:choose>
                                <c:when test="${enumUnit.getValue() == chosenCriteria}">
                                    <option selected>${enumUnit.getValue()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option>${enumUnit.getValue()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button>
                </form>
            </div>

            <%--Цвет вина выбрать--%>
            <div class="col-xs-4">
                <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                    <input type="hidden" name="command" value="change_price_by_criteria"/>
                    <select name="wineColorSelected" class="small">
                        <%--Цвет вина:--%>
                        <option selected>все вина по цвету</option>
                        <%--Если выбран какой-то один цвет вина
                        то таблица обнавляется (устанавливается "фильтр")
                        и в строке выбора остается выбранный элемент после обновления таблицы--%>
                        <c:forEach var="enumUnit" items="${wineColorEnum}">
                            <c:choose>
                                <c:when test="${enumUnit.getValue() == chosenCriteria}">
                                    <option selected>${enumUnit.getValue()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option>${enumUnit.getValue()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button>
                </form>
            </div>
        </div>


        <div class="row">
            <div class="col-xs-4">
                <%--Выдержку вина выбрать--%>
                <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                    <input type="hidden" name="command" value="change_price_by_criteria"/>
                    <select name="wineAgeSelected" class="small">
                        <%--Выдержка вина:--%>
                        <%--по умолчанию все вина выводятся в таблицу из БД--%>
                        <option selected>все вина по выдержке</option>
                        <%--Если выбран какой-то один тип вина
                        то таблица обнавляется (устанавливается "фильтр")
                        и в строке выбора остается выбранный элемент после обновления таблицы--%>
                        <c:forEach var="enumUnit" items="${wineAgeEnum}">
                            <c:choose>
                                <c:when test="${enumUnit.getValue() == chosenCriteria}">
                                    <option selected>${enumUnit.getValue()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option>${enumUnit.getValue()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button>
                </form>
            </div>

            <%--Крепость вина выбрать--%>
            <div class="col-xs-4">
                <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                    <input type="hidden" name="command" value="change_price_by_criteria"/>
                    <select name="wineSpiritSelected" class="small">
                        <%--Содержание спирта в вине:--%>
                        <option selected>все вина по крепости</option>
                        <%--Если выбран какой-то один тип вина
                            то таблица обнавляется (устанавливается "фильтр")
                            и в строке выбора остается выбранный элемент после обновления таблицы--%>
                        <c:forEach var="enumUnit" items="${wineSpiritEnum}">
                            <c:choose>
                                <c:when test="${enumUnit.getValue() == chosenCriteria}">
                                    <option selected>${enumUnit.getValue()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option>${enumUnit.getValue()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button>
                </form>
            </div>


            <%--Коллекцию вина выбрать--%>
            <div class="col-xs-4">
                <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                    <input type="hidden" name="command" value="change_price_by_criteria"/>
                    <select name="wineCollectionSelected" class="small">
                        <%--Вино из коллекции:--%>
                        <option selected>вина из всех коллекций</option>
                        <%--Если выбрана какая-то одна коллекция вина
                            то таблица обнавляется (устанавливается "фильтр")
                            и в строке выбора остается выбранный элемент после обновления таблицы--%>
                        <c:forEach var="enumUnit" items="${wineCollectionEnum}">
                            <c:choose>
                                <c:when test="${enumUnit.getValue() == chosenCriteria}">
                                    <option selected>${enumUnit.getValue()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option>${enumUnit.getValue()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i></button>
                </form>
            </div>
        </div>

    </div>


    <div class="col-xs-1 small">
        <h5>Пользователь:<br/> ${fio}<br/> (${login})</h5>
    </div>

    <div class="col-xs-2">
        <form name="administrationForm" method="POST" action="controller">
            <input type="hidden" name="command" value="logout"/>
            <input type="submit" value="Выход" class="btn-primary"/>
        </form>
        <br/>the project is complete (for protection)
        <form name="changeUserInfo" method="POST" action="controller">
            <input type="hidden" name="command" value="change_user_info"/>
            <b></b><h5><input type="submit" value="Изменить данные профиля" class="btn-link"/></h5></b>
        </form>

    </div>
</div>
</div>

<div class="row">
    <div class="col-xs-1">

    </div>
    <div class="col-xs-10">

        <%--таблица товаров (price)--%>
        <%--<table class="table table-bordered table-hover table-striped">--%>
        <table class="table table-hover table-striped">
            <tr>
                <th></th>
                <th>Наименование товара</th>
                <th>Цена</th>
                <th>Доп. информация</th>

            </tr>
            <c:forEach var="wine" items="${winesPrice}">
                <tr>
                        <%--для вывода изображения товара вызывается другой сервлет--%>
                    <td><img height="80" name="wineImage" src="showImageController?id=${wine.getId()}"/></td>
                    <td>${wine.toString()}</td>
                    <td>${wine.getPrice()} руб. без НДС</td>
                    <td>${wine.getAnnotation()}</td>

                </tr>
            </c:forEach>

        </table>
    </div>

    <div class="col-xs-1"></div>

</div>

<jsp:include page="template_footer.jsp"/>