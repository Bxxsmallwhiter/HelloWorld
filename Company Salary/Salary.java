package day05;


public class Salary {
		public static double profit;//���幫˾����
		//���幫˾Ӫҵ��
		public static double turnover = Math.random() * 10000 + 100000000;
}

//HashSet�µ�Staff�࣬�̳�Person
class Staff extends Person
{
	//Ա������
	public Staff()
	{
		salary=Math.random()*5000+7000;
	}
	//Ա����Ϣ
	public String toString()
	{
		return   "Ա��"+"     "+"������"+name+"     "
				+"�������£�"+Birth()+"     "
				+"���ʣ�"+String.format("%.2f",salary)+"     "
				+persent()+"!";
	}
}

//HashSet�µ�Manager�࣬�̳�Person
class Manager extends Person
{
	public double bouns;//���影��
	//�����ʼ�����
	public Manager()
	{
		salary=Math.random()*5000+10000;
		bouns=Math.random()*1000+8000;
	}
	//������Ϣ
	public String toString()
	{
		return   "����"+"     "+"������"+name+"     "
				+"�������£�"+Birth()+"     "
				+"���ʣ�"+String.format("%.2f",salary)+"     "
				+"����"+String.format("%.2f", bouns);
	}
}

//HashSet�µ�SH�࣬�̳�Person
class SH extends Person
{
	public int shares;//������ֺ�
	public SH(int shares)
	{
		this.shares=shares;
	}
	
	//�ɶ��ֺ�
	public double Yearshares()
	{
		return Salary.profit*0.1;
	}
	//�ɶ���Ϣ
	public String toString()
	{
		return   "�ɶ�"+"     "+"������"+name+"     "
				+"�������£�"+Birth()+"     "
				+"��ֺ죺"+String.format("%.2f", Yearshares());
	}
}


