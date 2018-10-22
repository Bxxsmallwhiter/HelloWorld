package day06;

public abstract class Transportation {
	public String Trans()
	{
		int time1=(int)(Math.random()*50+40);
		int time2=(int)(Math.random()*10+3);
		int time3=(int)(Math.random()*5+3);
		int time4=(int)(Math.random()*40+20);
		return 	 "到站所需时间:"+time1+"min"+"  "
				+"返回所需时间:"+time1+"min"+"  "
				+"取票时间:"+time2+"min"+"  "
				+"安检时间:"+time3+"min"+"  "
				+"等候时间:"+time4+"min"+"  ";
	}
	
	public abstract double price();
	public abstract double Speed();
}
