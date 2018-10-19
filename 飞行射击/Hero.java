package com.yi.shoot;
/**
 * 封装飞机的属性和功能的类
 * @author A556U
 *
 */
public class Hero extends Flyer {
	private int doubleFire;//双倍火力
	private int life;//生命值
	private int score;//得分
	//外界获取生命值
	public int getLife()
	{
		return life;
	}
	//外界获取得分
	public int getScore()
	{
		return score;
	}
	
	/**
	 * 飞机的无参构造方法
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
	 * 飞机随鼠标移动的方法
	 * @param x 鼠标的x坐标
	 * @param y 鼠标的y坐标
	 */
	public void move(int x,int y)
	{
		//传入的x,y是鼠标的位置
		this.x=x-width/2;
		this.y=y-height/2;
	}
	/**
	 * 飞机获得分数和奖励的方法
	 * @param f 是一个父类型的变量
	 *          既可以指向蜜蜂类型，也可指向敌机类型
	 */
	public void getScore_Award(Flyer f)
	{
		//先判断敌人对象类型,instanceof为判断
		if(f instanceof Airplane)
		{
			//如果为敌机，则分数+5
			score+=((Airplane) f).getScore();
		}
		else {
			//如果为蜜蜂类型，判断蜜蜂的奖励类型
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
	 * 飞机发射子弹的方法
	 * @return 新创建子弹对象
	 *         可能为1发，也可能是2发
	 *         所以用数组类型保存返回值
	 */
	public Bullet[] shoot()
	{
		Bullet[] bullets=null;
		//何时创建双倍火力
		if(doubleFire!=0)
		{
			bullets=new Bullet[2];
			Bullet b1=new Bullet(x+width/8,y-ShootGame.bullet.getHeight());
			Bullet b2=new Bullet(x+width*3/5,y-ShootGame.bullet.getHeight());
			bullets[0]=b1;
			bullets[1]=b2;
			//每发射一次，子弹数-2
			doubleFire-=2;
		}
		else {
		//单倍火力
		//子弹位置x坐标：x+飞机/3
		//子弹位置y坐标：y-子弹图片高度
		bullets=new Bullet[1];
		bullets[0]=new Bullet(x+width/3,y-ShootGame.bullet.getHeight());
		}
		return bullets;
	}
	/**
	 * 飞机与敌机碰撞检测的方法
	 * @param f 敌人为蜜蜂或敌机
	 * @return 返回true 碰撞
	 */
	public boolean hit(Flyer f)
	{
		//调用碰撞检测方法
		boolean r=Flyer.bang(this, f);
		if(r) {
			life--;
			doubleFire=0;
		}
		return r;
	}
}
