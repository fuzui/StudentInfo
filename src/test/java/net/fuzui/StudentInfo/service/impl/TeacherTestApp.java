package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.pojo.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service.impl
 * @ClassName: TeacherTestApp
 * @Description: 教师service测试类
 * @Author: 王泽
 * @CreateDate: 2019-04-09 20:41
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-09 20:41
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
public class TeacherTestApp {

    @Autowired
    private TeacherServiceImpl teacherServiceImpl;


    /**
     *
     * 查询全部教师信息测试
     */
    @Test
    // @Transactional //标明此方法需使用事务
    // @Rollback(false) //标明使用完此方法后事务不回滚,true时为回滚
    public void selectTest() {

        List<Teacher> lists = teacherServiceImpl.selectTeacherBySql(1, 3);

        for (Teacher teacher : lists) {
            System.out.println(teacher.getTid() + "\t" + teacher.getTname() + "\t" + teacher.getTpassword()
                    + "\t" + teacher.getTsex() + "\t" + teacher.getIntroduction());
        }
    }

    /**
     * 添加教师信息测试
     */
    @Test
    public void insertTest() {
        Teacher teacher = new Teacher();
        teacher.setTid("9001");
        teacher.setTname("李浩");
        teacher.setTpassword("111111");
        teacher.setTsex("男");
        teacher.setIntroduction("和蔼、亲近、志同道合");
        int countIns = teacherServiceImpl.insertTeacher(teacher);
        System.out.println("插入" + countIns);
    }

    /**
     * 根据教师编号查询教师信息
     */
    @Test
    public void selectTeacherBySid(){
        List<Teacher> lists = teacherServiceImpl.getByTeacherTid(1,3,"9001");
        for (Teacher teacher : lists) {
            System.out.println(teacher.getTid() + "\t" + teacher.getTname() + "\t" + teacher.getTpassword() + "\t"
                    + teacher.getTsex() + "\t" + teacher.getIntroduction());
        }
    }

    /**
     * 根据教师编号删除教师测试
     */
    @Test
    public void deleteTeacherBySid(){

        /**
         * insert into teacher(tid,tname,tpassword,tsex,introduction)
         * 		value ("9005", "高俅","222222","女","严厉";
         */
        int n = 0;
        n = teacherServiceImpl.deleteTeacher("9005");
        System.out.println(n);
        if(n != 0){
            System.out.println("教师"+n+"删除成功！");
        }
    }

    /**
     * 根据教师编号修改教师信息
     */
    @Test
    public void modifyTeacher() {
        Teacher teacher1 = new Teacher();
        teacher1.setTid("9005");
        teacher1.setTname("李梅");
        teacher1.setTpassword("123123");
        teacher1.setTsex("男");
        teacher1.setIntroduction("严厉！");

        int n = 0;
        n = teacherServiceImpl.modifyTeacher(teacher1);
        System.out.println(n);
        if(n != 0){
            System.out.println("修改成功");
            //调用查询
            List<Teacher> lists = teacherServiceImpl.getByTeacherTid(1,3,"201508024103");
            for (Teacher teacher : lists) {
                System.out.println(teacher.getTid() + "\t" + teacher.getTname() + "\t" + teacher.getTpassword()
                        + "\t" + teacher.getTsex() + "\t" + teacher.getIntroduction());
            }

        }else {
            System.out.println("修改失败！教师不存在");
        }
    }

    /**
     * 修改教师密码
     */
    @Test
    public void modifyTeacherPwd(){
        String tpassword = "654321";
        String tid = "9005";
        int n = 0;
        n = teacherServiceImpl.modifyTeacherPwd(tpassword,tid);

        //调用出现问题不能及时刷新，数据库已修改而查询出来的却是修改之前的，初步判断是延时，打算之后将调用封装在一个方法内
        if(n != 0){
            System.out.println("修改密码成功");
            //调用查询
            List<Teacher> lists = teacherServiceImpl.getByTeacherTid(1,3,"9005");
            for (Teacher teacher : lists) {
                System.out.println(teacher.getTid() + "\t" + teacher.getTpassword());
            }

        }else {
            System.out.println("修改失败！教师不存在");
        }
    }

    /**
     * 根据教师编号查询出教师实体
     */
    @Test
    public void getByTeaTid(){
        Teacher teacher = null;
        teacher = teacherServiceImpl.getByTeaTid("9005");
        System.out.println(teacher);
        if(teacher != null && !"".equals(teacher)){
            System.out.println("查询成功");

                System.out.println(teacher.getTid() + "\t" + teacher.getTname() + "\t" + teacher.getTpassword()
                        + "\t" + teacher.getTsex() + "\t" + teacher.getIntroduction());


        }else {
            System.out.println("查询失败！教师不存在");
        }
    }

    /**
     * 教师登录设置
     */
    @Test
    public void queryByNamePwd(){
        String n = null;
        n = teacherServiceImpl.queryByNamePwd("9001","101111");
        if(n != null && !"".equals(n)){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败，密码不正确或教师不存在");
        }
    }

    /**
     * ajax验证学号是否存在
     */
    @Test
    public void ajaxQueryBySid(){
        String n = null;
        n = teacherServiceImpl.ajaxQueryByTid("9002");
        if(n != null && !"".equals(n)){
            System.out.println("该教师编号已存在！");
        }else {
            System.out.println("教师编号可注册！");
        }
    }

}
