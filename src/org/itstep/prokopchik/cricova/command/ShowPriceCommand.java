package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.Admin;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;
import org.itstep.prokopchik.cricova.database.dao.admin.AdminsEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ShowPriceCommand implements ActionCommand {

    private static final String SESSION_ATTR_NAME_LOGIN = "login";
    private static final String SESSION_ATTR_WINES_PRICE = "winesPrice";

    private static final String ATTR_NAME_WINES_PRICE = "winesPrice";

    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {

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

        Admin admin = new AdminsEntity().findAdmin(login);

        //HashMap для записи аттрибутов сессии пользователя и аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();
        HashMap<String, Object> forSessionAttr = content.getSessionAttributes();

        //прайс продукции сохраняется как аттрибут запроса для передачи на страницу
        forRequestAttribute.put("winesPrice", content.getSessionAttributes().get(SESSION_ATTR_WINES_PRICE));

        forRequestAttribute.put("user", admin.getLogin());

        return "/price_administration.jsp";
    }
}
