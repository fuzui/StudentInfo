package net.fuzui.StudentInfo.service.impl;


import net.fuzui.StudentInfo.pojo.Course;
import net.fuzui.StudentInfo.pojo.CoursePlan;
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
 * @ClassName: CourseTestApp
 * @Description: 课程安排相关功能测试类
 * @Author: 王泽
 * @CreateDate: 2019-04-10 13:44
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-10 13:44
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
public class CoursePlanTestApp {
    @Autowired
    private CoursePlanServiceImpl coursePlanServiceImpl;

    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    /**
     * 添加课程信息测试
     */
    @Test
    // @Transactional //标明此方法需使用事务
    // @Rollback(false) //标明使用完此方法后事务不回滚,true时为回滚
    public void insertTest() {
        CoursePlan coursePlan = new CoursePlan();
        coursePlan.setCourseclass("网络工程1班");
        coursePlan.setCoursetime("34");
        coursePlan.setCourseweek("5");
        coursePlan.setCid("2002");
        coursePlan.setTid("9001");
        coursePlan.setClassroom("10103");
        coursePlan.setCredits("5");
        coursePlan.setPeriod("40");
        coursePlan.setTotalnum("40");

        int countIns = coursePlanServiceImpl.insertCoursePlan(coursePlan);
        System.out.println("插入" + countIns);
    }

    /**
     * 根据开课班级名删除课程安排测试
     */
    @Test
    public void deleteCoursePlanByCourseclass(){


        int n = 0;
        n = coursePlanServiceImpl.deleteCoursePlan("网络工程1班");
        System.out.println(n);
        if(n != 0){
            System.out.println("课程安排"+n+"删除成功！");
        }else {
            System.out.println("该开课班级不存在，删除失败");
        }

    }

    /**
     * 根据课程编号修改课程信息
     */
    @Test
    public void modifyStudent() {
        CoursePlan coursePlan = new CoursePlan();
        coursePlan.setCourseclass("网络工程1班");
        coursePlan.setCoursetime("34");
        coursePlan.setCourseweek("5");
        coursePlan.setCid("2002");
        coursePlan.setTid("9001");
        coursePlan.setClassroom("10103");
        coursePlan.setCredits("4");
        coursePlan.setPeriod("40");
        coursePlan.setTotalnum("40");

        int n = 0;
        n = coursePlanServiceImpl.modifyCoursePlan(coursePlan);
        System.out.println(n);
        if(n != 0){
            System.out.println("修改成功");

        }else {
            System.out.println("修改失败！该课程安排不存在");
        }
    }

    /**
     * 根据排课班级名查询课程安排信息
     */
    @Test
    public void selectCoursePlanByCourseclass(){
        List<CoursePlan> lists = coursePlanServiceImpl.getByCoursePlanCourseclass(1,3,"网络工程1班1");
        for (CoursePlan coursePlan : lists) {
            System.out.println(coursePlan.getCourseclass() + "\t" + coursePlan.getCoursetime() + "\t" + coursePlan.getCourseweek()
                    + "\t" + coursePlan.getCid() + "\t" + coursePlan.getTid() + "\t" + coursePlan.getClassroom()
                    + "\t" + coursePlan.getCredits() + "\t" + coursePlan.getPeriod() + "\t" + coursePlan.getTotalnum());
        }
    }

    /**
     * 根据教师id查询该教师所安排课程信息
     */
    @Test
    public void getByCoursePlanTid(){
        List<CoursePlan> lists = coursePlanServiceImpl.getByCoursePlanTid(1,3,"9001");
        for (CoursePlan coursePlan : lists) {
            System.out.println(coursePlan.getCourseclass() + "\t" + coursePlan.getCoursetime() + "\t" + coursePlan.getCourseweek()
                    + "\t" + coursePlan.getCid() + "\t" + coursePlan.getTid() + "\t" + coursePlan.getClassroom()
                    + "\t" + coursePlan.getCredits() + "\t" + coursePlan.getPeriod() + "\t" + coursePlan.getTotalnum());
        }
    }


    /**
     * ----------------------------------------------相当于嵌套查询，但为了sql语句简单，运用方法调用来实现-----------------------------------------------------
     *
     * 根据教师id查询该教师所安排课程的课程编号，以方便查询课程具体信息，通过课程编号再查出课程详细信息
     * 也就是：教师查询本人所授的课程
     */
    @Test
    public void getCidByCoursePlanTid(){
        List<CoursePlan> lists = coursePlanServiceImpl.getCidByCoursePlanTid(1,3,"9001");


        Course course = new Course();

        for (CoursePlan coursePlan : lists) {
            System.out.println(coursePlan.getCid());
            List<Course> lists1 = courseServiceImpl.getByCourseCid(1,3,coursePlan.getCid());
            //这里只会查出一条记录，所以将这条记录直接复制给course实体。
            course = lists1.get(0);
            System.out.println(course.getCid() + "\t" + course.getCname() + "\t" + course.getCintroduction()
                    + "\t" + course.getType() + "\t" + course.getBelongcoll() + "\t" + course.getBelongpro());

        }
    }

    /**
     * ----------------------------------------------相当于嵌套查询，但为了sql语句简单，运用方法调用来实现-----------------------------------------------------
     * 根据课程id查询该课程的上课教师，以方便查询教师具体信息
     */
    @Test
    public void getTidByCoursePlanCid(){

        List<CoursePlan> lists = coursePlanServiceImpl.getTidByCoursePlanCid(1,3,"2002");

        //这里也只有一条记录，可以去掉for，因为一门课只能有一个老师教授,也可以在新建一个返回为实体的方法，用来查询，因为在课程安排表中，课程编号也必然是唯一的
        //待优化·········
        for (CoursePlan coursePlan : lists) {
            System.out.println(coursePlan.getTid());
            //这里只会查出一条记录，所以将这条记录直接调用返回结果为实体的查询方法。
            Teacher teacher = teacherServiceImpl.getByTeaTid(coursePlan.getTid());


            System.out.println(teacher.getTid() + "\t" + teacher.getTname() + "\t" + teacher.getTpassword() + "\t"
                    + teacher.getTsex() + "\t" + teacher.getIntroduction());

        }
    }

    /**
     * 根据上课时间、地点、查询课程安排信息，为了ajax查重
     */
    @Test
    public void ajaxGetCoursePlan(){

        String n = null;

        n = coursePlanServiceImpl.ajaxGetCoursePlan("34","6","10103");

        if(n != null && !"".equals(n)){
            System.out.println("该时间地点冲突！请重新选择");
        }else{
            System.out.println("该时间地点可用，请尽快安排，以免被抢先");
        }
    }

    /**
     * 根据课程编号查询该课程，用于查询是否有有安排课程
     */
    @Test
    public void existsCoursePlan(){

        String n = null;

        n = coursePlanServiceImpl.existsCoursePlan("2002");

        if(n != null && !"".equals(n)){
            System.out.println("该课程安排已存在！请选择其他课程");
        }else{
            System.out.println("该课程安排不存在");
        }
    }
}
