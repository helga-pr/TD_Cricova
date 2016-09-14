package org.itstep.prokopchik.cricova.command.factory;


import org.itstep.prokopchik.cricova.command.ActionCommand;
import org.itstep.prokopchik.cricova.command.CommandEnum;
import org.itstep.prokopchik.cricova.command.EmptyCommand;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionFactory {

    public ActionCommand defineCommand(HttpServletRequest request) {

        ActionCommand current = new EmptyCommand();

        /**
         * извлечение имени команды из запроса
         */

        String action = request.getParameter("command");

        if (action == null || action.isEmpty()) {
            /**
             * если команда не задана в текущем запросе
             */
            //TODO Для отладки
            System.out.println("\n" + new SimpleDateFormat("dd.MM.yyyy HH:mm ").format(new Date()) +
                    "Returned action = " + current);

            return current;
        }

        /**
         * получение объекта, соответствующего команде
         */

        try {
            CommandEnum currentEnum =
                    CommandEnum.valueOf(action.toUpperCase());

            current = currentEnum.getCurrentCommand();

        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action
                    + "message.wrongaction");
        }

        //TODO Для отладки
        System.out.println("\n" + new SimpleDateFormat("dd.MM.yyyy HH:mm ").format(new Date()) +
                "Returned action = " + current);

        return current;

    }
}
