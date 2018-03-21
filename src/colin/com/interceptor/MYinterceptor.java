package colin.com.interceptor;

import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts(@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }))
public class MYinterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO 自动生成的方法存根
		Object obj=invocation.getTarget();
		Method m=invocation.getMethod();
		
		Object[] args=invocation.getArgs();
		
		MappedStatement bappedStatement=(MappedStatement)args[0];
		Object parameterObject=args[1];
		RowBounds rowBounds=(RowBounds)args[2];
		
		BoundSql boundsql=bappedStatement.getBoundSql(parameterObject);
		System.out.println(boundsql.getSql());
		String sql="select * from ("+boundsql.getSql()+") pagesql limit "+ rowBounds.getOffset()+","+rowBounds.getLimit();
		System.out.println(sql);
		bappedStatement=getMappedStatement(bappedStatement,boundsql,sql);
		args[0]=bappedStatement;
		
		
		
		return invocation.proceed();
	}

	private MappedStatement getMappedStatement(MappedStatement ms, BoundSql boundsql, String sql) {
		MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(),
				new StaticSqlSource(ms.getConfiguration(), sql, boundsql.getParameterMappings()),
				ms.getSqlCommandType());
		if(ms.getKeyColumns()!=null&&ms.getKeyColumns().length>0)
		builder.keyColumn(ms.getKeyColumns()[0]);
		builder.keyGenerator(ms.getKeyGenerator());
		if(ms.getKeyProperties()!=null&&ms.getKeyProperties().length>0)
		{
			builder.keyProperty(ms.getKeyProperties()[0]);
		}
		
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.databaseId(ms.getDatabaseId());
		builder.cache(ms.getCache());
		builder.fetchSize(ms.getFetchSize());
		builder.lang(ms.getLang());
		builder.parameterMap(ms.getParameterMap());
		builder.resource(ms.getResource());
		builder.timeout(ms.getTimeout());
		builder.resultSetType(ms.getResultSetType());
		builder.statementType(ms.getStatementType());
		builder.resultOrdered(ms.isResultOrdered());
		builder.resultMaps(ms.getResultMaps());
		return builder.build();
	}

	@Override
	public Object plugin(Object target) {
		// TODO 自动生成的方法存根
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO 自动生成的方法存根
		System.out.println(properties.getProperty("age"));
	}

}
