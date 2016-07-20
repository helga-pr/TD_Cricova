package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.logic.LoginLogic;

import javax.servlet.http.HttpServletRequest;

public class ChangeUserInfoCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_ADMINFLAG = "adminflag";

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        // извлечение из запроса введенных параметров
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String flag = request.getParameter(PARAM_NAME_ADMINFLAG);

        if (LoginLogic.checkLogin(login, pass, flag)) {
            page = "/user_office.jsp";
        }

        return page;
    }
}
