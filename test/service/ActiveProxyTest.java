package service;

import dao.ITalk;
import service.PeopleTalk;

public class ActiveProxyTest {
	
	public static void main(String[] args) {
        ITalk service = new PeopleTalk("����", "28");
        ProxyFactory handler = new ProxyFactory(service);
        ITalk serviceProxy = (ITalk)handler.getProxy();
        serviceProxy.talk("���");
        
        
        
        ITalk target = new PeopleTalk("����", "24");
        System.out.println(target.getClass());
        ITalk proxy = (ITalk) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.talk("�ٺ�");
    }

}
