package com.yc.tx.service;

import com.yc.tx.AppConfig;
import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpTypes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testopenAccount() {
        Integer accountid=accountService.openAccount(new Accounts(),1);
        System.out.println(accountid);
        Assert.assertNotNull(accountid);
    }

    @Test
    public void testdeposite() {
        Accounts a=new Accounts();
        a.setAccountID(1);
        Accounts aa=accountService.deposite(a,100, OpTypes.deposite.getName(),null);
        System.out.println(aa);
    }

    @Test
    public void testwithraw() {
        Accounts a=new Accounts();
        a.setAccountID(1);
        Accounts aa=accountService.withraw(a,99, OpTypes.deposite.getName(),null);
        System.out.println(aa);
    }

    @Test
    public void testtransfer() {
        Accounts out=new Accounts();
        out.setAccountID(2);
        Accounts inA=new Accounts();
        inA.setAccountID(2);
        this.accountService.transfer(inA,out,5);
    }

    @Test
    public void testshowBalance() {
        Accounts a=new Accounts();
        a.setAccountID(1);
        a=this.accountService.showBalance(a);
        System.out.println(a);
    }

    @Test
    public void testfindById() {
    }
}