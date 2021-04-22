package com.yc.tx.service;

import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpRecord;

import java.util.List;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-17 16:40
 */
public interface AccountService {
    public Integer openAccount(Accounts account,double money);

    public Accounts deposite(Accounts account,double money,String optype,String transferid);

    public Accounts withraw(Accounts account,double money,String optype,String transferid);

    public Accounts transfer(Accounts inAccount,Accounts outAccount,double money);

    public Accounts showBalance(Accounts account);

    public List<OpRecord> findById(Accounts account);
}
