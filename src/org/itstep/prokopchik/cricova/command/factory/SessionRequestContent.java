package org.itstep.prokopchik.cricova.command.factory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

public class SessionRequestContent {

    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;


    // конструкторы

    public SessionRequestContent() {
    }

    // метод извлечения информации из запроса
    public void extractValues(HttpServletRequest request) throws IOException {
        // реализация


    }

    // метод добавления в запрос данных для передачи в jsp
    public void insertAttributes(HttpServletRequest request) {
        // реализация

    }


    // some methods


    /**
     * @return the requestAttributes
     */
    public HashMap<String, Object> getRequestAttributes() {
        return requestAttributes;
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
        return requestParameters;
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
        return sessionAttributes;
    }

    /**
     * @param sessionAttributes the sessionAttributes to set
     */
    public void setSessionAttributes(HashMap<String, Object> sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }
}
