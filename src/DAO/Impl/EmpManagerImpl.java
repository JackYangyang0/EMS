package DAO.Impl;

import DAO.EmpManagerDao;
import DbUtils.DbUtils;
import Entry.empManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpManagerImpl implements EmpManagerDao {
    QueryRunner queryRunner = new QueryRunner();
    @Override
    public empManager select(String username) {
        try {
            empManager empManager = queryRunner.query(DbUtils.getConnection(), "select * from empManager where username=?;", new BeanHandler<empManager>(empManager.class), username);
            return empManager;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
