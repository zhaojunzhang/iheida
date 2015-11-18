package com.iheida.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.iheida.dao.AdminDAO;
import com.iheida.domin.Admin;
import com.iheida.domin.PageBean;
import com.iheida.domin.User;

/*
 * 管理员业务层
 */
@Service("adminService")
public class AdminService {
	@Qualifier("adminDAO")
	@Autowired
	private AdminDAO adminDAO;
	private static final int NUMPERPAGE = 10;

	// 登陆
	public Admin login(Admin admin) {
		return adminDAO.login(admin);
	}

	// 查询所有信息
	public List<User> select() {

		return adminDAO.findAll();
	}

	// 按条件查询

	public List<User> conditionQuery(String conditionName, String conditionValue) {

		return adminDAO.findbycondition(conditionName, conditionValue);
	}

	// 批量删除

	public boolean delBatchCustomer(String[] ids) {
		adminDAO.delAll(ids);
		return true;

	}

	// 按id删除

	public boolean deleteid(String id) {
		adminDAO.delbyId(id);
		return true;

	}

	// 添加用户信息

	public boolean addinfo(User user) {

		adminDAO.insertinfo(user);
		return true;

	}

	public PageBean pageQuery(int pNum) {
		// 根据页码和每页条数 计算开始索引
		int start = (pNum - 1) * NUMPERPAGE;

		PageBean pageBean = new PageBean();

		// 封装当前页码
		pageBean.setpNum(pNum);
		// 调用DAO进行分页查询 --- 结果数据

		List<User> users = adminDAO.findByPage(start, PageBean.NUMPERPAGE);
		pageBean.setUser(users);

		// 封装总记录条数
		int totalRecordNum = adminDAO.findtotalRecordNum();
		pageBean.setTotalRecordNum(totalRecordNum);

		// 计算总页数
		int totalpageNum = (totalRecordNum + PageBean.NUMPERPAGE - 1)
				/ PageBean.NUMPERPAGE;
		pageBean.setTotalPageNum(totalpageNum);

		return pageBean;

	}
    //根据ID来查询
	public User findbyid(String id) {

		return adminDAO.findById(id);
	}
    //更改状态吗
	public void updatestate(String id) {

		adminDAO.updatestate(id);

	}
    //取消关注
	public void Cancelupdatestate(String id) {
		adminDAO.Cancelupdatestate(id);
		
	}

}
