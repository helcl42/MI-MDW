/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:29 AM
 * To change this template use File | Settings | File Templates.
 */


package servlet;

import model.Coach;
import model.DAO;
import model.User;
import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CreateReservationServlet extends HttpServlet {


    private IBusinessFacade facade;

    public CreateReservationServlet() {
        super();
        this.facade = new BusinessFacade();
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
        DAO dao = DAO.getInstance();
        Coach c = dao.getEntity(Coach.class, Long.parseLong(request.getParameter("coachId")));
        request.setAttribute("reservedCoach", c);
        RequestDispatcher rd = request.getRequestDispatcher("/customer/createreservation.jsp");
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
        try {
            Long coachId = Long.parseLong(request.getParameter("coachId"));
            User u = (User) request.getSession().getAttribute("user");
            if (facade.createReservation(coachId, u.getUsername())) {
                facade.refreshSession(request, u.getUsername());
                response.sendRedirect("/customer/reservations");
            } else {
                response.sendRedirect("/customer/topupcredit?coachId=" + coachId);
            }
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            doGet(request, response);
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

