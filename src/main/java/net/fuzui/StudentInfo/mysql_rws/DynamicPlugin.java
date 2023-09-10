package net.fuzui.StudentInfo.mysql_rws;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.slf4j.Logger;

/**
 * @author fuzui
 * @date 2019年3月17日 下午5:58:43
 * 
 */
/**
 *  Mybatis插件，通过拦截Executor方式实现
 * */
@Intercepts({
	@Signature(type = Executor.class,method = "update",args = { MappedStatement.class,Object.class}),
	@Signature(type = Executor.class,method = "query",args = {MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class})
})
public class DynamicPlugin implements Interceptor {
	
	private Logger log = LoggerFactory.getLogger(DynamicPlugin.class);
	private static final Map<String,DynamicDataSourceGlobal> cacheMap = new ConcurrentHashMap<>();
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		//如果拥有事物上下文，则将连接绑定到事物上下文中
		boolean synchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();
		if(!synchronizationActive) {
			Object[] object = invocation.getArgs();
			MappedStatement ms = (MappedStatement) object[0];
			DynamicDataSourceGlobal dynamicDataSourceGlobal = null;
			if((dynamicDataSourceGlobal = cacheMap.get(ms.getId())) == null) {
				//读方法
				if(ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
					//当查询主键时使用主库
					if(ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
						dynamicDataSourceGlobal = DynamicDataSourceGlobal.WRITE;
					}else {
						dynamicDataSourceGlobal = DynamicDataSourceGlobal.READ;
					}
				}else {	
					//写方法
					dynamicDataSourceGlobal = DynamicDataSourceGlobal.WRITE;
				}
				System.out.println("设置方法[{"+ms.getId()+"}] use [{"+dynamicDataSourceGlobal.name()+"}] Strategy, SqlCommandType [{"+ms.getSqlCommandType().name()+"}]..");
				log.warn("设置方法[{}] use [{}] Strategy, SqlCommandType [{}]..", ms.getId(), dynamicDataSourceGlobal.name(), ms.getSqlCommandType().name());
				// 把id(方法名)和数据源存入map，下次命中后就直接执行
				cacheMap.put(ms.getId(), dynamicDataSourceGlobal);
			}
			DynamicDataSourceHolder.putDataSource(dynamicDataSourceGlobal);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

}
