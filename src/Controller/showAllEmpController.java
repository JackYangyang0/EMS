package Controller;

import Entry.Emp;
import Entry.Page;
import Service.EmpService;
import Service.Impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showAllEmpController", value = "/manager/safe/showAllEmp")
public class showAllEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndex = request.getParameter("pageIndex");
        if(pageIndex == null){
            pageIndex = "1";
        }
        Page page = new Page(Integer.valueOf(pageIndex));

        EmpService empService = new EmpServiceImpl();
        List<Emp> emps = empService.showAllEmpByPage(page);

        request.setAttribute("emps" , emps);
        request.setAttribute("page" , page);

        request.getRequestDispatcher("/empList.jsp").forward(request , response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
