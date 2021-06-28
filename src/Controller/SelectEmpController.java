package Controller;

import Entry.Emp;
import Service.EmpService;
import Service.Impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SelectEmpController" , value = "/manager/safe/selectEmp")
public class SelectEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        EmpService empService = new EmpServiceImpl();
        Emp emp = empService.selectEmp(Integer.valueOf(id));

        HttpSession session = request.getSession();
        session.setAttribute("emp" , emp);
        request.getRequestDispatcher("/updateEmp.jsp").forward(request , response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
