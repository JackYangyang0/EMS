package DAO.Impl;

import DAO.EmpDao;
import DbUtils.DbUtils;
import Entry.Emp;
import Entry.Page;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<Emp> selectAll(Page page) {
        try {
            List<Emp> emp = queryRunner.query(DbUtils.getConnection() , "select * from emp limit ?,?;" , new BeanListHandler<Emp>(Emp.class),page.getStartRows() , page.getPageSize());
            return emp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long selectCount() {
        try {
            long count = queryRunner.query(DbUtils.getConnection() , "select count(*) from emp;" , new ScalarHandler<>());
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        int result = 0;
        try {
            result = queryRunner.update(DbUtils.getConnection(), "delete from emp where id = ?;", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insert(Emp emp) {
        int result = 0;
        try {
            result = queryRunner.update(DbUtils.getConnection() , "insert into emp(name , salary , age) values(? , ? , ?);",emp.getName() , emp.getSalary() , emp.getAge());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Emp emp) {
        try {
            int update = queryRunner.update(DbUtils.getConnection(), "update emp set name=? , salary=? , age=? where id=?;", emp.getName(), emp.getSalary(), emp.getAge() , emp.getId());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Emp select(Integer id) {
        Emp emp = null;
        try {
            emp = queryRunner.query(DbUtils.getConnection(), "select * from emp where id =?;", new BeanHandler<Emp>(Emp.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }
}
