package com.yc.tx.dao;

import com.yc.tx.bean.Accounts;

import java.util.List;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-14 20:21
 */
public interface AccountsDao {
    public int saveAccount(Accounts accounts);

    public Accounts updateAccount(Accounts accounts);

    public Accounts findAccount(int accountid);

    public List<Accounts> findAll();

    public void delete(int accoutid);
}
