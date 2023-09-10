package net.fuzui.StudentInfo.pojo;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.pojo
 * @ClassName: StuSelectResult
 * @Description: 选课结果实体类
 * @Author: 王泽
 * @CreateDate: 2019-04-06 16:47
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-06 16:47
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
public class StuSelectResult implements java.io.Serializable{
    /**
     *  序列化
     */
    private static final long serialVersionUID = 1L;
    //学生班级
    private String classr;
    //上课时间
    private String coursetime;
    //上课周
    private String courseweek;
    //课程名称
    private String cname;
    //课程教室
    private String classroom;
    //学分
    private String credits;
    //学时
    private String period;
    //任课教师姓名
    private String tname;

    /**
     *  置取方法
     */
    public String getClassr() {
        return classr;
    }
    public void setClassr(String classr) {
        this.classr = classr;
    }
    public String getCoursetime() {
        return coursetime;
    }
    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime;
    }
    public String getCourseweek() {
        return courseweek;
    }
    public void setCourseweek(String courseweek) {
        this.courseweek = courseweek;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getClassroom() {
        return classroom;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
    public String getCredits() {
        return credits;
    }
    public void setCredits(String credits) {
        this.credits = credits;
    }
    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }
    public String getTname() {
        return tname;
    }
    public void setTname(String tname) {
        this.tname = tname;
    }


}

