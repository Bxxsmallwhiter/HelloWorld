package day01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		List<Date>list=new ArrayList<>();
			try {
				for(int cnt=0;cnt<10;cnt++) {
				Date date=dateformat.parse("09-12");
				list.add(date);
				}
			}catch(ParseException e) {
				e.printStackTrace();
			}
		}
	}


