package com.web.java.dbdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbConnection {

	private Connection conn = null;
	private static final String mysqlurl = "jdbc:mysql://";

	public static final String mysql = "mysql";
	public static final String oracle = "oracle";
	private static final String oracleurl = "jdbc:oracle:thin:@";
	private DataSource ds=null;

	public DbConnection(String name, String password, String dbName, String ip, String port, String dbtype) {
		// TODO �Զ����ɵĹ��캯�����
		String url = "";
		if (mysql.equals(dbtype)) {
			url = url + mysqlurl;
			url = url + ip + ":" + port + "/" + dbName;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		if (oracle.equals(dbtype)) {
			url = url + oracleurl;
			url = url + ip + ":" + port + ":" + dbName;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}

		try {
			conn = DriverManager.getConnection(url, name, password);
			System.out.println(dbName+"===���ݿ����ӳɹ�");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	public DbConnection() {
		// TODO �Զ����ɵĹ��캯�����
	 ds=new ComboPooledDataSource("mysqlId");
		
	}
	public Connection getConn() {
		if(null==conn)
		{
			try {
				conn=ds.getConnection();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO �Զ����ɵķ������
		super.finalize();
		if (this.conn != null) {
			conn.close();
		}
	}

	public Statement createStatement()
	{
		Statement st;
		if(this.conn==null)
		{
			getConn();
		}
		try {
			
			st = this.conn.createStatement();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return null;
		}
		return st;
	}
}
