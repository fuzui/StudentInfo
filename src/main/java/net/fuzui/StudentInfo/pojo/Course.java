package net.fuzui.StudentInfo.pojo;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.pojo
 * @ClassName: Course
 * @Description: 课程实体类
 * @Author: 王泽
 * @CreateDate: 2019-04-06 16:34
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-06 16:34
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
public class Course implements java.io.Serializable{
    /**
     *  序列化
     */
    private static final long serialVersionUID = 1L;
    //课程编号
    private String cid;
    //课程名称
    private String cname;
    //课程介绍
    private String cintroduction;
    //类型
    private String type;
    //所属学院
    private String belongcoll;
    //所属专业
    private String belongpro;

    /**
     * 默认构造方法
     */
    public Course() {

    }

    /**
     *  置取方法
     */
    public String getCid() {
        return cid;
    }
    public void setCid(String cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getCintroduction() {
        return cintroduction;
    }
    public void setCintroduction(String cintroduction) {
        this.cintroduction = cintroduction;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getBelongcoll() {
        return belongcoll;
    }
    public void setBelongcoll(String belongcoll) {
        this.belongcoll = belongcoll;
    }
    public String getBelongpro() {
        return belongpro;
    }
    public void setBelongpro(String belongpro) {
        this.belongpro = belongpro;
    }


}

