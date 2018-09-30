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
        //����������������
        ClassLoader classLoader = target.getClass().getClassLoader();
        //��������Ľӿ�
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //������ִ�У�ִ��ĳ�����ĳ�������������뷽����Σ���÷���ֵ
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                // TODO Auto-generated method stub
                System.out.println("��ʼִ�д���");
                Object returnValue = method.invoke(target, args);
                System.out.println("������ִ�д���");
                return returnValue;
            }
        };
        //���ش�����
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
	
	// ���ɴ������
    public Object getProxy() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader, interfaces, this);
    }
}
