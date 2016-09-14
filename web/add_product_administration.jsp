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

<div class="col-xs-2"></div>

<div class="col-xs-2"></div>

<form name="administrationForm" method="POST" action="controller">
    <input type="hidden" name="command" value="add_change_price_position"/>

    <div class="col-xs-8">
        <%--таблица для изменения/добавления товара (пункта прайса)--%>
        <table class="table table-bordered table-hover table-striped">
            <tr>
                <th>Наименование</th>
                <th>Цена, руб. (без НДС)</th>
                <th>Ставка НДС, %</th>
                <th>Фото</th>
                <th>Тип вина (тихое/игристое)</th>
                <th>Выдержка вина</th>
                <th>Цвет</th>
                <th>Спирт, %об</th>
                <th>Сахар, г/л</th>
                <th>Коллекция</th>
                <th>Доп. сведения (объем, л; страна ввоза; и т.д.)</th>

            </tr>

            <tr>
                <%--название и основные характеристики товара --%>
                <td>${wineForChange.getName()}</td>
                <td>${wineForChange.getPrice()}</td>
                <td>${wineForChange.getNdsRate()}</td>
                <td>${wineForChange.getImage()}</td>
                <td>${wineForChange.getWineType()}</td>
                <td>${wineForChange.getWineAge()}</td>
                <td>${wineForChange.getWineColor()}</td>
                <td>${wineForChange.getWineSpiritContent()}</td>
                <td>${wineForChange.getWineSugarContent()}</td>
                <td>${wineForChange.getWineCollection()}</td>
                <td>${wineForChange.getAnnotation()}</td>

            </tr>

        </table>

    </div>
</form>

<div class="col-xs-2"></div>


<jsp:include page="template_footer.jsp"/>