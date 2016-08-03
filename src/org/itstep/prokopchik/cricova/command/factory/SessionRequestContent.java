package org.itstep.prokopchik.cricova.command.factory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class SessionRequestContent {

    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;

    // конструкторы

    public SessionRequestContent() {
        requestAttributes = new HashMap<String, Object>();
        requestParameters = new HashMap<String, String[]>();
        sessionAttributes = new HashMap<String, Object>();

    }

    // метод извлечения информации из запроса
    public void extractParametersValues(HttpServletRequest request) throws IOException {

        request.setCharacterEncoding("utf-8");

        Enumeration parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {

            String paramName = (String) parameterNames.nextElement();
            String[] paramValues = {request.getParameter(paramName)};

            System.out.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    "Class = SessionRequestContent: Method extractParametersValues: " +
                    "\nparamValues количество элеменов = " + paramValues.length +
                    "; " + paramName + " => " + paramValues[0]);

            paramValues[0] = convertingInUtf8(paramValues[0]);

            requestParameters.put(paramName, paramValues);
        }
        //TODO для отладки
        System.out.println(new SimpleDateFormat("\ndd.MM.yyyy hh:mm:ss ").format(new Date()) +
                "Class = SessionRequestContent: Method extractParametersValues: " +
                "\nrequestParameters количество элеменов = " + this.requestParameters.size());

    }

    //если значение параметра внесено на русском языке, то конвертация должна помочь
    // корректно сохранить это значение для дальнейшей работы приложения
    private String convertingInUtf8(String value) {

        try {
            return new String(value.
                    getBytes("ISO-8859-1"), "utf-8");

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
        // }
    }


    // метод добавления в запрос данных для передачи в jsp
    public void insertAttributes(HttpServletRequest request) {

        if (!this.requestAttributes.isEmpty()) {
            for (Map.Entry entry : this.requestAttributes.entrySet()) {
                request.setAttribute((String) entry.getKey(), entry.getValue());
            }
        }
        //TODO для отладки
        System.out.println(new SimpleDateFormat("\ndd.MM.yyyy hh:mm:ss ").format(new Date()) +
                "Class = SessionRequestContent: method insertAttributes: " +
                "\nrequestAttributes количество элеменов = " + this.requestAttributes.size());

    }

    /**
     * метод извлечения аттрибутов сессии из запроса
     * Получение сессии пользователя
     * будет использоваться для сохранения некоторых данных о пользователе
     * при пеходе по страницам приложения
     *
     * @param request
     * @throws IOException
     */
    public void extractSessionAttributeValues(HttpServletRequest request) throws IOException {

        //получение (или создание) сессии пользователя
        HttpSession session = request.getSession();

        //TODO для отладки
        System.out.println(new SimpleDateFormat("dd.MM.yyyy hh:mm:ss ").format(new Date()) +
                "Class = SessionRequestContent: " +
                "\nsession = " + session);

        Enumeration attributeNames = session.getAttributeNames();

        while (attributeNames.hasMoreElements()) {
            String attrName = (String) attributeNames.nextElement();

            Object attrValue = session.getAttribute(attrName);
            this.sessionAttributes.put(attrName, attrValue);

            //TODO для отладки
            System.out.println(new SimpleDateFormat("\ndd.MM.yyyy hh:mm:ss ").format(new Date()) +
                    "Class = SessionRequestContent: Method extractSessionAttributeValues: " +
                    "\nsessionAttributeValues количество элеменов = " + this.sessionAttributes.size() +
                    "\n " + attrName + " => " + attrValue);
        }
    }

    /**
     * метод добавления в запрос данных сессии пользователя для передачи в jsp
     */
    public void insertSessionAttributes(HttpServletRequest request) {

        if (!this.sessionAttributes.isEmpty()) {
            HttpSession session = request.getSession();
            for (Map.Entry entry : this.sessionAttributes.entrySet()) {

                session.setAttribute((String) entry.getKey(), entry.getValue());
            }
        }
        //TODO для отладки
        System.out.println(new SimpleDateFormat("\ndd.MM.yyyy hh:mm:ss ").format(new Date()) +
                "Class = SessionRequestContent: Method insertSessionAttributes: " +
                "\nsessionAttribute количество элеменов = " + this.sessionAttributes.size());

    }

    /**
     * @return the requestAttributes
     */
    public HashMap<String, Object> getRequestAttributes() {
        return this.requestAttributes;
    }

    /**
     * @param requestAttributes the requestAttributes to set
     */
    public void setRequestAttributes(HashMap<String, Object> requestAttributes) {
        this.requestAttributes = requestAttributes;
    }

    /**
     * @return the requestParameters
     */
    public HashMap<String, String[]> getRequestParameters() {

        return this.requestParameters;
    }

    /**
     * @param requestParameters the requestParameters to set
     */
    public void setRequestParameters(HashMap<String, String[]> requestParameters) {
        this.requestParameters = requestParameters;
    }

    /**
     * @return the sessionAttributes
     */
    public HashMap<String, Object> getSessionAttributes() {

        return this.sessionAttributes;
    }

    /**
     * @param sessionAttributes the sessionAttributes to set
     */
    public void setSessionAttributes(HashMap<String, Object> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }
}
