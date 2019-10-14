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
	//���õ��Ĳ�ѯ����ת���ɲ�ѯSQL���
	public static  String sql_transfer(String str) {
		String sql;
		sql="select"+" [����],"+"["+str+"]"+" from dbo.[ʵ�����ݣ���֤ĳ��˾��������] ";
		//System.out.println("��ѯ����Ϊ:"+sql); 
		return sql;
	}
	//�������ת����XYDataset
	public static XYDataset createDataset(ResultSet res,String [] a) {
		XYDataset dataset;
		ArrayList<String> Listlist1 = new ArrayList<String>();
		ArrayList<String> Listlist2 = new ArrayList<String>() ;
		   //��ʾ�������
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
		//ת��Ϊ�м��
		Day day;
		double data;
		//ת��Ϊseries
		TimeSeries series = new TimeSeries("timeSeries");
		for(int i=0;i<Listlist1.size();i++) {
			data =Double.parseDouble(Listlist2.get(i));
			//System.out.println("����Ϊ:"+data);
			/*
			 * day=Day.parseDay(Listlist1.get(i)); 
			 * System.out.println("ʱ��Ϊ:"+day);
			 */
			
			 int year=Integer.parseInt((Listlist1.get(i).substring(0, 4))); 
			 System.out.println("��:"+year);
			 int month=Integer.parseInt((Listlist1.get(i).substring(5,7)));
			 System.out.println("��:"+month);
			 int thatday=Integer.parseInt((Listlist1.get(i).substring(8,10)));			  			 
			 System.out.println("��:"+thatday); 
			 day=new Day(thatday,month,year);
			 series.add(day,data);
		

		}
		dataset =new TimeSeriesCollection(series);
		return dataset;
		
	}
}
