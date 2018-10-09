package day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Test1 {
	public static int length=2000000;//定义查找长度
	public static void main(String[] args)
	{
		/*
		 * List查找速度测试
		 */
		List<Integer> list=new ArrayList<>();
		Long ListStart=System.currentTimeMillis();
		for(int i=0;i<length;i++)
		{
			list.add(i);
		}
		Long ListEnd=System.currentTimeMillis();
		System.out.println("List查询"+length+"时间："+(ListEnd-ListStart)+"ms");
		
		/*
		 * Map查找速度测试
		 */
		Map<Integer,Integer> map=new HashMap<>();
		Long MapStart=System.currentTimeMillis();
		for(int i=0;i<length;i++)
		{
			map.put(i, i);
		}
		Long MapEnd=System.currentTimeMillis();
		System.out.println("Map查询"+length+"时间："+(MapEnd-MapStart)+"ms");
		
		/*
		 * Set查找速度测试
		 */
		Set<Integer> set=new HashSet<>();
		Long SetStart=System.currentTimeMillis();
		for(int i=0;i<length;i++)
		{
			set.add(i);
		}
		Long SetEnd=System.currentTimeMillis();
		System.out.println("Set查询"+length+"时间："+(SetEnd-SetStart)+"ms");
		
		/*
		 * Tree查找速度测试
		 */
		Map<Integer,Integer> tree=new TreeMap<>();
		Long TMapStart=System.currentTimeMillis();
		for(int i=0;i<length;i++)
		{
			tree.put(i, i);
		}
		Long TMapEnd=System.currentTimeMillis();
		System.out.println("Tree查询"+length+"时间："+(TMapEnd-TMapStart)+"ms");
		
		/*
		 * HashSet查询速度测试
		 */
		HashSet<Integer> hashset=new HashSet<>();
		Long hashStart=System.currentTimeMillis();
		for(int i=0;i<length;i++)
		{
			hashset.add(i);
		}
		Long hashEnd=System.currentTimeMillis();
		System.out.println("HashSet查询"+length+"时间："+(hashEnd-hashStart)+"ms");

	}
}
