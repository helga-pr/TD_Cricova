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

public class UserOfficeChangeNameCommand implements ActionCommand {

    private static final String SESSION_ATTR_NAME_LOGIN = "login";

    @Override
    public String execute(HttpServletRequest request) {

        //если необходимо обновить данные flag == true
        boolean flagNeedChangeClient = false;

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

        // извлечение из запроса через специальный класс SessionRequestContent логина и пароля
        String login = (String) content.getSessionAttributes().get(SESSION_ATTR_NAME_LOGIN);

        //HashMap для записи аттрибутов сессии пользователя и аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();
        HashMap<String, Object> forSessionAttr = content.getSessionAttributes();

        Client client = new ClientsEntity().findClient(login);

        // извлечение из запроса введенных для изменения данных
        String newName = content.getRequestParameters().get("new_name")[0];
        String newMiddleName = content.getRequestParameters().get("new_middle_name")[0];
        String newLastName = content.getRequestParameters().get("new_last_name")[0];

        //TODO для отладки
        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "newName = " + newName + " == " + client.getName() +
                "; newMiddleName = " + newMiddleName + " == " + client.getMiddleName() +
                "; newLastName = " + newLastName + " == " + client.getLastname() +
                "\nПроверка для изменения ФИО клиента.");

        //если внесены изменения в фио пользователя, то информация о клиенте обновляется в БД
        //и обновляются аттрибуты запроса для передачи на следующий view (jsp-траницу)
        if ((!newName.trim().isEmpty() && !newName.equals(client.getName()))) {
            client.setName(newName);
            flagNeedChangeClient = true;
        }

        if ((!newMiddleName.trim().isEmpty() && !newMiddleName.equals(client.getMiddleName()))) {
            client.setMiddleName(newMiddleName);
            flagNeedChangeClient = true;
        }
        if ((!newLastName.trim().isEmpty() && !newLastName.equals(client.getLastname()))) {
            client.setLastname(newLastName);
            flagNeedChangeClient = true;

        }

        if (flagNeedChangeClient == true) {
            //обновляем данные в БД

            Integer id = new ClientsEntity().updateClient(client);

            if (id > 0) {
                client = new ClientsEntity().findClientById(id);

                forRequestAttribute.put("updateUserDataMessage", "ФИО пользователя успешно обновлены!");

                //TODO для отладки
                System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + "\n" + forRequestAttribute.get("updateUserDataMessage"));

            }

        }
        //получаем обновленные данные из БД

        Company company = client.getCompany();


        if (flagNeedChangeClient == false) {
            forRequestAttribute.put("updateUserDataMessage", "ФИО пользователя не обновлены! Введены некорректные данные или не обнаружено изменений.");

            //TODO для отладки
            System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    getClass() + "\n" + forRequestAttribute.get("updateUserDataMessage"));
        }

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

        return "/user_office.jsp";
    }
}
