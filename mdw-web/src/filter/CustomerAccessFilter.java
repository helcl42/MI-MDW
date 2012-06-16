/**
 * Created with IntelliJ IDEA.
 * User: lubos
 * Date: 4/20/12
 * Time: 11:11 PM
 * To change this template use File | Settings | File Templates.
 */

package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RoleEnum;
import model.User;


public class CustomerAccessFilter implements Filter {

    private static final boolean debug = false;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured.
    private FilterConfig filterConfig = null;

    public CustomerAccessFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        if (debug) log("CustomerAccessFilter:doFilter()");

        User u = (User) ((HttpServletRequest) request).getSession().getAttribute("user");

        if (u != null) {
            // User is logged in, just continue request.
            if (u.getRole() == RoleEnum.CUSTOMER) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendRedirect("/accessforbidden.jsp");
            }
        } else {
            // Not logged in, show login page. You can eventually show the error page instead.
            ((HttpServletResponse) response).sendRedirect("/login.jsp");
        }


    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("CustomerAccessFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) return ("CustomerAccessFilter()");
        StringBuilder sb = new StringBuilder("CustomerAccessFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        }
        catch(Exception ex) {}
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
