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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
@RequestMapping("/LoginHandler")
public class LoginHandler {
    @Autowired
    AdminService adminServiceImpl;
    @Autowired
	StudentService studentService;
    @Autowired
	TeacherService teacherService;
    
  //管理员登录

    @RequestMapping("/adminlogin")
    public String loginStudent(@RequestParam("aname") String aname, @RequestParam("apassword") String apassword,
                               Model model, HttpSession httpSession) {
        String n = null;
        n = adminServiceImpl.queryByNamePwd(aname,apassword);

        if (n != null && !"".equals(n)) {
            httpSession.setAttribute("aname", aname);
            return "admin/adminFace";
        } else {
            return "login";
        }

    }

    // 管理员退出登录
    @RequestMapping("/adminlogout")
    public ModelAndView adminLogout(HttpSession httpSession) {
        httpSession.removeAttribute("aname");
        httpSession.removeAttribute("couList");
        return new ModelAndView(new RedirectView("/StudentInfo/index.jsp"));
    }
    
    
 // 学生登录
 	@RequestMapping("/studentlogin")
 	public ModelAndView loginStudent(@RequestParam("sid") String sid, @RequestParam("spassword") String spassword,
 			Model model, HttpSession httpSession, HttpServletRequest httpRequest) {

 		Student student = new Student();
 		student = studentService.getByStuSid(sid);
 		if (studentService.queryByNamePwd(sid, spassword) != null) {
 			httpSession.setAttribute("sid", sid);
 			httpSession.setAttribute("sname", student.getSname());
 			return new ModelAndView(new RedirectView("../student/studentFace.jsp"));
 		} else {
 			httpRequest.setAttribute("msg","账号或密码不正确，登录失败!");
 			return new ModelAndView(new RedirectView("../fail.jsp"));
 		}

 	}
 	
 // 学生退出登录
 	@RequestMapping("/studentlogout")
 	public ModelAndView studentLogout(HttpSession httpSession) {

 		httpSession.removeAttribute("sid");
 		httpSession.removeAttribute("sname");
 		httpSession.removeAttribute("courseList");
 		httpSession.removeAttribute("ssrList");
 		httpSession.removeAttribute("sesList");
 		return new ModelAndView(new RedirectView("/StudentInfo/index.jsp"));
 	}
    
 	
 	
 // 教师登录
 	@RequestMapping("/teacherlogin")
 	public ModelAndView loginTeacher(@RequestParam("tid") String tid, @RequestParam("tpassword") String tpassword,
 			Model model, HttpSession httpSession) {

 		if (teacherService.queryByNamePwd(tid, tpassword) != null) {

 			Teacher teacher = new Teacher();
 			teacher = teacherService.getByTeaTid(tid);
 			// model.addAttribute("tid", tid);
 			httpSession.setAttribute("tid", tid);
 			httpSession.setAttribute("tname", teacher.getTname());
 			// httpSession.setAttribute("teachername", teacher.getTname());
 			return new ModelAndView(new RedirectView("../teacher/teacherFace.jsp"));

 		} else {
 			return new ModelAndView(new RedirectView("../fail.jsp"));
 		}

 	}
 	
 // 教师退出登录
 	@RequestMapping("/teacherlogout")
 	public ModelAndView teacherLogout(HttpSession httpSession) {

 		httpSession.removeAttribute("tid");
 		httpSession.removeAttribute("tname");
 		httpSession.removeAttribute("couList");
 		httpSession.removeAttribute("sesList");
 		httpSession.removeAttribute("lookList");

 		return new ModelAndView(new RedirectView("/StudentInfo/index.jsp"));
 	}
}
