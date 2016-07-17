package org.itstep.prokopchik.cricova.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnpLogic {

    public static Boolean checkUnp(final String unp) {

        //TODO Для отладки
        System.out.println("\n" + "class UnpLogic: проверка валидности введенного УНП организации \n(9 цифр, не начинается с нуля): ");

        Pattern pattern = Pattern.compile("^[1-9]{1}[0-9]{8}$");
        Matcher matcher = pattern.matcher(unp);

        //TODO Для отладки
        System.out.println("matcher.matches() = " + matcher.matches());

        return matcher.matches();
    }
}
