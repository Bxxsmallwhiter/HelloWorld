package day02;

import java.util.ArrayList;
import java.util.List;


public class Master {
	//�����赥����
	public static List<Song> listsong=new ArrayList<>();
	/*
	 * ���캯��
	 * ��ʼ��listsong
	 */
	public Master()
	{
	}
	
	public boolean play()
	{
		if(!listsong.isEmpty())
		{
			System.out.println("��ǰ���Ÿ�����"+listsong.get(0).songname);
			listsong.remove(0);//ɾ����ǰ����
			return true;
		}
		else return false;
	}
}
