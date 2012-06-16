/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/21/12
 * Time: 2:15 PM
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


public class TopUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("customer") == null) {
            response.sendRedirect("/");
            return;
        }
        RequestDispatcher rd = request.getRequestDispatcher("dobit.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = DAO.getInstance();
        Double money = Double.parseDouble(request.getParameter("money"));
        Customer cust = (Customer) request.getSession().getAttribute("customer");
        Account acc = dao.getEntity(cust.getAccount());
        acc.increaseBalance(money);
        dao.saveEntity(acc);
        response.sendRedirect("main.jsp");
    }


}

