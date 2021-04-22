package com.yc.tx.service;

import com.yc.tx.bean.Accounts;
import com.yc.tx.bean.OpRecord;
import com.yc.tx.bean.OpTypes;
import com.yc.tx.dao.AccountsDao;
import com.yc.tx.dao.OpRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-17 16:37
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountsDao accountsDao;

    @Autowired
    private OpRecordDao opRecordDao;

    @Override
    public Integer openAccount(Accounts account, double money) {
        account.setBalance(money);
        int accountid=accountsDao.saveAccount(account);
        OpRecord opRecord=new OpRecord();
        opRecord.setAccountid(2);
        opRecord.setOpmoney(10.0);
        opRecord.setOptype(OpTypes.deposite.getName());
        opRecord.setOptime(new Timestamp(System.currentTimeMillis()));
        opRecord.setTransferid(" ");
        opRecordDao.saveOpRecord(opRecord);
        return accountid;
    }

    @Override
    public Accounts deposite(Accounts account, double money, String optype, String transferid) {
        Accounts a=this.showBalance(account);
        OpRecord opRecord=new OpRecord();
        opRecord.setAccountid(a.getAccountID());
        opRecord.setOpmoney(money);
        opRecord.setOptype(optype);
        opRecord.setOptime(new Timestamp(System.currentTimeMillis()));
        if(transferid==null){
            opRecord.setTransferid(" ");
        }else {
            opRecord.setTransferid(transferid);
        }
        opRecordDao.saveOpRecord(opRecord);
        a.setBalance(a.getBalance()+money);
        accountsDao.updateAccount(a);
        return a;
    }

    @Override
    @Transactional
    public Accounts withraw(Accounts account, double money, String optype, String transferid) {
        Accounts a=this.showBalance(account);
        OpRecord opRecord=new OpRecord();
        opRecord.setAccountid(a.getAccountID());
        opRecord.setOpmoney(money);
        opRecord.setOptype(optype);
        opRecord.setOptime(new Timestamp(System.currentTimeMillis()));
        if(transferid==null){
            opRecord.setTransferid(" ");
        }else {
            opRecord.setTransferid(transferid);
        }
        opRecordDao.saveOpRecord(opRecord);
        a.setBalance(a.getBalance()-money);
        accountsDao.updateAccount(a);
        return a;
    }

    @Override
    public Accounts transfer(Accounts inAccount, Accounts outAccount, double money) {
        String uid= UUID.randomUUID().toString();
        this.deposite(inAccount,money, OpTypes.transfer.getName(),uid);
        Accounts newAccounts=this.withraw(outAccount,money, OpTypes.transfer.getName(),uid);
        return newAccounts;
    }

    @Override
    @Transactional(readOnly = true)
    public Accounts showBalance(Accounts account) {
        return accountsDao.findAccount(account.getAccountID());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OpRecord> findById(Accounts account) {
        return opRecordDao.findByAccountid(account.getAccountID());
    }
}
