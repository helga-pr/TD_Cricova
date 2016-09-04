package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ToAdministrationPageCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    //private static final String PARAM_NAME_PASSWORD = "password";
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
            System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                    "Class = LoginCommand: " +
                    "\nrequest = " + request);

            content.extractParametersValues(request);

            content.extractSessionAttributeValues(request);

        } catch (IOException e) {
            e.printStackTrace();
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

        //сохранение и передача аттрибутов на страницу
        content.setRequestAttributes(forRequestAttribute);
        content.insertAttributes(request);

        return "/administration.jsp";
    }
}
