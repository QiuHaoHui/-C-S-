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
	private final static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//加载驱动的字符串
	private final static String url="jdbc:sqlserver://database-1.c6ugvizdrrn0.us-east-1.rds.amazonaws.com:1433;DatabaseName = S-T";//数据库连接字符串
	private final static String usr="sa";//数据库用户
	private final static String pwd="052611";//登录密码
	private static ArrayList<String> Listlist1;
	private static ArrayList<String> Listlist2;
	private static List list1;
	private static List list2;
	static Connection conn;
    //加载驱动
    
    //连接数据库
    public static void getConn() {
    	try
    	{
    		Class.forName(driverName);
    		          
    		}catch(ClassNotFoundException e){
    			e.printStackTrace();
    			System.out.print("数据库连接失败!");
    	}
    	try {
    		
    		conn=DriverManager.getConnection(url,"admin", "wang630306");
    		System.out.println("数据库连接成功!"); 
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
        	
        
    	
    }
    
    public static ResultSet select(String sql) {
		ResultSet rs = null;
		try {
			getConn();
			PreparedStatement stmt = conn.prepareStatement(sql);
			//sql="select [日期],[成交金额(元)] from dbo.[实验数据：上证某公司股市数据] ";
			rs = stmt.executeQuery();	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error - Connection.executeSelectQuery - Query: " + " \nException: " + e.toString());
			return null;
		}
		return rs;
	}

    
    //获取数据库内容
    /*public static  ResultSet select(String sql)  {
    	//Connection conn=DriverManager.getConnection(url,usr,pwd);
    	 Statement stmt=conn.createStatement();
    	getConn();
        sql="select [日期],[成交金额(元)] from dbo.[实验数据：上证某公司股市数据] ";
        ResultSet rs=stmt.executeQuery(sql);     //将sql语句传至数据库，返回的值为一个字符集用一个变量接收 
        return rs;
    }*/
    
    //关闭数据库
    public static void closeConn(ResultSet rs,PreparedStatement stmt,Connection conn){
        
        try {
            if (rs!=null) {//如果返回的结果集对象不能为空,就关闭连接
                rs.close();
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        try {
            if (stmt!=null) {
            	stmt.close();//关闭预编译对象
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        try {
            
            if (conn!=null) {
                conn.close();//关闭结果集对象
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
    static public void main(String[]args) throws SQLException {
		String str="select [日期],[成交金额(元)]  from dbo.[实验数据：上证某公司股市数据]";
		ResultSet res=select(str);
		Listlist1=new ArrayList<String>();
		Listlist2=new ArrayList<String>() ;
		   //显示表格内容
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
   