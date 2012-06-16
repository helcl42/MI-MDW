/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:42 AM
 * To change this template use File | Settings | File Templates.
 */


package servlet;

import model.RoleEnum;
import model.User;
import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.SocketTimeoutException;


public class TopUpCreditServlet extends HttpServlet {

    IBusinessFacade facade;

    public TopUpCreditServlet() {
        facade = new BusinessFacade();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("coachId") != null) request.setAttribute("error", "Nedostatečný kredit");
        RequestDispatcher rd = request.getRequestDispatcher("/customer/topupcredit.jsp");
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
        String coachId = request.getParameter("coachId");
        User u = (User) request.getSession().getAttribute("user");
        String credit = request.getParameter("credit");
        try {
            if (u.getRole() == RoleEnum.CUSTOMER) {
                facade.refreshSession(request, facade.topUpCredit(credit, u).getUsername());
            }
            if (coachId != null)
                response.sendRedirect("/customer/createreservation?coachId=" + coachId);
            else
                response.sendRedirect("/customer/reservations");
        } catch (SocketTimeoutException ex) {
            request.setAttribute("error", "Čas pro připojení k bance vypršel. Zkuste to znovu.");
            request.setAttribute("tmpCredit", credit);
            doGet(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.setAttribute("tmpCredit", credit);
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
