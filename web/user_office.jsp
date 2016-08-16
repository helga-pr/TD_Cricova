<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="template_header.jsp"/>

<div class="row">

    <div class="col-xs-10">
        Личный кабинет пользователя: ${fio} (${login})
    </div>
    <div class="col-xs-2">
        <form name="userOfficeLogOut" method="POST" action="controller">
            <input type="hidden" name="command" value="logout"/>
            <input type="submit" value="Выход"/>
        </form>
    </div>
</div>

<div class="row">
    <div class="col-xs-2"></div>
    <div class="col-xs-8">
        <h4>Изменение данных профиля </h4>
        <h5>Заполните поля данных о себе, которые желаете изменить и нажмите кнопку "Изменить"</h5>

        <div class="row">
            <div class="col-xs-2"> Изменить имя:</div>
            <div class="col-xs-10">
                <form class="form-horizontal" name="userOfficeChangeName" method="POST"
                      action="controller" accept-charset="utf-8">

                    <div class="form-group">
                        <label for="newName" class="col-sm-5 control-label">Имя</label>
                        <input type="text" id="newName" name="new_name"
                               value=${userName}
                                       class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="inputNewMiddleName" class="col-sm-5 control-label">Отчество</label>
                        <input type="text" id="inputNewMiddleName" name="new_middle_name"
                               value=${userMiddleName}
                                       class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="inputNewLastName" class="col-sm-5 control-label">Фамилия</label>
                        <input type="text" id="inputNewLastName" name="new_last_name"
                               value=${userLastName} class="form-control">
                    </div>

                    <input type="hidden" name="command" value="change_user_name"/>
                    <input type="submit" value="Изменить имя" class="btn-warning btn-primary">

                </form>
            </div>

        </div>


        <div class="row">
            <div class="col-xs-2">Изменить пароль:</div>
            <div class="col-xs-10">
                <form class="form-horizontal" name="userOfficeChangePassword" method="POST"
                      action="controller" accept-charset="utf-8">

                    <div class="form-group">
                        <label for="oldPassword" class="col-sm-5 control-label">Старый пароль</label>
                        <input type="password" id="oldPassword" name="old_password"
                               placeholder="Старый пароль"
                               class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="newPassword" class="col-sm-5 control-label">Новый пароль</label>
                        <input type="password" id="newPassword" name="new_password"
                               placeholder="Новый пароль"
                               class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="repeatPassword" class="col-sm-5 control-label">Повторите
                            пароль</label>
                        <input type="password" id="repeatPassword" name="repeate_pass"
                               placeholder="Повторите пароль" class="form-control">
                    </div>
                    <input type="hidden" name="command" value="change_user_password"/>
                    <input type="submit" value="Изменить пароль" class="btn-warning btn-primary">
                </form>
            </div>

        </div>

        <h5>${updateUserDataMessage}</h5>

        <div class="row">
            <div class="col-xs-2">Изменить контактные данные</div>
            <div class="col-xs-10">
                <form class="form-horizontal" name="changeContactData" method="POST" action="controller"
                      accept-charset="utf-8">

                    <div class="form-group">
                        <label for="changeMyContacts" class="control-label">
                            Мои контактные данные:
                        </label>
                        <input type="text" id="changeMyContacts" name="new_contacts"
                               value=${userContacts} class="form-control">
                        <input type="hidden" name="command" value="change_user_contacts"/>
                        <input type="submit" value="Изменить мои контакты" class="btn-warning btn-primary">
                    </div>
                </form>
            </div>

            <h5>${updateUserContactsMessage}</h5>
        </div>

        <div class="row">
            <div class="col-xs-2"></div>
            <div class="col-xs-8">
                <form class="form-horizontal" name="changeContactData" method="POST" action="controller"
                      accept-charset="utf-10">

                    <div class="form-group">
                        <label for="changeCompanyNotes" class="control-label">
                            О компании ${companyName}:
                        </label>
                        <input type="text" id="changeCompanyNotes" name="new_company_notes"
                               value=${companyNotes} class="form-control">
                        <input type="hidden" name="command" value="change_company_notes"/>
                        <input type="submit" value="Изменить информацию о компании" class="btn-warning btn-primary">
                    </div>

                </form>
            </div>

        </div>
    </div>
    <div class="col-xs-2"></div>
</div>

<jsp:include page="template_footer.jsp"/>