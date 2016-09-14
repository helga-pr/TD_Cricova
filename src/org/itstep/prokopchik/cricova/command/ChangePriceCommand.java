package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.Wine;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;
import org.itstep.prokopchik.cricova.database.dao.wine.WinesEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ChangePriceCommand implements ActionCommand {

    private static final String SESSION_ATTR_NAME_LOGIN = "login";
    private static final String SESSION_ATTR_WINES_PRICE = "winesPriceSessionAttr";

    private static final String PARAM_NAME_WINES_PRICE = "winesPrice";
    private static final String PARAM_NAME_PRODUCT_ID_FOR_DELETE = "changedProductId";
    private static final String PARAM_NAME_PRODUCT_ID_FOR_CHANGE = "changedProductId";
    private static final String PARAM_NAME_COMMAND_BUTTON = "buttonName";
    private static final String PARAM_NAME_MESSAGE_FOR_PRICE = "messageForPrice";
    private static final String PARAM_NAME_WINE_FOR_CHANGE = "wineForChange";

    private static final String PRESSED_BUTTON_DELETE = "Удалить пункт прайса";
    private static final String PRESSED_BUTTON_CHANGE = "Изменить пункт прайса";
    private static final String PRESSED_BUTTON_ADD = "Добавить пункт прайса";

    List<Wine> winesPrice;

    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {

        /**
         * Использование специального класса для работы с аттрибутами и параметрами запроса
         * и сессии пользователя в целях безопасности приложения
         */
        SessionRequestContent content = new SessionRequestContent();

        try {

            //TODO для отладки
            System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    "Class = " + getClass() +
                    "\nrequest = " + request);

            content.extractParametersValues(request);
            content.extractSessionAttributeValues(request);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //HashMap для записи аттрибутов сессии пользователя и аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();
        HashMap<String, Object> forSessionAttr = content.getSessionAttributes();

        //какая кнопка нажата
        String commandButton = null;
        if (content.getRequestParameters().containsKey(PARAM_NAME_COMMAND_BUTTON)) {
            commandButton = content.getRequestParameters().get(PARAM_NAME_COMMAND_BUTTON)[0];
        }

        //id товара для изменения/удаления в БД
        String id = "0";
        if (content.getRequestParameters().containsKey(PARAM_NAME_PRODUCT_ID_FOR_CHANGE)) {
            id = (content.getRequestParameters().get(PARAM_NAME_PRODUCT_ID_FOR_CHANGE)[0].replace('/', ' ')).trim();
        }
        //если выбран пункт прайса и нажата кнопка Удалить
        if (Integer.valueOf(id) > 0 && commandButton.equals(PRESSED_BUTTON_DELETE)) {
            Integer numberRemoteLines = new WinesEntity().deleteWineById(Integer.valueOf(id));

            if (numberRemoteLines > 0) {
                //получение из БД обновленного прайса продукции и сохранение его в аттрибуты сессии
                winesPrice = new WinesEntity().findAllWines();
                forSessionAttr.put(SESSION_ATTR_WINES_PRICE, winesPrice);
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);
                forRequestAttribute.put(PARAM_NAME_MESSAGE_FOR_PRICE, "Товар успешно удален и БД. Прайс продукции обновлен");
            }
        }

        if (Integer.valueOf(id) > 0 && commandButton.equals(PRESSED_BUTTON_CHANGE)) {
            forRequestAttribute.put(PARAM_NAME_COMMAND_BUTTON, commandButton);

            Wine wine = new WinesEntity().findWineById(Integer.valueOf(id));
            forRequestAttribute.put(PARAM_NAME_WINE_FOR_CHANGE, wine);

            wine.getName();
            wine.getImage();
            wine.getPrice();
            wine.getNdsRate();
            wine.getWineType();
            wine.getWineAge();
            wine.getWineColor();
            wine.getWineSpiritContent();
            wine.getWineSugarContent();
            wine.getWineCollection();
            wine.getAnnotation();

            content.setRequestAttributes(forRequestAttribute);
            content.setSessionAttributes(forSessionAttr);
            content.insertAttributes(request);
            content.insertSessionAttributes(request);

            return "/add_change_product_administration";
        }

        if (commandButton.equals(PRESSED_BUTTON_ADD)) {
            forRequestAttribute.put(PARAM_NAME_COMMAND_BUTTON, commandButton);

            content.setRequestAttributes(forRequestAttribute);
            content.setSessionAttributes(forSessionAttr);
            content.insertAttributes(request);
            content.insertSessionAttributes(request);

            return "/add_change_product_administration";
        }


       /* //TODO для отладки
        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "request attributes ==> ");
        if (!content.getRequestParameters().isEmpty()) {
            for (Map.Entry entry : content.getRequestParameters().entrySet()) {

                System.out.println(entry.getKey() + " => " + content.getRequestParameters().get(entry.getKey())[0]);
                if("changedProductId".equals(entry.getKey())){
                    //id товара приходит в параметрах запроса с символом '/' в конце
                    String id = (content.getRequestParameters().get(entry.getKey())[0].replace('/', ' ')).trim();
                    System.out.println("id = " + Integer.valueOf(id));
                }
            }
            System.out.println("<<<\n");
        }*/


        content.setRequestAttributes(forRequestAttribute);
        content.setSessionAttributes(forSessionAttr);
        content.insertAttributes(request);
        content.insertSessionAttributes(request);

        return "/price_administration.jsp";
    }
}
