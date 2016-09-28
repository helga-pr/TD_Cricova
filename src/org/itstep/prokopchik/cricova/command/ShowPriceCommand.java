package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.Admin;
import org.itstep.prokopchik.cricova.Wine;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;
import org.itstep.prokopchik.cricova.database.dao.admin.AdminsEntity;
import org.itstep.prokopchik.cricova.database.dao.wine.WinesEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ShowPriceCommand implements ActionCommand {

    private static final String SESSION_ATTR_NAME_LOGIN = "login";
    private static final String SESSION_ATTR_WINES_PRICE = "winesPrice";
    private static final String PARAM_NAME_WINES_PRICE = "winesPrice";

    List<Wine> winesPrice;

    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {

        /**
         * Использование специального класса для работы с аттрибутами и параметрами запроса
         * и сессии пользователя в целях безопасности приложения
         */
        SessionRequestContent content = new SessionRequestContent();

        try {

           /* //TODO для отладки
            System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    "Class = " + getClass() +
                    "\nrequest = " + request);
*/
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

        //получение из БД прайса продукции и сохранение его в аттрибуты запроса, аттрибуты сессии
        winesPrice = new WinesEntity().findAllWines();
        forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);
        forSessionAttr.put(SESSION_ATTR_WINES_PRICE, winesPrice);


        content.setRequestAttributes(forRequestAttribute);
        content.insertAttributes(request);

        return "/WEB-INF/price_administration.jsp";
    }
}
