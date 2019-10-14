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
			frame.setTitle("��֤ĳ��˾�������ݲ�ѯ");
			
			JPanel p=new JPanel();
			frame.getContentPane().add(p);
	
			JTextField j1 = new JTextField(10);
			JLabel Label1 = new JLabel("��ʼ��:");
			p.add(Label1);
			p.add(j1);

			JTextField j2 = new JTextField(10);
			JLabel Label2 = new JLabel("��ʼ��:");
			p.add(Label2);
			p.add(j2);

			JTextField j3 = new JTextField(10);
			JLabel Label3 = new JLabel("��ʼ��:");
			p.add(Label3);
			p.add(j3);
	        
	        JTextField j4=new JTextField(10);
			JLabel Label4=new JLabel("��ֹ��:");
			p.add(Label4);
	        p.add(j4);

	        JTextField j5=new JTextField(10);
			JLabel Label5=new JLabel("��ֹ��:");
			p.add(Label5);
	        p.add(j5);
	        
	        JTextField j6=new JTextField(10);
			JLabel Label6=new JLabel("��ֹ��:");
			p.add(Label6);
	        p.add(j6);
	        
	        
	        
	        JButton button1=new JButton("��ѯ");
	        JButton button2=new JButton("ȡ��");
	        p.add(button1);
	        p.add(button2);
	        button1.addActionListener(new ActionListener() {
	        	 @Override 
	        	 public void actionPerformed(ActionEvent e) {
	        		// TODO �Զ����ɵķ������
	        		 if(e.getActionCommand().equals("��ѯ")){
	        			 //String [] a= {(String) j1.getText(),(String) j2.getText(),(String) j3.getText(),(String) j4.getText(),(String) j5.getText(),(String) j6.getText()};
	        			//System.out.println("���Ϊ"+a);  
	        			 	String str =(String)A.getSelectedItem();
	        				System.out.println(str); 
	        				String [] a= {(String) j1.getText(),(String) j2.getText(),(String) j3.getText(),(String) j4.getText(),(String) j5.getText(),(String) j6.getText()};
	        				System.out.println(a);   
	        				String str2=busLogic.sql_transfer(str);
	        				System.out.println(str2);   
	        				ResultSet res=dbConnection.select(str2);
	        				System.out.println(res);   
	        				
	        				XYDataset dataset=busLogic.createDataset(res,a);
	        				 //�����"name"��������ʲô��˼��Ҳ��֪������������������  
	        		        StandardChartTheme standardChartTheme = new StandardChartTheme("name");  
	        		        //���Ըı����������  
	        		        standardChartTheme.setLargeFont(new Font("����",Font.BOLD, 12));  
	        		        //���Ըı�ͼ��������  
	        		        standardChartTheme.setRegularFont(new Font("����",Font.BOLD, 8));  
	        		        //���Ըı�ͼ��ı�������  
	        		        standardChartTheme.setExtraLargeFont(new Font("����",Font.BOLD, 20));  
//	        		        ChartFactory.setChartTheme(standardChartTheme);//��������  
	        		        // ����JFreeChart����ChartFactory.createLineChart  
	        		        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(
	        		        		str+"����ͼ",
	        		        		"ʱ��", 
	        		        		"����", 
	        		        		dataset, 
	        		        		true,
	        		        		true, 
	        		        		false);  
	        		        // ʹ��CategoryPlot���ø��ֲ������������ÿ���ʡ�ԡ�  
					/*
					 * CategoryPlot plot = (CategoryPlot) jfreechart.getPlot(); // ����ɫ ͸����
					 * plot.setBackgroundAlpha(0.5f); // ǰ��ɫ ͸���� plot.setForegroundAlpha(0.5f); //
					 * �������� �ο� CategoryPlot��
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
	        		// TODO �Զ����ɵķ������
	        		 if(e.getActionCommand().equals("ȡ��")){
	        			 System.exit(0);
	        		 }
	        	 }
	        });
			frame.add(p);
			
	        frame.setLayout(new FlowLayout());
			A=new Choice();
			A.add("���̼�(Ԫ)");
			A.add("���̼�(Ԫ)");
			A.add("�ɽ����(Ԫ)");
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
		 * //�����"name"��������ʲô��˼��Ҳ��֪������������������ StandardChartTheme standardChartTheme = new
		 * StandardChartTheme("name"); //���Ըı���������� standardChartTheme.setLargeFont(new
		 * Font("����",Font.BOLD, 12)); //���Ըı�ͼ�������� standardChartTheme.setRegularFont(new
		 * Font("����",Font.BOLD, 8)); //���Ըı�ͼ��ı�������
		 * standardChartTheme.setExtraLargeFont(new Font("����",Font.BOLD, 20)); //
		 * ChartFactory.setChartTheme(standardChartTheme);//�������� //
		 * ����JFreeChart����ChartFactory.createLineChart JFreeChart jfreechart =
		 * ChartFactory.createTimeSeriesChart( str+"��ͬ���Сʱ�������ͼ", "ʱ��", "����", dataset,
		 * true, true, false); // ʹ��CategoryPlot���ø��ֲ������������ÿ���ʡ�ԡ� CategoryPlot plot =
		 * (CategoryPlot) jfreechart.getPlot(); // ����ɫ ͸����
		 * plot.setBackgroundAlpha(0.5f); // ǰ��ɫ ͸���� plot.setForegroundAlpha(0.5f); //
		 * �������� �ο� CategoryPlot�� ChartPanel panll=new ChartPanel(jfreechart);
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

