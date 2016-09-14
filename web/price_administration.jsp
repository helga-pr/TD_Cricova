<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="template_header.jsp"/>

<div class="row">
    <div class="col-xs-2">
        <h3>Администрирование</h3>

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

    <div class="col-xs-2">
        <h4>Администратор: ${login}</h4>

        <form name="administrationForm" method="POST" action="controller">
            <input type="hidden" name="command" value="logout"/>
            <input type="submit" value="Log out" class="small"/>
        </form>

    </div>
</div>

<%--/////////////////////////////////--%>
<%--Изменение прайса продукции--%>
<form name="administrationForm" method="POST" action="controller">
    <input type="hidden" name="command" value="change_price"/>

    <div class="row">
        <div class="col-xs-2">
            Управление прайсами продукции
            <br/><br/>

            <input type="submit" name="buttonName" value="Добавить пункт прайса" class="btn btn-warning"/>

            <br/><br/>

            <input type="submit" name="buttonName" value="Изменить пункт прайса" class="btn btn-warning"/>

            <br/><br/>

            <input type="submit" name="buttonName" value="Удалить пункт прайса" class="btn btn-danger"/>
            <%--сообщение о результате проведенного удаления объекта БД--%>
            <h4>${messageForPrice}</h4>

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
</form>

<jsp:include page="template_footer.jsp"/>