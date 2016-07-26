package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ChangeUserInfoCommand implements ActionCommand {

    private static final String SESSION_ATTR_NAME_LOGIN = "login";

    @Override
    public String execute(HttpServletRequest request) throws IOException {

        String page = null;

        // извлечение из запроса параметров и аттрибутов с использованием класса SessionRequestContent

        SessionRequestContent content = new SessionRequestContent();
        content.extractParametersValues(request);
        content.extractSessionAttributeValues(request);

        //HashMap для записи аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();

        String login = (String) content.getSessionAttributes().get(SESSION_ATTR_NAME_LOGIN);

        //передача атрибутов
        Client client = new ClientsEntity().findClient(login);

        String fio = client.getLastname() + " " + client.getName() + " " + client.getMiddleName();
        forRequestAttribute.put("fio", fio);
        forRequestAttribute.put("login", login);

        page = "/user_office.jsp";

        //TODO Для отладки
        System.out.println("\n" + new SimpleDateFormat("dd.mm.yyyy hh:mm ").format(new Date()) +
                "Class = ChangeUserInfoCommand;" +
                "Returned page = " + page);

        content.insertAttributes(request);

        return page;
    }
}
