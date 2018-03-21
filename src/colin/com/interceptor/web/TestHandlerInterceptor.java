package colin.com.interceptor.web;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("拦截====================");
		HandlerMethod hm=(HandlerMethod)handler;
		System.out.println(hm.getBean());
		System.out.println(hm.getMethod().getName());
		System.out.println(hm.getMethodParameters().toString());
		System.out.println(hm.getReturnType());
		System.out.println(hm.getBean());
		System.out.println(handler);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO 自动生成的方法存根
		
		System.out.println("postHandle========================="+modelAndView.getModel());
		modelAndView.addObject("tests", "测试完");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("afterCompletion===================================");
	}

	

	
}
