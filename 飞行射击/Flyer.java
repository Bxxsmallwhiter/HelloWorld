package com.yi.shoot;

import java.awt.image.BufferedImage;

/**
 * ��װ���з��������
 * @author A556U
 *
 */
public abstract class Flyer {
	protected int x;//���������Ͻ�x����
	protected int y;//���������Ͻ�y����
	protected int width;//������Ŀ��
	protected int height;//������ĸ߶�
	//Java����ͼƬʹ��BufferedImage
	protected BufferedImage image;
	/**
	 * Ҫ�����з����ﶼ���ƶ�
	 * �ƶ���ʽ���Լ�����ʵ��
	 */
	public abstract void step();
	/**
	 * ���Խ��
	 */
	public abstract boolean outOfBounds();
	/**
	 * ר�ż�������������Ƿ���ײ�Ĺ��߷���
	 * @param f1
	 * @param f2
	 * @return ����true ��ײ
	 */
	public static boolean bang(Flyer f1,Flyer f2)
	{
		//�������ε����ĵ�
		int f1x=f1.x+f1.width/2;
		int f1y=f1.y+f1.height/2;
		int f2x=f2.x+f2.width/2;
		int f2y=f2.y+f2.height/2;
		boolean H=Math.abs(f1x-f2x)<(f1.width+f2.width)/2;
		boolean V=Math.abs(f1y-f2y)<(f1.height+f2.height)/2;
		return H&V;
	}
}
