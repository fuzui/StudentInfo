package net.fuzui.StudentInfo.service;

import net.fuzui.StudentInfo.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service
 * @ClassName: StudentService
 * @Description: 学生Service接口类
 * @Author: 王泽
 * @CreateDate: 2019-04-07 22:09
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-07 22:09
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

public interface StudentService {



    /**
     *  添加学生
     * @param student   学生信息
     * @return  插入结果 !=0则插入成功
     */
    public int insertStudent(Student student);

    /**
     *  根据学号删除学生信息
     * @param sid   学号
     * @return  删除结果，!=0则删除成功
     */
    public int deleteStudent(String sid);

    /**
     *  修改学生信息
     * @param student   学生信息
     * @return  修改结果 !=0则修改成功
     */
    public int modifyStudent(Student student);

    /**
     *  修改学生密码
     * @param spassword     修改后的密码
     * @param sid   查询条件学号
     * @return  修改结果 !=0则修改成功
     */
    public int modifyStudentPwd(String spassword, String sid);

    /**
     *  根据学号查询出学生实体
     * @param sid
     * @return
     */
    public Student getByStuSid(String sid);

    /**
     *  学生登录设置
     * @param sid   学号（唯一）
     * @param pwd   密码
     * @return
     */
    public String queryByNamePwd(String sid, String pwd);

    /*
     * sql后加limit实现分页
     * */
    public List<Student> selectStudentBySql(int pageNo, int pageSize);

    /**
     * 根据学号查询学生信息
     * @param pageNo
     * @param pageSize
     * @return  查询结果
     */
    public List<Student> getByStudentSid(int pageNo, int pageSize,String sid);

    /**
     *  根据学院查询学生信息
     * @param pageNo
     * @param pageSize
     * @return 结果
     */
    public List<Student> getByStudentCol(int pageNo, int pageSize,String college);

    /**
     *  根据专业查询学生信息
     * @param pageNo
     * @param pageSize
     * @return  结果
     */
    public List<Student> getByStudentPro(int pageNo, int pageSize,String profession);

    /**
     *  根据班级查询学生信息
     * @param pageNo
     * @param pageSize
     * @return  结果
     */
    public List<Student> getByStudentCla(int pageNo, int pageSize,String classr);

    /**
     *  ajax验证学号是否存在
     * @param sid   学号
     * @return  结果
     */
    public String ajaxQueryBySid(String sid);

}
