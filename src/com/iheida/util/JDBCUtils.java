package com.iheida.util;

import java.sql.Connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ������ �ṩ���ݿ����ӳ� �����ݿ�����
 * 
 * @author seawind
 * 
 */
public class JDBCUtils {
private static DataSource dataSource = new ComboPooledDataSource();
	
	//�������ӳأ������ӳؽ�����ܣ�����Զ�������� ��������
	public static DataSource getDataSource(){
		return dataSource;
	}
	//�ṩDBUtils ,�ֶ���������ʹ��
	public static  Connection getConnect() throws SQLException{
		return dataSource.getConnection();
	
	}
}
