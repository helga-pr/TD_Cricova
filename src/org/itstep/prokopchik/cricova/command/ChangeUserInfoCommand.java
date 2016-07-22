package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;
import org.itstep.prokopchik.cricova.logic.LoginLogic;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeUserInfoCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "pass";
    private static final String PARAM_NAME_ADMINFLAG = "adminflag";

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        // извлечение из запроса параметров
        // ??? При этом в конце каждой строки появляется слеш (/)
        // индекс символа "/" в строке = (длина строки - 1)
        // чтобы получить строку без "/" последним должен быть символ  с индексом = длина строки - 2

        String login = request.getParameter(PARAM_NAME_LOGIN);
        login = login.substring(0, login.length() - 1);
        //TODO для отладки
        System.out.println("Substring login = " + login);

        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        pass = pass.substring(0, pass.length() - 1);
        //TODO для отладки
        System.out.println("Substring login = " + pass);

        String flag = request.getParameter(PARAM_NAME_ADMINFLAG);
        flag = flag.substring(0, flag.length() - 1);

        try {
            flag = new String(flag.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке
            //TODO для отладки
            System.out.println("Substring login = " + flag);

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //TODO Для отладки
        System.out.println("\n" + new SimpleDateFormat("dd.mm.yyyy hh:mm ").format(new Date()) +
                "Class = ChangeUserInfoCommand;" +
                "извлечение из запроса параметров: {login = " + login + ": pass = " + pass + ": flag = " + flag);


        //передача атрибутов
        Client client = new Client();
        client = new ClientsEntity().findClient(login);

        String fio = client.getLastname() + " " + client.getName() + " " + client.getMiddleName();
        request.setAttribute("fio", fio);

        request.setAttribute("clientname", fio);
        request.setAttribute("login", login);
        request.setAttribute("pass", pass);
        request.setAttribute("adminflag", flag);


        if (LoginLogic.checkLogin(login, pass, flag)) {
            page = "/user_office.jsp";
        }

        //TODO Для отладки
        System.out.println("\n" + new SimpleDateFormat("dd.mm.yyyy hh:mm ").format(new Date()) +
                "Class = ChangeUserInfoCommand;" +
                "Returned page = " + page);


        return page;
    }
}
