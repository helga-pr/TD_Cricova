package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.Company;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;
import org.itstep.prokopchik.cricova.database.dao.company.CompaniesEntity;
import org.itstep.prokopchik.cricova.logic.MailLogic;
import org.itstep.prokopchik.cricova.logic.UnpLogic;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class NewClientCommand implements ActionCommand {

    //параметры, извлекаемые из запроса клиента
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_PASSWORD_REPEAT = "passwordRepeat";
    private static final String PARAM_NAME_CLIENT_NAME = "client_name";
    private static final String PARAM_NAME_CLIENT_MIDDLENAME = "client_middlename";
    private static final String PARAM_NAME_CLIENT_LASTNAME = "client_lastname";
    private static final String PARAM_NAME_CLIENT_CONTACTS = "client_contacts";
    private static final String PARAM_NAME_COMPANY_NAME = "company_name";
    private static final String PARAM_NAME_COMPANY_UNP = "company_unp";
    private static final String PARAM_NAME_COMPANY_NOTES = "company_notes";

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        // извлечение из запроса введенных для регистрации логина и пароля
        /**
         * Использование специального класса для работы с аттрибутами и параметрами запроса
         * и сессии пользователя в целях безопасности приложения
         */
        SessionRequestContent content = new SessionRequestContent();

        try {

            //TODO для отладки
            System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    "Class = NewClientCommand: " +
                    "\nrequest = " + request);

            content.extractParametersValues(request);

            content.extractSessionAttributeValues(request);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //HashMap для записи аттрибутов сессии пользователя и аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();
        HashMap<String, Object> forSessionAttr = content.getSessionAttributes();


        //в качестве значения принимается первый элемент, собственно он должен быть и единственным
        String login = content.getRequestParameters().get(PARAM_NAME_LOGIN)[0];
        String pass = content.getRequestParameters().get(PARAM_NAME_PASSWORD)[0];
        String passwordRepeat = content.getRequestParameters().get(PARAM_NAME_PASSWORD_REPEAT)[0];
        String name = content.getRequestParameters().get(PARAM_NAME_CLIENT_NAME)[0];
        String middlename = content.getRequestParameters().get(PARAM_NAME_CLIENT_MIDDLENAME)[0];
        String lastname = content.getRequestParameters().get(PARAM_NAME_CLIENT_LASTNAME)[0];
        String clientContacts = content.getRequestParameters().get(PARAM_NAME_CLIENT_CONTACTS)[0];

        String companyName = content.getRequestParameters().get(PARAM_NAME_COMPANY_NAME)[0];
        String unp = content.getRequestParameters().get(PARAM_NAME_COMPANY_UNP)[0];
        String companyNotes = content.getRequestParameters().get(PARAM_NAME_COMPANY_NOTES)[0];

        //TODO для отладки
        System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "\nполучены параметры из запроса: name = " + name + "(login - " + login + "); company: " + companyName);

        //        String login = request.getParameter(PARAM_NAME_LOGIN);
//        String pass = request.getParameter(PARAM_NAME_PASSWORD);
//        String passwordRepeat = request.getParameter(PARAM_NAME_PASSWORD_REPEAT);
//        String name = request.getParameter(PARAM_NAME_CLIENT_NAME);
//        try {
//            name = new String(name.getBytes("ISO-8859-1"), "utf-8");//значение параметра может быть внесено на русском языке
//
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        String middlename = request.getParameter(PARAM_NAME_CLIENT_MIDDLENAME);
//        try {
//            middlename = new String(middlename.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке
//            if (middlename.isEmpty()) {
//                middlename = "";
//            }
//
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        String lastname = request.getParameter(PARAM_NAME_CLIENT_LASTNAME);
//        try {
//            lastname = new String(lastname.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке
//
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        String clientContacts = request.getParameter(PARAM_NAME_CLIENT_CONTACTS);
//        try {
//            clientContacts = new String(clientContacts.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке
//
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        String companyName = request.getParameter(PARAM_NAME_COMPANY_NAME);
//        try {
//            companyName = new String(companyName.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке
//
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        String unp = request.getParameter(PARAM_NAME_COMPANY_UNP);
//        String companyNotes = request.getParameter(PARAM_NAME_COMPANY_NOTES);
//        try {
//            companyNotes = new String(companyNotes.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке
//
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        /**
         *  проверка логина и пароля, проверка УНП
         * если такого клиента еще нет в БД, то он создается и записывается в БД
         */
        if (MailLogic.checkEmail(login)
                && pass.equals(passwordRepeat)
                && new ClientsEntity().findClient(login) == null
                && UnpLogic.checkUnp(unp)) {

            //TODO Для отладки
            System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    "e-mail = login = " + login + " is validity. \n " +
                    "UNP is validity. Client with this login not found in DB.");

            //создание нового клиента, если логин(в качестве логина используется e-mail) уникален,
            // и сохранение в БД

            Client newClient = null;
            Company company = null;
            CompaniesEntity companiesEntity = new CompaniesEntity();

            //если компания еще не зарегистрирована в БД, то  создается и сохраняется,
            // иначе используется существующая в БД, заметки обновляются
            if (!companiesEntity.isExistCompanyWithUnp(Long.parseLong(unp))) {
                company = companiesEntity.createCompany(companyName, Long.parseLong(unp), companyNotes);

                //TODO Для отладки
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "NewClientCommand class (method execute()): Company company.toString = "
                        + company.toString() + "\n");

            } else {
                company = companiesEntity.findByUnp(Long.parseLong(unp));
                company.setNotes(companyNotes);
                companiesEntity.updateCompany(company);

                //TODO Для отладки
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "NewClientCommand class (method execute())" +
                        "(after companiesEntity.updateCompany(company)): Company company.toString = "
                        + companiesEntity.findByUnp(Long.parseLong(unp)).toString() + "\n");
            }

            newClient = new ClientsEntity().createClient(login, pass, name, middlename, lastname, company, clientContacts);

            if (newClient != null) {
                //res - id записаного в БД нового клиента
                Integer res = new ClientsEntity().updateClient(newClient);

                //TODO для отладки
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "Результат обновления newClient = ");

                String fio = newClient.getLastname() + " " + newClient.getName() + " " + newClient.getMiddleName();

                forRequestAttribute.put("clientname", fio);
                forRequestAttribute.put("login", login);

                forSessionAttr.put("login", login);

                //запись аттрибутов запроса и сессии для передачи на следующую страницу
                content.insertAttributes(request);
                content.insertSessionAttributes(request);

                // определение пути к *.jsp
                page = "/WEB-INF/receive_price.jsp";
            }

        } else {
            //Клиент с таким логином уже есть в БД
            if (MailLogic.checkEmail(login)
                    && new ClientsEntity().findClient(login) != null
                    && UnpLogic.checkUnp(unp)) {
                //и клиент указал другую организацию
                //сообщить, что он уже зарегистрирован и перенаправить на страницу авторизации
                //сообщить, что внести изменения в свои учетные данные можно по кнопке "Изменить учетные данные"
                //после успешной авторизации на сайте
                forRequestAttribute.put("wrongAction", "Вы уже были зарегистрированы ранее на нашем сайте." +
                        "\nВнести изменения в свои учетные данные можно по кнопке \"Изменить учетные данные\"" +
                        "после успешной авторизации на сайте");
                forSessionAttr.put("login", login);
                //TODO Для отладки
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "Из блока (Else (Клиент с таким логином уже есть в БД) " +
                        "класса NewClientCommand)" +
                        ": wrongAction message: " + content.getRequestAttributes().get("wrongAction"));

                content.insertAttributes(request);
                content.insertSessionAttributes(request);
                page = "/WEB-INF/login.jsp";

                //логин указан некорректно, клияент возвращается на страницу регистрации
                //с указанием на ошибку
            } else {
                forRequestAttribute.put("errorLoginPassMessage",
                        "Incorrect login(use your e-mail as login only) or password!");

                content.insertAttributes(request);

                page = "/WEB-INF/registration.jsp";

                //TODO Для отладки
                System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                        "Из блока (Else (логин или пароль нового клиента не прошли валидацию) " +
                        "класса NewClientCommand)" +
                        ": errorLoginPassMessage: "
                        + content.getRequestAttributes().get("errorLoginPassMessage"));
            }
        }

        //TODO для отладки
        System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "Передаваемая страница из класса NewClientCommand = " + page);

        return page;
    }


}
