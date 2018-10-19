package com.yi.shoot;

import java.util.Random;

/**
 * ��װ�۷�����Ժ͹��ܵ���
 * @author A556U
 *
 */
public class Bee extends Flyer {
	public static final int DOUBLE_FIRE=0;//��������Ϊ0������˫������
	public static final int LIFE=1;//��������Ϊ1������һ������
	
	/*�۷����˽�г�Ա*/
	private int xspeed=1;//ˮƽ����1����λ
	private int yspeed=2;//��ֱ����2����λ
	private int awardType;//��ǰ�۷䱣��Ľ�������
	//����ȡ����
	public int getAwardType()
	{
		return awardType;
	}
	/**
	 * �۷���޲ι��췽��
	 */
	public Bee()
	{
		image=ShootGame.bee;
		width=image.getWidth();
		height=image.getHeight();
		y=-height;//��ʼ����߶�Ϊ-height
		Random r=new Random();
		x=r.nextInt(ShootGame.WIDTH-width);
		awardType=r.nextInt(2);
	}
	
	@Override
	public void step() {
		// TODO Auto-generated method stub
		//ÿ��x�ƶ�һ����λ,y�ƶ�1����λ
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
		//�۷�y����>��Ϸ����߶Ⱦ���Խ��
		return y>ShootGame.HEIGHT;
	}
}
