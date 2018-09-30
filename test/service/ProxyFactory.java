package service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler{

	private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        //被代理类的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //被代理类的接口
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //代理类执行，执行某个类的某个方法，并传入方法入参，获得返回值
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                // TODO Auto-generated method stub
                System.out.println("开始执行代理");
                Object returnValue = method.invoke(target, args);
                System.out.println("结束了执行代理");
                return returnValue;
            }
        };
        //返回代理类
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		 	System.out.println("-----before-----");
	        Object result = method.invoke(target, args);
	        System.out.println("-----end-----");
	        return result;
	}
	
	// 生成代理对象
    public Object getProxy() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader, interfaces, this);
    }
}
