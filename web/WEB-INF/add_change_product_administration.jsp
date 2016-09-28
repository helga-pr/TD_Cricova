<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="template_header.jsp"/>

<%--
На странице задаются новые значения/характеристики товара
для внесения нового товара в базу данных или изменения существующего
--%>

<div class="row">
    <div class="col-xs-2">
        <h3>Администрирование</h3>

    </div>

    <div class="col-xs-8">

        <div class="row">
            <div class="col-xs-4">
                <h4>Прайс: ВИНО ТМ &quotCRICOVA&quot (Молдова)</h4>
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

    <form name="administrationForm" method="POST" action="controller">
        <input type="hidden" name="command" value="add_change_price_position"/>
        <input type="hidden" name="changedProductId" value="${changedProductId}"/>

        <div class="col-xs-12">
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

                    <c:choose>
                        <c:when test="${buttonName eq 'Изменить пункт прайса'}">
                            <c:choose>
                                <c:when test="${changedProductId > 0}">
                                    Внесите небходимые изменения в наименование и основные характеристики товара и нажмите кнопку
                                    &quotВнести изменения&quot:

                                    <td><input onchange="doActionChangeButton()" size="10" type="text" name="wineName"
                                               value="${wineForChange.getName()}"/></td>
                                    <td><input onchange="doActionChangeButton()" size="5" type="text" name="winePrice"
                                               value="${wineForChange.getPrice()}"/></td>
                                    <td><input onchange="doActionChangeButton()" size="4" type="text" name="wineNdsRate"
                                               value="${wineForChange.getNdsRate()}"/>
                                    </td>
                                    <td><input onchange="doActionChangeButton()" type="image" name="wineImage"
                                               value="${wineForChange.getImage()}"/></td>
                                    <td>
                                        <select onchange="doActionChangeButton()" name="wineTypeSelected" class="small">
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
                                        <select onchange="doActionChangeButton()" name="wineAgeSelected" class="small">
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
                                        <select onchange="doActionChangeButton()" name="wineColorSelected"
                                                class="small">
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
                                        <select onchange="doActionChangeButton()" name="wineSpiritSelected"
                                                class="small">
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
                                        <select onchange="doActionChangeButton()" name="wineSugarSelected"
                                                class="small">
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
                                        <select onchange="doActionChangeButton()" name="wineCollectionSelected"
                                                class="small">
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
                                    <td><input onchange="doActionChangeButton()" type="text" name="wineAnnotation"
                                               value="${wineForChange.getAnnotation()}"/>
                                    </td>
                                </c:when>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            Для добавления нового пункта прайса внесите наименование и основные характеристики товара и нажмите кнопку
                            &quotВнести изменения&quot:

                            <td><input onchange="doActionChangeButton()" size="10" type="text" name="wineNameNew"
                                       value=""/></td>
                            <td><input onchange="doActionChangeButton()" size="5" type="text" name="winePriceNew"
                                       value=""/></td>
                            <td><input onchange="doActionChangeButton()" size="4" type="text" name="wineNdsRateNew"
                                       value="20"/>
                            </td>
                            <td><input onchange="doActionChangeButton()" type="file" name="wineImageNew" value=""/></td>
                            <td>
                                <select onchange="doActionChangeButton()" name="wineTypeSelectedNew" class="small">
                                        <%--Тип вина:--%>
                                    <c:forEach var="enumUnit" items="${wineTypeEnum}">
                                        <option>${enumUnit.getValue()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <select onchange="doActionChangeButton()" name="wineAgeSelectedNew" class="small">
                                        <%--Выдержка вина:--%>
                                    <c:forEach var="enumUnit" items="${wineAgeEnum}">
                                        <option>${enumUnit.getValue()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <select onchange="doActionChangeButton()" name="wineColorSelectedNew" class="small">
                                        <%--Цвет вина:--%>
                                    <c:forEach var="enumUnit" items="${wineColorEnum}">
                                        <option>${enumUnit.getValue()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <select onchange="doActionChangeButton()" name="wineSpiritSelectedNew" class="small">
                                        <%--Содержание спирта в вине:--%>
                                    <c:forEach var="enumUnit" items="${wineSpiritEnum}">
                                        <option>${enumUnit.getValue()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <select onchange="doActionChangeButton()" name="wineSugarSelectedNew" class="small">
                                        <%--Содержание сахара в вине:--%>
                                    <c:forEach var="enumUnit" items="${wineSugarEnum}">
                                        <option>${enumUnit.getValue()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <select onchange="doActionChangeButton()" name="wineCollectionSelectedNew"
                                        class="small">
                                        <%--Вино из коллекции:--%>
                                    <c:forEach var="enumUnit" items="${wineCollectionEnum}">
                                        <option>${enumUnit.getValue()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td><input onchange="doActionChangeButton()" type="text" name="wineAnnotationNew"
                                       value=""/>
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>

            </table>

                <%--            <button type="button" class="btn btn-primary" onclick="validate(this.form)" disabled="disabled"
                                    name="buttonNameValidate">Проверить
                            </button>--%>
                <button type="submit" class="btn btn-primary" name="buttonNameChangePage"
                        value="Внести изменения">
                    Внести изменения
                </button>

                <button type="submit" class="btn btn-primary" name="buttonNameChangePage" value="Отмена">
                    Отмена
            </button>

                <%--сообщение о результате проведенного сохранения нового объекта БД--%>
                <c:choose>
                    <c:when test="${errorFlag eq 'true'}">
                        <h4 class="bg-danger error">${messageForPrice}</h4>
                    </c:when>
                    <c:otherwise>
                        <h4>${messageForPrice}</h4>
                    </c:otherwise>
                </c:choose>

        </div>

    </form>
</div>


<jsp:include page="template_footer.jsp"/>