package day01;

import java.util.Scanner;

public class GuessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义输入变量
		int input=0;//保存用户的输入
		//定义输出变量
		int score=0;
		System.out.println("请输入数字：");
		Scanner sc=new Scanner(System.in);
		//随机生成数，生成5次
		for(int i=0;i<5;i++)
		{
			int a=(int)(Math.random()*5+1);//在1~5之间生成随机数
			input=sc.nextInt();
			/*输入数字不得超过1~5，超过即输出范围：输入错误，并且视为答错
			且浪费一次机会*/
			if(input<1||input>5)
			{
				System.out.println("输入错误！");
			}
			//猜对，得分+2，猜错，不得分
			if(a==input)
			{
				System.out.println("得分+2");
				score+=2;
			}
			else {
				System.out.println("答错！");
			}
		}
		System.out.println("最后得分："+score);//最后输出结果
	}

}
运行结果：
请输入数字：
2
答错！
3
得分+2
1
答错！
4
答错！
1
得分+2
最后得分：4