package com.yc.biz;

import com.yc.dao.StudentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-09 20:37
 */
@Service
public class StudentBizImpl {
    private StudentDao studentDao;

    public StudentBizImpl(StudentDao studentDao) {

        this.studentDao = studentDao;
    }

    public StudentBizImpl() {
    }

    //@Inject//javax中的依赖注入
    //public void setStudentDao(@Named("studentDaoJpaImpl") StudentDao studentDao) {
    //@Autowired//org.springframework
    //@Qualifier("studentDaoJpaImpl")
    @Resource(name = "studentDaoMybatisImpl")
    public void setStudentDao(StudentDao studentDao) {

        this.studentDao = studentDao;
    }

    public int add(String name){
        System.out.println("=============业务层=============");
        System.out.println("用户名是否重名");
        int result=studentDao.add(name);
        System.out.println("===========业务操作结束===========");
        return result;
    }

    public void update(String name){
        System.out.println("=============业务层=============");
        System.out.println("用户名是否重名");
        studentDao.update(name);
        System.out.println("===========业务操作结束===========");
    }
}
