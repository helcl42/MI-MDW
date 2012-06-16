/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:37 AM
 * To change this template use File | Settings | File Templates.
 */

package servlet;

import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;
import validation.ValidationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationServlet extends HttpServlet {

    private IBusinessFacade businessFacade;

    public RegistrationServlet() {
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
        RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
        rd.forward(request, response);
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

        String username = request.getParameter("username");
        String firstName = request.getParameter("name");
        String lastName = request.getParameter("surname");
        String account = request.getParameter("account");
        String passw1 = request.getParameter("password1");
        String passw2 = request.getParameter("password2");

        try {
            businessFacade.registerCustomer(username, firstName, lastName, account, passw1, passw2);
            response.sendRedirect("index.jsp");
        } catch (ValidationException exp) {
            request.setAttribute("error", exp.getMessage());
            request.setAttribute("tmpUsername", request.getParameter("username"));
            request.setAttribute("tmpName", request.getParameter("name"));
            request.setAttribute("tmpSurname", request.getParameter("surname"));
            request.getRequestDispatcher("registration.jsp").forward(request, response);
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

