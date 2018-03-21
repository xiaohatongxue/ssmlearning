package com.web.java.dbdao;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ColinDataSourceFactory extends UnpooledDataSourceFactory {

	public ColinDataSourceFactory() {
		// TODO 自动生成的构造函数存根
		this.dataSource = new ComboPooledDataSource("mysqlId");
	}
}
