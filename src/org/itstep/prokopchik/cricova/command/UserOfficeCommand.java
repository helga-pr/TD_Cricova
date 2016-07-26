package org.itstep.prokopchik.cricova.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

public class UserOfficeCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String SESSION_ATTRIBUTE_NAME_ROLE = "role";
    private static final String PARAM_NAME_PASSWORD_REPEAT = "passwordRepeat";
    private static final String PARAM_NAME_CLIENT_NAME = "client_name";
    private static final String PARAM_NAME_CLIENT_MIDDLENAME = "client_middlename";
    private static final String PARAM_NAME_CLIENT_LASTNAME = "client_lastname";
    private static final String PARAM_NAME_CLIENT_CONTACTS = "client_contacts";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        HttpSession session = request.getSession();

        // извлечение из запроса введенных для изменения данных
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String passwordRepeat = request.getParameter(PARAM_NAME_PASSWORD_REPEAT);
        String flag = (String) session.getAttribute(SESSION_ATTRIBUTE_NAME_ROLE);

        String name = request.getParameter(PARAM_NAME_CLIENT_NAME);
        try {
            name = new String(name.getBytes("ISO-8859-1"), "utf-8");//значение параметра может быть внесено на русском языке

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String middlename = request.getParameter(PARAM_NAME_CLIENT_MIDDLENAME);
        try {
            middlename = new String(middlename.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке
            if (middlename.isEmpty()) {
                middlename = "";
            }

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String lastname = request.getParameter(PARAM_NAME_CLIENT_LASTNAME);
        try {
            lastname = new String(lastname.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String clientContacts = request.getParameter(PARAM_NAME_CLIENT_CONTACTS);
        try {
            clientContacts = new String(clientContacts.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return page;
    }
}
