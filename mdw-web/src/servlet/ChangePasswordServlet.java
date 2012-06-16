/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:27 AM
 * To change this template use File | Settings | File Templates.
 */

package servlet;

import model.User;
import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;
import validation.ValidationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ChangePasswordServlet extends HttpServlet {

    private IBusinessFacade businessFacade;

    public ChangePasswordServlet() {
        super();
        businessFacade = new BusinessFacade();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        try {
            User u = businessFacade.changePassword(id, password1, password2);
            request.getSession().removeAttribute("user");
            request.getSession().setAttribute("user", u);
            request.setAttribute("msg", "Heslo bylo úspěšně změněno.");
        } catch (ValidationException ex) {
            request.setAttribute("error", ex.getMessage());
        } finally {
            request.getRequestDispatcher("/protected/edituser.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

