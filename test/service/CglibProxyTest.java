package service;

public class CglibProxyTest {
	public static void main(String[] args) {
        PeopleTalk peopleTalk = (PeopleTalk) new CglibProxy().getInstance(new PeopleTalk());
        peopleTalk.talk("ҵ�񷽷�");
        peopleTalk.speak("ҵ�񷽷�");
    }
}
