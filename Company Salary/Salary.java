package day05;


public class Salary {
		public static double profit;//定义公司利润
		//定义公司营业额
		public static double turnover = Math.random() * 10000 + 100000000;
}

//HashSet下的Staff类，继承Person
class Staff extends Person
{
	//员工工资
	public Staff()
	{
		salary=Math.random()*5000+7000;
	}
	//员工信息
	public String toString()
	{
		return   "员工"+"     "+"姓名："+name+"     "
				+"出生年月："+Birth()+"     "
				+"工资："+String.format("%.2f",salary)+"     "
				+persent()+"!";
	}
}

//HashSet下的Manager类，继承Person
class Manager extends Person
{
	public double bouns;//定义奖金
	//经理工资及奖金
	public Manager()
	{
		salary=Math.random()*5000+10000;
		bouns=Math.random()*1000+8000;
	}
	//经理信息
	public String toString()
	{
		return   "经理"+"     "+"姓名："+name+"     "
				+"出生年月："+Birth()+"     "
				+"工资："+String.format("%.2f",salary)+"     "
				+"奖金："+String.format("%.2f", bouns);
	}
}

//HashSet下的SH类，继承Person
class SH extends Person
{
	public int shares;//定义年分红
	public SH(int shares)
	{
		this.shares=shares;
	}
	
	//股东分红
	public double Yearshares()
	{
		return Salary.profit*0.1;
	}
	//股东信息
	public String toString()
	{
		return   "股东"+"     "+"姓名："+name+"     "
				+"出生年月："+Birth()+"     "
				+"年分红："+String.format("%.2f", Yearshares());
	}
}


