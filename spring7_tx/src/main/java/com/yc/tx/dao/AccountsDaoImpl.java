package com.yc.tx.dao;

import com.yc.tx.bean.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-14 20:32
 */
@Repository
public class AccountsDaoImpl implements AccountsDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    @Override
    public int saveAccount(Accounts accounts) {
        String sql="insert into accounts(balance) values(?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
           PreparedStatement ps=connection.prepareStatement(sql,new String[]{"id"});
           ps.setDouble(1,accounts.getBalance());
           return ps;
        },keyHolder);
//        jdbcTemplate.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement ps=connection.prepareStatement(sql,new String[]{"accountis"});
//                ps.setDouble(1,accounts.getBalance());
//                return ps;
//            }
//        },keyHolder);
        return ((BigInteger)keyHolder.getKey()).intValue();
    }

    @Override
    public Accounts updateAccount(Accounts accounts) {
        String sql="update accounts set balance=? where accountid=?";
        this.jdbcTemplate.update(sql,accounts.getBalance(),accounts.getAccountID());
        return accounts;
    }

    @Override
    public Accounts findAccount(int accountid) {
        String sql="select * from accounts where accountid=?";
        return this.jdbcTemplate.queryForObject(sql,
                (resultSet,rowNum)->{
                    Accounts a=new Accounts();
                    a.setAccountID(resultSet.getInt("accountid"));
                    a.setBalance(resultSet.getDouble("balance"));
                    return a;
                },accountid);
    }

    @Override
    public List<Accounts> findAll(){
        String sql="select * from accounts";
        List<Accounts>list=this.jdbcTemplate.query(sql, new RowMapper<Accounts>() {
            @Override
            public Accounts mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Accounts a=new Accounts();
                a.setAccountID(resultSet.getInt("accountid"));
                a.setBalance(resultSet.getDouble("balance"));
                return a;
            }
        });
        return list;
    }

    @Override
    public void delete(int accoutid){
        String sql="delete from accounts where accountid=?";
        this.jdbcTemplate.update(sql,accoutid);
    }
}
