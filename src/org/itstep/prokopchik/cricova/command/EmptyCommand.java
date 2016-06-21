package org.itstep.prokopchik.cricova.command;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

		 /* в случае ошибки или прямого обращения к контроллеру
         * переадресация на начальную страницу */

        // String page = ConfigurationManager.getProperty("path.page.login");

        return "/index.jsp";
    }
}
