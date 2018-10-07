package day02;

import java.util.Scanner;

public class Player {
	Song s;
	
	public boolean addsong()
	{
		String n,singer;
		double t;
		//新建歌曲单
		Scanner sc=new Scanner(System.in);
		System.out.print("歌曲名、歌曲名及歌曲时长(秒)：");
		n=sc.next();
		singer=sc.next();
		t=sc.nextDouble();
		s=new Song(n,singer,t);
		return true;
	};
}
