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
	//��Ϸ�����С
	public static final int WIDTH=400;
	public static final int HEIGHT=700;
	
	/*
	 * ��Ϸ������Ӳ�̼�������Ҫ�õ�ͼƬ���ڴ�
	 * ������������һ��--��̬��
	 * �����ڳ����ͼƬ����ʹ�ã�������һ��--��̬����
	 */
	public static BufferedImage background;//����ͼƬ
	public static BufferedImage start;//��ʼͼƬ
	public static BufferedImage airplane;//�л�ͼƬ
	public static BufferedImage bee;//�۷�ͼƬ
	public static BufferedImage bullet;//�ӵ�ͼƬ
	public static BufferedImage hero0;//�ɻ�ͼƬ
	public static BufferedImage hero1;
	public static BufferedImage pause;//��ͣͼƬ
	public static BufferedImage gameover;//����ͼƬ
	
	/*
	 * Ϊ��Ϸ�н�ɫ�������ݽṹ��
	 * 1���ɻ�
	 * 1���洢���ел����������
	 * 1���洢�����ӵ����������
	 */
	public Hero hero=new Hero();
	public Flyer[] flyers= {};//�洢�л�����
	public Bullet[] bullets= {};//�洢�ӵ�����
	
	//������Ϸ״̬����ǰ״̬ΪĬ�Ͽ�ʼ
	
	
	static {
		/*
		 * Java�д�Ӳ�̼���ͼƬ���ڴ淽����
		 * ImageIO.read����
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
		 * Java�л��ƴ��壺JFrame����--����
		 * �������--JPanel
		 */
		JFrame frame=new JFrame("Fly");
		frame.setSize(WIDTH,HEIGHT);
		frame.setAlwaysOnTop(true);//���ô����������ϣ������������嵲ס
		//�رմ���ͬʱ���˳�����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);//���ô����ʼλ��
		/*�ڴ�����Ƕ�뱳������--JPanel*/
		ShootGame game=new ShootGame();
		frame.add(game);
		/*��ʾ����setVisible����*/
		frame.setVisible(true);//�Զ����ô���paint����
		game.action();
	}
	/**
	 * ��Ϸ����ʱҪ������
	 */
	public void action()
	{
		//��������¼�����
		//����MouseAdapter�����ڲ���
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
		//Ҫ��Ӧ����¼������뽫����¼���ӵ�����ļ�����
		this.addMouseMotionListener(l);
		
		//������ʱ��
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			//����һ����ʱ������
			private int runTimes=0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				runTimes++;//ÿִ��һ�Σ���1
				if(runTimes%50==0)
				{
					//�Զ������������
					nextOne();
				}
				//����ÿ������
				for(int i=0;i<flyers.length;i++)
				{
					flyers[i].step();
				}
				//ÿ300���봴��һ���ӵ�
				if(runTimes%30==0)
				{
					shoot();
				}
				//�����ӵ�����
				for(int i=0;i<bullets.length;i++)
				{
					bullets[i].step();
				}
				//����ӵ����е��˵���ײ���
				bang();
				//���˺ͷɻ���ײ�ļ��
				hit();
				//���Խ������
				outOfBounds();
			
				//ֻҪ���淢���仯���������repaint�������»��ƽ���
				repaint();
			}
		
		}, 10,10);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(ShootGame.background, 0, 0, null);
		paintHero(g);//���Ʒɻ�
		paintFlyers(g);//���Ƶл�
		paintBullets(g);//�����ӵ�
		paintScore_Life(g);//���Ʒ����͵÷�
		
		
	}
	
	//���Ʒɻ�����
	public void paintHero(Graphics g)
	{
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	//�������Ƶл�����
	public void paintFlyers(Graphics g)
	{
		for(int i=0;i<flyers.length;i++)
		{
			g.drawImage(flyers[i].image, flyers[i].x, flyers[i].y, null);
		}
	}
	//�����ӵ�����
	public void paintBullets(Graphics g)
	{
		for(int i=0;i<bullets.length;i++)
		{
			g.drawImage(bullets[i].image, bullets[i].x, bullets[i].y, null);
		}
	}
	/**
	 * �������1�����˶���
	 * ÿ����һ���µ��ˣ�flyers���鶼Ҫ����1
	 * Ȼ���µ��˷����������һ��Ԫ��
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
		//�ȶ�flyers��������1
		flyers=Arrays.copyOf(flyers, flyers.length+1);
		flyers[flyers.length-1]=f;
	}
	/*
	 * ��÷ɻ���������ӵ�����
	 */
	public void shoot()
	{
		Bullet[] newBullets=hero.shoot();//��÷ɻ����ص����ӵ�����
		bullets=Arrays.copyOf(bullets, bullets.length+newBullets.length);
		System.arraycopy(newBullets, 0, bullets, bullets.length-newBullets.length, newBullets.length);
	}
	/**
	 * �����ӵ�����͵������飬������ײ���
	 * һ����ײ��������һ��
	 */
	public void bang()
	{
		for(int i=0;i<bullets.length;i++)
		{
			for(int j=0;j<flyers.length;j++)
			{
				if(Flyer.bang(bullets[i], flyers[j]))
				{
					//��ý���
					hero.getScore_Award(flyers[j]);
					//�ӵ���������ɾ�����еĵл�
					//ʹ���������һ��Ԫ���滻��ǰλ�ñ����еĵл�
					flyers[j]=flyers[flyers.length-1];
					//ѹ�����飬Ԫ�ظ���-1
					flyers=Arrays.copyOf(flyers, flyers.length-1);
					//���ӵ�������ɾ�����ел����ӵ�
					bullets[i]=bullets[bullets.length-1];
					bullets=Arrays.copyOf(bullets,bullets.length-1);
					i--;
					break;
				}
			}
		}
	}
	/**
	 * ���Ƶ÷�������ֵ�ķ���
	 * @param g
	 */
	public void paintScore_Life(Graphics g)
	{
		int x=10;//�������Ͻ�x����
		int y=15;//�������Ͻ�y����
		Font font=new Font(Font.SANS_SERIF,Font.BOLD,14);
		g.setFont(font);//���û��ʵ��������
		g.drawString("�÷֣�"+hero.getScore(), x, y);
		y+=20;
		g.drawString("����ֵ��"+hero.getLife(), x, y);
	}
	/**
	 * ������з������Ƿ�Խ��
	 */
	public void outOfBounds()
	{
		//������е����Ƿ�Խ��
		int index=0;
		Flyer[] Flives=new Flyer[flyers.length];
		//������������,�����ĵ��˶��󱣴浽��������
		for(int i=0;i<flyers.length;i++)
		{
			if(!flyers[i].outOfBounds())
			{
				Flives[index]=flyers[i];
				index++;
			}
		}//index���浱ǰ������ĸ���
		//ѹ�����������飬�����滻��������
		flyers=Arrays.copyOf(Flives,index);
		
		//����ӵ�Խ��
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
		//ѹ������ӵ����飬�����滻�ӵ�����
		bullets=Arrays.copyOf(Blives, index);
	}
	/**
	 * �����������飬�ɻ���ÿ��������ײ
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
		//ѹ�����������飬�����滻��������
		flyers=Arrays.copyOf(lives, index);
	}
	
}
