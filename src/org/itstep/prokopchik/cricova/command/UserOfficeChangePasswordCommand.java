package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.Company;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;
import org.itstep.prokopchik.cricova.logic.LoginLogic;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class UserOfficeChangePasswordCommand implements ActionCommand {

    private static final String SESSION_ATTR_NAME_LOGIN = "login";

    @Override
    public String execute(HttpServletRequest request) {
        /**
         * Использование специального класса для работы с аттрибутами и параметрами запроса
         * и сессии пользователя в целях безопасности приложения
         */
        SessionRequestContent content = new SessionRequestContent();

        try {

            //TODO для отладки
            System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    "Class = " + getClass() +
                    "\nrequest = " + request);

            content.extractParametersValues(request);
            content.extractSessionAttributeValues(request);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // извлечение из запроса через специальный класс SessionRequestContent логина
        String login = (String) content.getSessionAttributes().get(SESSION_ATTR_NAME_LOGIN);


        //HashMap для записи аттрибутов сессии пользователя и аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();
        HashMap<String, Object> forSessionAttr = content.getSessionAttributes();

        //передача атрибутов
        Client client = new ClientsEntity().findClient(login);

        // извлечение из запроса введенных для изменения данных
        String oldPass = content.getRequestParameters().get("old_password")[0];
        String newPass = content.getRequestParameters().get("new_password")[0];
        String repeatePass = content.getRequestParameters().get("repeate_pass")[0];

        //пользователь регистрируется в БД в таблице Clients
        //параметр запроса adminflag == "клиент"
        if (LoginLogic.checkLogin(login, oldPass, "клиент") && !newPass.trim().isEmpty() &&
                newPass.equals(repeatePass)) {
            client.setPassword(newPass);

            Integer id = new ClientsEntity().updateClient(client);

            //получаем обновленные данные из БД
            client = new ClientsEntity().findClientById(id);

            forRequestAttribute.put("updateUserDataMessage", "Пароль пользователя успешно обновлен!");

            //TODO для отладки
            System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    getClass() + "\n" + forRequestAttribute.get("updateUserDataMessage"));

        } else {
            forRequestAttribute.put("updateUserDataMessage", "Пароль пользователя не обновлен! Введены некорректные данные.");

            //TODO для отладки
            System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    getClass() + "\n" + forRequestAttribute.get("updateUserDataMessage"));

        }

        //устанавливаем аттрибуты запроса для следующей jsp-страницы
        Company company = client.getCompany();

        String name = client.getName();
        String middleName = client.getMiddleName();
        String lastName = client.getLastname();
        String fio = lastName + " " + name + " " + middleName;
        String contacts = client.getContacts();

        String companyName = company.getName();
        String companyNotes = company.getNotes();

        forRequestAttribute.put("userName", name);
        forRequestAttribute.put("userMiddleName", middleName);
        forRequestAttribute.put("userLastName", lastName);
        forRequestAttribute.put("userContacts", contacts);
        forRequestAttribute.put("fio", fio);
        forRequestAttribute.put("companyName", companyName);
        forRequestAttribute.put("companyNotes", companyNotes);

        content.setRequestAttributes(forRequestAttribute);
        content.insertAttributes(request);

        return "/WEB-INF/user_office.jsp";
    }
}
