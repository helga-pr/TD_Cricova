package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.Company;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Для страницы user office
 * в полях используются текущие значения данных о пользователе
 * Пользователь может внести новые данные и они сохранятся в базе данных
 */
public class ChangeUserInfoCommand implements ActionCommand {

    private static final String SESSION_ATTR_NAME_LOGIN = "login";

    @Override
    public String execute(HttpServletRequest request) throws IOException {

        /**
         * Использование специального класса для работы с аттрибутами и параметрами запроса
         * и сессии пользователя в целях безопасности приложения
         */
        SessionRequestContent content = new SessionRequestContent();

        try {

            //TODO для отладки
            System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                    "Class = LoginCommand: " +
                    "\nrequest = " + request);

            content.extractParametersValues(request);

            content.extractSessionAttributeValues(request);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // извлечение из запроса через специальный класс SessionRequestContent логина и пароля
        String login = (String) content.getSessionAttributes().get(SESSION_ATTR_NAME_LOGIN);

        //HashMap для записи аттрибутов сессии пользователя и аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();
        HashMap<String, Object> forSessionAttr = content.getSessionAttributes();

        //передача атрибутов
        Client client = new ClientsEntity().findClient(login);

        System.out.println(new SimpleDateFormat("dd.MM.yyyy H:mm:ss ").format(new Date()) +
                getClass() + "\nполучены данные о клиенте из БД:\n" + client.toString());
        Company company = client.getCompany();
        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                getClass() + "\nполучены данные о компании из БД:\n" + company.toString());

        String name = client.getName();
        String middleName = client.getMiddleName();
        String lastName = client.getLastname();
        String fio = lastName + " " + name + " " + middleName;
        String contacts = client.getContacts();

        String companyName = company.getName();
        String companyNotes = company.getNotes();

        forRequestAttribute.put("userName", name);
        forRequestAttribute.put("userMiddleName", middleName.isEmpty() ? "-" : middleName);
        forRequestAttribute.put("userLastName", lastName);
        forRequestAttribute.put("userContacts", contacts.isEmpty() ? "-" : contacts);
        forRequestAttribute.put("fio", fio);
        forRequestAttribute.put("login", login);
        forRequestAttribute.put("companyName", companyName);
        forRequestAttribute.put("companyNotes", companyNotes.isEmpty() ? "-" : companyNotes);

        content.setRequestAttributes(forRequestAttribute);
        content.insertAttributes(request);

        //TODO Для отладки
        System.out.println("Client fio = " + fio +
                "( из класса SessionRequestContent = " + content.getRequestAttributes().get("fio"));
        System.out.println("login = " + login +
                "( из класса SessionRequestContent = " + content.getRequestAttributes().get("login"));
        System.out.println("Из блока (else if (клиент)) класса LoginCommand");


        return "/WEB-INF/user_office.jsp";
    }
}
