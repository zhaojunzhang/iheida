package com.iheida.util;

import java.sql.Connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 工具类 提供数据库连接池 和数据库连接
 * 
 * @author seawind
 * 
 */
public class JDBCUtils {
private static DataSource dataSource = new ComboPooledDataSource();
	
	//返回连接池，将连接池交给框架，框架自动获得连接 管理事务
	public static DataSource getDataSource(){
		return dataSource;
	}
	//提供DBUtils ,手动控制事务使用
	public static  Connection getConnect() throws SQLException{
		return dataSource.getConnection();
	
	}
}
