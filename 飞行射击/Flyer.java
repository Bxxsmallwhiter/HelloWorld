package com.yi.shoot;

import java.awt.image.BufferedImage;

/**
 * 封装所有飞行物的类
 * @author A556U
 *
 */
public abstract class Flyer {
	protected int x;//飞行物左上角x坐标
	protected int y;//飞行物左上角y坐标
	protected int width;//飞行物的宽的
	protected int height;//飞行物的高度
	//Java保存图片使用BufferedImage
	protected BufferedImage image;
	/**
	 * 要求所有飞行物都能移动
	 * 移动方式由自己子类实现
	 */
	public abstract void step();
	/**
	 * 检查越界
	 */
	public abstract boolean outOfBounds();
	/**
	 * 专门检测两个飞行物是否碰撞的工具方法
	 * @param f1
	 * @param f2
	 * @return 返回true 碰撞
	 */
	public static boolean bang(Flyer f1,Flyer f2)
	{
		//两个矩形的中心点
		int f1x=f1.x+f1.width/2;
		int f1y=f1.y+f1.height/2;
		int f2x=f2.x+f2.width/2;
		int f2y=f2.y+f2.height/2;
		boolean H=Math.abs(f1x-f2x)<(f1.width+f2.width)/2;
		boolean V=Math.abs(f1y-f2y)<(f1.height+f2.height)/2;
		return H&V;
	}
}
