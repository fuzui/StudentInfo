package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service.impl
 * @ClassName: StudentTestApp
 * @Description: service层测试类
 * @Author: 王泽
 * @CreateDate: 2019-04-08 13:49
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-08 13:49
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
public class StudentTestApp {

    @Autowired
    private StudentServiceImpl studentServiceImpl;


    /**
     *
     * 查询全部学生信息测试
     */
    @Test
    // @Transactional //标明此方法需使用事务
    // @Rollback(false) //标明使用完此方法后事务不回滚,true时为回滚
    public void selectTest() {

        List<Student> lists = studentServiceImpl.selectStudentBySql(1, 3);

        for (Student student : lists) {
            System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSidcard()
                    + "\t" + student.getSsex() + "\t" + student.getSpassword() + "\t" + student.getSage()
                    + "\t" +  student.getClassr() + "\t" + student.getProfession() + "\t" + student.getCollege());
        }
    }

    /**
     * 添加学生信息测试
     */
    @Test
    public void insertTest() {
        Student student = new Student();
        student.setSid("201220122016");
        student.setSname("王泽");
        student.setSidcard("140140199612122255");
        student.setSsex("男");
        student.setSpassword("123123");
        student.setSage("22");
        student.setClassr("网络B151");
        student.setProfession("网络工程");
        student.setCollege("计算机学院");
        int countIns = studentServiceImpl.insertStudent(student);
        System.out.println("插入" + countIns);
    }

    /**
     * 根据学号查询学生信息
     */
    @Test
    public void selectStudentBySid(){
        List<Student> lists = studentServiceImpl.getByStudentSid(1,3,"201220122012");
        for (Student student : lists) {
            System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSidcard()
                    + "\t" + student.getSsex() + "\t" + student.getSpassword() + "\t" + student.getSage()
                    + "\t" +  student.getClassr() + "\t" + student.getProfession() + "\t" + student.getCollege());
        }
    }

    /**
     * 根据学院查询学生信息
     */
    @Test
    public void selectStudentByCol(){
        List<Student> lists = studentServiceImpl.getByStudentCol(1,3,"人文学院");
        for (Student student : lists) {
            System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSidcard()
                    + "\t" + student.getSsex() + "\t" + student.getSpassword() + "\t" + student.getSage()
                    + "\t" +  student.getClassr() + "\t" + student.getProfession() + "\t" + student.getCollege());
        }
    }

    /**
     * 根据专业查询学生信息
     */
    @Test
    public void selectStudentByPro(){
        List<Student> lists = studentServiceImpl.getByStudentPro(1,3,"网络工程");
        for (Student student : lists) {
            System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSidcard()
                    + "\t" + student.getSsex() + "\t" + student.getSpassword() + "\t" + student.getSage()
                    + "\t" +  student.getClassr() + "\t" + student.getProfession() + "\t" + student.getCollege());
        }
    }

    /**
     * 根据班级查询学生信息
     */
    @Test
    public void selectStudentByCla(){
        List<Student> lists = studentServiceImpl.getByStudentCla(1,3,"网络B151");
        for (Student student : lists) {
            System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSidcard()
                    + "\t" + student.getSsex() + "\t" + student.getSpassword() + "\t" + student.getSage()
                    + "\t" +  student.getClassr() + "\t" + student.getProfession() + "\t" + student.getCollege());
        }
    }

    /**
     * 根据学号删除学生测试
     */
    @Test
    public void deleteStudentBySid(){

        /**
         * insert into student(sid,sname,sidcard,ssex,spassword,sage,classr,profession,college)
         * 		value ("201508024103", "王五","588056987412012021","女","000000","21" ,"历史B151", "历史", "人文学院");
         */
        int n = 0;
        n = studentServiceImpl.deleteStudent("201508024103");
        System.out.println(n);
        if(n != 0){
            System.out.println("学生"+n+"删除成功！");
        }
    }

    /**
     * 根据学号修改学生信息
     */
    @Test
    public void modifyStudent() {
        Student student1 = new Student();
        student1.setSid("201508024103");
        student1.setSname("张三");
        student1.setSidcard("588056987412012021");
        student1.setSsex("男");
        student1.setSpassword("123123");
        student1.setSage("22");
        student1.setClassr("历史B151");
        student1.setProfession("历史");
        student1.setCollege("人文学院");
        int n = 0;
        n = studentServiceImpl.modifyStudent(student1);
        System.out.println(n);
        if(n != 0){
            System.out.println("修改成功");
            //调用查询
            List<Student> lists = studentServiceImpl.getByStudentSid(1,3,"201508024103");
            for (Student student : lists) {
                System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSidcard()
                        + "\t" + student.getSsex() + "\t" + student.getSpassword() + "\t" + student.getSage()
                        + "\t" +  student.getClassr() + "\t" + student.getProfession() + "\t" + student.getCollege());
            }

        }else {
            System.out.println("修改失败！学生不存在");
        }
    }

    /**
     * 修改学生密码
     */
    @Test
    public void modifyStudentPwd(){
        String spassword = "123456";
        String sid = "201508024103";
        int n = 0;
        n = studentServiceImpl.modifyStudentPwd(spassword,sid);

        if(n != 0){
            System.out.println("修改密码成功");
            //调用查询
            List<Student> lists = studentServiceImpl.getByStudentSid(1,3,"201508024103");
            for (Student student : lists) {
                System.out.println(student.getSid() + "\t" + student.getSpassword());
            }

        }else {
            System.out.println("修改失败！学生不存在");
        }
    }

    /**
     * 根据学号查询出学生实体
     */
    @Test
    public void getByStuSid(){
        Student student = null;
        student = studentServiceImpl.getByStuSid("201508024103");
        System.out.println(student);
        if(student != null && !"".equals(student)) {
            System.out.println("查询成功");
            System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSidcard()
                    + "\t" + student.getSsex() + "\t" + student.getSpassword() + "\t" + student.getSage()
                    + "\t" + student.getClassr() + "\t" + student.getProfession() + "\t" + student.getCollege());
        }else{
            System.out.println("未查询到该学生");
        }
    }

    /**
     * 学生登录设置
     */
    @Test
    public void queryByNamePwd(){
        String n = null;
        n = studentServiceImpl.queryByNamePwd("201508024103","000000");
        if(n != null && !"".equals(n)){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败，密码不正确或学生不存在");
        }
    }

    /**
     * ajax验证学号是否存在
     */
    @Test
    public void ajaxQueryBySid(){
        String n = null;
        n = studentServiceImpl.ajaxQueryBySid("201508024104");
        if(n != null && !"".equals(n)){
            System.out.println("该学号学生已存在！");
        }else {
            System.out.println("学号可注册！");
        }
    }
}
