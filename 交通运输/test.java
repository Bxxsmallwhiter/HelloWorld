package day06;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double c,tc,h,th,a,ta;
		System.out.println("����������ء�Ŀ�ĵؼ�����(KM/h):");
		Scanner sc=new Scanner(System.in);
		String start=sc.next();
		String end=sc.next();
		double distance=sc.nextDouble();
		
		Car car=new Car();
		HighTrain ht=new HighTrain();
		Airplane ap=new Airplane();
		System.out.println("����:"+car.Trans());
		System.out.println("����:"+ht.Trans());
		System.out.println("�ɻ�:"+ap.Trans());
		c=car.price()*distance;
		tc=distance/car.Speed();
		h=ht.price()*distance;
		th=distance/ht.Speed();
		a=ap.price()*distance;
		ta=distance/ap.Speed();
		System.out.println("�����������:"+String.format("%.2f", c)+"Ԫ"+"    "
							+"��������ʱ��:"+String.format("%.2f", tc)+"h");
		System.out.println("�����������:"+String.format("%.2f", h)+"Ԫ"+"    "
							+"��������ʱ��:"+String.format("%.2f", th)+"h");
		System.out.println("�ɻ��������:"+String.format("%.2f", a)+"Ԫ"+"    "
							+"�ɻ�����ʱ��:"+String.format("%.2f", ta)+"h");
	}

}
