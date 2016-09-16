package demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


class demo33 {
	@Test
	public void show(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.remove(1);
		System.out.println(list.get(222));
	}
	

}
