package org.itstep.prokopchik.cricova.command;

import org.itstep.prokopchik.cricova.logic.MailLogic;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

//import javax.mail.Authenticator;


/**
 * для отправки почты с сайта (прайс продукции) клиенту
 * источник: https://java.net/projects/javamail/pages/Home#Samples
 */
public class SenderCommand implements ActionCommand {

    private static final String PARAM_MAIL_TO = "new_email";
    private static final String PARAM_MY_EMAIL_FLAG = "my_email_flag";

    private static final String MAIL_PASSWORD = "cricova-cricova";
    private static final String MAIL_FROM = "cricova_price@gmail.com";
    private static final String SMTP_HOST = "smtp.gmail.com";
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
        }


        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST);//"smtp.gmail.com"
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
//
//        javax.mail.Session session = javax.mail.Session.getDefaultInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return super.getPasswordAuthentication();
//            }
//        });
//        session.setDebug(MAIL_DEBAG);

//        try {
//            // create a message
//            MimeMessage mimeMessage = new MimeMessage(session);
//
//            mimeMessage.setFrom(new InternetAddress(MAIL_FROM));
//            InternetAddress[] address = {new InternetAddress(mailTo)};
//            mimeMessage.setRecipients(javax.mail.Message.RecipientType.TO, address);
//            mimeMessage.setSubject(MAIL_SUBJECT);
//
//            // create and fill the message part
//            MimeBodyPart mimeBodyPartText = new MimeBodyPart();
//            mimeBodyPartText.setText(MAIL_MESSAGE, "utf8");
//            // create the second message part (file)
//            MimeBodyPart mimeBodyPartFile = new MimeBodyPart();
//            mimeBodyPartFile.attachFile(FILE);
//
//            // create the Multipart and add its parts to it
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(mimeBodyPartText);
//            multipart.addBodyPart(mimeBodyPartFile);
//
//            // add the Multipart to the message
//            mimeMessage.setContent(multipart);
//            // set the Date: header
//            mimeMessage.setSentDate(new Date());
//
//            // send the message
//            Transport.send(mimeMessage);

        request.setAttribute("info", "Прайс отправлен на указанный Вами адрес");
        request.setAttribute("wrongAction", "");
        request.setAttribute("errorLoginPassMessage", "");
        request.setAttribute("nullPage", "");

        page = "/receive_price";

//        } catch (AddressException e) {
//            e.printStackTrace();
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//            Exception ex = null;
//            if ((ex = mex.getNextException()) != null) {
//                ex.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return page;
    }

}
