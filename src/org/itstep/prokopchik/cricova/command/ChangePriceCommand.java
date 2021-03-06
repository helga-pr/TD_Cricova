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

/**
 * Класс обрабатывает нажатие кнопок управления прайсами продукции на странице Администратора
 * "Удалить пункт прайса" - удаляется выбранный пункт прайса
 * "Изменить пункт прайса" - перенаправляет на страницу изменения и внесения нового пункта прайса (нового товара).
 * в аттрибутах запроса передается выбранный пункт прайса (объект класса Wine) и команда кнопки.
 * "Добавить пункт прайса" - перенаправляет на страницу изменения и внесения нового пункта прайса (нового товара).
 * в аттрибутах запроса передается команда кнопки.
 */
public class ChangePriceCommand implements ActionCommand {

    private static final String SESSION_ATTR_NAME_LOGIN = "login";
    private static final String SESSION_ATTR_WINES_PRICE = "winesPriceSessionAttr";
    private static final String SESSION_ATTR_COMMAND_BUTTON = "commandButton";

    private static final String PARAM_NAME_WINES_PRICE = "winesPrice";
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

        //какая кнопка была нажата
        String commandButton = null;
        if (content.getRequestParameters().containsKey(PARAM_NAME_COMMAND_BUTTON)) {
            commandButton = content.getRequestParameters().get(PARAM_NAME_COMMAND_BUTTON)[0];
        }

        //id товара для изменения/удаления в БД
        String id = "0";
        if (content.getRequestParameters().containsKey(PARAM_NAME_PRODUCT_ID_FOR_CHANGE)) {
            id = (content.getRequestParameters().get(PARAM_NAME_PRODUCT_ID_FOR_CHANGE)[0].replace('/', ' ')).trim();
            forRequestAttribute.put(PARAM_NAME_PRODUCT_ID_FOR_CHANGE, id);
            content.setRequestAttributes(forRequestAttribute);
            content.insertAttributes(request);
        }
        //*************УДАЛЕНИЕ ЭКЗЕМПЛЯРА WINE из БД
        //если выбран пункт прайса и нажата кнопка Удалить
        if (Integer.valueOf(id) > 0 && commandButton.equals(PRESSED_BUTTON_DELETE)) {
            Integer numberRemoteLines = new WinesEntity().deleteWineById(Integer.valueOf(id));

            if (numberRemoteLines > 0) {
                //получение из БД обновленного прайса продукции и сохранение его в аттрибуты сессии
                winesPrice = new WinesEntity().findAllWines();
                forSessionAttr.put(SESSION_ATTR_WINES_PRICE, winesPrice);
                forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);
                forRequestAttribute.put(PARAM_NAME_MESSAGE_FOR_PRICE, "Товар успешно удален из БД. Прайс продукции обновлен");
            }
        }

        if (Integer.valueOf(id) > 0 && commandButton.equals(PRESSED_BUTTON_CHANGE)) {
            forRequestAttribute.put(PARAM_NAME_COMMAND_BUTTON, commandButton);
            forRequestAttribute.put(PARAM_NAME_PRODUCT_ID_FOR_CHANGE, Integer.valueOf(id));

            //сохранение переданной команды в аттрибутах сессии для использования обработчиком AddChangePricePositionCommand.java
            forSessionAttr.put(SESSION_ATTR_COMMAND_BUTTON, commandButton);

            Wine wine = new WinesEntity().findWineById(Integer.valueOf(id));
            forRequestAttribute.put(PARAM_NAME_WINE_FOR_CHANGE, wine);

            content.setRequestAttributes(forRequestAttribute);
            content.setSessionAttributes(forSessionAttr);

            content.insertAttributes(request);
            content.insertSessionAttributes(request);

            return "/WEB-INF/add_change_product_administration.jsp";
        }

        //*************ИЗМЕНЕНИЕ ЭКЗЕМПЛЯРА WINE в БД
        if (commandButton.equals(PRESSED_BUTTON_ADD)) {
            forRequestAttribute.put(PARAM_NAME_COMMAND_BUTTON, commandButton);

            //сохранение переданной команды в аттрибутах сессии для использования обработчиком AddChangePricePositionCommand.java
            forSessionAttr.put(SESSION_ATTR_COMMAND_BUTTON, commandButton);

            content.setRequestAttributes(forRequestAttribute);
            content.setSessionAttributes(forSessionAttr);
            content.insertAttributes(request);
            content.insertSessionAttributes(request);

            return "/WEB-INF/add_change_product_administration.jsp";
        }

        content.setRequestAttributes(forRequestAttribute);
        content.setSessionAttributes(forSessionAttr);
        content.insertAttributes(request);
        content.insertSessionAttributes(request);

        return "/WEB-INF/price_administration.jsp";
    }
}
