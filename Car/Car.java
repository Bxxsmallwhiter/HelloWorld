package day01;

import java.util.Scanner;

/**
 * 定义汽车的属性
 * @author A556U
 *
 */
public class Car {
	public String name;//汽车名
	public int tank;//储存油箱容量
	public double oilConsumption;//汽车油耗
	//将数值初始化
	public Car() {
		name="奥迪R6";
		tank=100;
		oilConsumption=5.2;
	}
	/*
	 * Car的带参构造
	 */
	public Car(String cname,int ctank,double coilConsumption)
	{
		name=cname;
		tank=ctank;
		oilConsumption=coilConsumption;
	}
	/**
	 * 汽车加油
	 */
	public void gass(int a)
	{
		a=40;
		if(a>tank-oilConsumption)
		{
			System.out.println("该加油了！");
		}
	}
	/**
	 * 汽车信息显示
	 */
	public void printInfo()
	{
		System.out.println("车名："+name+"  "+"油箱容量："
	                        +tank+"L"+"  "+"油耗："+oilConsumption+"L/Km");
	}


	public static void main(String[] args) {
		//车辆的输入输出
		int num;
		String sname;
		int itank;
		double doilConsumption;
		System.out.println("请输入车辆数：");
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();//输入车辆数
		Car[] c=new Car[num];
		for(int i=0;i<num;i++) {
			System.out.println("请输入第"+(i+1)+"车名,油箱容量"
					+ "及油耗：");
			sname=sc.next();//输入车名
			itank=sc.nextInt();//输入油箱容量
			doilConsumption=sc.nextDouble();//输入油耗
			c[i]=new Car(sname,itank,doilConsumption);
		}
		for(int i=0;i<num;i++)
		{
			c[i].printInfo();//显示车辆信息
		}
	}
}
