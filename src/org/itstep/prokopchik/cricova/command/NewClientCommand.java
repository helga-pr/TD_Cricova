package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.Company;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;
import org.itstep.prokopchik.cricova.database.dao.company.CompaniesEntity;
import org.itstep.prokopchik.cricova.logic.MailLogic;
import org.itstep.prokopchik.cricova.logic.UnpLogic;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public class NewClientCommand implements ActionCommand {

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
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String passwordRepeat = request.getParameter(PARAM_NAME_PASSWORD_REPEAT);
        String name = request.getParameter(PARAM_NAME_CLIENT_NAME);
        try {
            name = new String(name.getBytes("ISO-8859-1"), "utf-8");//значение параметра может быть внесено на русском языке

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String middlename = request.getParameter(PARAM_NAME_CLIENT_MIDDLENAME);
        try {
            middlename = new String(middlename.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке
            if (middlename.isEmpty()) {
                middlename = "";
            }

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String lastname = request.getParameter(PARAM_NAME_CLIENT_LASTNAME);
        try {
            lastname = new String(lastname.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String clientContacts = request.getParameter(PARAM_NAME_CLIENT_CONTACTS);
        try {
            clientContacts = new String(clientContacts.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String companyName = request.getParameter(PARAM_NAME_COMPANY_NAME);
        try {
            companyName = new String(companyName.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String unp = request.getParameter(PARAM_NAME_COMPANY_UNP);
        String companyNotes = request.getParameter(PARAM_NAME_COMPANY_NOTES);
        try {
            companyNotes = new String(companyNotes.getBytes("ISO-8859-1"), "utf-8");//значение параметра внесено на русском языке

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        // проверка логина и пароля, проверка УНП
        //если такого клиента еще нет в БД, то он создается и записывается в БД
        if (MailLogic.checkEmail(login)
                && pass.equals(passwordRepeat)
                && new ClientsEntity().findClient(login) == null
                && UnpLogic.checkUnp(unp)) {

            //TODO Для отладки
            System.out.println("\n" + "e-mail = login = " + login + " is validity. \n " +
                    "UNP is validity. Client with this login not found in DB.");

            //создание нового клиента, если логин(в качестве логина используется e-mail) уникален,
            // и сохранение в БД

            Client newClient = null;
            Company company = null;
            CompaniesEntity companiesEntity = new CompaniesEntity();

            //если компания еще не зарегистрирована в БД, то  создается и сохраняется,
            // иначе используется существующая в БД, заметки добавляются
            if (!companiesEntity.isExistCompanyWithUnp(Long.parseLong(unp))) {
                company = companiesEntity.createCompany(companyName, Long.parseLong(unp), companyNotes);

                //TODO Для отладки
                System.out.println("NewClientCommand class (method execute()): Company company.toString = "
                        + company.toString() + "\n");

            } else {
                company = companiesEntity.findByUnp(Long.parseLong(unp));
                company.setNotes(company.getNotes() + "; " + companyNotes);
                companiesEntity.updateCompany(company);

                //TODO Для отладки
                System.out.println("NewClientCommand class (method execute())" +
                        "(after companiesEntity.updateCompany(company)): Company company.toString = "
                        + company.toString() + "\n");
            }

            newClient = new ClientsEntity().createClient(login, pass, name, middlename, lastname, company, clientContacts);


            if (newClient != null) {
                //res - id записаного в БД нового клиента
                Integer res = new ClientsEntity().updateClient(newClient);


                //TODO для отладки
                System.out.println("Результат обновления newClient = ");

                String fio = newClient.getLastname() + " " + newClient.getName() + " " + newClient.getMiddleName();

                request.setAttribute("clientname", fio);

                request.setAttribute("login", login);

                // определение пути к *.jsp
                page = "/receive_price.jsp";
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
                request.setAttribute("wrongAction", "Вы уже были зарегистрированы ранее на нашем сайте." +
                        "\nВнести изменения в свои учетные данные можно по кнопке \"Изменить учетные данные\"" +
                        "после успешной авторизации на сайте");

                //TODO Для отладки
                System.out.println("Из блока (Else (Клиент с таким логином уже есть в БД) " +
                        "класса NewClientCommand)" +
                        ": wrongAction message: " + request.getAttribute("wrongAction"));

                page = "/login.jsp";

                //логин указан некорректно, клияент возвращается на страницу регистрации
                //с указанием на ошибку
            } else {
                request.setAttribute("errorLoginPassMessage",
                        "Incorrect login(use your e-mail as login only) or password!");

                //page = ConfigurationManager.getProperty("path.page.login");
                page = "/registration.jsp";

                //TODO Для отладки
                System.out.println("Из блока (Else (логин или пароль нового клиента не прошли валидацию) " +
                        "класса NewClientCommand)" +
                        ": errorLoginPassMessage: " + request.getAttribute("errorLoginPassMessage"));

            }
        }

        //TODO для отладки
        System.out.println("\nПередаваемая страница из класса NewClientCommand = " + page);

        return page;
    }


}
