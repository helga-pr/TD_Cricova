<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="template_header.jsp"/>

<div class="row">
    <div class="col-xs-1"></div>
    <div class="col-xs-1">
        <a class="btn-link" href="../index.jsp">На Главную</a>
    </div>
    <div class="col-xs-5">
        <h4 class="small">Уважаемый Покупатель!<br/>Для работы с прайсом продукции введите, пожалуйста, логин, указанный
            Вами при
            заключении
            договора поставки, и пароль, выданный Вам после оформления договора. Цены в прайсе указаны с учетом
            действующей для Вас скидки и(или)текущей акции.</h4>
        <br/>
        <h4>
            <b>Желаете приобрести нашу продукцию?</b><br/>
            Для заключения договора обратитесь, пожалуйста, к менеджеру в Вашем регионе по телефону, указанному
            ниже.<br/>
            Будем рады сотрудничеству с Вами!
        </h4>

    </div>
    <div class="col-xs-1"></div>
    <div class="col-xs-4">

        <form name="loginForm" method="POST" action="controller">
            <input type="hidden" name="command" value="login"/>
            Логин:<br/>
            <input type="text" name="login" value=""/>

            <br/>Пароль:<br/>
            <input type="password" name="password" value=""/>

            <br/>
            ${errorLoginPassMessage}

            ${wrongAction}

            ${nullPage}
            <br/>
            <input type="submit" value="Войти" class="btn-primary"/>

        </form>

    </div>
    <div class="col-xs-1"></div>
</div>

<jsp:include page="template_footer.jsp"/>