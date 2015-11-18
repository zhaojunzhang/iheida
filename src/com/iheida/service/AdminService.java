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
 * ����Աҵ���
 */
@Service("adminService")
public class AdminService {
	@Qualifier("adminDAO")
	@Autowired
	private AdminDAO adminDAO;
	private static final int NUMPERPAGE = 10;

	// ��½
	public Admin login(Admin admin) {
		return adminDAO.login(admin);
	}

	// ��ѯ������Ϣ
	public List<User> select() {

		return adminDAO.findAll();
	}

	// ��������ѯ

	public List<User> conditionQuery(String conditionName, String conditionValue) {

		return adminDAO.findbycondition(conditionName, conditionValue);
	}

	// ����ɾ��

	public boolean delBatchCustomer(String[] ids) {
		adminDAO.delAll(ids);
		return true;

	}

	// ��idɾ��

	public boolean deleteid(String id) {
		adminDAO.delbyId(id);
		return true;

	}

	// ����û���Ϣ

	public boolean addinfo(User user) {

		adminDAO.insertinfo(user);
		return true;

	}

	public PageBean pageQuery(int pNum) {
		// ����ҳ���ÿҳ���� ���㿪ʼ����
		int start = (pNum - 1) * NUMPERPAGE;

		PageBean pageBean = new PageBean();

		// ��װ��ǰҳ��
		pageBean.setpNum(pNum);
		// ����DAO���з�ҳ��ѯ --- �������

		List<User> users = adminDAO.findByPage(start, PageBean.NUMPERPAGE);
		pageBean.setUser(users);

		// ��װ�ܼ�¼����
		int totalRecordNum = adminDAO.findtotalRecordNum();
		pageBean.setTotalRecordNum(totalRecordNum);

		// ������ҳ��
		int totalpageNum = (totalRecordNum + PageBean.NUMPERPAGE - 1)
				/ PageBean.NUMPERPAGE;
		pageBean.setTotalPageNum(totalpageNum);

		return pageBean;

	}
    //����ID����ѯ
	public User findbyid(String id) {

		return adminDAO.findById(id);
	}
    //����״̬��
	public void updatestate(String id) {

		adminDAO.updatestate(id);

	}
    //ȡ����ע
	public void Cancelupdatestate(String id) {
		adminDAO.Cancelupdatestate(id);
		
	}

}
