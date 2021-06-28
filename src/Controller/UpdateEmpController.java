package Controller;

import Entry.Emp;
import Service.EmpService;
import Service.Impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateEmpController" , value = "/manager/safe/updateEmp")
public class UpdateEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String salary = request.getParameter("salary");
        String age = request.getParameter("age");

        Emp emp = new Emp(Integer.valueOf(id) , name , Double.valueOf(salary) , Integer.valueOf(age));

        EmpService empService = new EmpServiceImpl();
        empService.updateEmp(emp);

        response.sendRedirect(request.getContextPath() + "/manager/safe/showAllEmp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
