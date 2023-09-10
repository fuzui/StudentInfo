package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.mapper.StudentMapper;
import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service.impl
 * @ClassName: StudentServiceImpl
 * @Description: 学生具体服务类
 * @Author: 王泽
 * @CreateDate: 2019-04-07 22:15
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-07 22:15
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

@Service
public class StudentServiceImpl implements StudentService, Serializable {

    @Autowired
    private StudentMapper studentMapper;

    /**
     *  添加学生
     * @param student   学生信息
     * @return  插入结果 !=0则插入成功
     */
    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    /**
     *  根据学号删除学生信息
     * @param sid   学号
     * @return  删除结果，!=0则删除成功
     */
    @Override
    public int deleteStudent(String sid) {
        return studentMapper.deleteStudent(sid);
    }

    /**
     *  修改学生信息
     * @param student   学生信息
     * @return  修改结果 !=0则修改成功
     */
    @Override
    public int modifyStudent(Student student) {
        return studentMapper.modifyStudent(student);
    }

    /**
     *  修改学生密码
     * @param spassword     修改后的密码
     * @param sid   查询条件学号
     * @return  修改结果 !=0则修改成功
     */
    @Override
    public int modifyStudentPwd(String spassword, String sid) {
        return studentMapper.modifyStudentPwd(spassword,sid);
    }

    /**
     *  根据学号查询出学生实体
     * @param sid
     * @return
     */
    @Override
    public Student getByStuSid(String sid) {
        return studentMapper.getByStuSid(sid);
    }

    /**
     *  学生登录设置
     * @param sid   学号（唯一）
     * @param pwd   密码
     * @return
     */
    @Override
    public String queryByNamePwd(String sid, String pwd) {
        return studentMapper.queryByNamePwd(sid,pwd);
    }

    /**
     *  查询全部学生
     * @param pageNo
     * @param pageSize
     * @return  查询结果
     */
    @Override
    public List<Student> selectStudentBySql(int pageNo, int pageSize) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        return studentMapper.selectStudentBySql(data);
    }

    /**
     * 根据学号查询学生信息
     * @param pageNo
     * @param pageSize
     * @return  查询结果
     */
    @Override
    public List<Student> getByStudentSid(int pageNo, int pageSize,String sid) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("sid",sid);
        return studentMapper.getByStudentSid(data);
    }

    /**
     *  根据学院查询学生信息
     * @param pageNo
     * @param pageSize
     * @return 结果
     */
    @Override
    public List<Student> getByStudentCol(int pageNo, int pageSize,String college) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("college",college);
        return studentMapper.getByStudentCol(data);
    }

    /**
     *  根据专业查询学生信息
     * @param pageNo
     * @param pageSize
     * @return  结果
     */
    @Override
    public List<Student> getByStudentPro(int pageNo, int pageSize,String profession) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("profession",profession);
        return studentMapper.getByStudentPro(data);
    }

    /**
     *  根据班级查询学生信息
     * @param pageNo
     * @param pageSize
     * @return  结果
     */
    @Override
    public List<Student> getByStudentCla(int pageNo, int pageSize,String classr) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("classr",classr);
        return studentMapper.getByStudentCla(data);
    }
    /**
     *  ajax验证学号是否存在
     * @param sid   学号
     * @return  结果
     */
    @Override
    public String ajaxQueryBySid(String sid) {
        return studentMapper.ajaxQueryBySid(sid);
    }

}
