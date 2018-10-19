package com.yi.shoot;
/**
 * 封装子弹属性和功能的类
 * @author A556U
 *
 */
public class Bullet extends Flyer {
	private int speed=4;//子弹上升速度3个单位
	/**
	 * 子弹的带参构造方法
	 * @param x 飞机指定子弹创建的x坐标
	 * @param y 飞机指定子弹创建的y坐标
	 */
	public Bullet(int x,int y)
	{
		image=ShootGame.bullet;
		width=image.getWidth();
		height=image.getHeight();
		this.x=x;
		this.y=y;
	}
	
	@Override
	public void step() {
		// TODO Auto-generated method stub
		y-=speed;//每次向上移动一个单位
	}

	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		//子弹y坐标+子弹高度<0为越界
		return y+height<0;
	}
}
