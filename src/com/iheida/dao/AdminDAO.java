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
 * 管理员数据层
 */
@Service("adminDAO")
public class AdminDAO{

	//管理员登陆
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
			throw new RuntimeException("Sql语句错误");
		}
		
		
	}
	//查询所有数据
	public List<User> findAll() {
		String sql = "select * from user";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		
		try {
			List<User> users = queryRunner.query(sql, new BeanListHandler<User>(User.class));
			return users;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("sql语句错误");
		}
		
	}
//按条件查询
		public List<User> findbycondition(String conditionName,
			String conditionValue) {
			
			String sql = "select * from user";
			//姓名
			if(conditionName.equals("username")){
				sql+= " where "+conditionName +" like ?";
				conditionValue ="%" +conditionValue+"%";
			}else if (conditionName.equals("event_name")) {
				//社团名称
				sql += " where " + conditionName + " = ?";
				
			}else if(conditionName.equals("community_name")){
				//社团名称
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
			throw new RuntimeException("条价查询sql语句错误");
		}
	}
	//批量删除信息
	
	public void delAll(String[] ids) {
		try {
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			String sql = "delete from user where id = ?";
			for(String id:ids){		
				queryRunner.update(sql,id);	
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("批量删除出现错误");
		}
	}
	//根据ID进行删除
	
	public void delbyId(String id) {
		String sql ="delete from user where id = ?";
		
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("根据删除Id的SQL语句错误");
		}
		
	}
	//新插入数据库
	
	public void insertinfo(User user) {
		String sql = "insert into user values(null,?,?,0,null,?,?,?)";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		Object[] param ={user.getUsername(),user.getStudent_id(),user.getEvent_name(),user.getCommunity_name(),user.getEvent_content()};
		try {
			queryRunner.update(sql, param);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("数据插入错误");
		}
		
		
	}
	//物理分页查询数据库
	
	public List<User> findByPage(int start, int numperpage) {
		String sql = "select * from user limit ?,? ";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		
		try {
			List<User> users = queryRunner.query(sql, new BeanListHandler<User>(User.class),start,numperpage);
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("物理分页查询错误SQL语句错误");
		}
	}
	
	//查询总记录条数
	
	public int findtotalRecordNum(){
			String sql = "select count(*) from user";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			  try {
				long totalRecordNum = (Long) queryRunner.query(sql, new ScalarHandler(1));
				return (int)totalRecordNum;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("查询总记录条数SQL语句错误");
			}
	
			
		}
		//根据Id来查询信息
	
	public User findById(String id) {
			String sql = "select * from user where id=?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			try {
				User user = queryRunner.query(sql, new BeanHandler<User>(User.class),id);
				return user;
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new RuntimeException("//根据Id来查询信息SQL语句错误");
			}
			
	
		}
		//更改状态码
	public void updatestate(String id) {
			String sql = "update user set state=1 where id = ?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			try {
				queryRunner.update(sql,id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("更改状态码SQL错误");
			}
			
		}
	//取消关注
	public void Cancelupdatestate(String id) {
		String sql = "update user set state=0 where id = ?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("取消更改状态码SQL错误");
		}
		
		
	}

}
