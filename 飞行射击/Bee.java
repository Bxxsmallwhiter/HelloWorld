package com.yi.shoot;

import java.util.Random;

/**
 * 封装蜜蜂的属性和功能的类
 * @author A556U
 *
 */
public class Bee extends Flyer {
	public static final int DOUBLE_FIRE=0;//奖励类型为0，奖励双倍火力
	public static final int LIFE=1;//奖励类型为1，奖励一次生命
	
	/*蜜蜂类的私有成员*/
	private int xspeed=1;//水平移速1个单位
	private int yspeed=2;//垂直移速2个单位
	private int awardType;//当前蜜蜂保存的奖励类型
	//外界获取奖励
	public int getAwardType()
	{
		return awardType;
	}
	/**
	 * 蜜蜂的无参构造方法
	 */
	public Bee()
	{
		image=ShootGame.bee;
		width=image.getWidth();
		height=image.getHeight();
		y=-height;//开始下落高度为-height
		Random r=new Random();
		x=r.nextInt(ShootGame.WIDTH-width);
		awardType=r.nextInt(2);
	}
	
	@Override
	public void step() {
		// TODO Auto-generated method stub
		//每次x移动一个单位,y移动1个单位
		x+=xspeed;
		y+=yspeed;
		if(x<0||x>(ShootGame.WIDTH-width))
		{
			xspeed*=-1;
		}
	}
	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		//蜜蜂y坐标>游戏界面高度就算越界
		return y>ShootGame.HEIGHT;
	}
}
