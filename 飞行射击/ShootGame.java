package com.yi.shoot;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShootGame extends JPanel {
	//游戏界面大小
	public static final int WIDTH=400;
	public static final int HEIGHT=700;
	
	/*
	 * 游戏启动从硬盘加载所有要用的图片到内存
	 * 仅在启动加载一次--静态块
	 * 缓存在程序的图片反复使用，仅保存一份--静态变量
	 */
	public static BufferedImage background;//背景图片
	public static BufferedImage start;//开始图片
	public static BufferedImage airplane;//敌机图片
	public static BufferedImage bee;//蜜蜂图片
	public static BufferedImage bullet;//子弹图片
	public static BufferedImage hero0;//飞机图片
	public static BufferedImage hero1;
	public static BufferedImage pause;//暂停图片
	public static BufferedImage gameover;//结束图片
	
	/*
	 * 为游戏中角色定义数据结构：
	 * 1个飞机
	 * 1个存储所有敌机对象的数组
	 * 1个存储所有子弹对象的数组
	 */
	public Hero hero=new Hero();
	public Flyer[] flyers= {};//存储敌机对象
	public Bullet[] bullets= {};//存储子弹对象
	
	//定义游戏状态，当前状态为默认开始
	
	
	static {
		/*
		 * Java中从硬盘加载图片到内存方法：
		 * ImageIO.read方法
		 */
		try {
			background=ImageIO.read(ShootGame.class.getResource("background.png"));
			airplane=ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee=ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet=ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0=ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1=ImageIO.read(ShootGame.class.getResource("hero1.png"));
			start=ImageIO.read(ShootGame.class.getResource("start.png"));
			pause=ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover=ImageIO.read(ShootGame.class.getResource("gameover.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Java中绘制窗体：JFrame对象--窗框
		 * 背景面板--JPanel
		 */
		JFrame frame=new JFrame("Fly");
		frame.setSize(WIDTH,HEIGHT);
		frame.setAlwaysOnTop(true);//设置窗体总在最上，不被其他窗体挡住
		//关闭窗体同时，退出程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);//设置窗体初始位置
		/*在窗体中嵌入背景对象--JPanel*/
		ShootGame game=new ShootGame();
		frame.add(game);
		/*显示调用setVisible方法*/
		frame.setVisible(true);//自动调用窗体paint方法
		game.action();
	}
	/**
	 * 游戏启动时要做的事
	 */
	public void action()
	{
		//定义鼠标事件监听
		//创建MouseAdapter匿名内部类
		MouseAdapter l=new MouseAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
				int x=e.getX();
				int y=e.getY();
				hero.move(x, y);
			}
			
		};
		//要响应鼠标事件，必须将鼠标事件添加到程序的监听器
		this.addMouseMotionListener(l);
		
		//创建定时器
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			//定义一个计时器变量
			private int runTimes=0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				runTimes++;//每执行一次，加1
				if(runTimes%50==0)
				{
					//自动随机创建对象
					nextOne();
				}
				//遍历每个对象
				for(int i=0;i<flyers.length;i++)
				{
					flyers[i].step();
				}
				//每300毫秒创建一次子弹
				if(runTimes%30==0)
				{
					shoot();
				}
				//遍历子弹数组
				for(int i=0;i<bullets.length;i++)
				{
					bullets[i].step();
				}
				//添加子弹击中敌人的碰撞检测
				bang();
				//敌人和飞机碰撞的检测
				hit();
				//添加越界销毁
				outOfBounds();
			
				//只要界面发生变化，必须调用repaint方法重新绘制界面
				repaint();
			}
		
		}, 10,10);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(ShootGame.background, 0, 0, null);
		paintHero(g);//绘制飞机
		paintFlyers(g);//绘制敌机
		paintBullets(g);//绘制子弹
		paintScore_Life(g);//绘制分数和得分
		
		
	}
	
	//绘制飞机方法
	public void paintHero(Graphics g)
	{
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	//批量绘制敌机方法
	public void paintFlyers(Graphics g)
	{
		for(int i=0;i<flyers.length;i++)
		{
			g.drawImage(flyers[i].image, flyers[i].x, flyers[i].y, null);
		}
	}
	//绘制子弹对象
	public void paintBullets(Graphics g)
	{
		for(int i=0;i<bullets.length;i++)
		{
			g.drawImage(bullets[i].image, bullets[i].x, bullets[i].y, null);
		}
	}
	/**
	 * 随机生成1个敌人对象
	 * 每生成一个新敌人，flyers数组都要扩容1
	 * 然后将新敌人放入数组最后一个元素
	 */
	public void nextOne()
	{
		Random r=new Random();
		Flyer f=null;
		if(r.nextInt(20)==10||r.nextInt(20)==0||r.nextInt(20)==15)
		{
			f=new Bee();
		}
		else {f=new Airplane();}
		//先对flyers数组扩容1
		flyers=Arrays.copyOf(flyers, flyers.length+1);
		flyers[flyers.length-1]=f;
	}
	/*
	 * 获得飞机对象发射的子弹对象
	 */
	public void shoot()
	{
		Bullet[] newBullets=hero.shoot();//获得飞机返回的新子弹数组
		bullets=Arrays.copyOf(bullets, bullets.length+newBullets.length);
		System.arraycopy(newBullets, 0, bullets, bullets.length-newBullets.length, newBullets.length);
	}
	/**
	 * 遍历子弹数组和敌人数组，进行碰撞检测
	 * 一旦碰撞，都减少一个
	 */
	public void bang()
	{
		for(int i=0;i<bullets.length;i++)
		{
			for(int j=0;j<flyers.length;j++)
			{
				if(Flyer.bang(bullets[i], flyers[j]))
				{
					//获得奖励
					hero.getScore_Award(flyers[j]);
					//从敌人数组中删除击中的敌机
					//使用数组最后一个元素替换当前位置被击中的敌机
					flyers[j]=flyers[flyers.length-1];
					//压缩数组，元素个数-1
					flyers=Arrays.copyOf(flyers, flyers.length-1);
					//从子弹数组中删除击中敌机的子弹
					bullets[i]=bullets[bullets.length-1];
					bullets=Arrays.copyOf(bullets,bullets.length-1);
					i--;
					break;
				}
			}
		}
	}
	/**
	 * 绘制得分与生命值的方法
	 * @param g
	 */
	public void paintScore_Life(Graphics g)
	{
		int x=10;//文字左上角x坐标
		int y=15;//文字左上角y坐标
		Font font=new Font(Font.SANS_SERIF,Font.BOLD,14);
		g.setFont(font);//设置画笔的字体对象
		g.drawString("得分："+hero.getScore(), x, y);
		y+=20;
		g.drawString("生命值："+hero.getLife(), x, y);
	}
	/**
	 * 检查所有飞行物是否越界
	 */
	public void outOfBounds()
	{
		//检查所有敌人是否越界
		int index=0;
		Flyer[] Flives=new Flyer[flyers.length];
		//遍历敌人数组,将存活的敌人对象保存到新数组中
		for(int i=0;i<flyers.length;i++)
		{
			if(!flyers[i].outOfBounds())
			{
				Flives[index]=flyers[i];
				index++;
			}
		}//index保存当前存活对象的个数
		//压缩存活敌人数组，并且替换敌人数组
		flyers=Arrays.copyOf(Flives,index);
		
		//检测子弹越界
		Bullet[] Blives=new Bullet[bullets.length];
		index=0;
		for(int i=0;i<bullets.length;i++)
		{
			if(!bullets[i].outOfBounds())
			{
				Blives[index]=bullets[i];
				index++;
			}
		}
		//压缩存活子弹数组，并且替换子弹数组
		bullets=Arrays.copyOf(Blives, index);
	}
	/**
	 * 遍历敌人数组，飞机和每个敌人碰撞
	 */
	public void hit()
	{
		Flyer[] lives=new Flyer[flyers.length];
		int index=0;
		for(int i=0;i<flyers.length;i++)
		{
			if(!hero.hit(flyers[i]))
			{
				lives[index]=flyers[i];
				index++;
			}
		}
		//压缩存活敌人数组，并且替换敌人数组
		flyers=Arrays.copyOf(lives, index);
	}
	
}
