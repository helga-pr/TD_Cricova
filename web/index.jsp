﻿<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="WEB-INF/template_header.jsp"/>

<div class="row">

    <div class="row">
        <div class="col-xs-3">
            <h3><a href="resources/company_history.html" target="mainframe">О компании</a></h3></div>
        <div class="col-xs-3">
            <h3><a href="resources/company_history_underground.html" target="mainframe">Подвалы
                Крикова</a></h3></div>
        <div class="col-xs-2">
            <h3><a href="resources/company_history_collection_of_wine.html" target="mainframe">Винотека</a></h3>
        </div>

        <div class="col-xs-2">
            <h3><a href="#products">Наша продукция</a></h3></div>

        <div class="col-xs-2">
            <h3><a href="#contactData">Контакты</a></h3></div>
    </div>

    <%--<div class="col-xs-2">--%>

    <%-- перенести на страницу регистрации отдельно для админа и для пользователя (на страницу с общим описанием продукции)
    <form name="index" method="POST" action="controller">
         <input type="hidden" name="command" value="to_login_page"/>
         <input type="submit" value="Admin" class=" btn btn-warning"/>

     </form>


     <form name="newClientForm" method="POST" action="controller">
         <input type="hidden" name="command" value="no_registration"/>
         <input type="submit" value="Зарегистрироваться" class="btn-link"/>

         <div> ${errorLoginPassMessage} ${wrongAction} ${nullPage}</div>

     </form>--%>

    <%-- </div>--%>
</div>
<hr/>
</div>

<div class="row">
    <%--Колонка справа--%>
    <div class="col-xs-2">
        <a href="resources/products_sparking_wine.html" name="products" target="mainframe"><h3>Наша продукция</h3><h4>
            Игристые вина</h4></a>
        <img src="resources/Cricova_SparklingWine_Crisecco.jpg" class="img-rounded img-responsive"/>


        <div class="video1"></div>
        <iframe src="https://www.youtube.com/embed/RKF8dhqQmn8" width="90%" frameborder="0" allowfullscreen>
        </iframe>

    </div>
    <div class="col-xs-8">
        <%--Для iframe--%>
        <div class="row">

            <div class="col-xs-12 myvideo">
                <iframe src="resources/company_history.html" name="mainframe" width="95%"
                        frameborder="0">

                </iframe>
            </div>
        </div>
    </div>
    <%--Колонка слева --%>
    <div class="col-xs-2">
        <a href="resources/products_still_wine.html" name="products" target="mainframe"><h3>Наша продукция</h3><h4>Тихие
            вина</h4></a>
        <img src="resources/Cricova_Muscat_Krujeva-2.jpg" class="img-rounded img-responsive" height="90%"/>

        <div class="video3"></div>
        <iframe src="https://www.youtube.com/embed/X8OVsrzWguI" width="90%" frameborder="0" allowfullscreen>
        </iframe>

    </div>
</div>


<jsp:include page="WEB-INF/template_footer.jsp"/>