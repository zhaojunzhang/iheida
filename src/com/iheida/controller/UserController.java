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

	// �û������Ϣ
	@RequestMapping("/web/useraddinfo.act")
	public void useraddinfo(HttpServletRequest request,
			HttpServletResponse response) {
		// ��ȡ�û�������Ϣ
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
			// �����ж���Ϣ���ͻ���
			response.getWriter().write(isSuccess.toString());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("�û������Ϣ����");
		}
	}

	// չ���û��ѷ�����Ϣ
	@RequestMapping(value = "/web/userShowinfo.act")
	public void userShowinfo(HttpServletRequest request,
			HttpServletResponse response) {
		// ��ѯ�û���Ϣ
		userService.select();
		// ���÷�ҳ����
		userpagequery(request, response);
	}

	/*
	 * ����������
	 */
	@RequestMapping(value = "/web/userConditionSelectinfo.act")
	public void userConditionSelectinfo(HttpServletRequest request,
			HttpServletResponse response) {

		try { // ����û���ѯ�����ֶΣ�ֵ
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
			throw new RuntimeException("������ѯ�������");
		}
	}

	// ��ҳ��ѯ
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
			throw new RuntimeException("��ҳ��ѯ���ִ���");
		}

		// return new ModelAndView("userShow", "users", users);
	}

	// ��������ID���鿴��Ϣ
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
			throw new RuntimeException("����ID��ѯ��Ϣ����");
		}
	}

	// ����ѧ������ѯ��Ϣ
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
			throw new RuntimeException("����ID��ѯ��Ϣ����");
		}
		// return new ModelAndView("details", "user", user);

	}

	// ɾ����Ϣ
	@RequestMapping("/web/DelinfoByid.act")
	public void DelUserinfo(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");

			Boolean isSuccess = false;
			// ��ȡID
			String id = request.getParameter("id");
			// ����ҵ���
			if (id != null) {
				isSuccess = userService.deleteuser_id(id);
			}
			response.getWriter().write(isSuccess.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ɾ����Ϣ����");
		}

	}

}
