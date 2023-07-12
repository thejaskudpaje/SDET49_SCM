package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class InsertDataInto08 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement state = conn.createStatement();
			String QUERY="insert into project values('TY_SCM_1908','Sanjay','29/06/2023','TYSS','progress','3')";
			int result = state.executeUpdate(QUERY);
			if (result==1) {
				System.out.println("Data is created");
			}
			else {
				System.out.println("Data is not created");

			}
			
		} finally {
			conn.close();
			
		}
		
		
	}

}
