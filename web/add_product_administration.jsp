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
    <div class="col-xs-1"></div>
    <div class="col-xs-9">
        <%--таблица товаров (price)--%>
        <table class="table table-bordered table-hover table-striped">
            <%--<table class="table table-hover table-striped">--%>
            <tr>
                <th></th>
                <th></th>
                <th>Product</th>
                <th>Price</th>
                <th>Annotation</th>

            </tr>
            <c:foreach var="wine" items="${winesPrice}">
                <tr>
                    <td>
                        <input type="radio" name="changedProduct" value=${wine.getId}/>
                    </td>
                    <td>${wine.getImage()}</td>
                    <%--<td>${wine.getName}</td>--%>
                    <td>${wine.toString()}</td>
                    <td>${wine.getPrice()}</td>
                    <td>${wine.getAnnotation()}</td>

                </tr>
            </c:foreach>foreach>

        </table>

    </div>
</div>


<div class="row">
    <div class="col-xs-2"></div>
    <div class="col-xs-8">

    </div>
    <div class="col-xs-2"></div>
</div>

<jsp:include page="template_footer.jsp"/>