package com.yi.shoot;

import java.util.Random;

/**
 * 封装敌机的属性和功能的类
 * @author A556U
 *
 */
public class Airplane extends Flyer {
	private int speed=3;//敌机下落2个单位
	private int score=5;//敌机包含的额奖励分数
	public int getScore()
	{
		return score;
	}
	/**
	 * 敌机无参构造方法
	 */
	public Airplane()
	{
		image=ShootGame.airplane;
		width=image.getWidth();
		height=image.getHeight();
		y=-height;
		Random r=new Random();
		x=r.nextInt(ShootGame.WIDTH-width);
	}
	
	@Override
	public void step() {
		// TODO Auto-generated method stub
		//每次向下移动一个单位
		y+=speed;
		
	}
	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		//敌机y坐标>游戏界面高度就算越界
		return y>ShootGame.HEIGHT;
	}
}
