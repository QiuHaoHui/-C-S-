package sjk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.lowagie.text.List;
public class dbConnection {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub`
	private final static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//�����������ַ���
	private final static String url="jdbc:sqlserver://database-1.c6ugvizdrrn0.us-east-1.rds.amazonaws.com:1433;DatabaseName = S-T";//���ݿ������ַ���
	private final static String usr="sa";//���ݿ��û�
	private final static String pwd="052611";//��¼����
	private static ArrayList<String> Listlist1;
	private static ArrayList<String> Listlist2;
	private static List list1;
	private static List list2;
	static Connection conn;
    //��������
    
    //�������ݿ�
    public static void getConn() {
    	try
    	{
    		Class.forName(driverName);
    		          
    		}catch(ClassNotFoundException e){
    			e.printStackTrace();
    			System.out.print("���ݿ�����ʧ��!");
    	}
    	try {
    		
    		conn=DriverManager.getConnection(url,"admin", "wang630306");
    		System.out.println("���ݿ����ӳɹ�!"); 
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
        	
        
    	
    }
    
    public static ResultSet select(String sql) {
		ResultSet rs = null;
		try {
			getConn();
			PreparedStatement stmt = conn.prepareStatement(sql);
			//sql="select [����],[�ɽ����(Ԫ)] from dbo.[ʵ�����ݣ���֤ĳ��˾��������] ";
			rs = stmt.executeQuery();	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error - Connection.executeSelectQuery - Query: " + " \nException: " + e.toString());
			return null;
		}
		return rs;
	}

    
    //��ȡ���ݿ�����
    /*public static  ResultSet select(String sql)  {
    	//Connection conn=DriverManager.getConnection(url,usr,pwd);
    	 Statement stmt=conn.createStatement();
    	getConn();
        sql="select [����],[�ɽ����(Ԫ)] from dbo.[ʵ�����ݣ���֤ĳ��˾��������] ";
        ResultSet rs=stmt.executeQuery(sql);     //��sql��䴫�����ݿ⣬���ص�ֵΪһ���ַ�����һ���������� 
        return rs;
    }*/
    
    //�ر����ݿ�
    public static void closeConn(ResultSet rs,PreparedStatement stmt,Connection conn){
        
        try {
            if (rs!=null) {//������صĽ����������Ϊ��,�͹ر�����
                rs.close();
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        try {
            if (stmt!=null) {
            	stmt.close();//�ر�Ԥ�������
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        try {
            
            if (conn!=null) {
                conn.close();//�رս��������
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
    static public void main(String[]args) throws SQLException {
		String str="select [����],[�ɽ����(Ԫ)]  from dbo.[ʵ�����ݣ���֤ĳ��˾��������]";
		ResultSet res=select(str);
		Listlist1=new ArrayList<String>();
		Listlist2=new ArrayList<String>() ;
		   //��ʾ�������
     	while(res.next())
		 {
     		
     		Listlist1.add(res.getString(1));
     		Listlist2.add(res.getString(2));
		  }
		   
		for(String i:Listlist1) {
			System.out.println(i);
		}
}

	private static ResultSet select_return(String str) {
		// TODO Auto-generated method stub
		return null;
	}
}
   