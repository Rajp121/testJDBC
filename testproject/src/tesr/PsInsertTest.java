package tesr;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertTest {

	private static final String ACTOR_INSERT_Querry="INSERT INTO ACTOR_INFO VALUES(AID_SEQ.NEXTVAL,?,?,?)";
	public static void main(String[] args) throws SQLException {
		
		
		try(Scanner sc=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "piyush1234");
			PreparedStatement ps=con.prepareStatement(ACTOR_INSERT_Querry);
		){
			String aname=null;
			String photopath=null,resumepath=null;
			if(sc!=null)
			{
				System.out.println("enter actor name :");
				aname=sc.next();
				System.out.println("enter actor photopath:");
				photopath=sc.next();
				System.out.println("enter actor resumepath:");
				resumepath=sc.next();
			}
			try(InputStream is=new FileInputStream(photopath);
					Reader reader=new FileReader(resumepath);
					){
				if(ps!=null)
				{
					ps.setString(1, aname);
					ps.setBinaryStream(2, is);
					ps.setCharacterStream(3, reader);
					int result=ps.executeUpdate();
					if(result==0)
						System.out.println("record not inserted");
					else
						System.out.println("record inseted");
				}
			}
			
	
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
