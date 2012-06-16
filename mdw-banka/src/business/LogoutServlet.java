/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/21/12
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */


package business;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("customer") != null) {
            request.getSession().invalidate();
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/");
        }
    }

}

