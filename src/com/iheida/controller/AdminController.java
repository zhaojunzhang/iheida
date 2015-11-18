package com.iheida.controller;

import java.io.IOException;
import java.util.List;







import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;







/*
 * ����Ա��½

 */
import com.iheida.domin.Admin;
import com.iheida.domin.PageBean;
import com.iheida.domin.User;
import com.iheida.service.AdminService;
import com.iheida.util.JSNOUtil;

@Controller
public class AdminController {
	
   @Qualifier("adminService")
   @Autowired
   private AdminService adminService;


	@RequestMapping("/web/login.act")
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
          
		Admin admin = new Admin();
		admin.setUsername(userName);
		admin.setPassword(password);
		Admin admin1 = adminService.login(admin);

		response.setContentType("text/html");
		if (admin1 != null) {
			
            //��½�ɹ�
			response.getWriter().write("1");
			
		} else {
			//��¼ʧ��
			response.getWriter().write("0");

		
		}

	}
//�����Ϣ
	@RequestMapping("/web/addinfo.act")
	public void addinfo(HttpServletRequest request,
			HttpServletResponse response) {
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
				isSuccess = adminService.addinfo(user);

			}
		
             
			response.getWriter().write(isSuccess.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("����Ա�����Ϣ����");
		}
		

	}

	/**
	 * 
	 * ��ѯ������Ϣ
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/web/Showinfo.act")
	public void Showinfo(HttpServletRequest request,
			HttpServletResponse response) {

		adminService.select();
		pagequery(request, response);
	}

	/*
	 * ����������
	 */
	@RequestMapping(value = "/web/ConditionSelectinfo.act")
	public void ConditionSelectinfo(HttpServletRequest request,
			HttpServletResponse response) {
		// ����û���ѯ�����ֶΣ�ֵ
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=UTF-8");
			String conditionName = request.getParameter("conditionName");
			
			String conditionValue = request.getParameter("conditionValue");
			
			List<User> users = adminService.conditionQuery(conditionName,
					conditionValue);
			String json = JSNOUtil.getJsonFromList(users);
			response.setContentType("application/json;charset=UTF-8");
             
			response.getWriter().write(json);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("���������ҳ���");
		}

	}

	/*
	 * ����ɾ����Ϣ
	 */
	@RequestMapping(value = "/web/DelBacthUserinfo.act")
	public void DelBacthUserinfo(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("ids");
			String[] ids = id.split(",");
			Boolean isSuccess = false;
			if (ids != null) {
				isSuccess = adminService.delBatchCustomer(ids);
			}
			response.getWriter().write(isSuccess.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("����ɾ����Ϣ����");
		}

	}

	/*
	 * ɾ����Ϣ
	 */
	@RequestMapping("/web/DelUserinfo.act")
	public void DelUserinfo(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");

			Boolean isSuccess = false;
			// ��ȡID
			String id = request.getParameter("id");

			// ����ҵ���
			if (id != null) {
				isSuccess = adminService.deleteid(id);
			}

			response.getWriter().write(isSuccess.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ɾ����Ϣ����");
		}

	}

	// ��ҳ��ѯ
	@RequestMapping(value = "/web/pagequery.act")
	public void pagequery(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");

			response.setContentType("text/json;charset=UTF-8");
			int pNum = 1;
			String pNumStr = request.getParameter("pNum");
		

			if (pNumStr != null) {
				pNum = Integer.parseInt(pNumStr);
			}

			PageBean pageBean = adminService.pageQuery(pNum);
			/*List<User> users = pageBean.getUser();
			request.setAttribute("pageBean", pageBean);*/
			String json = JSNOUtil.getJsonFromBean(pageBean);
			response.setContentType("application/json;charset=UTF-8");
		
			response.getWriter().write(json);
			
		} catch (IOException e) {

			e.printStackTrace();
			throw new RuntimeException("��ҳjsno����ת��ʧ��");
		}
	}

	// ��������ID���鿴��Ϣ
	@RequestMapping(value = "/web/selectidinfo.act")
	public void selectidinfo(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=UTF-8");
			String id = request.getParameter("id");
			User user = adminService.findbyid(id);
			String json = JSNOUtil.getJsonFromBean(user);
			response.setContentType("application/json;charset=UTF-8");
			
			response.getWriter().write(json);
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("����ID��ѯ��Ϣ����");
		}

	}

	@RequestMapping(value = "/web/pulishinfo.act")
	public String pulishinfo(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		adminService.updatestate(id);
		/*try {
			response.getWriter().write("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��Ӧǰ̨ʧ��");
		}*/
		return "redirect:/web/Showinfo.act";

	}
	//ȡ����ע
	@RequestMapping(value = "/web/Cancelpulishinfo.act")
	public String Cancelpulishinfo(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		adminService.Cancelupdatestate(id);
		/*try {
			response.getWriter().write("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��Ӧǰ̨ʧ��");
		}*/
		return "redirect:/web/Showinfo.act";

	}
	

}
