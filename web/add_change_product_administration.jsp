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

    <input type="hidden">

    <div class="col-xs-8">

        <div class="row">
            <div class="col-xs-4">
                <%--Тип (тихое или игристое) вина выбрать--%>
                    <%--<form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                        <input type="hidden" name="command" value="change_price_by_criteria"/>
                        <select name="wineTypeSelected" class="small">
                            &lt;%&ndash;Тип вина:&ndash;%&gt;
                            &lt;%&ndash;по умолчанию все вина выводятся в таблицу из БД&ndash;%&gt;
                            <option selected>все типы вин</option>
                            &lt;%&ndash;Если выбран какой-то один тип вина
                            то таблица обнавляется (устанавливается "фильтр")
                            и в строке выбора остается выбранный элемент после обновления таблицы
                            &ndash;%&gt;
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


                &lt;%&ndash;Содержание сахара вина выбрать&ndash;%&gt;
                <div class="col-xs-4">
                    <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                        <input type="hidden" name="command" value="change_price_by_criteria"/>
                        <select name="wineSugarSelected" class="small">
                            &lt;%&ndash;Содержание сахара в вине:&ndash;%&gt;
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

                &lt;%&ndash;Цвет вина выбрать&ndash;%&gt;
                <div class="col-xs-4">
                    <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                        <input type="hidden" name="command" value="change_price_by_criteria"/>
                        <select name="wineColorSelected" class="small">
                            &lt;%&ndash;Цвет вина:&ndash;%&gt;
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
                    &lt;%&ndash;Выдержку вина выбрать&ndash;%&gt;
                    <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                        <input type="hidden" name="command" value="change_price_by_criteria"/>
                        <select name="wineAgeSelected" class="small">
                            &lt;%&ndash;Выдержка вина:&ndash;%&gt;
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

                &lt;%&ndash;Крепость вина выбрать&ndash;%&gt;
                <div class="col-xs-4">
                    <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                        <input type="hidden" name="command" value="change_price_by_criteria"/>
                        <select name="wineSpiritSelected" class="small">
                            &lt;%&ndash;Содержание спирта в вине:&ndash;%&gt;
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


                &lt;%&ndash;Коллекцию вина выбрать&ndash;%&gt;
                <div class="col-xs-4">
                    <form name="choiceCriteriaForProductPrice" method="POST" action="controller">
                        <input type="hidden" name="command" value="change_price_by_criteria"/>
                        <select name="wineCollectionSelected" class="small">
                            &lt;%&ndash;Вино из коллекции:&ndash;%&gt;
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
                    </form>--%>
            </div>
        </div>

    </div>
    </input>

    <div class="col-xs-2">
        <h4>Администратор: ${login}</h4>

        <form name="administrationForm" method="POST" action="controller">
            <input type="hidden" name="command" value="logout"/>
            <input type="submit" value="Log out" class="small"/>
        </form>

    </div>
</div>


<div class="row">
    <div class="col-xs-1"></div>

    <form name="administrationForm" method="POST" action="controller">
        <input type="hidden" name="command" value="add_change_price_position"/>

        <div class="col-xs-9">
            <%--таблица для изменения/добавления товара (пункта прайса)--%>
            <table class="table table-bordered table-hover table-striped">
                <tr>
                    <th>Наименование</th>
                    <th>Цена, руб. (без НДС)</th>
                    <th>Ставка НДС, %</th>
                    <th>Фото</th>
                    <th>Тип вина (тихое/ игристое)</th>
                    <th>Выдержка вина</th>
                    <th>Цвет</th>
                    <th>Спирт, %об</th>
                    <th>Сахар, г/л</th>
                    <th>Коллекция</th>
                    <th>Доп. сведения (объем, л; страна ввоза; и т.д.)</th>

                </tr>

                <tr>
                    Внесите небходимые изменения в наименование и основные характеристики товара и нажмите кнопку
                    &quotВнести изменения&quot:
                    <c:choose>
                        <c:when test="${buttonName eq 'Изменить пункт прайса'}">
                            <c:choose>
                                <c:when test="${changedProductId > 0}">
                                    <td><input size="10" type="text" name="wineName"
                                               value="${wineForChange.getName()}"/></td>
                                    <td><input size="5" type="text" name="winePrice"
                                               value="${wineForChange.getPrice()}"/></td>
                                    <td><input size="4" type="text" name="wineNdsRAte"
                                               value="${wineForChange.getNdsRate()}"/>
                                    </td>
                                    <td><input type="image" name="wineImage" value="${wineForChange.getImage()}"/></td>
                                    <td>
                                        <select name="wineTypeSelected" class="small">
                                                <%--Тип вина:--%>
                                            <c:forEach var="enumUnit" items="${wineTypeEnum}">
                                                <c:choose>
                                                    <c:when test="${enumUnit.getValue()== wineForChange.getWineType().getValue()}">
                                                        <option selected>${enumUnit.getValue()}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option>${enumUnit.getValue()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="wineAgeSelected" class="small">
                                                <%--Выдержка вина:--%>
                                            <c:forEach var="enumUnit" items="${wineAgeEnum}">
                                                <c:choose>
                                                    <c:when test="${enumUnit.getValue() == wineForChange.getWineAge().getValue()}">
                                                        <option selected>${enumUnit.getValue()}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option>${enumUnit.getValue()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="wineColorSelected" class="small">
                                                <%--Цвет вина:--%>
                                            <c:forEach var="enumUnit" items="${wineColorEnum}">
                                                <c:choose>
                                                    <c:when test="${enumUnit.getValue() == wineForChange.getWineColor().getValue()}">
                                                        <option selected>${enumUnit.getValue()}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option>${enumUnit.getValue()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="wineSpiritSelected" class="small">
                                                <%--Содержание спирта в вине:--%>
                                            <c:forEach var="enumUnit" items="${wineSpiritEnum}">
                                                <c:choose>
                                                    <c:when test="${enumUnit.getValue() == wineForChange.getWineSpiritContent().getValue()}">
                                                        <option selected>${enumUnit.getValue()}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option>${enumUnit.getValue()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="wineSugarSelected" class="small">
                                                <%--Содержание сахара в вине:--%>
                                            <c:forEach var="enumUnit" items="${wineSugarEnum}">
                                                <c:choose>
                                                    <c:when test="${enumUnit.getValue() == wineForChange.getWineSugarContent().getValue()}">
                                                        <option selected>${enumUnit.getValue()}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option>${enumUnit.getValue()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="wineCollectionSelected" class="small">
                                                <%--Вино из коллекции:--%>
                                            <c:forEach var="enumUnit" items="${wineCollectionEnum}">
                                                <c:choose>
                                                    <c:when test="${enumUnit.getValue() == wineForChange.getWineCollection().getValue()}">
                                                        <option selected>${enumUnit.getValue()}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option>${enumUnit.getValue()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input type="text" name="wineAnnotation"
                                               value="${wineForChange.getAnnotation()}"/>
                                    </td>
                                </c:when>
                            </c:choose>
                        </c:when>
                    </c:choose>
                </tr>

            </table>

            <button type="submit" class="btn btn-primary" name="buttonName" disabled="disabled">Внести изменения
            </button>
            <button type="submit" class="btn btn-primary" name="buttonName">Отмена</button>
        </div>
        <div class="col-xs-2"></div>

    </form>
</div>


<jsp:include page="template_footer.jsp"/>