package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.Client;
import org.itstep.prokopchik.cricova.Company;
import org.itstep.prokopchik.cricova.database.dao.client.ClientsEntity;
import org.itstep.prokopchik.cricova.database.dao.company.CompaniesEntity;
import org.itstep.prokopchik.cricova.logic.MailLogic;

import javax.servlet.http.HttpServletRequest;

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
        String middlename = request.getParameter(PARAM_NAME_CLIENT_MIDDLENAME);
        String lastname = request.getParameter(PARAM_NAME_CLIENT_LASTNAME);
        String clientContacts = request.getParameter(PARAM_NAME_CLIENT_CONTACTS);
        String companyName = request.getParameter(PARAM_NAME_COMPANY_NAME);
        String unp = request.getParameter(PARAM_NAME_COMPANY_UNP);
        String companyNotes = request.getParameter(PARAM_NAME_COMPANY_NOTES);

        // проверка логина и пароля +
        //если такого клиента еще нет в БД, то он создается и записывается в БД
        if (MailLogic.checkEmail(login) && pass.equals(passwordRepeat) && new ClientsEntity().findClient(login) == null) {

            //TODO Для отладки
            System.out.println("\n" + "e-mail = login = " + login + " is validity.");

            //создание нового клиента, если логин(в качестве логина используется e-mail) уникален,
            // и сохранение в БД

            Client newClient = null;
            Company company = null;

            //если компания еще не зарегистрирована в БД, то  создается и сохраняется,
            // иначе используется существующая в БД, заметки добавляются
            if (!new CompaniesEntity().isExistCompanyWithUnp(Long.parseLong(unp))) {
                company = new CompaniesEntity().createCompany(companyName, Long.parseLong(unp), companyNotes);
            } else {
                company = new CompaniesEntity().findByUnp(Long.parseLong(unp));
                company.setNotes(company.getNotes() + "; " + companyNotes);
                new CompaniesEntity().updateCompany(company);
            }

            newClient = new ClientsEntity().createClient(login, pass, name, middlename, lastname, company);


            if (newClient.getContacts().contains(clientContacts)) {
                newClient.setContacts(newClient.getContacts() + "; " + clientContacts);
            } else {
                newClient.setContacts(clientContacts);
            }

            Integer res = new ClientsEntity().updateClient(newClient);

            //TODO для отладки
            System.out.println("Результат обновления newClient = ");

            String fio = newClient.getLastname() + " " + newClient.getName() + " " + newClient.getMiddleName();

            request.setAttribute("clientname", fio);

            request.setAttribute("login", login);

            // определение пути к *.jsp
            page = "/receive_price.jsp";


        } else {
            request.setAttribute("errorLoginPassMessage", "Incorrect login(use your e-mail as login only) or password!");

            //page = ConfigurationManager.getProperty("path.page.login");
            page = "/registration.jsp";

            //TODO Для отладки
            System.out.println("Из блока (Else (логин или пароль нового клиента не прошли валидацию) " +
                    "класса NewClientCommand)" +
                    ": errorLoginPassMessage: " + request.getAttribute("errorLoginPassMessage"));
        }

        //TODO для отладки
        System.out.println("Returns page = " + page);

        return page;
    }


}
