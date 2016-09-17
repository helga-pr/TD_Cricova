package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.Wine;
import org.itstep.prokopchik.cricova.WineSpiritContentEnum;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;
import org.itstep.prokopchik.cricova.database.dao.wine.WinesEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ChangePriceByCriteriaCommand implements ActionCommand {

    private static final String PARAM_NAME_ADMINFLAG = "adminflag";
    private static final String PARAM_NAME_WINES_PRICE = "winesPrice";
    private static final String PARAM_NAME_CHOSEN_CRITERIA = "chosenCriteria";

    private static final String SESSION_ATTR_FIO = "fio";
    private static final String SESSION_ATTR_ROLE = "role";//роль пользователя (клиент или администратор)
    private static final String SESSION_ATTR_LOGIN = "login";

    private static final String SESSION_ATTR_WINES_PRICE = "winesPriceSessionAttr";
    private static final String SESSION_ATTR_WINE_TYPE_ENUM = "wineTypeEnum";
    private static final String SESSION_ATTR_WINE_AGE_ENUM = "wineAgeEnum";
    private static final String SESSION_ATTR_WINE_COLOR_ENUM = "wineColorEnum";
    private static final String SESSION_ATTR_WINE_SUGAR_ENUM = "wineSugarEnum";
    private static final String SESSION_ATTR_WINE_SPIRIT_ENUM = "wineSpiritEnum";
    private static final String SESSION_ATTR_WINE_COLLECTION_ENUM = "wineCollectionEnum";

    private static final String PARAM_NAME_WINE_TYPE_SELECTED = "wineTypeSelected";
    private static final String PARAM_NAME_WINE_AGE_SELECTED = "wineAgeSelected";
    private static final String PARAM_NAME_WINE_COLOR_SELECTED = "wineColorSelected";
    private static final String PARAM_NAME_WINE_SUGAR_SELECTED = "wineSugarSelected";
    private static final String PARAM_NAME_WINE_SPIRIT_SELECTED = "wineSpiritSelected";
    private static final String PARAM_NAME_WINE_COLLECTION_SELECTED = "wineCollectionSelected";

    List<Wine> winesPrice;


    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {
        String page;

        /**
         * Использование специального класса для работы с аттрибутами и параметрами запроса
         * и сессии пользователя в целях безопасности приложения
         */
        SessionRequestContent content = new SessionRequestContent();

        try {

            content.extractParametersValues(request);

            content.extractSessionAttributeValues(request);
            content.getSessionAttributes();

        } catch (IOException e) {
            e.printStackTrace();
        }

/*
        //TODO для отладки
        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "session attributes ==> ");

        content.getSessionAttributes();
        if (!content.getSessionAttributes().isEmpty()) {
            for (Map.Entry entry : content.getSessionAttributes().entrySet()) {

                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
            System.out.println("<<<\n");
        }
*/

        // извлечение из запроса через специальный класс SessionRequestContent логина и пароля
        String role = (String) content.getSessionAttributes().get(SESSION_ATTR_ROLE);

        if (role.equals("клиент")) {
            page = "/receive_price.jsp";
        } else {
            page = "/price_administration.jsp";
        }

        //HashMap для записи аттрибутов сессии пользователя и аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();
        HashMap<String, Object> forSessionAttr = content.getSessionAttributes();

        /**
         * ===============================================================================
         * Выборка товаров согласно полученному со страницы пользователя критерию отбора
         * ********************
         * (установка "фильтра" в таблице товаров по типу вина (тихое или игристое)
         */
        if (content.getRequestParameters().containsKey(PARAM_NAME_WINE_TYPE_SELECTED)) {
            String selected = content.getRequestParameters().get(PARAM_NAME_WINE_TYPE_SELECTED)[0];

            //для устанавления в поле выбора критерия отбора выбранного по умолчанию значения (<option selected>)
            forRequestAttribute.put(PARAM_NAME_CHOSEN_CRITERIA, selected);

            if (selected.equals("все типы вин")) {
                //получение из БД прайса всей продукции и сохранение его в аттрибуты сессии
                winesPrice = new WinesEntity().findAllWines();
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                return page;
            } else {
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, new WinesEntity().findWineByWineType(selected));
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                //TODO для отладки
                System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "selected = " + selected +
                        "\nиз PARAM_NAME_WINES_PRICE для ChangePriceByCriteria (wineType):");
                if (forRequestAttribute.containsKey(PARAM_NAME_WINES_PRICE)) {
                    for (Wine t : (List<Wine>) forRequestAttribute.get(PARAM_NAME_WINES_PRICE)) {

                        System.out.println("t => " + t);
                    }
                }

                return page;
            }
        }

        /**
         * ********************
         * (установка "фильтра" в таблице товаров по выдержке (возрасту) вина (ординарное, выдержанное, коллекционное)
         */
        if (content.getRequestParameters().containsKey(PARAM_NAME_WINE_AGE_SELECTED)) {
            String selected = content.getRequestParameters().get(PARAM_NAME_WINE_AGE_SELECTED)[0];

            //для устанавления в поле выбора критерия отбора выбранного по умолчанию значения (<option selected>)
            forRequestAttribute.put(PARAM_NAME_CHOSEN_CRITERIA, selected);

            if (selected.equals("все вина по выдержке")) {
                //получение из БД прайса всей продукции и сохранение его в аттрибуты сессии
                winesPrice = new WinesEntity().findAllWines();
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                return page;
            } else {
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, new WinesEntity().findWineByWineAge(selected));
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                //TODO для отладки
                System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "selected = " + selected +
                        "\nиз PARAM_NAME_WINES_PRICE для ChangePriceByCriteria (wineByWineAge):");
                if (forRequestAttribute.containsKey(PARAM_NAME_WINES_PRICE)) {
                    for (Wine t : (List<Wine>) forRequestAttribute.get(PARAM_NAME_WINES_PRICE)) {

                        System.out.println("t => " + t);
                    }
                }

                return page;
            }
        }

        /**
         * ********************
         * (установка "фильтра" в таблице товаров по содержанию сахара в вине (сухое, полусухое, полусладное...)
         */
        if (content.getRequestParameters().containsKey(PARAM_NAME_WINE_SUGAR_SELECTED)) {
            String selected = content.getRequestParameters().get(PARAM_NAME_WINE_SUGAR_SELECTED)[0];

            //для устанавления в поле выбора критерия отбора выбранного по умолчанию значения (<option selected>)
            forRequestAttribute.put(PARAM_NAME_CHOSEN_CRITERIA, selected);

            if (selected.equals("все вина по содерж. сахара")) {
                //получение из БД прайса всей продукции и сохранение его в аттрибуты сессии
                winesPrice = new WinesEntity().findAllWines();
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                return page;
            } else {
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, new WinesEntity().findWineByWineSugarContent(selected));
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                //TODO для отладки
                System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "selected = " + selected +
                        "\nиз PARAM_NAME_WINES_PRICE для ChangePriceByCriteria (wineSugarContent):");
                if (forRequestAttribute.containsKey(PARAM_NAME_WINES_PRICE)) {
                    for (Wine t : (List<Wine>) forRequestAttribute.get(PARAM_NAME_WINES_PRICE)) {

                        System.out.println("t => " + t);
                    }
                }

                return page;
            }
        }

        /**
         * ********************
         * (установка "фильтра" в таблице товаров по содержанию спирта в вине (9-11 %об ...)
         */
        if (content.getRequestParameters().containsKey(PARAM_NAME_WINE_SPIRIT_SELECTED)) {
            String selected = content.getRequestParameters().get(PARAM_NAME_WINE_SPIRIT_SELECTED)[0];

            //для устанавления в поле выбора критерия отбора выбранного по умолчанию значения (<option selected>)
            forRequestAttribute.put(PARAM_NAME_CHOSEN_CRITERIA, selected);

            if (selected.equals("все вина по крепости")) {
                //получение из БД прайса всей продукции и сохранение его в аттрибуты сессии
                winesPrice = new WinesEntity().findAllWines();
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                return page;
            } else {

                //для выполнения запрса к базе данных нужно получить констатнту перечисления, а не ее значение
                //(только для перечисления WineSpiritContentEnum)
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE,
                        new WinesEntity().findWineByWineSpiritContent(WineSpiritContentEnum.getConstant(selected)));
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                //TODO для отладки
                System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "selected = " + selected +
                        "\nиз PARAM_NAME_WINES_PRICE для ChangePriceByCriteria (wineSpiritContent):");
                if (forRequestAttribute.containsKey(PARAM_NAME_WINES_PRICE)) {
                    for (Wine t : (List<Wine>) forRequestAttribute.get(PARAM_NAME_WINES_PRICE)) {

                        System.out.println("t => " + t);
                    }
                }

                return page;
            }
        }

        /**
         * ********************
         * (установка "фильтра" в таблице товаров по цвету вина (белое, красное, розовое)
         */
        if (content.getRequestParameters().containsKey(PARAM_NAME_WINE_COLOR_SELECTED)) {
            String selected = content.getRequestParameters().get(PARAM_NAME_WINE_COLOR_SELECTED)[0];

            //для устанавления в поле выбора критерия отбора выбранного по умолчанию значения (<option selected>)
            forRequestAttribute.put(PARAM_NAME_CHOSEN_CRITERIA, selected);

            if (selected.equals("все вина по цвету")) {
                //получение из БД прайса всей продукции и сохранение его в аттрибуты сессии
                winesPrice = new WinesEntity().findAllWines();
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                return page;
            } else {
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, new WinesEntity().findWineByWineColor(selected));
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                //TODO для отладки
                System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "selected = " + selected +
                        "\nиз PARAM_NAME_WINES_PRICE для ChangePriceByCriteria (wineByWineColor):");
                if (forRequestAttribute.containsKey(PARAM_NAME_WINES_PRICE)) {
                    for (Wine t : (List<Wine>) forRequestAttribute.get(PARAM_NAME_WINES_PRICE)) {

                        System.out.println("t => " + t);
                    }
                }

                return page;
            }
        }

        /**
         * ********************
         * (установка "фильтра" в таблице товаров по коллекции вина
         */
        if (content.getRequestParameters().containsKey(PARAM_NAME_WINE_COLLECTION_SELECTED)) {
            String selected = content.getRequestParameters().get(PARAM_NAME_WINE_COLLECTION_SELECTED)[0];

            //для устанавления в поле выбора критерия отбора выбранного по умолчанию значения (<option selected>)
            forRequestAttribute.put(PARAM_NAME_CHOSEN_CRITERIA, selected);

            if (selected.equals("вина из всех коллекций")) {
                //получение из БД прайса всей продукции и сохранение его в аттрибуты сессии
                winesPrice = new WinesEntity().findAllWines();
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                return page;
            } else {
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, new WinesEntity().findWineByWineCollection(selected));
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);

                //TODO для отладки
                System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "selected = " + selected +
                        "\nиз PARAM_NAME_WINES_PRICE для ChangePriceByCriteria (wineCollection):");
                if (forRequestAttribute.containsKey(PARAM_NAME_WINES_PRICE)) {
                    for (Wine t : (List<Wine>) forRequestAttribute.get(PARAM_NAME_WINES_PRICE)) {

                        System.out.println("t => " + t);
                    }
                }

                return page;
            }
        }

        return page;
    }
}
