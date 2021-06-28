package Controller;

import Entry.empManager;
import Service.EmpManagerService;
import Service.Impl.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmpManagerLoginController", value = "/manager/empManagerLogin")
public class EmpManagerLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("inputVcode");

        String codes = (String)request.getSession().getAttribute("codes");

        EmpManagerService empManagerService = new EmpManagerServiceImpl();
        empManager empManager = empManagerService.login(username, password);
        if(!codes.isEmpty() && code.equalsIgnoreCase(codes)){
            if(empManager != null){
                HttpSession session = request.getSession();
                session.setAttribute("empManager" , empManager);

                response.sendRedirect(request.getContextPath() + "/manager/safe/showAllEmp");
            }else{
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        }else{
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
