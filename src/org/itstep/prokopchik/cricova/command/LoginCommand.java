package org.itstep.prokopchik.cricova.command;


import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;
import org.itstep.prokopchik.cricova.logic.LoginLogic;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public class LoginCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_ADMINFLAG = "adminflag";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        // извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String flag = request.getParameter(PARAM_NAME_ADMINFLAG);

        try {
            flag = new String(flag.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        // проверка логина и пароля
        if (LoginLogic.checkLogin(login, pass, flag)) {

            //TODO Для отладки
            System.out.println("flag of admin = " + flag);
            System.out.println("Из блока if (админ) класса LoginCommand");

            // определение пути к *.jsp

            if ("администратор".equals(flag)) {

                //страница администратора
                //page = ConfigurationManager.getProperty("path.page.main");
                request.setAttribute("user", login);

                page = "/administration.jsp";
            }

            //страница клиента
            else if ("клиент".equals(flag)) {

                //TODO Для отладки
                System.out.println("flag of client = " + flag);
                System.out.println("Из блока (else if (клиент)) класса LoginCommand");

                Client client = new Client();
                client = new ClientsEntity().findClient(login);

                String fio = client.getLastname() + " " + client.getName() + " " + client.getMiddleName();
                request.setAttribute("fio", fio);

                request.setAttribute("clientname", fio);

                request.setAttribute("login", login);

                page = "/receive_price.jsp";

            }
        } else {


            request.setAttribute("errorLoginPassMessage", "Incorrect login or password.");

            //page = ConfigurationManager.getProperty("path.page.login");
            page = "/login.jsp";

            //TODO Для отладки
            System.out.println("Из блока (Else (логин или пароль не соответствует данным БД) класса LoginCommand)" +
                    ": errorLoginPassMessage: " + request.getAttribute("errorLoginPassMessage"));

        }

        //TODO для отладки
        System.out.println("Returns page = " + page);

        return page;

    }

}

