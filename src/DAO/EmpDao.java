package DAO;

import Entry.Emp;
import Entry.Page;

import java.util.List;

public interface EmpDao {
    public List<Emp> selectAll(Page page);

    public long selectCount();

    public int delete(Integer id);

    public int insert(Emp emp);

    public int update(Emp emp);

    public Emp select(Integer id);
}
