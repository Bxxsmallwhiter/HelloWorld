package day06;

public abstract class Transportation {
	public String Trans()
	{
		int time1=(int)(Math.random()*50+40);
		int time2=(int)(Math.random()*10+3);
		int time3=(int)(Math.random()*5+3);
		int time4=(int)(Math.random()*40+20);
		return 	 "��վ����ʱ��:"+time1+"min"+"  "
				+"��������ʱ��:"+time1+"min"+"  "
				+"ȡƱʱ��:"+time2+"min"+"  "
				+"����ʱ��:"+time3+"min"+"  "
				+"�Ⱥ�ʱ��:"+time4+"min"+"  ";
	}
	
	public abstract double price();
	public abstract double Speed();
}
