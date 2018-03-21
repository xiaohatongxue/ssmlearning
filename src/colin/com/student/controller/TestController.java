package colin.com.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.java.user.bean.User;

import colin.com.student.po.DepartmentExt;
import colin.com.student.service.StudentService;

@Controller
public class TestController {

	@Resource
	private StudentService studentService;

	// ModelAndView String void
	@RequestMapping("/test.htm")
	public String test(Model model) {
		
		return "/add.jsp";
	}

	@RequestMapping("/query.htm")
	public void query(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException {
		String id = req.getParameter("id");
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().println("=================="+id);

	}
	
	@RequestMapping("/insert.htm")
	public String insert(Model model) {
		
		// ModelAndView model = new ModelAndView();
		// service 处理数据
		// 数据存到model
		// model.setViewName("/offer/test.jsp");
		model.addAttribute("list", studentService.selectDepattemntList());
		// studentService.selectDepattemntList().size());
		return "/test.jsp";
	}
	@RequestMapping("/getJson.action")
	public @ResponseBody List<DepartmentExt>  getJson() /**@RequestBody Map<String,String> map*/{
		
		System.out.println("获得Json数据");
		return studentService.selectDepattemntList();
	}

}
