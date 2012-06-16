/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:34 AM
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


public class EditUserServlet extends HttpServlet {

    private IBusinessFacade businessFacade;

    public EditUserServlet() {
        super();
        businessFacade = new BusinessFacade();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("user", businessFacade.getUserById(id));
        request.getRequestDispatcher("/protected/edituser.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String account = request.getParameter("account");
        try {
            User u = businessFacade.updateUser(id, name, surname, account);
            request.getSession().removeAttribute("user");
            request.getSession().setAttribute("user", u);
            request.setAttribute("msg", "Změny byly úspěšně uloženy.");
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

