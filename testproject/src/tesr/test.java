package tesr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class test {
	
	private final static String DEPT_INSERT_QUERRY="INSERT INTO DEPT VALUES(?,?,?)";

	public static void main(String[] args) throws SQLException {
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "piyush1234");
				PreparedStatement ps=con.prepareStatement(DEPT_INSERT_QUERRY);
				)
		{
			int count = 0;
			if(sc!=null)
			{
				System.out.println("enter dept count");
				count =sc.nextInt();
			}
			
			if(sc!=null && ps!=null)
			{
				for(int i=1;i<=count;++i)
				{
					System.out.println("enter"+i+"student details");
					System.out.println("enter student number");
					int deptno=sc.nextInt();
					System.out.println("enter student name");
					String dname=sc.next();
					System.out.println("enter student loc");
					String loc=sc.next();
					ps.setInt(1, deptno);
					ps.setString(2, dname);
					ps.setString(3, loc);
					int result=ps.executeUpdate();
					
					if(result==0)
						System.out.println("record inserted");
					else
						System.out.println("not inserted");
					
					
				}
			}
			
			
			
			
		}
	
				
				
				
	

	}

}
