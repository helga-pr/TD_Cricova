package org.itstep.prokopchik.cricova.servlets;

import org.itstep.prokopchik.cricova.Wine;
import org.itstep.prokopchik.cricova.command.factory.SessionRequestContent;
import org.itstep.prokopchik.cricova.database.dao.wine.WinesEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/showImageController"}, name = "showImageController")
public class ServletShowImageController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String PARAM_NAME_WINE_ID = "id";

    private static final String SESSION_ATTR_WINES_PRICE = "winesPriceSessionAttr";

    private String encoding;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletShowImageController() {
        super();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO Для отладки
        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "Class = " + getClass());

        System.out.println("start doPost => ");

        processRequest(request, response);

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO Для отладки
        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                "Class = " + getClass());

        System.out.println("start doGet => ");

        processRequest(request, response);
    }

    //********

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        /**
         * для установления кодировки получаемых из веб-форм параметров
         */
        if (encoding != null) {
            try {
                request.setCharacterEncoding(encoding);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

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

 /*       //HashMap для записи аттрибутов сессии пользователя и аттрибутов запроса
        HashMap<String, Object> forRequestAttribute = new HashMap<String, Object>();
        HashMap<String, Object> forSessionAttr = content.getSessionAttributes();
*/
        response.setContentType("image/jpeg");

        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Integer id = Integer.valueOf(content.getRequestParameters().get(PARAM_NAME_WINE_ID)[0]);

            Wine wine = new WinesEntity().findWineById(id);

            Blob image = (Blob) wine.getImage();
            InputStream inputStream = image.getBinaryStream();
            int length;
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.flush();

            //TODO Для отладки
            System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss ").format(new Date()) +
                    "Class = " + getClass());

            System.out.println("image  => " + wine.getName() + " with length = " + image.length());


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

