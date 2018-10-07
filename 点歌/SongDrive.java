package day02;

import java.util.Scanner;

public class SongDrive {
	public static Master master;
	public static Player player;
	
	//初始化master和player
	public SongDrive()
	{
		master=new Master();
		player=new Player();
	}
	
	public static void main(String[] args)
	{
		SongDrive song=new SongDrive();
		Scanner sc=new Scanner(System.in);
		System.out.println("输入0,1,2,3：");
		System.out.println("0：退出点歌，"
				+ "1：点歌，"
				+ "2：播放歌曲,
				+ "3:  退出系统");
		//循环输入
		int i;
		do {
			System.out.print("请输入：");
			i=sc.nextInt();
		switch(i)
		{
		case 0:System.out.println("退出点歌！");break;
		case 1://添加歌曲
				player.addsong();
				master.listsong.add(player.s);
				System.out.println("若继续点歌请按1");
				break;
		case 2:	//播放歌曲
				if(!master.play())
				{
					System.out.println("当前列表无歌曲！");
				}
				else System.out.println("继续播放请按2");
				break;
		case 3:break;//退出
			default:
			System.out.println("ERROR！");break;
		}
		}while(i!=3);
	}
}
