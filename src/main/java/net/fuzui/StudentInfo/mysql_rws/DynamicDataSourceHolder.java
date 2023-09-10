package net.fuzui.StudentInfo.mysql_rws;
/**
 * @author fuzui
 * @date 2019年3月17日 下午5:47:47
 * 
 */
//使用ThreadLocal技术来记录当前线程中的数据源的key
public class DynamicDataSourceHolder {

	private static final ThreadLocal<DynamicDataSourceGlobal> holder = new ThreadLocal<DynamicDataSourceGlobal>();
	private DynamicDataSourceHolder() {
		
	}
	
	//设置数据源
	public static void putDataSource(DynamicDataSourceGlobal dataSource) {
		holder.set(dataSource);
	}
	//获取数据源
	public static DynamicDataSourceGlobal getDataSource() {
		return holder.get();
	}
	//清理数据源
	public static void clearDataSource() {
		holder.remove();
	}
	
	
}
