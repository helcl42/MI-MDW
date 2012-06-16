/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:31 AM
 * To change this template use File | Settings | File Templates.
 */

package servlet;

import model.User;
import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteReservationServlet extends HttpServlet {

    private IBusinessFacade facade;

    public DeleteReservationServlet() {
        facade = new BusinessFacade();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long resId = Long.parseLong(request.getParameter("resId"));
        facade.deleteReservation(resId);
        User u = (User) request.getSession().getAttribute("user");
        facade.refreshSession(request, u.getUsername());
        response.sendRedirect("/customer/reservations");
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

