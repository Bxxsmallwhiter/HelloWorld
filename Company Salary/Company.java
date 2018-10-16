package day05;

import java.util.HashSet;
import java.util.Set;


public class Company {

	public HashSet<Staff> staffSet;//����Ա������
	public HashSet<Manager> managerSet;//����������
	public HashSet<SH> SHSet;//�����ɶ�����
	
	//��ʼ��Ա���������ɶ�
	public Company() 
	{
		this(5,2,1);//Ĭ��5λԱ����2λ����1λ�ɶ�
	}
	
	public Company(int snum,int mnum,int shnum) 
	{
		staffSet = createStaff(snum);//��ʼ������Ա������
		managerSet = createManager(mnum);//��ʼ������������
		SHSet = createSH(shnum);//��ʼ�������ɶ�����
	}

	// ����Ա��
	private HashSet<Staff> createStaff(int num) 
	{
		Set<Staff> setStaff = new HashSet<>();
		while (setStaff.size() < num) 
		{
			setStaff.add(new Staff());
		}
		return (HashSet<Staff>) setStaff;
	}

	// ���ɾ���
	private HashSet<Manager> createManager(int num) 
	{
		Set<Manager> setManager = new HashSet<>();
		while (setManager.size() < num) 
		{
			setManager.add(new Manager());
		}
		return (HashSet<Manager>) setManager;
	}

	// ���ɹɶ�
	private HashSet<SH> createSH(int num) 
	{
		//��˾����=��˾Ӫҵ��-��˾��Ա��������֧��
		Salary.profit = Salary.turnover - Company.AllPay(staffSet, managerSet);
		Set<SH> setShareHolder = new HashSet<>();
		//��˾�ܹɷ�
		int shareAll = 100;
		//��ǰnum-1���ɶ�ͨ������������ɶ��ɷ�
		while (setShareHolder.size() < num-1) 
		{
			int shares = (int)(Math.random()*(shareAll - 10)) + 10;
			shareAll = shareAll - shares;
			setShareHolder.add(new SH(shares));
		}
		//���һ���ɶ��Ĺɷ�Ϊʣ�µĹɷ�
		setShareHolder.add(new SH(shareAll));
		shareAll = 0;
		return (HashSet<SH>) setShareHolder;
	}
	
	//���㹫˾֧��Ա��������
	public static double AllPay(HashSet<Staff> setStaff,HashSet<Manager> setManager) 
	{
		double sum = 0;
		//����Ա������
		for(Staff staff:setStaff) 
		{
			sum = sum + staff.salary*12;
		}
		//���㾭���ʼ�����
		for(Manager manager:setManager)
		{
			sum=sum+(manager.salary+manager.bouns)*12;
		}
		return sum;
	}

	//��ʾԱ����Ϣ
	public void StaffprintInfo() 
	{
		for(Staff staff:staffSet) 
		{
			System.out.println(staff);
		}
	}
	
	//��ʾ������Ϣ
	public void ManagerprintInfo() 
	{
		for(Manager manager:managerSet) 
		{
			System.out.println(manager);
		}
	}
	
	//��ʾ�ɶ���Ϣ
	public void ShareHolderprintInfo() 
	{
		for(SH shareHolder:SHSet) 
		{
			System.out.println(shareHolder);
		}
	}
	
	
}
