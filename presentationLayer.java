package sjk;
import java.awt.*;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class presentationLayer {
		static Choice A;
		JPanel p;
		public static  JTextField j1;
		public static JTextField j2;
		public static JTextField j3;
		public static JTextField j4;
		public static JTextField j5;
		public static JTextField j6;

		presentationLayer(){
			JFrame frame=new JFrame();
			frame.setTitle("上证某公司股市数据查询");
			
			JPanel p=new JPanel();
			frame.getContentPane().add(p);
	
			JTextField j1 = new JTextField(10);
			JLabel Label1 = new JLabel("起始年:");
			p.add(Label1);
			p.add(j1);

			JTextField j2 = new JTextField(10);
			JLabel Label2 = new JLabel("起始月:");
			p.add(Label2);
			p.add(j2);

			JTextField j3 = new JTextField(10);
			JLabel Label3 = new JLabel("起始日:");
			p.add(Label3);
			p.add(j3);
	        
	        JTextField j4=new JTextField(10);
			JLabel Label4=new JLabel("截止年:");
			p.add(Label4);
	        p.add(j4);

	        JTextField j5=new JTextField(10);
			JLabel Label5=new JLabel("截止月:");
			p.add(Label5);
	        p.add(j5);
	        
	        JTextField j6=new JTextField(10);
			JLabel Label6=new JLabel("截止日:");
			p.add(Label6);
	        p.add(j6);
	        
	        
	        
	        JButton button1=new JButton("查询");
	        JButton button2=new JButton("取消");
	        p.add(button1);
	        p.add(button2);
	        button1.addActionListener(new ActionListener() {
	        	 @Override 
	        	 public void actionPerformed(ActionEvent e) {
	        		// TODO 自动生成的方法存根
	        		 if(e.getActionCommand().equals("查询")){
	        			 //String [] a= {(String) j1.getText(),(String) j2.getText(),(String) j3.getText(),(String) j4.getText(),(String) j5.getText(),(String) j6.getText()};
	        			//System.out.println("结果为"+a);  
	        			 	String str =(String)A.getSelectedItem();
	        				System.out.println(str); 
	        				String [] a= {(String) j1.getText(),(String) j2.getText(),(String) j3.getText(),(String) j4.getText(),(String) j5.getText(),(String) j6.getText()};
	        				System.out.println(a);   
	        				String str2=busLogic.sql_transfer(str);
	        				System.out.println(str2);   
	        				ResultSet res=dbConnection.select(str2);
	        				System.out.println(res);   
	        				
	        				XYDataset dataset=busLogic.createDataset(res,a);
	        				 //这里的"name"参数；是什么意思我也不知道，反正这样可以用  
	        		        StandardChartTheme standardChartTheme = new StandardChartTheme("name");  
	        		        //可以改变轴向的字体  
	        		        standardChartTheme.setLargeFont(new Font("楷体",Font.BOLD, 12));  
	        		        //可以改变图例的字体  
	        		        standardChartTheme.setRegularFont(new Font("宋体",Font.BOLD, 8));  
	        		        //可以改变图标的标题字体  
	        		        standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD, 20));  
//	        		        ChartFactory.setChartTheme(standardChartTheme);//设置主题  
	        		        // 创建JFreeChart对象：ChartFactory.createLineChart  
	        		        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(
	        		        		str+"拆线图",
	        		        		"时间", 
	        		        		"数据", 
	        		        		dataset, 
	        		        		true,
	        		        		true, 
	        		        		false);  
	        		        // 使用CategoryPlot设置各种参数。以下设置可以省略。  
					/*
					 * CategoryPlot plot = (CategoryPlot) jfreechart.getPlot(); // 背景色 透明度
					 * plot.setBackgroundAlpha(0.5f); // 前景色 透明度 plot.setForegroundAlpha(0.5f); //
					 * 其他设置 参考 CategoryPlot类
					 */	        		        ChartPanel panll=new ChartPanel(jfreechart);
	        		      
	        		        JFrame jf=new JFrame();
	        		        jf.add(panll);
	        		        jf.setSize(500, 300);
	        		        jf.setVisible(true);
	        		 }
	        	 }
	        });
	        button2.addActionListener(new ActionListener() {
	        	 @Override 
	        	 public void actionPerformed(ActionEvent e) {
	        		// TODO 自动生成的方法存根
	        		 if(e.getActionCommand().equals("取消")){
	        			 System.exit(0);
	        		 }
	        	 }
	        });
			frame.add(p);
			
	        frame.setLayout(new FlowLayout());
			A=new Choice();
			A.add("开盘价(元)");
			A.add("收盘价(元)");
			A.add("成交金额(元)");
			frame.add(A);
			frame.setSize(1200,300);
			frame.setVisible(true);
		}
		
		public static void paint() {
		/*
		 * String str =(String)A.getSelectedItem(); System.out.println(str); String []
		 * a= {(String) j1.getText(),(String) j2.getText(),(String)
		 * j3.getText(),(String) j4.getText(),(String) j5.getText(),(String)
		 * j6.getText()}; System.out.println(a); String str2=busLogic.sql_transfer(str);
		 * System.out.println(str2); ResultSet res=dbConnection.select(str2);
		 * System.out.println(res);
		 * 
		 * XYDataset dataset=busLogic.createDataset(res);
		 * //这里的"name"参数；是什么意思我也不知道，反正这样可以用 StandardChartTheme standardChartTheme = new
		 * StandardChartTheme("name"); //可以改变轴向的字体 standardChartTheme.setLargeFont(new
		 * Font("楷体",Font.BOLD, 12)); //可以改变图例的字体 standardChartTheme.setRegularFont(new
		 * Font("宋体",Font.BOLD, 8)); //可以改变图标的标题字体
		 * standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD, 20)); //
		 * ChartFactory.setChartTheme(standardChartTheme);//设置主题 //
		 * 创建JFreeChart对象：ChartFactory.createLineChart JFreeChart jfreechart =
		 * ChartFactory.createTimeSeriesChart( str+"不同类别按小时计算拆线图", "时间", "数据", dataset,
		 * true, true, false); // 使用CategoryPlot设置各种参数。以下设置可以省略。 CategoryPlot plot =
		 * (CategoryPlot) jfreechart.getPlot(); // 背景色 透明度
		 * plot.setBackgroundAlpha(0.5f); // 前景色 透明度 plot.setForegroundAlpha(0.5f); //
		 * 其他设置 参考 CategoryPlot类 ChartPanel panll=new ChartPanel(jfreechart);
		 * 
		 * JFrame jf=new JFrame(); jf.add(panll); jf.setSize(500, 300);
		 * jf.setVisible(true);
		 */
	         
		}
		
		
		public static void  main(String args[])
	{
		new presentationLayer();
	}
}

