package com.yc.dao;

import com.yc.tx.AppConfig;
import com.yc.tx.bean.OpRecord;
import com.yc.tx.bean.OpTypes;
import com.yc.tx.dao.OpRecordDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-17 14:57
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestOpRecordDao {
    @Autowired
    private OpRecordDao accountsDao;

    @Test
    public void testSave(){
        OpRecord opRecord=new OpRecord();
        opRecord.setAccountid(1);
        opRecord.setOpmoney(1.0);
        opRecord.setOptype(OpTypes.deposite.getName());
        opRecord.setOptime(new Timestamp(new Date().getTime()));
        opRecord.setTransferid(" ");
        accountsDao.saveOpRecord(opRecord);
    }

    @Test
    public void testAll(){
        List<OpRecord>list=accountsDao.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void testByAccountId(){
        List<OpRecord>list=accountsDao.findByAccountid(1);
        Assert.assertNotEquals(0,list.size());
    }
}
