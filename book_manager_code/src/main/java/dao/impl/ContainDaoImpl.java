package dao.impl;


import dao.ContainDao;
import mapper.ContainMapper;
import model.Contain;
import util.Constants;

import java.util.List;

public class ContainDaoImpl extends BaseDaoImpl<Contain> implements ContainDao {

    public List<Contain> viewContain(Integer book_case_id) {
        StringBuffer query = new StringBuffer("SELECT * \n");
        query.append("FROM " + Constants.CONTAIN_TABLE_NAME + "\n");
        query.append("WHERE  book_case_id = ?");
        List<Contain> list = this.query(query.toString(), new ContainMapper(), book_case_id);
        if (list.size() == 0) {
            System.out.println(11);
            return null;
        } else {
            return list;
        }
    }
}
