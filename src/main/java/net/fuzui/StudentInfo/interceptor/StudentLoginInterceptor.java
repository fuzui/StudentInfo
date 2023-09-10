package net.fuzui.StudentInfo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.interceptor
 * @ClassName: StudentLoginInterceptor
 * @Description: 学生登录拦截
 * @Author: 王泽
 * @CreateDate: 2019年4月12日 下午3:51:01
 * @UpdateUser: 王泽
 * @UpdateDate: 2019年4月12日 下午3:51:01
 * @UpdateRemark: 新建
 * @Version: 1.0
 */
public class StudentLoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Object sid = request.getSession().getAttribute("sid");
        if (sid == null) {
            System.out.println("尚未登录，调到登录页面");
            response.sendRedirect("/StudentInfo/index.jsp");
            return false;
        }
        
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");
		
	}

	
	
}
