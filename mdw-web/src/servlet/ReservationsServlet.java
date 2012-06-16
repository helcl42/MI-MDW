/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:38 AM
 * To change this template use File | Settings | File Templates.
 */

package servlet;

import model.User;
import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ReservationsServlet extends HttpServlet {

    IBusinessFacade facade;

    public ReservationsServlet() {
        facade = new BusinessFacade();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("reservations", facade.getReservationsByCustomer(user.getUsername()));
        request.setAttribute("usr", facade.getUserById(user.getId().toString()));
        RequestDispatcher rd = request.getRequestDispatcher("/customer/reservations.jsp");
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

