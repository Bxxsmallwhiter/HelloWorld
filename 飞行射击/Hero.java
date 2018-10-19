package com.yi.shoot;
/**
 * ��װ�ɻ������Ժ͹��ܵ���
 * @author A556U
 *
 */
public class Hero extends Flyer {
	private int doubleFire;//˫������
	private int life;//����ֵ
	private int score;//�÷�
	//����ȡ����ֵ
	public int getLife()
	{
		return life;
	}
	//����ȡ�÷�
	public int getScore()
	{
		return score;
	}
	
	/**
	 * �ɻ����޲ι��췽��
	 */
	public Hero()
	{
		image=ShootGame.hero0;
		width=image.getWidth();
		height=image.getHeight();
		x=150;
		y=450;
		doubleFire=0;
		life=3;
		score=0;
	}
	
	@Override
	public void step() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * �ɻ�������ƶ��ķ���
	 * @param x ����x����
	 * @param y ����y����
	 */
	public void move(int x,int y)
	{
		//�����x,y������λ��
		this.x=x-width/2;
		this.y=y-height/2;
	}
	/**
	 * �ɻ���÷����ͽ����ķ���
	 * @param f ��һ�������͵ı���
	 *          �ȿ���ָ���۷����ͣ�Ҳ��ָ��л�����
	 */
	public void getScore_Award(Flyer f)
	{
		//���жϵ��˶�������,instanceofΪ�ж�
		if(f instanceof Airplane)
		{
			//���Ϊ�л��������+5
			score+=((Airplane) f).getScore();
		}
		else {
			//���Ϊ�۷����ͣ��ж��۷�Ľ�������
			if(((Bee)f).getAwardType()==Bee.DOUBLE_FIRE)
			{
				doubleFire+=60;
			}
			else {
				life+=1;
			}
		}
	}
	/**
	 * �ɻ������ӵ��ķ���
	 * @return �´����ӵ�����
	 *         ����Ϊ1����Ҳ������2��
	 *         �������������ͱ��淵��ֵ
	 */
	public Bullet[] shoot()
	{
		Bullet[] bullets=null;
		//��ʱ����˫������
		if(doubleFire!=0)
		{
			bullets=new Bullet[2];
			Bullet b1=new Bullet(x+width/8,y-ShootGame.bullet.getHeight());
			Bullet b2=new Bullet(x+width*3/5,y-ShootGame.bullet.getHeight());
			bullets[0]=b1;
			bullets[1]=b2;
			//ÿ����һ�Σ��ӵ���-2
			doubleFire-=2;
		}
		else {
		//��������
		//�ӵ�λ��x���꣺x+�ɻ�/3
		//�ӵ�λ��y���꣺y-�ӵ�ͼƬ�߶�
		bullets=new Bullet[1];
		bullets[0]=new Bullet(x+width/3,y-ShootGame.bullet.getHeight());
		}
		return bullets;
	}
	/**
	 * �ɻ���л���ײ���ķ���
	 * @param f ����Ϊ�۷��л�
	 * @return ����true ��ײ
	 */
	public boolean hit(Flyer f)
	{
		//������ײ��ⷽ��
		boolean r=Flyer.bang(this, f);
		if(r) {
			life--;
			doubleFire=0;
		}
		return r;
	}
}
