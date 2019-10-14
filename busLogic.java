package sjk;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class busLogic {
	//将得到的查询内容转换成查询SQL语句
	public static  String sql_transfer(String str) {
		String sql;
		sql="select"+" [日期],"+"["+str+"]"+" from dbo.[实验数据：上证某公司股市数据] ";
		//System.out.println("查询内容为:"+sql); 
		return sql;
	}
	//将结果集转化成XYDataset
	public static XYDataset createDataset(ResultSet res,String [] a) {
		XYDataset dataset;
		ArrayList<String> Listlist1 = new ArrayList<String>();
		ArrayList<String> Listlist2 = new ArrayList<String>() ;
		   //显示表格内容
		try {
			while(res.next())
			 {
	     		
	     		Listlist1.add(res.getString(1));
	     		//System.out.println(res.getString(1)); 
	     		Listlist2.add(res.getString(2));
	     		//System.out.println(res.getString(2)); 
	     		
			  }
		}catch(Exception e) {
			//TOOD Auto-generated catch block
			e.printStackTrace();
		}
		//转化为中间件
		Day day;
		double data;
		//转化为series
		TimeSeries series = new TimeSeries("timeSeries");
		for(int i=0;i<Listlist1.size();i++) {
			data =Double.parseDouble(Listlist2.get(i));
			//System.out.println("数据为:"+data);
			/*
			 * day=Day.parseDay(Listlist1.get(i)); 
			 * System.out.println("时间为:"+day);
			 */
			
			 int year=Integer.parseInt((Listlist1.get(i).substring(0, 4))); 
			 System.out.println("年:"+year);
			 int month=Integer.parseInt((Listlist1.get(i).substring(5,7)));
			 System.out.println("月:"+month);
			 int thatday=Integer.parseInt((Listlist1.get(i).substring(8,10)));			  			 
			 System.out.println("日:"+thatday); 
			 day=new Day(thatday,month,year);
			 series.add(day,data);
		

		}
		dataset =new TimeSeriesCollection(series);
		return dataset;
		
	}
}
