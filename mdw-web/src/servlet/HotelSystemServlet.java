/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:34 AM
 * To change this template use File | Settings | File Templates.
 */

package servlet;

import model.Coach;
import model.facade.BusinessFacade;
import model.facade.IBusinessFacade;
import rest.converters.hotel.HotelReservation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;


public class HotelSystemServlet extends HttpServlet {

    private IBusinessFacade businessFacade;

    public HotelSystemServlet() {
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
        try {
            String s = request.getParameter("coachId");
            List<HotelReservation> reservations = businessFacade.getAllReservationByHotelSystem();
            request.setAttribute("reservations", reservations);
            if (s != null) {
                Long coachId = Long.parseLong(s);
                HotelReservation chosenReservation = businessFacade.getReservationById(coachId, reservations);
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yyyy");
                List<Coach> coaches = businessFacade.searchCoaches(chosenReservation.getFrom(), chosenReservation.getTo(), sdf.format(chosenReservation.getDepartureTime()));
                if (coaches.isEmpty()) {
                    request.setAttribute("msg", "Nebyly nalezeny žádné blízké spoje.");
                } else {
                    request.setAttribute("coaches", coaches);
                    request.setAttribute("oldCoachId", chosenReservation.getIdCoach());
                }
            }
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
        } finally {
            request.getRequestDispatcher("/admin/hotelsystem.jsp").forward(request, response);
        }
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
            Long oldCoachId = Long.parseLong(request.getParameter("oldCoachId"));
            businessFacade.updateHotelReservation(coachId, oldCoachId);
            request.setAttribute("msg", "Rezervace byla úspěšně změněna.");
            response.sendRedirect("/admin/hotelsystem");
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

