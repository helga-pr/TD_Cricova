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


            // определение пути к main.jsp

            if (flag == "администратор") {

                //страница администратора
                //page = ConfigurationManager.getProperty("path.page.main");
                request.setAttribute("user", login);

                page = "/administration.jsp";
            }

            //страница клиента
            else {
                page = "/receive_price.jsp";
                Client client = new Client();
                client = new ClientsEntity().getClient(login);

                String fio = client.getLastname() + " " + client.getName() + " " + client.getMiddleName();
                request.setAttribute("fio", fio);

                request.setAttribute("clientname", fio);

                request.setAttribute("login", login);

                request.setAttribute("pass", pass);

            }
        } else {

            request.setAttribute("errorLoginPassMessage", "Incorrect login or password.");
            //page = ConfigurationManager.getProperty("path.page.login");
            page = "/index.jsp";
        }
        return page;

    }

}

