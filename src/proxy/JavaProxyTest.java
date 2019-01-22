package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 代理测试类
 * @author liuyang
 * @param <T>
 *
 */
public class JavaProxyTest<T> implements InvocationHandler {
	
	private Object target;
	
	JavaProxyTest(){
		super();
	}
	
	JavaProxyTest(Object target){
		super();
		this.target = target;
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("调用方法之前："+method.getName());
		Object result = method.invoke(target, args);
		System.out.println("调用方法之后："+method.getName()+"++++++++++"+result);
		
		return result;
	}
	
	public static void main(String[] args) {
		UserServiceImpl userService = new UserServiceImpl();
		//返回类加载器
		ClassLoader clazz = userService.getClass().getClassLoader();
		Class<T> interfaces = userService.getClass().getInterfaces();
		InvocationHandler h = new JavaProxyTest<>(userService);
		
		UserService userServiceProxy = (UserService)Proxy.newProxyInstance(clazz, userService.getClass().getInterfaces(), h);
		
		
		System.out.println(userServiceProxy.getUserName());
		System.out.println(userServiceProxy.getUserAge());

	}

}
