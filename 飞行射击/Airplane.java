package com.yi.shoot;

import java.util.Random;

/**
 * ��װ�л������Ժ͹��ܵ���
 * @author A556U
 *
 */
public class Airplane extends Flyer {
	private int speed=3;//�л�����2����λ
	private int score=5;//�л������Ķ������
	public int getScore()
	{
		return score;
	}
	/**
	 * �л��޲ι��췽��
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
		//ÿ�������ƶ�һ����λ
		y+=speed;
		
	}
	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		//�л�y����>��Ϸ����߶Ⱦ���Խ��
		return y>ShootGame.HEIGHT;
	}
}
