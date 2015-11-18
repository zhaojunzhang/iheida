package com.iheida.dao;

import java.sql.SQLException;





import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;




import org.springframework.stereotype.Service;

import com.iheida.domin.Admin;
import com.iheida.domin.User;
import com.iheida.util.JDBCUtils;
/*
 * ����Ա���ݲ�
 */
@Service("adminDAO")
public class AdminDAO{

	//����Ա��½
	public Admin login(Admin admin) {
		String username = admin.getUsername();
		String password = admin.getPassword();
		String sql = "select * from admin where username=? and password=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Admin admin1 = queryRunner.query(sql, new BeanHandler<Admin>(Admin.class),username,password);
			
				return admin1;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Sql������");
		}
		
		
	}
	//��ѯ��������
	public List<User> findAll() {
		String sql = "select * from user";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		
		try {
			List<User> users = queryRunner.query(sql, new BeanListHandler<User>(User.class));
			return users;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("sql������");
		}
		
	}
//��������ѯ
		public List<User> findbycondition(String conditionName,
			String conditionValue) {
			
			String sql = "select * from user";
			//����
			if(conditionName.equals("username")){
				sql+= " where "+conditionName +" like ?";
				conditionValue ="%" +conditionValue+"%";
			}else if (conditionName.equals("event_name")) {
				//��������
				sql += " where " + conditionName + " = ?";
				
			}else if(conditionName.equals("community_name")){
				//��������
				sql+= " where "+conditionName +" like ?";
				conditionValue=" % "+conditionValue+" % ";
				
			}
		
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<User> users = queryRunner.query(sql, new BeanListHandler<User>(User.class),conditionValue);
			
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("���۲�ѯsql������");
		}
	}
	//����ɾ����Ϣ
	
	public void delAll(String[] ids) {
		try {
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			String sql = "delete from user where id = ?";
			for(String id:ids){		
				queryRunner.update(sql,id);	
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("����ɾ�����ִ���");
		}
	}
	//����ID����ɾ��
	
	public void delbyId(String id) {
		String sql ="delete from user where id = ?";
		
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("����ɾ��Id��SQL������");
		}
		
	}
	//�²������ݿ�
	
	public void insertinfo(User user) {
		String sql = "insert into user values(null,?,?,0,null,?,?,?)";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		Object[] param ={user.getUsername(),user.getStudent_id(),user.getEvent_name(),user.getCommunity_name(),user.getEvent_content()};
		try {
			queryRunner.update(sql, param);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("���ݲ������");
		}
		
		
	}
	//�����ҳ��ѯ���ݿ�
	
	public List<User> findByPage(int start, int numperpage) {
		String sql = "select * from user limit ?,? ";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		
		try {
			List<User> users = queryRunner.query(sql, new BeanListHandler<User>(User.class),start,numperpage);
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�����ҳ��ѯ����SQL������");
		}
	}
	
	//��ѯ�ܼ�¼����
	
	public int findtotalRecordNum(){
			String sql = "select count(*) from user";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			  try {
				long totalRecordNum = (Long) queryRunner.query(sql, new ScalarHandler(1));
				return (int)totalRecordNum;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("��ѯ�ܼ�¼����SQL������");
			}
	
			
		}
		//����Id����ѯ��Ϣ
	
	public User findById(String id) {
			String sql = "select * from user where id=?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			try {
				User user = queryRunner.query(sql, new BeanHandler<User>(User.class),id);
				return user;
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new RuntimeException("//����Id����ѯ��ϢSQL������");
			}
			
	
		}
		//����״̬��
	public void updatestate(String id) {
			String sql = "update user set state=1 where id = ?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			try {
				queryRunner.update(sql,id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("����״̬��SQL����");
			}
			
		}
	//ȡ����ע
	public void Cancelupdatestate(String id) {
		String sql = "update user set state=0 where id = ?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ȡ������״̬��SQL����");
		}
		
		
	}

}
