package Service.Impl;

import DAO.EmpManagerDao;
import DAO.Impl.EmpManagerImpl;
import DbUtils.DbUtils;
import Entry.empManager;
import Service.EmpManagerService;

public class EmpManagerServiceImpl implements EmpManagerService {
    private EmpManagerDao empManagerDao = new EmpManagerImpl();
    @Override
    public empManager login(String username, String password) {
        empManager manager = null;
        try {
            DbUtils.begin();
            empManager temp = empManagerDao.select(username);
            if(temp != null){
                if(temp.getPassword().equals(password)){
                    manager = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return manager;
    }
}
