package service;

public class CglibProxyTest {
	public static void main(String[] args) {
        PeopleTalk peopleTalk = (PeopleTalk) new CglibProxy().getInstance(new PeopleTalk());
        peopleTalk.talk("业务方法");
        peopleTalk.speak("业务方法");
    }
}
