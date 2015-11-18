package com.iheida.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iheida.domin.PageBean;
import com.iheida.domin.User;
import com.iheida.service.UserService;
import com.iheida.util.JSNOUtil;

@Controller
public class UserController {
	@Qualifier("userService")
	@Autowired
	private UserService userService;

	// 用户添加信息
	@RequestMapping("/web/useraddinfo.act")
	public void useraddinfo(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取用户输入信息
		String username = request.getParameter("username");
		String student_id = request.getParameter("student_id");
		String event_name = request.getParameter("event_name");
		String community_name = request.getParameter("community_name");
		String event_content = request.getParameter("event_content");
		User user = new User();
		user.setUsername(username);
		user.setStudent_id(student_id);
		user.setEvent_name(event_name);
		user.setCommunity_name(community_name);
		user.setEvent_content(event_content);
		try {
			request.setCharacterEncoding("UTF-8");
			Boolean isSuccess = false;
			if (user != null) {
				isSuccess = userService.addinfo(user);

			}
			// 发送判断信息给客户端
			response.getWriter().write(isSuccess.toString());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("用户添加信息错误");
		}
	}

	// 展现用户已发布信息
	@RequestMapping(value = "/web/userShowinfo.act")
	public void userShowinfo(HttpServletRequest request,
			HttpServletResponse response) {
		// 查询用户信息
		userService.select();
		// 调用分页方法
		userpagequery(request, response);
	}

	/*
	 * 按条件查找
	 */
	@RequestMapping(value = "/web/userConditionSelectinfo.act")
	public void userConditionSelectinfo(HttpServletRequest request,
			HttpServletResponse response) {

		try { // 获得用户查询条件字段，值
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=UTF-8");
			String conditionName = request.getParameter("conditionName");
			String conditionValue = request.getParameter("conditionValue");

			List<User> users = userService.conditionQuery(conditionName,
					conditionValue);
			String json = JSNOUtil.getJsonFromList(users);
			response.setContentType("application/json;charset=UTF-8");

			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("条件查询程序出错");
		}
	}

	// 分页查询
	@RequestMapping(value = "/web/userpagequery.act")
	public void userpagequery(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=UTF-8");
			int pNum = 1;
			String pNumStr = request.getParameter("pNum");
			if (pNumStr != null) {
				pNum = Integer.parseInt(pNumStr);
			}
			PageBean pageBean = userService.pageQuery(pNum);
			int pNum1 = pageBean.getpNum();
			pNum1++;
			pageBean.setpNum(pNum1);
			String json = JSNOUtil.getJsonFromBean(pageBean);
			response.setContentType("application/json;charset=UTF-8");

			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("分页查询出现错误");
		}

		// return new ModelAndView("userShow", "users", users);
	}

	// 根据数据ID来查看信息
	@RequestMapping(value = "/web/userselectidinfo.act")
	public void userselectidinfo(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=UTF-8");
			String id = request.getParameter("id");
			User user = userService.findbyid(id);
			String json = JSNOUtil.getJsonFromBean(user);
			response.setContentType("application/json;charset=UTF-8");

			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("根据ID查询信息出错");
		}
	}

	// 根据学号来查询信息
	@RequestMapping(value = "/web/selectstudent_idinfo.act")
	public void selectstudent_idinfo(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=UTF-8");
			String student_id = request.getParameter("student_id");
			User user = userService.findbystudent_id(student_id);
			String json = JSNOUtil.getJsonFromBean(user);
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("根据ID查询信息出错");
		}
		// return new ModelAndView("details", "user", user);

	}

	// 删除信息
	@RequestMapping("/web/DelinfoByid.act")
	public void DelUserinfo(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");

			Boolean isSuccess = false;
			// 获取ID
			String id = request.getParameter("id");
			// 调用业务层
			if (id != null) {
				isSuccess = userService.deleteuser_id(id);
			}
			response.getWriter().write(isSuccess.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除信息出错");
		}

	}

}
