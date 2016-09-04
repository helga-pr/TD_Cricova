<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="template_header.jsp"/>

<div class="row">
    <div class="col-xs-6">
        <form name="changeUserInfo" method="POST" action="controller">
            <input type="hidden" name="command" value="to_administration_page"/>
            <input type="submit" value="Администрирование" class="btn-link"/>
        </form>

    </div>

    <div class="col-xs-4">
        Администратор: ${user}

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
        <form name="administrationForm" method="POST" action="controller">
            <input type="hidden" name="command" value="show_price"/>
            <input type="submit" value="Прайс продукции" class="btn btn-info"/>
        </form>
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
        <br/><br/>


    </div>
    <div class="col-xs-8">
        <%--добавить новый товар в БД--%>
        <form class="form-horizontal" name="addNewProduct" method="post" action="controller">
            <%--Ввод наименования--%>
            <form class="form-group">
                <label for="newProductName" class="control-label">Наименование</label>
                <input id="newProductName" class="form-control"
                       placeholder="Введите наименование, например, Вино Кагор или Алиготе"/>
            </form>
            <%--Фото товара (необязательно)--%>
            <form class="form-group">
                <label for="newProductImage" class="control-label">Изображение</label>
                <input id="newProductImage" class="form-control" type="file" name="image"
                       placeholder="Выберите файл изображения товара"/>
            </form>
            <%--Стоимость--%>
            <form class="form-group">
                <label for="newProductPrice" class="control-label">Цена без НДС</label>
                <input id="newProductPrice" class="form-control"
                       placeholder="Введите цену единицы товара (без НДС)"/>
            </form>
            <%--Ставка НДС--%>
            <form class="form-group">
                <label for="newProductNDS" class="control-label">Ставка НДС</label>
                <input id="newProductNDS" class="form-control"
                       placeholder="Введите ставку НДС в %"/>
            </form>
            <%--ввод разлиных характеристик нового продукта путем выбора из списка--%>
            <form class="form-group">

                <fieldset>
                    <legend style="font-weight: bold">Основные характеристики товара:</legend>

                    <label for="wineType" class="control-label">Тип вина</label>
                    <select id="wineType" class="form-control" name="wineType">
                        <c:forEach var="type" items="${wineTypeEnum}">
                            <option>type</option>
                        </c:forEach>
                    </select>

                    <label for="wineColor" class="control-label">Цвет вина</label>
                    <select id="wineColor" class="form-control" name="wineColor">
                        <c:forEach var="color" items="${wineColorEnum}">
                            <option>color</option>
                        </c:forEach>
                    </select>


                </fieldset>
            </form>


        </form>

    </div>
    <div class="col-xs-2"></div>
</div>


<div class="row">
    <div class="col-xs-2"></div>
    <div class="col-xs-8">

    </div>
    <div class="col-xs-2"></div>
</div>

<jsp:include page="template_footer.jsp"/>