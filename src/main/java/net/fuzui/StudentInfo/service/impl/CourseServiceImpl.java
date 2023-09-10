package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.mapper.CourseMapper;
import net.fuzui.StudentInfo.pojo.Course;
import net.fuzui.StudentInfo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service.impl
 * @ClassName: CourseServiceImpl
 * @Description: 课程service具体实现类
 * @Author: 王泽
 * @CreateDate: 2019-04-10 13:32
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-10 13:32
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    /**
     *  添加课程
     * @param course   课程信息
     * @return  插入结果 !=0则插入成功
     */
    @Override
    public int insertCourse(Course course) {
        return courseMapper.insertCourse(course);
    }

    /**
     *  根据课程编号删除课程信息信息
     * @param cid   课程编号
     * @return  删除结果，!=0则删除成功
     */
    @Override
    public int deleteCourse(String cid) {
        return courseMapper.deleteCourse(cid);
    }

    /**
     *  修改课程信息
     * @param course   课程信息
     * @return  修改结果 !=0则修改成功
     */
    @Override
    public int modifyCourse(Course course) {
        return courseMapper.modifyCourse(course);
    }

    /**
     *  根据课程编号查询出课程实体
     * @param cid
     * @return
     */
    @Override
    public Course getByCouCid(String cid) {
        return courseMapper.getByCouCid(cid);
    }

    /**
     * 查询全部课程，接住sql语句进行分页
     * @param pageNo
     * @param pageSize
     * @return      查询结果
     */
    @Override
    public List<Course> selectCourseBySql(int pageNo, int pageSize) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        return courseMapper.selectCourseBySql(data);
    }

    /**
     * 根据课程编号查询课程信息
     * @param pageNo
     * @param pageSize
     * @return  查询结果
     */
    @Override
    public List<Course> getByCourseCid(int pageNo, int pageSize, String cid) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("cid",cid);
        return courseMapper.getByCourseCid(data);
    }

    /**
     * 根据课程名称查询课程信息
     * @param pageNo
     * @param pageSize
     * @param cname     课程名称
     * @return  查询结果
     */
    @Override
    public List<Course> getByCourseCname(int pageNo, int pageSize, String cname) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("cname",cname);
        return courseMapper.getByCourseCname(data);
    }

    /**
     *  根据学院查询课程信息
     * @param pageNo
     * @param pageSize
     * @param belongcoll    所属学院
     * @return 结果
     */
    @Override
    public List<Course> getByCourseCol(int pageNo, int pageSize, String belongcoll) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("belongcoll",belongcoll);
        return courseMapper.getByCourseCol(data);
    }

    /**
     *  根据课程类型查询课程信息
     * @param pageNo
     * @param pageSize
     * @param type      课程类型
     * @return  结果
     */
    @Override
    public List<Course> getByCourseType(int pageNo, int pageSize, String type) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("type",type);
        return courseMapper.getByCourseType(data);
    }

    /**
     *  ajax验证课程编号是否存在
     * @param cid   课程编号
     * @return  结果
     */
    @Override
    public String ajaxQueryByCid(String cid) {
        return courseMapper.ajaxQueryByCid(cid);
    }
}
