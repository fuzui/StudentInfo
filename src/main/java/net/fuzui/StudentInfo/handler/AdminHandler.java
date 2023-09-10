package net.fuzui.StudentInfo.handler;

import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.Teacher;
import net.fuzui.StudentInfo.service.AdminService;
import net.fuzui.StudentInfo.service.CoursePlanService;
import net.fuzui.StudentInfo.service.CourseService;
import net.fuzui.StudentInfo.service.SelectCourseService;
import net.fuzui.StudentInfo.service.StudentService;
import net.fuzui.StudentInfo.service.TeacherService;
import net.fuzui.StudentInfo.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.handler
 * @ClassName: AdminHandler
 * @Description: admin的handler层（servlet）
 * @Author: 王泽
 * @CreateDate: 2019-04-10 22:50
 * @UpdateUser: 王泽
 * @UpdateDate: 2019-04-10 22:50
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

@Controller
@RequestMapping("/AdminHandler")
//@SessionAttributes("studentList")
//@SessionAttributes("teacherList")
public class AdminHandler {


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


	/**
	 * JavaScript学的不好，目前只能通过这种方式把三级联动下拉列表的val改变为以下值传给数据库。
	 * 
	 */
	String[] arr_belongcoll = {"计算机学院","建筑学院","外国语学院","人文学院"};
	String[][] arr_belongpro = {
                    {"网络工程","软件工程","物联网","信息管理"},
                    {"土木工程","测绘工程","工程造价", "城市规划"},
                    {"英语", "日语", "俄语", "西班牙语"},
                    {"汉语言", "历史", "新闻", "网络新媒体"}
				};
	String[][][] arr_belongcla = {
                {
                    {"网络B151","网络B152","网络B161","网络B162","网络B171","网络B172"},
                    {"软件B151","软件B152","软件B161","软件B162","软件B171","软件B172"},
                    {"物联B151","物联B152","物联B161","物联B162","物联B171","物联B172"},
                    {"信管B151","信管B152","信管B161","信管B162","信管B171","信管B172"}
                    
                },
                {
                    {"土木B151","土木B152","土木B161","土木B162","土木B171","土木B172"},
                    {"测绘B151","测绘B152","测绘B161","测绘B162","测绘B171","测绘B172"},
                    {"造价B151","造价B152","造价B161","造价B162","造价B171","造价B172"},
                    {"规划B151","规划B152","规划B161","规划B162","规划B171","规划B172"}
                    
                },
                {
                    {"英语B151","英语B152","英语B161","英语B162","英语B171","英语B172"},
                    {"日语B151","日语B152","日语B161","日语B162","日语B171","日语B172"},
                    {"俄语B151","俄语B152","俄语B161","俄语B162","俄语B171","俄语B172"},
                    {"牙语B151","牙语B152","牙语B161","牙语B162","牙语B171","牙语B172"}
                    
				},
                {
                    {"汉语B151","汉语B152","汉语B161","汉语B162","汉语B171","汉语B172"},
                    {"历史B151","历史B152","历史B161","历史B162","历史B171","历史B172"},
                    {"新闻B151","新闻B152","新闻B161","新闻B162","新闻B171","新闻B172"},
                    {"网媒B151","网媒B152","网媒B161","网媒B162","网媒B171","网媒B172"}
                    
				}
		};

 // 添加
 	@RequestMapping("/addStudent")
 	public String addStudent(Student student, Model model) {
 		
 		
 		
 		
 		int col = Integer.parseInt(student.getCollege());
 		int pro = Integer.parseInt(student.getProfession());
 		int cla = Integer.parseInt(student.getClassr());
 		//总感觉前端js写的有问题。
 		student.setCollege(arr_belongcoll[pro]);
 		student.setProfession(arr_belongpro[pro][col]);
 		student.setClassr(arr_belongcla[pro][col][cla]);
 		
 		
 		
 		if (studentService.insertStudent(student) != 0) {
 			model.addAttribute("student", student);
 			return "success";
 			// return "admin/addStudent";
 		} else {
 			return "fail";
 		}

 	}
 	//查询全部学生方法
 	public void queryStu(HttpServletRequest request) {
 		List<Student> studentList = new ArrayList<Student>();
 		studentList = studentService.selectStudentBySql(1,10);
 		
 		
 		request.setAttribute("slist", studentList);
 	}

 	public void pageIn(Model model,List list) {
 		PageInfo page = new PageInfo(list, 5);
	 	model.addAttribute("pageInfo", page);
 	}
 	
 	// 查询
 	@RequestMapping(value = "/query/{pn}", method = RequestMethod.GET)
 	public String redirect(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {

 		int no = Integer.parseInt(pn);
// 		System.out.println("-----"+no+"----");
 		List<Student> studentList = new ArrayList<Student>();
 		PageHelper.startPage(no, 5);
 		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);
 		//查询全部
 		if (serc.equals("all")) {
 			
 			
 			
 	 		
 			System.out.println("------------------------------------------------------------------------------------------------");
// 			studentList = studentService.selectStudentBySql(1,10);
// 			//model.addAttribute("studentList", studentList);
// 			request.setAttribute("slist", studentList);
// 			System.out.println("00000"+request.getAttribute("slist"));
// 			System.out.println(studentList);
 			studentList = studentService.selectStudentBySql(1,10);
 			pageIn(model, studentList);
 	 		request.setAttribute("slist", studentList);
 			return "admin/queryStudent";

 		//根据学号查询
 		} else if (serc.equals("sid")) {

 			studentList = studentService.getByStudentSid(1,10,condition);
 			pageIn(model, studentList);
 			request.setAttribute("slist", studentList);
 			System.out.println("sid");

 			return "admin/queryStudent";

 		//根据学院查询
 		} else if (serc.equals("col")) {
 			
 			
 			studentList = studentService.getByStudentCol(1,10,condition);
 			pageIn(model, studentList);
 			request.setAttribute("slist", studentList);
 			System.out.println(studentList);
 			System.out.println("col");
 			return "admin/queryStudent";

 		//根据专业查询
 		} else if (serc.equals("pro")) {
 			studentList = studentService.getByStudentPro(1,10,condition);
 			pageIn(model, studentList);
 			request.setAttribute("slist", studentList);
 			System.out.println(studentList);
 			System.out.println("pro");
 			return "admin/queryStudent";

 		//根据班级查询
 		} else if (serc.equals("cla")) {
 			studentList = studentService.getByStudentCla(1,10,condition);
 			pageIn(model, studentList);
 			//model.addAttribute("studentList", studentList);
 			request.setAttribute("slist", studentList);
// 			System.out.println(studentList);
// 			System.out.println("cla");
 			return "admin/queryStudent";

 		} else {

// 			studentList = studentService.selectStudentBySql(1,10);
// 			model.addAttribute("studentList", studentList);
// 			request.setAttribute("slist", studentList);
// 			System.out.println("00000"+request.getAttribute("slist"));
// 			System.out.println(studentList);
 			studentList = studentService.selectStudentBySql(1,10);
 			pageIn(model, studentList);
 	 		request.setAttribute("slist", studentList);
 			return "admin/queryStudent";

 		}

 	}

 	// 删除学生
 	@RequestMapping(value = "/delete/{sid}", method = RequestMethod.GET)
 	public String deleteStudent(@PathVariable(value = "sid") String sid, Model model) {


 		if (studentService.deleteStudent(sid) != 0) {
 			System.out.println("success");
 			
 			return "success";
 		} else {
 			System.out.println("fail");
 			return "fail";
 		}

 	}

 	// 跳转页面
 	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
 	public String finalPage(HttpServletRequest request) {
 		queryStu(request);
 		return "admin/queryStudent";
 	}

 	// 修改定位
 	@RequestMapping(value = "/moditystu/{sid}", method = RequestMethod.GET)
 	public String editPre(@PathVariable("sid") String sid, HttpServletRequest request) {

 		List<Student> studentList = new ArrayList<Student>();
 		studentList = studentService.getByStudentSid(1,10,sid);
 		
 		request.setAttribute("studentList", studentList);
 		System.out.println("-----进入修改");
 		return "admin/modiStudent";
 	}

 	
 	
 	// 修改
 	@RequestMapping(value = "/moditystud/{sid}", method = RequestMethod.GET)
 	public String update(@PathVariable("sid") String sid, Student student, HttpServletRequest request) {

 		int col = Integer.parseInt(student.getCollege());
 		int pro = Integer.parseInt(student.getProfession());
 		int cla = Integer.parseInt(student.getClassr());
 		//总感觉前端js写的有问题。
 		student.setCollege(arr_belongcoll[pro]);
 		student.setProfession(arr_belongpro[pro][col]);
 		student.setClassr(arr_belongcla[pro][col][cla]);
 		
 		if (studentService.modifyStudent(student) != 0) {
 			System.out.println("----修改成功--------------------------------------------------------------------------------------------------------");
 			return "success";
 		} else {
 			System.out.println("----修改失败----------------------------------------------------------------");
 			return "fail";
 		}
 	}
 	
 	
 	

 	// 跳转页面
 	@RequestMapping("/managestu/{pn}")
 	public String manageStudent(HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		
 		PageHelper.startPage(no, 5);
 		List<Student> studentList = new ArrayList<Student>();
 		studentList = studentService.selectStudentBySql(1,100);
 		pageIn(model, studentList);
 		request.setAttribute("slist", studentList);
 		return "admin/queryStudent";
 	}
 		
 	// 跳转页面
 	@RequestMapping("/managetea/{pn}")
 	public String manageTeacher(HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		List<Teacher> teacherList = new ArrayList<Teacher>();
	 	teacherList = teacherService.selectTeacherBySql(1,10);
	 	pageIn(model, teacherList);
	 	request.setAttribute("teacherList", teacherList);
 		return "admin/queryTeacher";
 	}


 	// 跳转页面
 	@RequestMapping("/addstu")
 	public String adStudent() {
 		return "admin/addStudent";
 	}

 	// 跳转页面
 	@RequestMapping("/addtea")
 	public String adTeacher() {
 		return "admin/addTeacher";
 	}

 	// 跳转页面
 	@RequestMapping("/addcou")
 	public String adCourse() {
 		return "admin/addCourse";
 	}
 	
 // 添加
 	@RequestMapping("/addTeacher")
 	public String addTeacher(Teacher teacher, Model model, HttpSession httpSession) {

 		if (teacherService.insertTeacher(teacher) != 0) {
 			model.addAttribute("teacher", teacher);

 			//---------------------------------待优化-----同样不能实时刷新--------------------------------------------
 			return "success";
 			//return new ModelAndView(new RedirectView("/StudentInfo/TeacherHandler/finalPage"));
 			// return "techer/teacherFace";
 		} else {
 			return "fail";
 			//return new ModelAndView(new RedirectView("fail"));
 		}

 	}

 	
 	/**
 	 * 教师相关
 	 */
 	
 	//查询全部教师方法
 	 	public void queryTea(HttpServletRequest request) {
 	 		List<Teacher> teacherList = new ArrayList<Teacher>();
 	 		teacherList = teacherService.selectTeacherBySql(1,10);
 	 		request.setAttribute("teacherList", teacherList);
 	 	}
 	
 	// 查询
 	@RequestMapping(value = "/queryTea/{pn}", method = RequestMethod.GET)
 	public String redirectTea(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request,
 			@PathVariable(value = "pn") String pn,Model model) {
 		int no = Integer.parseInt(pn);
 		PageHelper.startPage(no, 5);
 		List<Teacher> teacherList = new ArrayList<Teacher>();
 		request.setAttribute("serc", serc);
		request.setAttribute("condition", condition);
 		
 		if (serc.equals("all")) {

 			teacherList = teacherService.selectTeacherBySql(1,10);
 			pageIn(model, teacherList);
 	 		request.setAttribute("teacherList", teacherList);
 			return "admin/queryTeacher";

 		} else if (serc.equals("tid")) {

 			teacherList = teacherService.getByTeacherTid(1,10,condition);
 			pageIn(model, teacherList);
 			request.setAttribute("teacherList", teacherList);
 			System.out.println("tid");

 			return "admin/queryTeacher";

 		} else {

 			teacherList = teacherService.selectTeacherBySql(1,10);
 			pageIn(model, teacherList);
 	 		request.setAttribute("teacherList", teacherList);
 			return "admin/queryTeacher";

 		}

 	}
 	
 	

 	//删除教师
 	@RequestMapping(value = "/deleteTea/{tid}", method = RequestMethod.GET)
 	public String deleteTeacher(@PathVariable(value = "tid") String tid, Model model) {


 		if (teacherService.deleteTeacher(tid) != 0) {
 			System.out.println("success");
 //------------------------代优化，现状：删除后需要手动刷新界面或者重新查询，不能实时刷新。---------------------------------------------------
 			return "success";
 		} else {
 			System.out.println("fail");
 			return "fail";
 			
 		}

 	}

 	@RequestMapping(value = "/finalPageTea", method = RequestMethod.GET)
 	public String finalPageTea(HttpServletRequest request) {
 		queryTea(request);
 		return "admin/queryTeacher";
 	}

 	//修改定位，可优化
 	@RequestMapping(value = "/modityTea/{tid}", method = RequestMethod.GET)
 	public String editPreTea(@PathVariable("tid") String tid, HttpServletRequest request) {

 		List<Teacher> teacherList = new ArrayList<Teacher>();
 		teacherList = teacherService.getByTeacherTid(1,10,tid);
 		//model.addAttribute("teacherList", teacherList);
 		request.setAttribute("teacherList", teacherList);

 		return "admin/modiTeacher";
 	}

 	// 修改
 	@RequestMapping(value = "/modityTeac/{tid}", method = RequestMethod.GET)
 	public String update(@PathVariable("tid") String tid, Teacher teacher, HttpServletRequest request) {

 		if (teacherService.modifyTeacher(teacher) != 0) {
 			return "success";
 		} else {
 			return "fail";
 		}
 	}
    
    
}
