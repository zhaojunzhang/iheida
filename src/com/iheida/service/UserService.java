package com.iheida.service;

import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.iheida.dao.UserDAO;
import com.iheida.domin.PageBean;
import com.iheida.domin.User;

@Service("userService")
public class UserService {
	@Qualifier("userDAO")
	@Autowired
	private UserDAO userDAO;
	
	public static final int NUMPERPAGE=10;
	  
	  //��ѯ���е�����
		public List<User> select() {
			
			
			return userDAO.findAll();
		}
		
		

		//��������ѯ
		public List<User> conditionQuery(String conditionName, String conditionValue) {
		
			return userDAO.findbycondition(conditionName,conditionValue);
		}
		
		
	    //����û���Ϣ
		public boolean addinfo(User user) {
			
			 userDAO.insertinfo(user);
			 return true;
			 
		}

		public PageBean pageQuery(int pNum) {
			//����ҳ���ÿҳ����  ���㿪ʼ����
			int start = (pNum-1) * NUMPERPAGE;
			
			
			PageBean pageBean = new PageBean();
			
			//��װ��ǰҳ��
			pageBean.setpNum(pNum);
			// ����DAO���з�ҳ��ѯ --- �������
			
			List<User> users = 	userDAO.findByPage(start,PageBean.NUMPERPAGE);
			pageBean.setUser(users);
			
			//��װ�ܼ�¼����
			int totalRecordNum = userDAO.findtotalRecordNum();
			pageBean.setTotalRecordNum(totalRecordNum);
			
			
			//������ҳ��
			int totalpageNum = (totalRecordNum+PageBean.NUMPERPAGE-1)/PageBean.NUMPERPAGE;
			pageBean.setTotalPageNum(totalpageNum);
			
			
			return pageBean;
			
		
		}



		public User findbyid(String id) {
			
			return userDAO.findById(id);
		}



		public User findbystudent_id(String student_id) {
			
			return userDAO.findBystudent_id(student_id);
		}



		public Boolean deleteuser_id(String id) {
			userDAO.delbyuser_Id(id);
			return true;
		}



		
	}


