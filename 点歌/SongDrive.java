package day02;

import java.util.Scanner;

public class SongDrive {
	public static Master master;
	public static Player player;
	
	//��ʼ��master��player
	public SongDrive()
	{
		master=new Master();
		player=new Player();
	}
	
	public static void main(String[] args)
	{
		SongDrive song=new SongDrive();
		Scanner sc=new Scanner(System.in);
		System.out.println("����0,1,2,3��");
		System.out.println("0���˳���裬"
				+ "1����裬"
				+ "2�����Ÿ���,
				+ "3:  �˳�ϵͳ");
		//ѭ������
		int i;
		do {
			System.out.print("�����룺");
			i=sc.nextInt();
		switch(i)
		{
		case 0:System.out.println("�˳���裡");break;
		case 1://��Ӹ���
				player.addsong();
				master.listsong.add(player.s);
				System.out.println("����������밴1");
				break;
		case 2:	//���Ÿ���
				if(!master.play())
				{
					System.out.println("��ǰ�б��޸�����");
				}
				else System.out.println("���������밴2");
				break;
		case 3:break;//�˳�
			default:
			System.out.println("ERROR��");break;
		}
		}while(i!=3);
	}
}
