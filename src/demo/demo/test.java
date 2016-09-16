package demo;

import org.junit.Test;

public class test {

	@Test
	public void demo(){
		Son son = new Son("son.....");
	}
}

class Parent{
	private String name;
	public Parent(){
		System.out.println("none.....");
	}
	public Parent(String name){
		this.name = name;
		System.out.println(name);
	}
}

class Son extends Parent{
	public Son(String name){
		System.out.println(name);
	}
}

class test21 {
	static{
		System.out.println("load");
	}

}
