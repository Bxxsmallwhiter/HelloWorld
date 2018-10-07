package day02;

import java.util.ArrayList;
import java.util.List;


public class Master {
	//创建歌单数组
	public static List<Song> listsong=new ArrayList<>();
	/*
	 * 构造函数
	 * 初始化listsong
	 */
	public Master()
	{
	}
	
	public boolean play()
	{
		if(!listsong.isEmpty())
		{
			System.out.println("当前播放歌曲："+listsong.get(0).songname);
			listsong.remove(0);//删除当前歌曲
			return true;
		}
		else return false;
	}
}
