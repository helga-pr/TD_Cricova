package org.itstep.prokopchik.cricova.command;


import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.Company;
import org.itstep.prokopchik.cricova.Wine;
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
    private static final String PARAM_NAME_ADMINFLAG = "adminflag";

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String page = null;

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
        String login = content.getRequestParameters().get(PARAM_NAME_LOGIN)[0];
        String pass = content.getRequestParameters().get(PARAM_NAME_PASSWORD)[0];

        String flag = content.getRequestParameters().get(PARAM_NAME_ADMINFLAG)[0];

        //HashMap для записи аттрибутов сессии пользователя и аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();
        HashMap<String, Object> forSessionAttr = content.getSessionAttributes();

        //TODO Для отладки
        System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                "извлечение из запроса через специальный класс SessionRequestContent логина и пароля: " +
                "login = " + content.getRequestParameters().get(PARAM_NAME_LOGIN)[0] +
                "; pass = " + content.getRequestParameters().get(PARAM_NAME_PASSWORD)[0] +
                "; flag = " + content.getRequestParameters().get(PARAM_NAME_ADMINFLAG)[0]);


        // проверка логина и пароля
        if (LoginLogic.checkLogin(login, pass, flag)) {

            //установить аттрибуты для данной пользовательской сессии,
            //которые будут использоваться на разных страницах приложения

            forSessionAttr.put("role", flag);
            forSessionAttr.put("login", login);

            content.setSessionAttributes(forSessionAttr);

            content.insertSessionAttributes(request);

            //TODO Для отладки
            System.out.println("\n" + new SimpleDateFormat("dd.mm.yyyy hh:mm ").format(new Date()) +
                    "Class = ChangeUserInfoCommand;" +
                    "Returned page = " + page);

            //TODO Для отладки
            System.out.println(new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                    "Установлены аттрибуты сессии: Роль пользователя = " + content.getSessionAttributes().get("role") +
                    "; логин = " + content.getSessionAttributes().get("login"));

            // определение пути к *.jsp
            if ("администратор".equals(flag)) {

                //страница администратора
                //page = ConfigurationManager.getProperty("path.page.main");
                //request.setAttribute("user", login);
                forRequestAttribute.put("user", login);
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                //TODO Для отладки
                System.out.println("\n" + new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                        "Из блока if (админ) класса LoginCommand");
                System.out.println("flag = " + flag +
                        "(from sessionAttr flag = " + content.getSessionAttributes().get("role") + ")");


                page = "/administration.jsp";
            }

            //страница клиента
            else if ("клиент".equals(flag)) {

                //передача атрибутов
                Client client = new ClientsEntity().findClient(login);

                System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + "\nполучены данные о клиенте из БД:\n" + client.toString());
                Company company = client.getCompany();
                System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        getClass() + "\nполучены данные о компании из БД:\n" + company.toString());

                String name = client.getName();
                String middleName = client.getMiddleName();
                String lastName = client.getLastname();
                String fio = lastName + " " + name + " " + middleName;

                forRequestAttribute.put("email", login);

                List<Wine> winesPrice = new WinesEntity().findAllWines();
                forRequestAttribute.put("winesPrice", winesPrice);
                forSessionAttr.put("winesPrice", winesPrice);

                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                //TODO Для отладки
                System.out.println("\n" + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "flag of client = " + flag +
                        "( из класса SessionRequestContent = " + content.getRequestAttributes().get("adminflag"));
                System.out.println("Client fio = " + fio +
                        "( из класса SessionRequestContent = " + content.getRequestAttributes().get("fio"));
                System.out.println("login = " + login +
                        "( из класса SessionRequestContent = " + content.getRequestAttributes().get("login"));
                System.out.println("Из блока (else if (клиент)) класса LoginCommand");


                page = "/receive_price.jsp";

            }
        } else {

            forRequestAttribute.put("errorLoginPassMessage", "Incorrect login or password.");
            content.setRequestAttributes(forRequestAttribute);

            //page = ConfigurationManager.getProperty("path.page.login");
            page = "/login.jsp";

            //TODO Для отладки
            System.out.println("\n" + new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                    "Из блока (Else (логин или пароль не соответствует данным БД) класса LoginCommand)" +
                    ": errorLoginPassMessage: " + request.getAttribute("errorLoginPassMessage"));

        }

        //TODO для отладки
        System.out.println("\n" + new SimpleDateFormat("dd.mm.yyyy hh:mm:ss ").format(new Date()) +
                "Returns page = " + page);

        // запись атрибутов сессии пользователя и аттрибутов запроса
        // с использованием специального класса SessionRequestContent
        content.insertAttributes(request);

        return page;

    }

}

