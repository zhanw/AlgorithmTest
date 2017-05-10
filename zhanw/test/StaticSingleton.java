package zhanw.test;

/**
 * 不考虑序列化与反序列化，
 * 
 * 使用静态内部类的方式实现单例，既可以做到延迟加载，也不必使用synchronized关键字，
 * 是一种比较完善的实现方式
 * @author wei
 *
 */
public class StaticSingleton {
	private StaticSingleton(){}
	
	private static StaticSingleton getInstance(){
		return SingletonHolder.instance;
	}
	
	private static class SingletonHolder{
		private static StaticSingleton instance = new StaticSingleton();
	}
}
