package day01;

import java.util.Scanner;

/**
 * ��������������
 * @author A556U
 *
 */
public class Car {
	public String name;//������
	public int tank;//������������
	public double oilConsumption;//�����ͺ�
	//����ֵ��ʼ��
	public Car() {
		name="�µ�R6";
		tank=100;
		oilConsumption=5.2;
	}
	/*
	 * Car�Ĵ��ι���
	 */
	public Car(String cname,int ctank,double coilConsumption)
	{
		name=cname;
		tank=ctank;
		oilConsumption=coilConsumption;
	}
	/**
	 * ��������
	 */
	public void gass(int a)
	{
		a=40;
		if(a>tank-oilConsumption)
		{
			System.out.println("�ü����ˣ�");
		}
	}
	/**
	 * ������Ϣ��ʾ
	 */
	public void printInfo()
	{
		System.out.println("������"+name+"  "+"����������"
	                        +tank+"L"+"  "+"�ͺģ�"+oilConsumption+"L/Km");
	}


	public static void main(String[] args) {
		//�������������
		int num;
		String sname;
		int itank;
		double doilConsumption;
		System.out.println("�����복������");
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();//���복����
		Car[] c=new Car[num];
		for(int i=0;i<num;i++) {
			System.out.println("�������"+(i+1)+"����,��������"
					+ "���ͺģ�");
			sname=sc.next();//���복��
			itank=sc.nextInt();//������������
			doilConsumption=sc.nextDouble();//�����ͺ�
			c[i]=new Car(sname,itank,doilConsumption);
		}
		for(int i=0;i<num;i++)
		{
			c[i].printInfo();//��ʾ������Ϣ
		}
	}
}
