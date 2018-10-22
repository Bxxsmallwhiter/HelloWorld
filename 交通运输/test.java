package day06;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double c,tc,h,th,a,ta;
		System.out.println("请输入出发地、目的地及距离(KM/h):");
		Scanner sc=new Scanner(System.in);
		String start=sc.next();
		String end=sc.next();
		double distance=sc.nextDouble();
		
		Car car=new Car();
		HighTrain ht=new HighTrain();
		Airplane ap=new Airplane();
		System.out.println("汽车:"+car.Trans());
		System.out.println("高铁:"+ht.Trans());
		System.out.println("飞机:"+ap.Trans());
		c=car.price()*distance;
		tc=distance/car.Speed();
		h=ht.price()*distance;
		th=distance/ht.Speed();
		a=ap.price()*distance;
		ta=distance/ap.Speed();
		System.out.println("汽车所需费用:"+String.format("%.2f", c)+"元"+"    "
							+"汽车所需时间:"+String.format("%.2f", tc)+"h");
		System.out.println("高铁所需费用:"+String.format("%.2f", h)+"元"+"    "
							+"高铁所需时间:"+String.format("%.2f", th)+"h");
		System.out.println("飞机所需费用:"+String.format("%.2f", a)+"元"+"    "
							+"飞机所需时间:"+String.format("%.2f", ta)+"h");
	}

}
