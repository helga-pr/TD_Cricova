package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.*;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class AddProductCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_ADMINFLAG = "role";
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

        //TODO Для отладки
        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "Class = " + getClass());

        for (Wine t : (List<Wine>) content.getSessionAttributes().get(SESSION_ATTR_WINES_PRICE)) {

            System.out.println("t => " + t);
        }


        // извлечение из запроса через специальный класс SessionRequestContent логина и пароля
        String login = (String) content.getSessionAttributes().get(PARAM_NAME_LOGIN);
        String flag = (String) content.getSessionAttributes().get(PARAM_NAME_ADMINFLAG);

        //HashMap для записи аттрибутов сессии пользователя и аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();
        HashMap<String, Object> forSessionAttr = content.getSessionAttributes();
        //добавление аттрибутов
        forRequestAttribute.put("user", login);

        //прайс продукции сохраняется как аттрибут запроса для передачи на страницу
        forRequestAttribute.put(ATTR_NAME_WINES_PRICE,
                content.getSessionAttributes().get(SESSION_ATTR_WINES_PRICE));

        forSessionAttr.put("wineTypeEnum", WineTypeEnum.values());
        forSessionAttr.put("wineColorEnum", WineColorEnum.values());
        forSessionAttr.put("wineAgeEnum", WineAgeEnum.values());
        forSessionAttr.put("wineSugarEnum", WineSugarContentEnum.values());
        forSessionAttr.put("wineSpiritEnum", WineSpiritContentEnum.values());
        forSessionAttr.put("wineCollectionEnum", WineCollectionEnum.values());

        //сохранение и передача аттрибутов на страницу
        content.setRequestAttributes(forRequestAttribute);
        content.insertAttributes(request);

        content.setSessionAttributes(forSessionAttr);
        content.insertSessionAttributes(request);

        //TODO Для отладки
        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "Class = " + getClass());

        for (Wine t : (List<Wine>) content.getSessionAttributes().get(SESSION_ATTR_WINES_PRICE)) {

            System.out.println("t => " + t);
        }

        return "/add_product_administration.jsp";
    }
}
