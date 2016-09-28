package org.itstep.prokopchik.cricova.command;

import javax.servlet.http.HttpServletRequest;

public class NoRegistrationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        /**
         * команда перенаправляет на страницу регистрации
         */
        String page = "/WEB-INF/registration.jsp";

        return page;
    }
}
