package net.fuzui.StudentInfo.pojo;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.pojo
 * @ClassName: CoursePlan
 * @Description: 课程安排实体类
 * @Author: 王泽
 * @CreateDate: 2019-04-06 16:28
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-06 16:28
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
public class CoursePlan implements java.io.Serializable {
    /**
     *  序列化
     */
    private static final long serialVersionUID = 1L;
    //开课班级
    private String courseclass;
    //上课时间
    private String coursetime;
    //上课周
    private String courseweek;
    //课程编号
    private String cid;
    //教师编号
    private String tid;
    //上课教室
    private String classroom;
    //学分
    private String credits;
    //学时
    private String period;
    //总人数
    private String totalnum;

    /**
     * 默认构造方法
     */
    public CoursePlan() {

    }

    /**
     *  置取方法
     */
    public String getCourseclass() {
        return courseclass;
    }

    public void setCourseclass(String courseclass) {
        this.courseclass = courseclass;
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

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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

    public String getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(String totalnum) {
        this.totalnum = totalnum;
    }

}

