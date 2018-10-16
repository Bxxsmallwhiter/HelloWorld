package day05;

import java.util.HashSet;
import java.util.Set;


public class Company {

	public HashSet<Staff> staffSet;//创建员工集合
	public HashSet<Manager> managerSet;//创建经理集合
	public HashSet<SH> SHSet;//创建股东集合
	
	//默认5位员工，2位经理，1位股东
	public Company() {
		this(5,2,1);
	}
	
	public Company(int snum,int mnum,int shnum) {
		staffSet = createStaff(snum);
		managerSet = createManager(mnum);
		SHSet = createSH(shnum);
		//公司利润
		Salary.profit = Salary.turnover - Company.AllPay(staffSet, managerSet);
	}

	// 生成员工,num为员工数量
	private HashSet<Staff> createStaff(int num) {
		Set<Staff> setStaff = new HashSet<>();
		while (setStaff.size() < num) 
		{
			setStaff.add(new Staff());
		}
		return (HashSet<Staff>) setStaff;
	}

	// 生成经理,num为经理数量
	private HashSet<Manager> createManager(int num) {
		Set<Manager> setManager = new HashSet<>();
		while (setManager.size() < num) 
		{
			setManager.add(new Manager());
		}
		return (HashSet<Manager>) setManager;
	}

	// 生成股东,num为股东数量
	private HashSet<SH> createSH(int num) {
		Set<SH> setShareHolder = new HashSet<>();
		//公司总股份
		int shareAll = 100;
		//给前num-1个股东通过随机数给各股东股份,
		while (setShareHolder.size() < num-1) 
		{
			int shares = (int)(Math.random()*(shareAll - 10)) + 10;
			shareAll = shareAll - shares;
			setShareHolder.add(new SH(shares));
		}
		//最后一个股东的股份为剩下的股份
		setShareHolder.add(new SH(shareAll));
		shareAll = 0;
		return (HashSet<SH>) setShareHolder;
	}
	
	//计算公司一年员工和经理的工资及奖金
	public static double AllPay(HashSet<Staff> setStaff,HashSet<Manager> setManager) {
		double sum = 0;
		//计算员工工资
		for(Staff staff:setStaff) 
		{
			sum = sum + staff.salary*12;
		}
		//计算经理工资及奖金
		for(Manager manager:setManager)
		{
			sum=sum+(manager.salary+manager.bouns)*12;
		}
		return sum;
	}

	//显示所有员工信息
	public void StaffprintInfo() {
		for(Staff staff:staffSet) 
		{
			System.out.println(staff);
		}
	}
	
	//显示所有经理信息
	public void ManagerprintInfo() {
		for(Manager manager:managerSet) 
		{
			System.out.println(manager);
		}
	}
	
	//显示所有股东信息
	public void ShareHolderprintInfo() {
		for(SH shareHolder:SHSet) 
		{
			System.out.println(shareHolder);
		}
	}
	
	
}
