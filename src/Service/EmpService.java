package Service;

import Entry.Emp;
import Entry.Page;

import java.util.List;

public interface EmpService {
    public List<Emp> showAllEmpByPage(Page page);

    public int deleteEmp(Integer id);

    public int addEmp(Emp emp);

    public int updateEmp(Emp emp);

    public Emp selectEmp(Integer id);
}
