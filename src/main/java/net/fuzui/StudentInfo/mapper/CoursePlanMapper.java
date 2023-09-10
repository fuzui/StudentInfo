package net.fuzui.StudentInfo.mapper;

import net.fuzui.StudentInfo.pojo.CourseGrade;
import net.fuzui.StudentInfo.pojo.CoursePlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.mapper
 * @ClassName: CoursePlanMapper
 * @Description: 课程安排数据接口层
 * @Author: 王泽
 * @CreateDate: 2019-04-10 15:22
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-10 15:22
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
public interface CoursePlanMapper {

    /**
     *  添加课程安排
     * @param coursePlan   课程安排信息
     * @return  插入结果 !=0则插入成功
     */
    public int insertCoursePlan(CoursePlan coursePlan);

    /**
     *  根据排课班级名删除课程信息信息
     * @param courseclass   排课班级名
     * @return  删除结果，!=0则删除成功
     */
    public int deleteCoursePlan(String courseclass);

    /**
     *  修改课程信息
     * @param coursePlan   课程安排信息
     * @return  修改结果 !=0则修改成功
     */
    public int modifyCoursePlan(CoursePlan coursePlan);



    //查询全部课程安排，暂无需求
    //public List<CoursePlan> selectCoursePlanBySql(Map<String, Object> data);

    /**
     * 根据排课班级名查询课程安排信息
     * @param data
     * @return  查询结果
     */
    public List<CoursePlan> getByCoursePlanCourseclass(Map<String, Object> data);

    /**
     * 根据教师id查询该教师所安排课程信息
     * @param data
     * @return  查询结果
     */
    public List<CoursePlan> getByCoursePlanTid(Map<String, Object> data);

    /**
     * 根据教师id查询该教师所安排课程的课程编号，以方便查询课程具体信息
     * @param data
     * @return  查询结果
     */
    public List<CoursePlan> getCidByCoursePlanTid(Map<String, Object> data);

    /**
     * 根据课程id查询该课程的上课教师，以方便查询教师具体信息
     * @param data
     * @return  查询结果
     */
    public List<CoursePlan> getTidByCoursePlanCid(Map<String, Object> data);

    /**
     * 根据上课时间、地点、查询课程安排信息，为了ajax查重
     * @param coursetime    上课时间
     * @param courseweek    上课周
     * @param classroom     上课教室
     * @return  查询结果
     */
    public String ajaxGetCoursePlan(@Param("coursetime") String coursetime,@Param("courseweek") String courseweek,@Param("classroom") String classroom);

    /**
     *  	根据课程编号查询该课程，用于查询是否有有安排课程
     * @param cid
     * @return
     */
    public String existsCoursePlan(String cid);
    
    /**
     *  	根据课程编号查询该课程学分
     * @param cid
     * @return
     */
    public Integer getCreditsByCid(String cid);
    

    /**
     * 根据课程id查询该课程的上课教师，以方便查询教师具体信息
     * @param data
     * @return  查询结果
     */
    public List<CourseGrade> getCourseGrade(Map<String, Object> data);

}
