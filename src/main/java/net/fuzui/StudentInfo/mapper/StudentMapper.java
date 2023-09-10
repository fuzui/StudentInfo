package net.fuzui.StudentInfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import net.fuzui.StudentInfo.pojo.Student;

/**
* @ProjectName: StudentInfo
* @Package: net.fuzui.StudentInfo.mapper
* @ClassName: StudentMapper
* @Description: 学生数据访问层接口
* @Author: 王泽
* @CreateDate: 2019-04-07 22:08
* @UpdateUser: 王泽
* @UpdateDate: 2019-04-07 22:08
* @UpdateRemark: 新建
* @Version: 1.0
 */

public interface StudentMapper {


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
    public int modifyStudentPwd(@Param("spassword") String spassword, @Param("sid") String sid);

    /**
     *  根据学号查询出学生实体
     * @param sid
     * @return
     */
    public Student getByStuSid(String sid);

    /**
     *  学生登录设置
     * @param sid   学号（唯一）
     * @param spassword   密码
     * @return
     */
    public String queryByNamePwd(@Param("sid") String sid, @Param("spassword") String spassword);

    /**
     * 查询全部学生，接住sql语句进行分页
     * @param data
     * @return      查询结果
     */
    public List<Student> selectStudentBySql(Map<String, Object> data);

    /**
     * 根据学号查询学生信息
     * @param data
     * @return  查询结果
     */
    public List<Student> getByStudentSid(Map<String, Object> data);

    /**
     *  根据学院查询学生信息
     * @param data
     * @return 结果
     */
    public List<Student> getByStudentCol(Map<String, Object> data);

    /**
     *  根据专业查询学生信息
     * @param data
     * @return  结果
     */
    public List<Student> getByStudentPro(Map<String, Object> data);

    /**
     *  根据班级查询学生信息
     * @param data
     * @return  结果
     */
    public List<Student> getByStudentCla(Map<String, Object> data);

    /**
     *  ajax验证学号是否存在
     * @param sid   学号
     * @return  结果
     */
    public String ajaxQueryBySid(String sid);


}
