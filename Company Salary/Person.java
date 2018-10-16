package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Person {
	public String name;//定义姓名
	public double salary;//定义工资
	public Calendar birthday;//定义生日

	public Person()
	{
		/*
		 * 创建随机姓名
		 * 姓由name1随机生成
		 * 名由name2随机生成
		 */
		String[] name1= {"赵","钱","孙","李","周","吴","郑","王"};
		String[] name2= {"天","地","山","水","辛","岩","茂","器"};
		List<String> name1List=new ArrayList<>(Arrays.asList(name1));
		List<String> name2List=new ArrayList<>(Arrays.asList(name2));
		//随机从name1抽取姓，从name2抽取名
		name=name1List.get((int)(Math.random()*8))+name2List.get((int)(Math.random()*8));
	}
	
	/*
	 * 随机创建生日
	 */
	public String Birth()
	{
		birthday=Calendar.getInstance();//创建一个日历
		int year=birthday.get(Calendar.YEAR)-(int)(Math.random()*35+20);//年龄出生=从当前年份-[20~75)随机数
		int month=(int)(Math.random()*12+1);//随机12月
		int day=(int)(Math.random()*30+1);//随机30天
		birthday.set(year, month,day);//传递birthday的年月日
		return year+"年"+month+"月"+day+"日";
	}

	// 判断当月是否是此人的生日
	public boolean isBirthday() 
	{
		Calendar calendar = Calendar.getInstance();
		return (birthday.get(birthday.MONTH) == calendar.MONTH);//返回当月是否为生日
	}

	/*
	 * 判断当月是否为生日，如果是，则给出相应的奖励
	 * 				 如果不是，则没有奖励
	 */
	public String persent()
	{
		if(isBirthday())
		{
			String[] persent= {"带薪休一周","工资+5%","三日旅游","生日礼包"};
			List<String> persents=new ArrayList<>(Arrays.asList(persent));
			return "当月为员工生日，奖励："+persents.get((int)(Math.random()*4));
		}
		else return "当月不为生日，没有奖励";
	}
}
