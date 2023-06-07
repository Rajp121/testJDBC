package tesr;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbCapabiltiesTest {
	//added new comment

	public static void main(String[] args) throws SQLException {
		System.out.println("test");
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "piyush1234");)
		{
			if(con!=null)
			{
				DatabaseMetaData dbmd=con.getMetaData();
				if(dbmd!=null)
				{
					System.out.println("DB sq name"+dbmd.getDatabaseProductName());
					System.out.println("DB sq version"+dbmd.getDatabaseProductVersion());
					System.out.println("sql keyword"+dbmd.getSQLKeywords());
					
					
				}
			}
			
			
		}
		catch (SQLException se) {
			se.printStackTrace();
		}

	}

}
