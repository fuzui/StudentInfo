package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.pojo.Course;
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
 * @Description: 课程相关功能测试类
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
public class CourseTestApp {
    @Autowired
    private CourseServiceImpl courseServiceImpl;

    /**
     * 添加课程信息测试
     */
    @Test
    // @Transactional //标明此方法需使用事务
    // @Rollback(false) //标明使用完此方法后事务不回滚,true时为回滚
    public void insertTest() {
        Course course = new Course();
        course.setCid("2001");
        course.setCname("软件工程");
        course.setCintroduction("详细介绍软件设计流程");
        course.setType("必修");
        course.setBelongcoll("计算机学院");
        course.setBelongpro("软件工程");

        int countIns = courseServiceImpl.insertCourse(course);
        System.out.println("插入" + countIns);
    }

    /**
     *
     * 查询全部课程信息测试
     */
    @Test
    public void selectTest() {

        List<Course> lists = courseServiceImpl.selectCourseBySql(1, 5);

        for (Course course : lists) {
            System.out.println(course.getCid() + "\t" + course.getCname() + "\t" + course.getCintroduction()
                    + "\t" + course.getType() + "\t" + course.getBelongcoll() + "\t" + course.getBelongpro());
        }
    }

    /**
     * 根据课程编号查询课程信息
     */
    @Test
    public void selectCourseByCid(){
        List<Course> lists = courseServiceImpl.getByCourseCid(1,3,"2002");
        for (Course course : lists) {
            System.out.println(course.getCid() + "\t" + course.getCname() + "\t" + course.getCintroduction()
                    + "\t" + course.getType() + "\t" + course.getBelongcoll() + "\t" + course.getBelongpro());
        }
    }

    /**
     * 根据所属学院查询课程信息
     */
    @Test
    public void selectCourseByCol(){
        List<Course> lists = courseServiceImpl.getByCourseCol(1,3,"人文学院");
        for (Course course : lists) {
            System.out.println(course.getCid() + "\t" + course.getCname() + "\t" + course.getCintroduction()
                    + "\t" + course.getType() + "\t" + course.getBelongcoll() + "\t" + course.getBelongpro());
        }
    }

    /**
     * 根据课程类型查询课程信息
     */
    @Test
    public void selectStudentByPro(){
        List<Course> lists = courseServiceImpl.getByCourseType(1,3,"必修");
        for (Course course : lists) {
            System.out.println(course.getCid() + "\t" + course.getCname() + "\t" + course.getCintroduction()
                    + "\t" + course.getType() + "\t" + course.getBelongcoll() + "\t" + course.getBelongpro());
        }
    }

    /**
     * 根据课程名称查询课程信息
     */
    @Test
    public void selectCourseByCla(){
        List<Course> lists = courseServiceImpl.getByCourseCname(1,3,"网络工程");
        for (Course course : lists) {
            System.out.println(course.getCid() + "\t" + course.getCname() + "\t" + course.getCintroduction()
                    + "\t" + course.getType() + "\t" + course.getBelongcoll() + "\t" + course.getBelongpro());
        }
    }


    /**
     * 根据课程编号删除课程测试
     */
    @Test
    public void deleteCourseByCid(){


        int n = 0;
        n = courseServiceImpl.deleteCourse("2001");
        System.out.println(n);
        if(n != 0){
            System.out.println("课程"+n+"删除成功！");
        }else {
            System.out.println("该课程不存在，删除失败");
        }

    }

    /**
     * 根据课程编号修改课程信息
     */
    @Test
    public void modifyStudent() {
        Course course1 = new Course();
        course1.setCid("2002");
        course1.setCname("网络工程");
        course1.setCintroduction("网络安全、网络路由配置");
        course1.setType("必修");
        course1.setBelongcoll("计算机学院");
        course1.setBelongpro("网络工程");

        int n = 0;
        n = courseServiceImpl.modifyCourse(course1);
        System.out.println(n);
        if(n != 0){
            System.out.println("修改成功");

        }else {
            System.out.println("修改失败！该课程不存在");
        }
    }
    /**
     * 根据课程编号查询出课程实体
     */
    @Test
    public void getByStuSid(){
        Course course = null;
        course = courseServiceImpl.getByCouCid("2002");
        System.out.println(course);
        if(course != null && !"".equals(course)) {
            System.out.println("查询成功");
            System.out.println(course.getCid() + "\t" + course.getCname() + "\t" + course.getCintroduction()
                    + "\t" + course.getType() + "\t" + course.getBelongcoll() + "\t" + course.getBelongpro());
        }else{
            System.out.println("未查询到该学生");
        }
    }

    /**
     * ajax验证课程编号是否存在
     */
    @Test
    public void ajaxQueryByCid(){
        String n = null;
        n = courseServiceImpl.ajaxQueryByCid("2013");
        if(n != null && !"".equals(n)){
            System.out.println("该课程编号已存在！");
        }else {
            System.out.println("课程编号可注册！");
        }
    }

}
