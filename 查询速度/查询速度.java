package day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Test1 {
	public static int length=2000000;//������ҳ���
	public static void main(String[] args)
	{
		/*
		 * List�����ٶȲ���
		 */
		List<Integer> list=new ArrayList<>();
		Long ListStart=System.currentTimeMillis();
		for(int i=0;i<length;i++)
		{
			list.add(i);
		}
		Long ListEnd=System.currentTimeMillis();
		System.out.println("List��ѯ"+length+"ʱ�䣺"+(ListEnd-ListStart)+"ms");
		
		/*
		 * Map�����ٶȲ���
		 */
		Map<Integer,Integer> map=new HashMap<>();
		Long MapStart=System.currentTimeMillis();
		for(int i=0;i<length;i++)
		{
			map.put(i, i);
		}
		Long MapEnd=System.currentTimeMillis();
		System.out.println("Map��ѯ"+length+"ʱ�䣺"+(MapEnd-MapStart)+"ms");
		
		/*
		 * Set�����ٶȲ���
		 */
		Set<Integer> set=new HashSet<>();
		Long SetStart=System.currentTimeMillis();
		for(int i=0;i<length;i++)
		{
			set.add(i);
		}
		Long SetEnd=System.currentTimeMillis();
		System.out.println("Set��ѯ"+length+"ʱ�䣺"+(SetEnd-SetStart)+"ms");
		
		/*
		 * Tree�����ٶȲ���
		 */
		Map<Integer,Integer> tree=new TreeMap<>();
		Long TMapStart=System.currentTimeMillis();
		for(int i=0;i<length;i++)
		{
			tree.put(i, i);
		}
		Long TMapEnd=System.currentTimeMillis();
		System.out.println("Tree��ѯ"+length+"ʱ�䣺"+(TMapEnd-TMapStart)+"ms");
		
		/*
		 * HashSet��ѯ�ٶȲ���
		 */
		HashSet<Integer> hashset=new HashSet<>();
		Long hashStart=System.currentTimeMillis();
		for(int i=0;i<length;i++)
		{
			hashset.add(i);
		}
		Long hashEnd=System.currentTimeMillis();
		System.out.println("HashSet��ѯ"+length+"ʱ�䣺"+(hashEnd-hashStart)+"ms");

	}
}
