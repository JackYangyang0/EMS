package filter;

import Entry.empManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebFilter(filterName = "CheckFilter" , value = "/manager/safe/*")
public class CheckFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        empManager empManager = (empManager)session.getAttribute("empManager");
        if(empManager != null){
            chain.doFilter(request , response);
        }else{
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
