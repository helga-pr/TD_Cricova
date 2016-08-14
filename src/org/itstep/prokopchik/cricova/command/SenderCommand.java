package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.logic.MailLogic;

import javax.servlet.http.HttpServletRequest;

/**
 * для отправки почты с сайта (прайс продукции) клиенту
 * источник: https://java.net/projects/javamail/pages/Home#Samples
 */
public class SenderCommand implements ActionCommand {

    private static final String PARAM_MAIL_TO = "new_email";
    private static final String PARAM_MY_EMAIL_FLAG = "my_email_flag";

    private static final String MAIL_SUBJECT = "Cricova price for you";
    private static final String FILE = "../web/files/08.04.16_Заявочный лист_с италией+масло+водка+Исп,Фр со скидкой.xls";
    private static final String MAIL_MESSAGE = "Здравствуйте. " +
            "В прикрепленном файле запрошенный Вами прайс нашей продукции. " +
            "Будем рады сотрудничеству с Вами." +
            "С уважением, компания Торговый Дом CRICOVA";
    private static final Boolean MAIL_DEBAG = true;


    //TODO отправка прайса по e-mail
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/receive_price";

        // извлечение из запроса
        String mailTo = request.getParameter(PARAM_MAIL_TO);
        if (!MailLogic.checkEmail(mailTo) || mailTo.isEmpty()) {
            mailTo = PARAM_MY_EMAIL_FLAG;
            //sendSimpleMessage();
        }

        request.setAttribute("info", "Прайс отправлен на указанный Вами адрес");
        request.setAttribute("wrongAction", "");
        request.setAttribute("errorLoginPassMessage", "");
        request.setAttribute("nullPage", "");

        page = "/receive_price";


        return page;
    }

//    public static ClientResponse sendSimpleMessage() {
//
//        Client client = Client.create();
//        client.addFilter(new HTTPBasicAuthFilter("api",
//                "key-2507461864f38cecfea82b7fdaf51b30"));
//        WebResource webResource =
//                client.resource("https://api.mailgun.net/v3/sandboxf5d73537c6154f808d0907635974e846.mailgun.org/messages");
//        MultivaluedMapImpl formData = new MultivaluedMapImpl();
//        formData.add("from", "Mailgun Sandbox <postmaster@sandboxf5d73537c6154f808d0907635974e846.mailgun.org>");
//        formData.add("to", "helga <helga-pr@yandex.ru>");
//        formData.add("subject", "Hello helga");
//        formData.add("text", "Congratulations helga, you just sent an email with Mailgun!  You are truly awesome!  You can see a record of this email in your logs: https://mailgun.com/cp/log .  You can send up to 300 emails/day from this sandbox server.  Next, you should add your own domain so you can send 10,000 emails/month for free.");
//
//        //TODO ошибка в PageAttributes.MediaType.APPLICATION_FORM_URLENCODED
//        //return webResource.type(PageAttributes.MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);
//        return null;
//    }

}
