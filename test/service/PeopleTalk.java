package service;

import dao.ITalk;

public class PeopleTalk implements ITalk {

	public String name;
	public String age;
	
	public PeopleTalk(String name, String age) {
		//super();
		this.name = name;
		this.age = age;
	}
	public PeopleTalk() {
	}
	@Override
	public void talk(String msg) {
		System.out.println(msg+"你好，我是"+name+"年龄是"+age);
	}
	public void speak(String msg) {
		System.out.println("speak chinese");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
}
