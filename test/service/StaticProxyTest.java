package service;

import dao.ITalk;
/*
 * ��̬����
 */
public class StaticProxyTest {
	public static void main(String[] args) {
        // ����Ҫִ�ж��ⷽ���ġ�
        ITalk people = new PeopleTalk("AOP", "18");
        people.talk("No ProXY Test");
        System.out.println("-----------------------------");

        // ��Ҫִ�ж��ⷽ���ģ����棩
        TalkProxy talker = new TalkProxy(people);
        talker.talk("ProXY Test", "����");
    }
}
