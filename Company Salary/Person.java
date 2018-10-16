package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Person {
	public String name;//��������
	public double salary;//���幤��
	public Calendar birthday;//��������

	public Person()
	{
		/*
		 * �����������
		 * ����name1�������
		 * ����name2�������
		 */
		String[] name1= {"��","Ǯ","��","��","��","��","֣","��"};
		String[] name2= {"��","��","ɽ","ˮ","��","��","ï","��"};
		List<String> name1List=new ArrayList<>(Arrays.asList(name1));
		List<String> name2List=new ArrayList<>(Arrays.asList(name2));
		//�����name1��ȡ�գ���name2��ȡ��
		name=name1List.get((int)(Math.random()*8))+name2List.get((int)(Math.random()*8));
	}
	
	/*
	 * �����������
	 */
	public String Birth()
	{
		birthday=Calendar.getInstance();//����һ������
		int year=birthday.get(Calendar.YEAR)-(int)(Math.random()*35+20);//�������=�ӵ�ǰ���-[20~40)�����
		int month=(int)(Math.random()*12+1);//���12��
		int day=(int)(Math.random()*30+1);//���30��
		birthday.set(year, month,day);
		return year+"��"+month+"��"+day+"��";
	}

	// �жϵ����Ƿ��Ǵ��˵�����
	public boolean isBirthday() 
	{
		Calendar calendar = Calendar.getInstance();
		return (birthday.get(birthday.MONTH) == calendar.MONTH);
	}

	/*
	 * �жϵ����Ƿ�Ϊ���գ�����ǣ��������Ӧ�Ľ���
	 * 				 ������ǣ���û�н���
	 */
	public String persent()
	{
		if(isBirthday())
		{
			String[] persent= {"��н��һ��","����+5%","��������","�������"};
			List<String> persents=new ArrayList<>(Arrays.asList(persent));
			return "����ΪԱ�����գ�������"+persents.get((int)(Math.random()*4));
		}
		else return "���²�Ϊ���գ�û�н���";
	}
}
