package net.fuzui.StudentInfo.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.fuzui.StudentInfo.pojo.Course;
import net.fuzui.StudentInfo.pojo.CourseGrade;
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
 * @date 2019年4月11日 下午5:22:15
 * 
 */
@Controller
@RequestMapping("/TeacherHandler")

public class TeacherHandler {

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

	// 添加
	@RequestMapping("/addcou")
	public String addCou() {
		return "teacher/addCou";
	}

	@RequestMapping("/sercsc")
	public String sercSC() {
		return "teacher/serchSC";
	}

	/*
	* 
	*/
	@RequestMapping("/queryvita/{tid}")
	public String queryVita(@PathVariable(value = "tid") String tid, Model model) {
		Teacher teacher = new Teacher();
		teacher = teacherService.getByTeaTid(tid);
		model.addAttribute("tid", teacher.getTid());
		model.addAttribute("tname", teacher.getTname());
		model.addAttribute("tpassword", teacher.getTpassword());
		model.addAttribute("tsex", teacher.getTsex());
		model.addAttribute("introduction", teacher.getIntroduction());
		System.out.println(teacher);
		System.out.println(teacher.getTpassword());

		return "teacher/queryVita";
	}

	public void pageIn(Model model, List list) {
		PageInfo page = new PageInfo(list, 5);
		model.addAttribute("pageInfo", page);
	}

	@RequestMapping("/managecou/{tid}/{pn}")
	public String manageCou(@PathVariable(value = "tid") String tid, Model model, HttpSession httpSession,
			@PathVariable(value = "pn") String pn) {
		// Course course = new Course();
		// CoursePlan coursePlan = new CoursePlan();
		int no = Integer.parseInt(pn);
		PageHelper.startPage(no, 5);

		List<CoursePlan> coursePlanList = new ArrayList<CoursePlan>();
		List<Course> couList = new ArrayList<Course>();

		coursePlanList = coursePlanService.getByCoursePlanTid(1, 10, tid);
		pageIn(model, coursePlanList);
		// 通过tid查出cid
		// ------------------此处有bug
		List<CoursePlan> lists = coursePlanService.getCidByCoursePlanTid(1, 3, tid);
		// 通过cid查出课程
		if (lists.size() != 0) {
			couList = courseService.getByCourseCid(1, 10, lists.get(0).getCid());

			httpSession.setAttribute("coursePlanList", coursePlanList);
			httpSession.setAttribute("couList", couList);

			System.out.println(coursePlanList);

			System.out.println(couList);
		}
		return "teacher/manageCourse";
	}

	// 修改
	@RequestMapping("/moditypw/{tid}")
	public ModelAndView teacherModi(@PathVariable(value = "tid") String tid, Model model, HttpServletRequest request) {
		System.out.print(request.getRemoteAddr());
		return new ModelAndView(new RedirectView("../../teacher/modityPw.jsp"));
	}

	@RequestMapping("/moditypassword/{tid}")
	public ModelAndView teacherModiPw(@PathVariable(value = "tid") String tid,
			@RequestParam("tpassword") String tpassword, Model model) {
		if (teacherService.modifyTeacherPwd(tpassword, tid) != 0) {
			return new ModelAndView(new RedirectView("../queryvita/{tid}"));
		} else {
			return new ModelAndView(new RedirectView("../fail.jsp"));
		}

	}

	@RequestMapping(value = "/sercsc/{tid}/{pn}", method = RequestMethod.GET)
	public String sercChoose(@PathVariable("tid") String tid, StuSelectResult ssr, Model model, HttpSession httpSession,
			@PathVariable(value = "pn") String pn) {

		int no = Integer.parseInt(pn);
		PageHelper.startPage(no, 5);

		List<StuExitSelect> sesList = new ArrayList<StuExitSelect>();
		sesList = selectCourseService.getLookByTid(1, 10, tid);
		pageIn(model, sesList);
		httpSession.setAttribute("sesList", sesList);

		return "teacher/serchSC";

	}

	// 查询
	@RequestMapping(value = "/looksel/{cid}/{cname}/{pn}", method = RequestMethod.GET)
	public String lookChoose(@PathVariable("cid") String cid, @PathVariable("cname") String cname, Model model,
			HttpSession httpSession, @PathVariable(value = "pn") String pn, HttpServletRequest request) {

		int no = Integer.parseInt(pn);
		PageHelper.startPage(no, 5);
		List<Student> lookList = new ArrayList<Student>();
		lookList = selectCourseService.getByStuSid(1, 10, cid);
		pageIn(model, lookList);
		httpSession.setAttribute("lookList", lookList);
		model.addAttribute("cname", cname);
		request.setAttribute("cid", cid);
		request.setAttribute("cname", cname);

		return "teacher/printStudent";

	}

	// 结课查询页
	@RequestMapping(value = "/endcou/{cid}/{cname}/{pn}", method = RequestMethod.GET)
	public String endCourse(@PathVariable("cid") String cid, @PathVariable("cname") String cname, Model model,
			HttpSession httpSession, @PathVariable(value = "pn") String pn, HttpServletRequest request) {

		int no = Integer.parseInt(pn);
		PageHelper.startPage(no, 5);
		List<Student> lookList = new ArrayList<Student>();
		lookList = selectCourseService.getByStuSid(1, 10, cid);
		pageIn(model, lookList);
		httpSession.setAttribute("lookList", lookList);
		model.addAttribute("cname", cname);
		request.setAttribute("cid", cid);
		request.setAttribute("cname", cname);

		return "teacher/endCourse";

	}
	
	
	// 结课成绩查询页
		@RequestMapping(value = "/endcougrade/{cid}/{cname}/{pn}", method = RequestMethod.GET)
		public String endCourseGrade(@PathVariable("cid") String cid, @PathVariable("cname") String cname, Model model,
				HttpSession httpSession, @PathVariable(value = "pn") String pn, HttpServletRequest request) {

			int no = Integer.parseInt(pn);
			PageHelper.startPage(no, 5);
			List<CourseGrade> lookList = new ArrayList<CourseGrade>();
			lookList = coursePlanService.getCourseGrade(1, 10, cid);
			pageIn(model, lookList);
			httpSession.setAttribute("lookList1", lookList);
			
			request.setAttribute("cname", cname);

			return "teacher/endCourseGrade";

		}

	// 添加成绩
	@RequestMapping(value = "/addGrade", method = RequestMethod.POST)
	public String addGrade(@RequestParam("cid") String cid, @RequestParam("sid") String sid,
			@RequestParam("grade") Integer grade, Model model, HttpServletRequest request) {


		Grade g = new Grade();
		g.setCid(cid);
		g.setSid(sid);
		g.setGrade(grade);
		
		/**
		 * 根据cid查学分
		 */
		if(grade >= 60) {
			Integer credits = coursePlanService.getCreditsByCid(cid);
			g.setCredits(credits);
		}
		
		gradeService.insertGrade(g);
		
		System.out.println(g.toString());
		return "teacher/endCourse";

	}

}