/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/21/12
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */


package business;

import entity.Account;
import entity.Customer;
import entity.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("customer") != null) {
            response.sendRedirect("main.jsp");
            return;
        }
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
        DAO dao = DAO.getInstance();
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");
        String passwordAgain = request.getParameter("passwordagain");

        if (!password.isEmpty() && password.equals(passwordAgain)) {
            Account acc = new Account(0.0);
            dao.saveEntity(acc);
            Customer cust = new Customer(name, surname, username, password, acc.getKey());
            dao.saveEntity(cust);
            acc.setCustomer(cust.getKey());
            dao.saveEntity(acc);

            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("error", "Hesla se musi shodovat!");
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

