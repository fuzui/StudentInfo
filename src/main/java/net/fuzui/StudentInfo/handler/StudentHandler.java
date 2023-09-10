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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.fuzui.StudentInfo.pojo.Course;
import net.fuzui.StudentInfo.pojo.CoursePlan;
import net.fuzui.StudentInfo.pojo.Grade;
import net.fuzui.StudentInfo.pojo.StuExitSelect;
import net.fuzui.StudentInfo.pojo.StuSelectResult;
import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.Teacher;
import net.fuzui.StudentInfo.service.CoursePlanService;
import net.fuzui.StudentInfo.service.CourseService;
import net.fuzui.StudentInfo.service.GradeService;
import net.fuzui.StudentInfo.service.SelectCourseService;
import net.fuzui.StudentInfo.service.StudentService;
import net.fuzui.StudentInfo.service.TeacherService;

/**
 * @author fuzui
 * @date 2019年4月11日 下午4:43:46
 * 
 */
@Controller
@RequestMapping("/StudentHandler")
public class StudentHandler {

	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	CoursePlanService coursePlanService;
	@Autowired
	CourseService courseService;
	@Autowired
	SelectCourseService selectCourseService;
	@Autowired
	GradeService gradeService;

	// 查询
	@RequestMapping("/queryvitastu/{sid}")
	public String queryVita(@PathVariable(value = "sid") String sid, Model model) {

		Grade grade = new Grade();
		String credits = gradeService.queryCreditsSum(sid);
		Student student = new Student();
		student = studentService.getByStuSid(sid);
		model.addAttribute("sid", student.getSid());
		model.addAttribute("sname", student.getSname());
		model.addAttribute("sidcard", student.getSidcard());
		model.addAttribute("ssex", student.getSsex());
		model.addAttribute("spassword", student.getSpassword());
		model.addAttribute("sage", student.getSage());
		model.addAttribute("classr", student.getClassr());
		model.addAttribute("profession", student.getProfession());
		model.addAttribute("college", student.getCollege());
		model.addAttribute("credits", credits);

		System.out.println(student);
		System.out.println(student.getSpassword());

		return "student/queryVitaStu";
	}

	// 跳转页面
	@RequestMapping("/moditypwstu/{sid}")
	public ModelAndView teacherModi(@PathVariable(value = "sid") String sid, Model model) {

		return new ModelAndView(new RedirectView("/StudentInfo/student/modityPwStu.jsp"));
	}

	// 修改
	@RequestMapping("/moditypasswordstu/{sid}")
	public ModelAndView teacherModiPw(@PathVariable(value = "sid") String tid,
			@RequestParam("spassword") String spassword, Model model) {
		if (studentService.modifyStudentPwd(spassword, tid) != 0) {
			return new ModelAndView(new RedirectView("../queryvitastu/{sid}"));
		} else {
			return new ModelAndView(new RedirectView("../fail.jsp"));
		}

	}

	public void pageIn(Model model, List list) {
		PageInfo page = new PageInfo(list, 5);
		model.addAttribute("pageInfo", page);
	}

	// 查询
	@RequestMapping(value = "/queryy/{pn}", method = RequestMethod.GET)
	public String redirect(@RequestParam("serc") String serc, @RequestParam("condition") String condition,
			HttpServletRequest request, @PathVariable(value = "pn") String pn, Model model) {
		int no = Integer.parseInt(pn);
		List<Course> courseList = new ArrayList<Course>();
		PageHelper.startPage(no, 5);
		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);

		if (serc.equals("all")) {

			courseList = courseService.selectCourseBySql(1, 10);
			pageIn(model, courseList);
			request.setAttribute("courseList", courseList);
			System.out.println(courseList);
			return "student/selCourse";

		} else if (serc.equals("sid")) {

			courseList = courseService.getByCourseCid(1, 10, condition);
			pageIn(model, courseList);
			request.setAttribute("courseList", courseList);
			System.out.println("sid");

			return "student/selCourse";

		} else if (serc.equals("nam")) {
			courseList = courseService.getByCourseCname(1, 10, condition);
			pageIn(model, courseList);
			request.setAttribute("courseList", courseList);
			System.out.println(courseList);
			System.out.println("cla");
			return "student/selCourse";

		} else if (serc.equals("col")) {
			courseList = courseService.getByCourseCol(1, 10, condition);
			pageIn(model, courseList);
			request.setAttribute("courseList", courseList);
			System.out.println(courseList);
			System.out.println("col");
			return "student/selCourse";

		} else if (serc.equals("type")) {
			courseList = courseService.getByCourseType(1, 10, condition);
			pageIn(model, courseList);
			request.setAttribute("courseList", courseList);
			System.out.println(courseList);
			System.out.println("pro");
			return "student/selCourse";

		} else {

			courseList = courseService.selectCourseBySql(1, 10);
			pageIn(model, courseList);
			request.setAttribute("courseList", courseList);
			System.out.println(courseList);
			return "student/selCourse";

		}

	}

	// 查询,根据cid查询老师
	@RequestMapping(value = "/selcou/{cid}", method = RequestMethod.GET)
	public String selCou(@PathVariable(value = "cid") String cid, Model model) {

		// 代优化
		List<CoursePlan> lists = null;
		lists = coursePlanService.getTidByCoursePlanCid(1, 10, cid);
		System.out.println("------" + lists.size());
		Teacher teacher = new Teacher();
		Course course = new Course();
		if (lists.size() != 0) {
			System.out.println("-----进入选课");
			String tid = lists.get(0).getTid();
			teacher = teacherService.getByTeaTid(tid);
			model.addAttribute("tname", teacher.getTname());
			model.addAttribute("inroduction", teacher.getIntroduction());
			System.out.println(teacher.getIntroduction() + "-----------------------");
			course = courseService.getByCouCid(cid);
			model.addAttribute("cname", course.getCname());
			model.addAttribute("cid", cid);
			return "student/seling";

		} else {
			System.out.println("-----进入无教师选课");
			course = courseService.getByCouCid(cid);
			model.addAttribute("cname", course.getCname());
			model.addAttribute("cid", cid);
			return "student/noseling";
		}

	}

	// 加入课程
	@RequestMapping("/seling")
	public String confirmSelect(@RequestParam("cid") String cid, @RequestParam("sid") String sid, Model model,
			HttpSession httpSession, HttpServletRequest httpRequest) {
		// 判断是否加入过此课程
		if (selectCourseService.existCourse(cid, sid) != null) {
			httpRequest.setAttribute("msg", "已经加入过该课程，不能重复加入!");
			System.out.println("已经加入过该课程，不能重复加入!");
			return "fail";
		}
		if (selectCourseService.selectCourse(cid, sid) != 0) {
			System.out.println(cid);
			System.out.println(sid);
			return "success";
		} else {
			return "fail";
		}

	}

	// 退出
	@RequestMapping("/backseling/{cid}")
	public ModelAndView backConfirmSelect(@PathVariable(value = "cid") String cid) {

		return new ModelAndView(new RedirectView("/StudentInfo/StudentHandler/selqueryy/1"));

	}

	// 跳转页面
	@RequestMapping("/selqueryy/{pn}")
	public String selQueryy(HttpServletRequest request, @PathVariable(value = "pn") String pn, Model model) {
		int no = Integer.parseInt(pn);
		List<Course> courseList = new ArrayList<Course>();
		PageHelper.startPage(no, 5);
		courseList = courseService.selectCourseBySql(1, 10);
		pageIn(model, courseList);
		request.setAttribute("courseList", courseList);
		return "student/selCourse";
	}

	// 学生查询本人选课
	@RequestMapping(value = "/selcouresult/{sid}/{pn}", method = RequestMethod.GET)
	public String selcouresult(@PathVariable("sid") String sid, StuSelectResult ssr, HttpServletRequest request,
			@PathVariable(value = "pn") String pn, Model model) {

		List<StuSelectResult> ssrList = new ArrayList<StuSelectResult>();
		ssrList = selectCourseService.getSCBySid(1, 10, sid);
		pageIn(model, ssrList);
		request.setAttribute("ssrList", ssrList);

		return "student/selectedCourse";

	}

	// 所选课程列表详情-----退选
	@RequestMapping(value = "/exitchoose/{sid}/{pn}", method = RequestMethod.GET)
	public String exitChoose(@PathVariable("sid") String sid, StuSelectResult ssr, HttpServletRequest request,
			@PathVariable(value = "pn") String pn, Model model) {

		List<StuExitSelect> sesList = new ArrayList<StuExitSelect>();
		sesList = selectCourseService.getExitBysid(1, 10, sid);
		pageIn(model, sesList);
		request.setAttribute("sesList", sesList);

		return "student/exitSel";

	}

	// 退选
	@RequestMapping(value = "/exitsel/{cid}/{sid}", method = RequestMethod.GET)
	public ModelAndView exitSel(@PathVariable("cid") String cid, @PathVariable("sid") String sid) {

		if (selectCourseService.deleteSC(cid, sid) != 0) {
			return new ModelAndView(new RedirectView("/StudentInfo/StudentHandler/exitchoose/{sid}/1"));
		} else {
			return new ModelAndView(new RedirectView("../fail.jsp"));
		}

	}

	// 学生查询本人选课
	@RequestMapping(value = "/endcourse/{sid}/{pn}", method = RequestMethod.GET)
	public String endcourse(@PathVariable("sid") String sid, Grade grade, HttpServletRequest request,
			@PathVariable(value = "pn") String pn, Model model) {

		List<Grade> endCourseList = new ArrayList<Grade>();
		endCourseList = gradeService.getEedCourseBySid(1, 10, sid);
		pageIn(model, endCourseList);
		request.setAttribute("endCourseList", endCourseList);

		return "student/endCourse";

	}

}
