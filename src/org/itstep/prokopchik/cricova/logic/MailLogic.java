package org.itstep.prokopchik.cricova.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * класс MailLogic для проверки валидности введенного e-mail
 * regex = ^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$
 */
public class MailLogic {

    /**
     * Validate e-mail address with regular expression
     *
     * @param email e-mail address for validation
     * @return true valid e-mail address, false invalid e-mail address
     */

    public static Boolean checkEmail(final String email) {

        //TODO Для отладки
        System.out.println("\n" + "class MailLogic: проверка валидности введенного e-mail: ");

        Pattern pattern = Pattern.compile
                ("^[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);

        //TODO Для отладки
        System.out.println("matcher.matches() = " + matcher.matches());

        return matcher.matches();
    }
}
