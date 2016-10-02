package org.itstep.prokopchik.cricova.servlets;

import org.itstep.prokopchik.cricova.command.ActionCommand;
import org.itstep.prokopchik.cricova.command.factory.ActionFactory;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/controller"}, loadOnStartup = 1, name = "controller")
public class ServletController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String encoding;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

    }

    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        encoding = config.getInitParameter("PARAMETER_ENCODING");
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /**
         * для установления кодировки получаемых из веб-форм параметров
         */
        if (encoding != null) {
            request.setCharacterEncoding(encoding);
        }

        String page = null;

        // определение команды, пришедшей из JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        /**
         * вызов метода execute() и передача параметров
         * классу-обработчику конкретной команды
         *  метод возвращает страницу ответа
         */
        page = command.execute(request);

        if (page != null) {
            try {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);

                // вызов страницы ответа на запрос
                dispatcher.forward(request, response);

                //request.getRequestDispatcher(page).forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            // установка страницы c cообщением об ошибке

            // page = ConfigurationManager.getProperty("path.page.index");
            page = "/index.jsp";

            //request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            SessionRequestContent content = new SessionRequestContent();

            //HashMap для записи аттрибутов запроса
            HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();

            forRequestAttribute.put("nullPage", "Page not found. Business logic error");

            content.insertAttributes(request);

            response.sendRedirect(request.getContextPath() + page);
        }

    }


}
