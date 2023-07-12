package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataintoDB {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		String Project_Name="TY_SCM_1908";
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement state = conn.createStatement();
			String QUERY="select * from project";
			ResultSet result = state.executeQuery(QUERY);
			boolean flag = false;
			
		} finally {
			// TODO: handle finally clause
		}

	}

}
