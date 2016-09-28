package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.*;
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
 * Класс обрабатывает нажатие кнопок "Внести изменения" и "Отмена"
 * на странице изменения/добавления пункта прайса (и одновременно товара в БД)
 * add_change_product_administration.jsp
 * Кнопка "Внести изменения" возвразает страницу add_change_product_administration.jsp
 * с новой строкой в таблице для добавления товара,
 * если была использована команда "Добавить пункт прайса";
 * и возвращает страницу price_administration.jsp,
 * если была использована команда "Изменить пункт прайса" или нажата кнопка "Отмена".
 */

public class AddChangePricePositionCommand implements ActionCommand {

    private static final String SESSION_ATTR_WINES_PRICE = "winesPriceSessionAttr";
    private static final String SESSION_ATTR_COMMAND_BUTTON = "commandButton";

    private static final String PARAM_NAME_COMMAND_BUTTON = "buttonName";
    private static final String PARAM_NAME_WINES_PRICE = "winesPrice";
    private static final String PARAM_NAME_WINE_FOR_CHANGE = "wineForChange";
    private static final String PARAM_NAME_PRODUCT_ID_FOR_CHANGE = "changedProductId";
    private static final String PARAM_NAME_BUTTON_CHANGE_PAGE = "buttonNameChangePage";//"Внести изменения" / "Отмена"
    private static final String PARAM_NAME_MESSAGE_FOR_PRICE = "messageForPrice";//true - set error-format for message, false - normal format for message
    private static final String PARAM_NAME_ERROR_FLAG = "errorFlag";

    private static final String PRESSED_BUTTON_CHANGE = "Изменить пункт прайса";
    private static final String PRESSED_BUTTON_ADD = "Добавить пункт прайса";
    private static final String PRESSED_BUTTON_SAVE_CHANGE = "Внести изменения";
    private static final String PRESSED_BUTTON_CANCEL = "Отмена";

    /**
     * константы - поля для экземпляра Wine при изменении
     */
    private static final String PARAM_NAME_WINE_NAME_UPDATE = "wineName";
    private static final String PARAM_NAME_WINE_PRICE_UPDATE = "winePrice";
    private static final String PARAM_NAME_WINE_NDS_RATE_UPDATE = "wineNdsRate";
    private static final String PARAM_NAME_WINE_IMAGE_UPDATE = "wineImage";
    private static final String PARAM_NAME_WINE_TYPE_UPDATE = "wineTypeSelected";
    private static final String PARAM_NAME_WINE_AGE_UPDATE = "wineAgeSelected";
    private static final String PARAM_NAME_WINE_COLOR_UPDATE = "wineColorSelected";
    private static final String PARAM_NAME_WINE_SPIRIT_UPDATE = "wineSpiritSelected";
    private static final String PARAM_NAME_WINE_SUGAR_UPDATE = "wineSugarSelected";
    private static final String PARAM_NAME_WINE_COLLECTION_UPDATE = "wineCollectionSelected";
    private static final String PARAM_NAME_WINE_ANNOTATION_UPDATE = "wineAnnotation";

    /**
     * константы - поля для экземпляра Wine при добавлении нового (новый пункт прайса)
     */
    private static final String PARAM_NAME_WINE_NAME_NEW = "wineNameNew";
    private static final String PARAM_NAME_WINE_PRICE_NEW = "winePriceNew";
    private static final String PARAM_NAME_WINE_NDS_RATE_NEW = "wineNdsRateNew";
    private static final String PARAM_NAME_WINE_IMAGE_NEW = "wineImageNew";
    private static final String PARAM_NAME_WINE_TYPE_NEW = "wineTypeSelectedNew";
    private static final String PARAM_NAME_WINE_AGE_NEW = "wineAgeSelectedNew";
    private static final String PARAM_NAME_WINE_COLOR_NEW = "wineColorSelectedNew";
    private static final String PARAM_NAME_WINE_SPIRIT_NEW = "wineSpiritSelectedNew";
    private static final String PARAM_NAME_WINE_SUGAR_NEW = "wineSugarSelectedNew";
    private static final String PARAM_NAME_WINE_COLLECTION_NEW = "wineCollectionSelectedNew";
    private static final String PARAM_NAME_WINE_ANNOTATION_NEW = "wineAnnotationNew";


    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {

        /**
         * Использование специального класса для работы с аттрибутами и параметрами запроса
         * и сессии пользователя в целях безопасности приложения
         */
        SessionRequestContent content = new SessionRequestContent();

        List<Wine> winesPrice = null;

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

        //какая кнопка была нажата при перенаправлении на страницу price_administration.jsp
        //(добавить или изменить)
        String commandButton = null;
        if (content.getSessionAttributes().containsKey(SESSION_ATTR_COMMAND_BUTTON)) {
            commandButton = (String) content.getSessionAttributes().get(SESSION_ATTR_COMMAND_BUTTON);
        }

        //какая кнопка (Внести изменения или Отмена) была нажата на странице add_change_product_administration.jsp
        String button = null;
        if (content.getRequestParameters().containsKey(PARAM_NAME_BUTTON_CHANGE_PAGE)) {
            button = content.getRequestParameters().get(PARAM_NAME_BUTTON_CHANGE_PAGE)[0];
        }

        //id товара для изменения/удаления в БД
        String id = "0";
        if (content.getRequestParameters().containsKey(PARAM_NAME_PRODUCT_ID_FOR_CHANGE)) {
            id = (content.getRequestParameters().get(PARAM_NAME_PRODUCT_ID_FOR_CHANGE)[0].replace('/', ' ')).trim();

/*            //TODO Для отладки
            System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    "Class = " + getClass());

            System.out.println("id => " + id);
 */
        }

        //=======================
        //Если была нажата кнопка "Отмена", то проиходит возврат на страницу с общим прайсом продукции
        if (button.equals(PRESSED_BUTTON_CANCEL)) {
            System.out.println("Если была нажата кнопка \"Отмена\", то проиходит возврат на страницу с общим прайсом продукции");
            //получение из БД обновленного прайса продукции и сохранение его в аттрибуты сессии
            winesPrice = new WinesEntity().findAllWines();
            forSessionAttr.put(SESSION_ATTR_WINES_PRICE, winesPrice);
            forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);

            //сохранение и передача аттрибутов на страницу
            content.setRequestAttributes(forRequestAttribute);
            content.insertAttributes(request);

            content.setSessionAttributes(forSessionAttr);
            content.insertSessionAttributes(request);

            return "/WEB-INF/price_administration.jsp";
        }


        //=======================
        //если выполняется команда Изменить пункт прайса и была нажата кнопка "Внести изменения"
        if (commandButton.equals(PRESSED_BUTTON_CHANGE) && button.equals(PRESSED_BUTTON_SAVE_CHANGE)) {
            /**
             * находим в БД товар с полученным со  страницы id
             * записываем его  в экземпляр Wine
             * в экземпляре Wine перезаписываем изменненые поля и сохраняем эти  изменения в БД
             * если изменения не обнаружены, то возврат на страницу add_change_product_administration.jsp
             */

            Wine changingWine = new WinesEntity().findWineById(Integer.valueOf(id));
            forRequestAttribute.put(PARAM_NAME_WINE_FOR_CHANGE, changingWine);
            /**id измененного товара в БД, если изменение успешно сохранено
             * (если равно 0, то данные о товаре не изменены;
             * если равно -1, то товар с указанным id не был найден в БД
             */
            Integer idUpdateWine = 0;
            //флаг изменения товара (если хотя бы одно поле было изменено, то true)
            Boolean changeFlag = false;

            /**
             * если не заполнены обязательные поля - возврат на страницу add_change_product_administration.jsp
             */
            if (content.getRequestParameters().get(PARAM_NAME_WINE_NAME_UPDATE)[0].isEmpty()
                    || content.getRequestParameters().get(PARAM_NAME_WINE_PRICE_UPDATE)[0].isEmpty()
                    || Integer.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_PRICE_UPDATE)[0]) <= 0
                    || content.getRequestParameters().get(PARAM_NAME_WINE_NDS_RATE_UPDATE)[0].isEmpty()
                    || Integer.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_NDS_RATE_UPDATE)[0]) < 0) {

                forRequestAttribute.put(PARAM_NAME_PRODUCT_ID_FOR_CHANGE, id);
                forRequestAttribute.put(PARAM_NAME_COMMAND_BUTTON, PRESSED_BUTTON_CHANGE);
                forRequestAttribute.put(PARAM_NAME_ERROR_FLAG, "true");
                forRequestAttribute.put(PARAM_NAME_MESSAGE_FOR_PRICE, "Изменения НЕ сохранены!!!" +
                        "\nПроверьте корректность внесенных данных!" +
                        "\nДля возврата к общему прайсу нажмите кнопку \"Отмена\"");
                content.setRequestAttributes(forRequestAttribute);
                content.insertAttributes(request);
                return "/WEB-INF/add_change_product_administration.jsp";
            } else {

                if (!changingWine.getName().equals(content.getRequestParameters().get(PARAM_NAME_WINE_NAME_UPDATE)[0])) {
                    changingWine.setName(content.getRequestParameters().get(PARAM_NAME_WINE_NAME_UPDATE)[0]);
                    changeFlag = true;
                }
                if (changingWine.getPrice() != Integer.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_PRICE_UPDATE)[0])) {
                    changingWine.setPrice(Integer.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_PRICE_UPDATE)[0]));
                    changeFlag = true;

                }
                if (changingWine.getNdsRate() != Integer.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_NDS_RATE_UPDATE)[0])) {
                    changingWine.setNdsRate(Integer.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_NDS_RATE_UPDATE)[0]));
                    changeFlag = true;

                }
                if (content.getRequestParameters().containsKey(PARAM_NAME_WINE_IMAGE_UPDATE)) {
                    if (!PARAM_NAME_WINE_IMAGE_UPDATE.isEmpty() && !changingWine.getImage().equals(content.getRequestParameters()
                            .get(PARAM_NAME_WINE_IMAGE_UPDATE)[0])) {
                        changingWine.setImage(content.getRequestParameters().get(PARAM_NAME_WINE_IMAGE_UPDATE)[0].getBytes());
                        changeFlag = true;
                    }
                }
                if (!changingWine.getWineType().equals(WineTypeEnum.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_TYPE_UPDATE)[0].toUpperCase()))) {
                    changingWine.setWineType(WineTypeEnum.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_TYPE_UPDATE)[0].toUpperCase()));
                    changeFlag = true;
                }
                if (!changingWine.getWineAge().equals(WineAgeEnum.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_AGE_UPDATE)[0].toUpperCase()))) {
                    changingWine.setWineAge(WineAgeEnum.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_AGE_UPDATE)[0].toUpperCase()));
                    changeFlag = true;
                }
                if (!changingWine.getWineColor().equals(WineColorEnum.valueOf(content.getRequestParameters()
                        .get(PARAM_NAME_WINE_COLOR_UPDATE)[0].toUpperCase()))) {

                    changingWine.setWineColor(WineColorEnum.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_COLOR_UPDATE)[0].toUpperCase()));
                    changeFlag = true;

                }

                if (!changingWine.getWineSpiritContent().equals(WineSpiritContentEnum.valueOf(WineSpiritContentEnum.getConstant(
                        content.getRequestParameters().get(PARAM_NAME_WINE_SPIRIT_UPDATE)[0])))) {
                    changingWine.setWineSpiritContent(WineSpiritContentEnum.valueOf(WineSpiritContentEnum.getConstant(
                            content.getRequestParameters().get(PARAM_NAME_WINE_SPIRIT_UPDATE)[0])));
                    changeFlag = true;
                }

                if (!changingWine.getWineSugarContent().equals(WineSugarContentEnum.valueOf(content.getRequestParameters()
                        .get(PARAM_NAME_WINE_SUGAR_UPDATE)[0].toUpperCase()))) {
                    changingWine.setWineSugarContent(WineSugarContentEnum.valueOf(content.getRequestParameters()
                            .get(PARAM_NAME_WINE_SUGAR_UPDATE)[0].toUpperCase()));
                    changeFlag = true;
                }

                if (!changingWine.getWineCollection().equals(WineCollectionEnum.valueOf(
                        content.getRequestParameters().get(PARAM_NAME_WINE_COLLECTION_UPDATE)[0].toUpperCase()))) {
                    changingWine.setWineCollection(WineCollectionEnum.valueOf(content.getRequestParameters()
                            .get(PARAM_NAME_WINE_COLLECTION_UPDATE)[0].toUpperCase()));
                    changeFlag = true;
                }
                if (!changingWine.getAnnotation().equals(content.getRequestParameters().get(PARAM_NAME_WINE_ANNOTATION_UPDATE)[0])) {
                    changingWine.setAnnotation(content.getRequestParameters().get(PARAM_NAME_WINE_ANNOTATION_UPDATE)[0]);
                    changeFlag = true;
                }

                /**
                 * флаг изменения True, то обновляется Объект в БД
                 */

                if (changeFlag == true) {
                    idUpdateWine = new WinesEntity().updateWine(changingWine);
                }
                /**
                 * иначе возврат обратно на страницу с сообщением об ошибке
                 */
                else {
                    forRequestAttribute.put(PARAM_NAME_PRODUCT_ID_FOR_CHANGE, id);
                    forRequestAttribute.put(PARAM_NAME_COMMAND_BUTTON, PRESSED_BUTTON_CHANGE);
                    forRequestAttribute.put(PARAM_NAME_ERROR_FLAG, "true");
                    forRequestAttribute.put(PARAM_NAME_MESSAGE_FOR_PRICE, "Изменения не обнаружены!" +
                            "\nВнесите необходимые корректировки и проверьте корректность внесенных данных!" +
                            "\nДля возврата к общему прайсу нажмите кнопку \"Отмена\"");
                    content.setRequestAttributes(forRequestAttribute);
                    content.insertAttributes(request);
                    return "/WEB-INF/add_change_product_administration.jsp";
                }

                /**
                 * если обновление прошло успешно
                 */
                if (idUpdateWine > 0) {
                    //получение из БД обновленного прайса продукции и сохранение его в аттрибуты сессии
                    winesPrice = new WinesEntity().findAllWines();
                    forSessionAttr.put(SESSION_ATTR_WINES_PRICE, winesPrice);
                    forRequestAttribute.put(PARAM_NAME_WINES_PRICE, winesPrice);
                    forRequestAttribute.put(PARAM_NAME_ERROR_FLAG, "false");
                    forRequestAttribute.put(PARAM_NAME_MESSAGE_FOR_PRICE, "Измененния в БД внесены. Прайс продукции обновлен.");

                    //TODO для отладки
                    System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()));
                    System.out.println("Товар успешно изменен и БД. Прайс продукции обновлен.");

                    //сохранение и передача аттрибутов на страницу
                    content.setRequestAttributes(forRequestAttribute);
                    content.insertAttributes(request);

                    content.setSessionAttributes(forSessionAttr);
                    content.insertSessionAttributes(request);

                    return "/WEB-INF/price_administration.jsp";
                }
            }
        }

        //=======================
        //если выполняется команда добавления нового товара и была нажата кнопка "Внести изменения"
        else {
            if (commandButton.equals(PRESSED_BUTTON_ADD) && button.equals(PRESSED_BUTTON_SAVE_CHANGE)) {
                //Проверить, что все обязательные поля заполнены, в противном случае админ возвращается обратно на страницу
                //внесения нового товара
                if (content.getRequestParameters().get(PARAM_NAME_WINE_PRICE_NEW)[0].isEmpty()
                        || Integer.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_PRICE_NEW)[0]) <= 0
                        || content.getRequestParameters().get(PARAM_NAME_WINE_NDS_RATE_NEW)[0].isEmpty()
                        || Integer.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_NDS_RATE_NEW)[0]) < 0) {

                    forRequestAttribute.put(PARAM_NAME_ERROR_FLAG, "true");
                    forRequestAttribute.put(PARAM_NAME_MESSAGE_FOR_PRICE, "Новая позиция товара НЕ внесена в БД." +
                            "\nПроверьте корректность внесенных данных!" +
                            "\nДля возврата к общему прайсу нажмите кнопку \"Отмена\"");
                    content.setRequestAttributes(forRequestAttribute);
                    content.insertAttributes(request);

                    return "/WEB-INF/add_change_product_administration.jsp";
                } else {
                    //Если все обязательные поля заполнены, Создать и записать в БД новый экземпляр Wine

                    Wine newWine = new WinesEntity().createWine(
                            content.getRequestParameters().get(PARAM_NAME_WINE_NAME_NEW)[0],
                            Integer.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_PRICE_NEW)[0]),
                            Integer.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_NDS_RATE_NEW)[0]),
                            (byte[]) (content.getRequestAttributes().get(PARAM_NAME_WINE_IMAGE_NEW)),
                            content.getRequestParameters().get(PARAM_NAME_WINE_ANNOTATION_NEW)[0],
                            WineTypeEnum.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_TYPE_NEW)[0].toUpperCase()),
                            WineColorEnum.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_COLOR_NEW)[0].toUpperCase()),
                            WineAgeEnum.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_AGE_NEW)[0].toUpperCase()),
                            WineSugarContentEnum.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_SUGAR_NEW)[0].toUpperCase()),
                            WineSpiritContentEnum.valueOf(WineSpiritContentEnum.getConstant(content.getRequestParameters().get(PARAM_NAME_WINE_SPIRIT_NEW)[0])),
                            WineCollectionEnum.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_COLLECTION_NEW)[0].toUpperCase()));

                    if (newWine != null) {

                        forRequestAttribute.put(PARAM_NAME_ERROR_FLAG, "false");
                        forRequestAttribute.put(PARAM_NAME_MESSAGE_FOR_PRICE, "Новая позиция товара в БД внесена." +
                                "\n Для возврата к общему прайсу нажмите кнопку \"Отмена\"");
                        content.setRequestAttributes(forRequestAttribute);
                        content.insertAttributes(request);

                        //TODO для отладки
                        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                                "Class = " + getClass());
                        System.out.println("After Adding new wine: ");
                        System.out.println("Товар " + newWine.toString() + "сохранен в БД!");

                        //вернуть админа на страницу внесения нового товара

                    }
                    /**если товар успешно добавлен, админ возвращается на страницу добавления товара и может внести
                     * следующий новый пункт прайса, для возвращения к общему прайсу нужно нажать кнопку "Отмена".
                     */
                    return "/WEB-INF/add_change_product_administration.jsp";
                }
            }
        }

        //эта строка не должна выполняться никогда (в случае выполнения отобразится страница с пустой таблицей
        return "/WEB-INF/price_administration.jsp";
    }
}
