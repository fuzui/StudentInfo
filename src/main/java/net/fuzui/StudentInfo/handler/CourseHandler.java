package net.fuzui.StudentInfo.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.fuzui.StudentInfo.pojo.Course;
import net.fuzui.StudentInfo.pojo.Teacher;
import net.fuzui.StudentInfo.service.CourseService;

/**
 * 
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.handler
 * @ClassName: CourseHandler
 * @Description: 课程handler类（servlet）
 * @Author: 王泽
 * @CreateDate: 2019年4月11日 下午4:13:55
 * @UpdateUser: 王泽
 * @UpdateDate: 2019年4月11日 下午4:13:55
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
@Controller
@RequestMapping("/CourseHandler")
@SessionAttributes("courseList")
public class CourseHandler {
	@Autowired
    CourseService courseService;

	// 添加课程
	@RequestMapping("/addCourse")
	public String addCourse(Course course, Model model) {
		

		if (courseService.insertCourse(course) != 0) {
			model.addAttribute("course", course);
			return "success";
		} else {
			return "fail";
		}
	}

	public void pageIn(Model model,List list) {
 		PageInfo page = new PageInfo(list, 5);
	 	model.addAttribute("pageInfo", page);
 	}
	
	public void queryCou(HttpServletRequest request) {
		List<Course> courseList = new ArrayList<Course>();
	 	courseList = courseService.selectCourseBySql(1,10);
	 	request.setAttribute("courseList", courseList);
	}

	// 查询课程
	@RequestMapping(value = "/query/{pn}", method = RequestMethod.GET)
	public String redirect(@RequestParam("serc") String serc, @RequestParam("condition") String condition,
			HttpServletRequest request,@PathVariable(value = "pn") String pn,Model model) {

		int no = Integer.parseInt(pn);
		List<Course> courseList = new ArrayList<Course>();
		PageHelper.startPage(no, 5);
		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);
		
		
		if (serc.equals("all")) {

	
		 	courseList = courseService.selectCourseBySql(1,10);
		 	pageIn(model, courseList);
		 	request.setAttribute("courseList", courseList);
			System.out.println(courseList);
			return "admin/queryCourse";

		} else if (serc.equals("sid")) {

			courseList = courseService.getByCourseCid(1,10,condition);
			pageIn(model, courseList);
			request.setAttribute("courseList", courseList);
			System.out.println("sid");

			return "admin/queryCourse";

		} else if (serc.equals("nam")) {
			courseList = courseService.getByCourseCname(1,10,condition);
			pageIn(model, courseList);
			request.setAttribute("courseList", courseList);
			System.out.println(courseList);
			System.out.println("cla");
			return "admin/queryCourse";

		} else if (serc.equals("col")) {
			courseList = courseService.getByCourseCol(1,10,condition);
			pageIn(model, courseList);
			request.setAttribute("courseList", courseList);
			System.out.println(courseList);
			System.out.println("col");
			return "admin/queryCourse";

		} else if (serc.equals("type")) {
			courseList = courseService.getByCourseType(1,10,condition);
			pageIn(model, courseList);
			request.setAttribute("courseList", courseList);
			System.out.println(courseList);
			System.out.println("pro");
			return "admin/queryCourse";

		} else {

			courseList = courseService.selectCourseBySql(1,10);
		 	pageIn(model, courseList);
		 	request.setAttribute("courseList", courseList);
			return "admin/queryCourse";

		}

	}

	//删除学生
	@RequestMapping(value = "/delete/{cid}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable(value = "cid") String cid, HttpServletRequest request) {


		if (courseService.deleteCourse(cid) != 0) {
			System.out.println("success");
			queryCou(request);
			return "success";
		} else {
			System.out.println("fail");
			return "fail";
		}

	}

	//跳转到queryCourse页面
	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
	public String finalPage(HttpSession httpSession,HttpServletRequest request) {
		Object admin = request.getSession().getAttribute("courseList");
 		System.out.println(admin+"111111111111111111111111111111111111111111111111111111111111111111111111111");
		return "admin/queryCourse";
	}

	/**
	 * 	修改课程定位
	 * @param cid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/moditystu/{cid}", method = RequestMethod.GET)
	public String editPre(@PathVariable("cid") String cid, HttpServletRequest request) {

		
		List<Course> courseList = new ArrayList<Course>();
		courseList = courseService.getByCourseCid(1,10,cid);
		request.setAttribute("courseList", courseList);

		return "admin/modiCourse";
	}

	//修改课程信息
	@RequestMapping(value = "/moditystud/{cid}", method = RequestMethod.GET)
	public String update(@PathVariable("cid") String cid, Course course, Model model) {
		
		if (courseService.modifyCourse(course) != 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	
	//跳转到queryCourse页面
	@RequestMapping("/managecou/{pn}")
	public String manageCourse(HttpServletRequest request,@PathVariable(value = "pn") String pn,Model model) {
		int no = Integer.parseInt(pn);
		List<Course> courseList = new ArrayList<Course>();
		PageHelper.startPage(no, 5);
		courseList = courseService.selectCourseBySql(1,10);
	 	pageIn(model, courseList);
	 	request.setAttribute("courseList", courseList);
		return "admin/queryCourse";
	}
}

