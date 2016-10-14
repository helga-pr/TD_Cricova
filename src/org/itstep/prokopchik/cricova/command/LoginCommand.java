package org.itstep.prokopchik.cricova.command;


import org.itstep.prokopchik.cricova.*;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;
import org.itstep.prokopchik.cricova.database.dao.wine.WinesEntity;
import org.itstep.prokopchik.cricova.logic.LoginLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class LoginCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    private static final String PARAM_NAME_WINES_PRICE = "winesPrice";
    private static final String PARAM_NAME_CHOSEN_CRITERIA = "chosenCriteria";

    private static final String SESSION_ATTR_FIO = "fio";
    private static final String SESSION_ATTR_ROLE = "role";//роль пользователя (клиент или администратор)
    private static final String SESSION_ATTR_LOGIN = "login";

    private static final String SESSION_ATTR_WINES_PRICE = "winesPriceSessionAttr";
    private static final String SESSION_ATTR_WINE_TYPE_ENUM = "wineTypeEnum";
    private static final String SESSION_ATTR_WINE_AGE_ENUM = "wineAgeEnum";
    private static final String SESSION_ATTR_WINE_COLOR_ENUM = "wineColorEnum";
    private static final String SESSION_ATTR_WINE_SUGAR_ENUM = "wineSugarEnum";
    private static final String SESSION_ATTR_WINE_SPIRIT_ENUM = "wineSpiritEnum";
    private static final String SESSION_ATTR_WINE_COLLECTION_ENUM = "wineCollectionEnum";

    List<Wine> winesPrice;

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String page = null;

        /**
         * Использование специального класса для работы с аттрибутами и параметрами запроса
         * и сессии пользователя в целях безопасности приложения
         */
        SessionRequestContent content = new SessionRequestContent();

        try {

 /*           //TODO для отладки
            System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                    "Class = LoginCommand: " +
                    "\nrequest = " + request);
*/
            content.extractParametersValues(request);

            content.extractSessionAttributeValues(request);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // извлечение из запроса через специальный класс SessionRequestContent логина и пароля
        String login = content.getRequestParameters().get(PARAM_NAME_LOGIN)[0];
        String pass = content.getRequestParameters().get(PARAM_NAME_PASSWORD)[0];

        //HashMap для записи аттрибутов сессии пользователя и аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();
        HashMap<String, Object> forSessionAttr = content.getSessionAttributes();

        //аттрибут используется при построении таблицы товаров на странице, возвращаемой пользователю
        forRequestAttribute.put(PARAM_NAME_CHOSEN_CRITERIA, "");
/*
        //TODO Для отладки
        System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                "извлечение из запроса через специальный класс SessionRequestContent логина и пароля: " +
                "login = " + content.getRequestParameters().get(PARAM_NAME_LOGIN)[0] +
                "; pass = " + content.getRequestParameters().get(PARAM_NAME_PASSWORD)[0]);

*/

        // проверка логина и пароля
        if (LoginLogic.checkLogin(login, pass).equals("admin")) {

            //установить аттрибуты для данной пользовательской сессии,
            //которые будут использоваться на разных страницах приложения

            forSessionAttr.put(SESSION_ATTR_ROLE, "admin");
            forSessionAttr.put(SESSION_ATTR_LOGIN, login);

           /* //TODO Для отладки
            System.out.println("\n" + new SimpleDateFormat("dd.mm.yyyy hh:mm ").format(new Date()) +
                    "Class = ChangeUserInfoCommand;" +
                    "Returned page = " + page);

            //TODO Для отладки
            System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                    "Установлены аттрибуты сессии: Роль пользователя = " + content.getSessionAttributes().get("role") +
                    "; логин = " + content.getSessionAttributes().get("login"));
*/

            // определение пути к *.jsp
            //TODO Для отладки
            System.out.println("\n" + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    "Из блока if (админ) класса LoginCommand");
            System.out.println("role = " + SESSION_ATTR_ROLE +
                    "(from sessionAttr login = " + content.getSessionAttributes().get("login") + ")");

            page = "/WEB-INF/administration.jsp";
        }

        //страница клиента
        else if (LoginLogic.checkLogin(login, pass).equals("client")) {

            //передача атрибутов
            Client client = new ClientsEntity().findClient(login);

  /*
        //TODO
            Для отладкиSystem.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + "\nполучены данные о клиенте из БД:\n" + client.toString());
                Company company = client.getCompany();
                System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + "\nполучены данные о компании из БД:\n" + company.toString());
*/
            forSessionAttr.put(SESSION_ATTR_ROLE, "client");
            String name = client.getName();
            String middleName = client.getMiddleName();
            String lastName = client.getLastname();
            String fio = lastName + " " + name + " " + middleName;
            forSessionAttr.put(SESSION_ATTR_FIO, fio);
            forSessionAttr.put(SESSION_ATTR_LOGIN, login);

            //получение из БД прайса продукции и сохранение его в аттрибуты сессии
            winesPrice = new WinesEntity().findAllWines();
            forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);
            forSessionAttr.put(SESSION_ATTR_WINES_PRICE, winesPrice);

 /*               //TODO Для отладки
                System.out.println("\n" + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "flag of client = " + flag +
                        "( из класса SessionRequestContent = " + content.getRequestAttributes().get("adminflag"));
                System.out.println("Client fio = " + fio +
                        "( из класса SessionRequestContent = " + content.getRequestAttributes().get("fio"));
                System.out.println("login = " + login +
                        "( из класса SessionRequestContent = " + content.getRequestAttributes().get("login"));
                System.out.println("Из блока (else if (клиент)) класса LoginCommand:");
*/
            page = "/WEB-INF/receive_price.jsp";

        } else {

            forRequestAttribute.put("errorLoginPassMessage", "Incorrect login or password.");
            content.setRequestAttributes(forRequestAttribute);

            //page = ConfigurationManager.getProperty("path.page.login");
            page = "/WEB-INF/login.jsp";

 /*           //TODO Для отладки
            System.out.println("\n" + new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                    "Из блока (Else (логин или пароль не соответствует данным БД) класса LoginCommand)" +
                    ": errorLoginPassMessage: " + request.getAttribute("errorLoginPassMessage"));
*/
        }

 /*       //TODO для отладки
        System.out.println("\n" + new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                "Returns page = " + page);
*/
        /**запись в аттрибуты сессии перечней основных характеристик продукции (тип вина, выдержка, цвет и т.д)
         *
         */
        forSessionAttr.put(SESSION_ATTR_WINE_TYPE_ENUM, WineTypeEnum.values());
        forSessionAttr.put(SESSION_ATTR_WINE_AGE_ENUM, WineAgeEnum.values());
        forSessionAttr.put(SESSION_ATTR_WINE_COLOR_ENUM, WineColorEnum.values());
        forSessionAttr.put(SESSION_ATTR_WINE_SPIRIT_ENUM, WineSpiritContentEnum.values());
        forSessionAttr.put(SESSION_ATTR_WINE_SUGAR_ENUM, WineSugarContentEnum.values());
        forSessionAttr.put(SESSION_ATTR_WINE_COLLECTION_ENUM, WineCollectionEnum.values());


        // запись атрибутов сессии пользователя и аттрибутов запроса
        // с использованием специального класса SessionRequestContent
        content.setRequestAttributes(forRequestAttribute);
        content.setSessionAttributes(forSessionAttr);

        content.insertAttributes(request);
        content.insertSessionAttributes(request);

   /*     //TODO для отладки
        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "из SESSION_ATTR_WINES_PRICE:");
        if (forSessionAttr.containsKey(SESSION_ATTR_WINES_PRICE)) {
            for (Wine t : (List<Wine>) forSessionAttr.get(SESSION_ATTR_WINES_PRICE)) {

                System.out.println("t => " + t);
            }
        }
        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "из переменной winesPrice:");

        if (winesPrice != null) {
            for (Wine t : winesPrice) {

                System.out.println("t => " + t);
            }
        }

        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "аттрибут wines_price Из запроса (request attributes): ");

        if (forRequestAttribute.containsKey(PARAM_NAME_WINES_PRICE)) {
            for (Wine t : (List<Wine>) forRequestAttribute.get(PARAM_NAME_WINES_PRICE)) {

                System.out.println("t => " + t);
            }
        }*/


        return page;

    }

}

