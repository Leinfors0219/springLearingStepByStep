package com.yc.dao;

import com.yc.tx.AppConfig;
import com.yc.tx.bean.Accounts;
import com.yc.tx.dao.AccountsDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-14 19:42
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestDao {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AccountsDao accountsDao;

    @Test
    public void testDateSource()throws SQLException{
        Assert.assertNotNull(dataSource);
        try {
            System.out.println(dataSource.getConnection());
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Test
    public void testAccountsDaoImpl(){
        Assert.assertNotNull(accountsDao);
    }

    @Test
    public void testOpenAccounts(){
        Accounts a=new Accounts();
        a.setBalance(10.0);
        int accountid= accountsDao.saveAccount(a);
        System.out.println("开户成功,新开户头ID为"+accountid);
    }
}
