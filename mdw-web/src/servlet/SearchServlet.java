/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:39 AM
 * To change this template use File | Settings | File Templates.
 */


package servlet;


import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SearchServlet extends HttpServlet {

    private IBusinessFacade facade;

    public SearchServlet() {
        facade = new BusinessFacade();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
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
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String departureTime = request.getParameter("departureTime");
        try {
            request.setAttribute("coaches", facade.searchCoaches(from, to, departureTime));
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        }
        request.setAttribute("tmpFrom", from);
        request.setAttribute("tmpTo", to);
        request.setAttribute("tmpDepartureTime", departureTime);
        doGet(request, response);
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

