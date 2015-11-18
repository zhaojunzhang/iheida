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
	  
	  //查询所有的数据
		public List<User> select() {
			
			
			return userDAO.findAll();
		}
		
		

		//按条件查询
		public List<User> conditionQuery(String conditionName, String conditionValue) {
		
			return userDAO.findbycondition(conditionName,conditionValue);
		}
		
		
	    //添加用户信息
		public boolean addinfo(User user) {
			
			 userDAO.insertinfo(user);
			 return true;
			 
		}

		public PageBean pageQuery(int pNum) {
			//根据页码和每页条数  计算开始索引
			int start = (pNum-1) * NUMPERPAGE;
			
			
			PageBean pageBean = new PageBean();
			
			//封装当前页码
			pageBean.setpNum(pNum);
			// 调用DAO进行分页查询 --- 结果数据
			
			List<User> users = 	userDAO.findByPage(start,PageBean.NUMPERPAGE);
			pageBean.setUser(users);
			
			//封装总记录条数
			int totalRecordNum = userDAO.findtotalRecordNum();
			pageBean.setTotalRecordNum(totalRecordNum);
			
			
			//计算总页数
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


