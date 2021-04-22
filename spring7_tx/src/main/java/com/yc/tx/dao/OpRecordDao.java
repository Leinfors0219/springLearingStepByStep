package com.yc.tx.dao;

import com.yc.tx.bean.OpRecord;

import java.util.List;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-14 21:10
 */
public interface OpRecordDao {
    public void saveOpRecord(OpRecord opRecord);

    public List<OpRecord>findAll();

    public List<OpRecord>findByAccountid(int accountid);
}
