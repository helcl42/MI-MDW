/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:28 AM
 * To change this template use File | Settings | File Templates.
 */

package servlet;

import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;
import validation.ValidationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CoachServlet extends HttpServlet {

    private IBusinessFacade businessFacade;

    public CoachServlet() {
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
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("coaches", businessFacade.getAllCoaches());
        request.setAttribute("routes", businessFacade.getAllRoutes());
        request.getRequestDispatcher("coach.jsp").forward(request, response);
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
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");
        String route = request.getParameter("route");
        String capacity = request.getParameter("capacity");
        try {
            businessFacade.createCoach(departure, arrival, route, capacity);
        } catch (ValidationException ex) {
            request.setAttribute("error", ex.getMessage());
            request.setAttribute("departure", departure);
            request.setAttribute("arrival", arrival);
            request.setAttribute("route", route);
            request.setAttribute("capacity", capacity);
        } finally {
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

