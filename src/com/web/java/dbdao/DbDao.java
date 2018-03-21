package com.web.java.dbdao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbDao {

	private Statement st;

	public DbDao(Statement st) {
		// TODO �Զ����ɵĹ��캯�����
		this.st = st;
	}

	public int insert(String sql) {
		int t = 0;
		try {
			t = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return t;
	}

	public int update(String sql) {
		int t = 0;
		try {
			t = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return t;
	}

	public int del(String sql) {
		int t = 0;
		try {
			t = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return t;
	}

	public ResultSet query(String sql) {
		ResultSet rs=null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return rs;
	}
	
	
	public ResultSet pageQuery(String sql,PageBean page) {
		ResultSet rs=null;
		try {
			int count=queryCount(sql);
			if(count==0)
			{
				return null;
			}
			page.setCount(count);
			sql=sql+" limit "+page.getStart()+","+page.getPageSize();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return rs;
	}
	private int queryCount(String sql)
	{
		String countsql=" select count(*) c from ( "+sql+") t";
		ResultSet rs= this.query(countsql);
		try {
			if(rs.next())
			{
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO �Զ����ɵķ������
		super.finalize();
		if(st!=null)
		{
			st.close();
		}
	}
	
	
	public  <E> List<E> queryObjectList(String sql,String ClassName) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException
	{
		//�������ݿ�
		
		ResultSet  rs=this.query(sql);
		ResultSetMetaData meta=rs.getMetaData();
		int count=meta.getColumnCount();//�ֶε�����
		Class cla=Class.forName(ClassName);
		Field[]  fs=cla.getDeclaredFields();
		
		List<E> list=new ArrayList<E>();
		
		while(rs.next())
		{
			Object obj=cla.newInstance();
			for(int i=1;i<=count;i++)//������ֶ�
			{
				for(Field f:fs)//���������
				{
					//����ֶ�����==���ݿ��ֶ����� ��ֵ
					if(f.getName().equals(meta.getColumnName(i))) //�����Ƿ���ֶ�һ��
					{
						if("INT".equals(meta.getColumnTypeName(i)))
						{
							f.set(obj, rs.getInt(meta.getColumnName(i)));
						}
						if("VARCHAR".equals(meta.getColumnTypeName(i)))
						{
							f.set(obj, rs.getString(meta.getColumnName(i)));
						}
						
					}
				}
			}
			list.add((E)obj);
		}
		rs.close();
		return list;
	}
	
	
	
	
}
