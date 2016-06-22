package org.itstep.prokopchik.cricova.command;

import javax.servlet.http.HttpServletRequest;

public class ToLoginPage implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

        String page = "/login.jsp";
        return page;
    }
}
