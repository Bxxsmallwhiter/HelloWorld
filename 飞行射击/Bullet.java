package com.yi.shoot;
/**
 * ��װ�ӵ����Ժ͹��ܵ���
 * @author A556U
 *
 */
public class Bullet extends Flyer {
	private int speed=4;//�ӵ������ٶ�3����λ
	/**
	 * �ӵ��Ĵ��ι��췽��
	 * @param x �ɻ�ָ���ӵ�������x����
	 * @param y �ɻ�ָ���ӵ�������y����
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
		y-=speed;//ÿ�������ƶ�һ����λ
	}

	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		//�ӵ�y����+�ӵ��߶�<0ΪԽ��
		return y+height<0;
	}
}
