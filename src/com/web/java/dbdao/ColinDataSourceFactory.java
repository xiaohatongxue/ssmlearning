package com.web.java.dbdao;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ColinDataSourceFactory extends UnpooledDataSourceFactory {

	public ColinDataSourceFactory() {
		// TODO �Զ����ɵĹ��캯�����
		this.dataSource = new ComboPooledDataSource("mysqlId");
	}
}
