package day01;

import java.util.ArrayList;
import java.util.List;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>(1);
		Integer integer=new Integer(10);
		list.add(integer);
		
		integer=list.get(0);
		int cnt=integer.intValue();
		
		Integer l=list.get(0);
		l=5;
		
		System.out.println(integer+","+l);
		System.out.println(integer.equals(l));
	}

}

Êä³ö½á¹û£º
10,5
false
