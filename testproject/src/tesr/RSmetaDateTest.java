package tesr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class RSmetaDateTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("test");
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "piyush1234");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");
		)
		{
			ResultSetMetaData rsmd=null;
			if(rs!=null)
			{
			rsmd=rs.getMetaData();
			}
			if(rsmd!=null)
			{
				int colcount=rsmd.getColumnCount();
				for(int i=1; i<=colcount;++i)
				{
					System.out.print(rsmd.getColumnName(i)+"("+rsmd.getColumnTypeName(i)+")"+"\t\t");
					
				}
				System.out.println();
				while(rs.next())
				{
					for(int i=1;i<=colcount;++i)
					{
						System.out.print(rs.getString(i)+"\t\t\t\t");
					}
					System.out.println();
				}
			}
			
			
			
		}
		catch (SQLException se) {
			se.printStackTrace();
		

	}

	}}
