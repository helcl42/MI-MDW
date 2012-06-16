/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 2:35 AM
 * To change this template use File | Settings | File Templates.
 */

package servlet;

import model.*;
import util.HashUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class InitServlet extends HttpServlet {

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
        String passw = "admin";
        Admin a = new Admin("admin", "admin", "admin", HashUtil.Sha1(passw));
        dao.saveEntities(a);

        Destination d1 = new Destination("Praha", "Česká republika");
        Destination d2 = new Destination("Brno", "Česká republika");
        Destination d3 = new Destination("Ostrava", "Česká republika");
        Destination d4 = new Destination("Vídeň", "Rakousko");
        Destination d5 = new Destination("Berlín", "Německo");
        Destination d6 = new Destination("Paříž", "Francie");
        dao.saveEntities(d1, d2, d3, d4, d5, d6);

        //Praha - Brno
        Route r1 = new Route(145d, 210, d1.getKey(), d2.getKey());
        //Brno - Praha
        Route r2 = new Route(145d, 210, d2.getKey(), d1.getKey());
        //Brno - Ostrava
        Route r3 = new Route(100d, 150, d2.getKey(), d4.getKey());
        //Ostrava - Brno
        Route r4 = new Route(100d, 150, d4.getKey(), d2.getKey());
        //Brno - Ostrava
        Route r5 = new Route(80d, 100, d2.getKey(), d3.getKey());
        //Ostrava - Brno
        Route r6 = new Route(80d, 100, d3.getKey(), d2.getKey());
        //Praha - Berlin
        Route r7 = new Route(700d, 348, d1.getKey(), d5.getKey());
        //Berlin - Praha
        Route r8 = new Route(700d, 348, d5.getKey(), d1.getKey());
        //Praha - Pariz
        Route r9 = new Route(1800d, 1033, d1.getKey(), d6.getKey());
        //Pariz - Praha
        Route r10 = new Route(1800d, 1033, d6.getKey(), d1.getKey());
        dao.saveEntities(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);

        //Praha - Brno, 30 dni, 6 busu denne, prvni v 8 hodin rano, kazdy dalsi po dvou hodinach, doba cesty 2 hodiny, kapacita 60 lidi
        createCoaches(r1, 15, 6, 8, 2, 2, 60);
        //Brno - Praha, 30 dni, 6 busu denne, prvni v 8 hodin rano, kazdy dalsi po dvou hodinach, doba cesty 2 hodiny, kapacita 60 lidi
        createCoaches(r2, 15, 6, 8, 2, 2, 60);
        //Brno - Viden
        createCoaches(r3, 15, 3, 6, 6, 2, 60);
        //Viden - Brno
        createCoaches(r4, 15, 3, 6, 6, 2, 60);
        //Brno - Ostrava
        createCoaches(r5, 15, 4, 7, 4, 3, 60);
        //Ostrava - Brno
        createCoaches(r6, 15, 4, 7, 4, 3, 60);
        //Praha - Berlin
        createCoaches(r7, 15, 2, 6, 12, 5, 60);
        //Praha - Berlin
        createCoaches(r8, 15, 2, 6, 12, 5, 60);
        //Praha - Pariz
        createCoaches(r9, 15, 1, 12, 0, 24, 60);
        //Praha - Pariz
        createCoaches(r10, 15, 1, 12, 0, 24, 60);

        //response.sendRedirect("index.jsp");
        response.sendRedirect("/inicialized.jsp");
    }

    /**
     * Vygeneruje spoje od dnesniho dne.
     *
     * @param r                  pozadovana trasa
     * @param numberOfDays       pocet dni
     * @param numberOfBusesInDay pocet spoju za den
     * @param firstBus           hodina, kdy vyjizdi prvni
     * @param nextAfter          pocet hodin, za jak dlouho vyjede dalsi
     * @param travelTime         doba cesty
     * @param capacity           kapacita spoje
     */
    private void createCoaches(Route r, int numberOfDays, int numberOfBusesInDay, int firstBus, int nextAfter, int travelTime, int capacity) {
        DAO dao = DAO.getInstance();
        Calendar calendar = new GregorianCalendar();
        for (int i = 0; i < numberOfDays; i++) {
            calendar.set(Calendar.HOUR, -12 + firstBus);
            calendar.set(Calendar.MINUTE, 0);
            for (int j = 0; j < numberOfBusesInDay; j++) {
                Calendar cloneCalender = (Calendar) calendar.clone();
                cloneCalender.add(Calendar.HOUR, travelTime);
                Coach c = new Coach(capacity, calendar.getTime(), cloneCalender.getTime(), r.getKey());
                dao.saveEntity(c);
                if (j + 1 != numberOfBusesInDay) {
                    calendar.add(Calendar.HOUR, nextAfter);
                }
            }
            calendar.add(Calendar.DATE, 1);
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

