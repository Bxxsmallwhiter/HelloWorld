package day02;

import java.util.Scanner;

public class Player {
	Song s;
	
	public boolean addsong()
	{
		String n,singer;
		double t;
		//�½�������
		Scanner sc=new Scanner(System.in);
		System.out.print("��������������������ʱ��(��)��");
		n=sc.next();
		singer=sc.next();
		t=sc.nextDouble();
		s=new Song(n,singer,t);
		return true;
	};
}
