package net.fuzui.StudentInfo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service.impl
 * @ClassName: AdminTestApp
 * @Description: 管理员相关功能测试类
 * @Author: 王泽
 * @CreateDate: 2019-04-09 22:11
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-09 22:11
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = {"classpath:config/spring/applicationContext.xml"}) // 加载配置文件

// -----------
// 如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上
// 这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
// @Transactional
// 这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时
// 指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
// @TransactionConfiguration(transactionManager = "transactionManager",
// defaultRollback = true)
// ------------
public class AdminTestApp {
    @Autowired
    AdminServiceImpl adminServiceImpl;

    /**
     *
     * 管理员登录测试
     */
    @Test
    // @Transactional //标明此方法需使用事务
    // @Rollback(false) //标明使用完此方法后事务不回滚,true时为回滚
    public void queryByNamePwd(){
        String n = null;
        n = adminServiceImpl.queryByNamePwd("admin","admin");
        if(n != null && !"".equals(n)){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败，密码不正确或该管理员不存在");
        }
    }
}
