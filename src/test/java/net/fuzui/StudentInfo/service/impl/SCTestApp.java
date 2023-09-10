package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.pojo.SC;
import net.fuzui.StudentInfo.pojo.StuExitSelect;
import net.fuzui.StudentInfo.pojo.StuSelectResult;
import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.service.SelectCourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service.impl
 * @ClassName: SCTestApp
 * @Description: 选课相关功能测试类
 * @Author: 王泽
 * @CreateDate: 2019-04-10 21:20
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-10 21:20
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
public class SCTestApp {
    @Autowired
    private SelectCourseService selectCourseServiceImpl;


    /**
     * 选课
     */
    @Test
    public void selectCourse(){
        int countIns = selectCourseServiceImpl.selectCourse("0001","201507024125");
        //在后端编写时，此处要进行判断，判断该学生是否已经选过该课程
        if(countIns != 0){
            System.out.println("选课成功");
        }else {
            System.out.println("选课失败");
        }
    }

    /**
     * 判断是否加入过此课程
     */
    @Test
    public void existCourse(){
        String n = null;
        n = selectCourseServiceImpl.existCourse("0002","201507024125");
        if(n != null && !"".equals(n)){
            System.out.println("已经选过该课，不可重复选");
        }else {
            System.out.println("可选！");
        }
    }

    /**
     * 查询全部
     */
    @Test
    public void getAllSC(){
        List<SC> lists = selectCourseServiceImpl.getAllSC(1,3,"201507024131");
        for (SC sc : lists) {
            System.out.println(sc.getId() + "\t" + sc.getCid() + "\t" + sc.getSid());
        }
    }

    /**
     * 根据课程编号查询课程选课信息
     */
    @Test
    public void getSCByCid(){
        List<SC> lists = selectCourseServiceImpl.getSCByCid(1,3,"0001");
        for (SC sc : lists) {
            System.out.println(sc.getId() + "\t" + sc.getCid() + "\t" + sc.getSid());
        }
    }

    /**
     * 根据学号查询本人已选课程，可优化····
     */
    @Test
    public void getSCBySid(){
        List<StuSelectResult> lists = selectCourseServiceImpl.getSCBySid(1,3,"201507024131");
        for (StuSelectResult scResult : lists) {
            System.out.println(scResult.getClassr() + "\t" + scResult.getCoursetime() + "\t" + scResult.getCourseweek()
                    + "\t" + scResult.getCname() + "\t" + scResult.getClassroom() + "\t" + scResult.getCredits()
                    + "\t" + scResult.getPeriod() + "\t" + scResult.getTname());
        }
    }

    /**
     * 根据学号退选（待确定··）
     */
    @Test
    public void getExitBysid(){
        List<StuExitSelect> lists = selectCourseServiceImpl.getExitBysid(1,3,"201507024131");
        for (StuExitSelect scExitResult : lists) {
            System.out.println(scExitResult.getCid() + "\t" + scExitResult.getCname() + "\t" + scExitResult.getSid());
        }
    }

    /**
     * 退选
     */
    @Test
    public void deleteSC(){
        int n = 0;
        n = selectCourseServiceImpl.deleteSC("0001","201507024125");
        if(n != 0) {
            System.out.println("退选成功");
        }else{
            System.out.println("退选失败");
        }
    }

    /**
     * 查看课程已选人数
     */
    @Test
    public void getLookByTid(){
        List<StuExitSelect> lists = selectCourseServiceImpl.getLookByTid(1,3,"0002");
        for (StuExitSelect scExitResult : lists) {
            System.out.println(scExitResult.getCid() + "\t" + scExitResult.getCname() + "\t" + "0002教师" + "\t" + scExitResult.getTotalNum()
                    + "\t" + scExitResult.getStuSum());
        }
    }

    /**
     * 查看课程的学生详细信息
     */
    @Test
    public void getByStuSid(){
        List<Student> lists = selectCourseServiceImpl.getByStuSid(1,3,"0001");
        for (Student student : lists) {
            System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSidcard()
                    + "\t" + student.getSsex() + "\t" + student.getSpassword() + "\t" + student.getSage()
                    + "\t" +  student.getClassr() + "\t" + student.getProfession() + "\t" + student.getCollege());
        }
    }


}
