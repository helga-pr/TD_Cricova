package org.itstep.prokopchik.cricova.servlets;

import org.itstep.prokopchik.cricova.command.ActionCommand;
import org.itstep.prokopchik.cricova.command.factory.ActionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/controller"}, loadOnStartup = 1)
public class ServletController extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
        processRequest(request, response);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;

        // определение команды, пришедшей из JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        //  для отладки:
        // System.out.println("processRequest Работает!!!");
        /**
         * вызов метода execute() и передача параметров
         * классу-обработчику конкретной команды
         */
        page = command.execute(request);
        // метод возвращает страницу ответа

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
            request.getSession().setAttribute("nullPage", "Page not found. Business logic error");

            response.sendRedirect(request.getContextPath() + page);
        }

    }

}
