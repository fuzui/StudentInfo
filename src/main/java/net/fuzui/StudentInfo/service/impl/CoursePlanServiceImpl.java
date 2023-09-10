package net.fuzui.StudentInfo.service.impl;

import net.fuzui.StudentInfo.mapper.CoursePlanMapper;
import net.fuzui.StudentInfo.pojo.CourseGrade;
import net.fuzui.StudentInfo.pojo.CoursePlan;
import net.fuzui.StudentInfo.service.CoursePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.service.impl
 * @ClassName: CoursePlanServiceImpl
 * @Description: 课程安排service具体实现类
 * @Author: 王泽
 * @CreateDate: 2019-04-10 16:03
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-10 16:03
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
@Service
public class CoursePlanServiceImpl implements CoursePlanService {

    @Autowired
    private CoursePlanMapper coursePlanMapper;

    /**
     *  添加课程安排
     * @param coursePlan   课程安排信息
     * @return  插入结果 !=0则插入成功
     */
    @Override
    public int insertCoursePlan(CoursePlan coursePlan) {
        return coursePlanMapper.insertCoursePlan(coursePlan);
    }

    /**
     *  根据排课班级名删除课程信息信息
     * @param courseclass   排课班级名
     * @return  删除结果，!=0则删除成功
     */
    @Override
    public int deleteCoursePlan(String courseclass) {
        return coursePlanMapper.deleteCoursePlan(courseclass);
    }

    /**
     *  修改课程信息
     * @param coursePlan   课程安排信息
     * @return  修改结果 !=0则修改成功
     */
    @Override
    public int modifyCoursePlan(CoursePlan coursePlan) {
        return coursePlanMapper.modifyCoursePlan(coursePlan);
    }

    /**
     * 根据排课班级名查询课程安排信息
     * @param pageNo
     * @param pageSize
     * @param courseclass   开课班级名
     * @return  查询结果
     */
    @Override
    public List<CoursePlan> getByCoursePlanCourseclass(int pageNo, int pageSize, String courseclass) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("courseclass",courseclass);
        return coursePlanMapper.getByCoursePlanCourseclass(data);
    }

    /**
     * 根据教师id查询该教师所安排课程信息
     * @param pageNo
     * @param pageSize
     * @param tid   教师id
     * @return  查询结果
     */
    @Override
    public List<CoursePlan> getByCoursePlanTid(int pageNo, int pageSize, String tid) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("tid",tid);
        return coursePlanMapper.getByCoursePlanTid(data);
    }

    /**
     * 根据教师id查询该教师所安排课程的课程编号，以方便查询课程具体信息
     * @param pageNo
     * @param pageSize
     * @param   tid     教师id
     * @return  查询结果
     */
    @Override
    public List<CoursePlan> getCidByCoursePlanTid(int pageNo, int pageSize, String tid) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("tid",tid);
        return coursePlanMapper.getCidByCoursePlanTid(data);
    }

    /**
     * 根据课程id查询该课程的上课教师，以方便查询教师具体信息
     * @param pageNo
     * @param pageSize
     * @param   cid     课程编号
     * @return  查询结果
     */
    @Override
    public List<CoursePlan> getTidByCoursePlanCid(int pageNo, int pageSize, String cid) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("cid",cid);
        return coursePlanMapper.getTidByCoursePlanCid(data);
    }

    /**
     * 根据上课时间、地点、查询课程安排信息，为了ajax查重
     * @param coursetime    上课时间
     * @param courseweek    上课周
     * @param classroom     上课教室
     * @return  查询结果
     */
    @Override
    public String ajaxGetCoursePlan(String coursetime, String courseweek, String classroom) {

        return coursePlanMapper.ajaxGetCoursePlan(coursetime,courseweek,classroom);
    }

    /**
     *  根据课程编号查询该课程，用于查询是否有有安排课程
     * @param cid
     * @return
     */
    @Override
    public String existsCoursePlan(String cid) {
        return coursePlanMapper.existsCoursePlan(cid);
    }
    /**
     *  	根据课程编号查询该课程学分
     * @param cid
     * @return
     */
	@Override
	public Integer getCreditsByCid(String cid) {
		return coursePlanMapper.getCreditsByCid(cid);
	}

	@Override
	public List<CourseGrade> getCourseGrade(int pageNo, int pageSize, String cid) {
		// TODO Auto-generated method stub
		Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("cid",cid);
        return coursePlanMapper.getCourseGrade(data);
	}
}
