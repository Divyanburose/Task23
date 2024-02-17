package task23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Empdetail1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Database connection details	
				String db_url ="jdbc:mysql://localhost:3306/Empdetail";
		// username and password
				String user="root";
				String password="root";
		// Establish the connection
				try {
					Connection connection = DriverManager.getConnection(db_url, user, password);
					if(connection!=null) {
						System.out.println("Connection sucessfull");
						} else {
						System.out.println("Connection unsucessfull");
						}
					//Perform the operation
	Statement stmt = connection.createStatement();
    String createTable="create table empldemo2 (empcode int,empname varchar(25),empage int,empsalary int)";
	String select ="Select * from empldemo2";
	String insert ="insert into empldemo2 values (101,'Jenny',25,10000),"
						+"(102,'Jacky',30,20000),"
							+"(103,'Joe',20,40000),"
							+"(104,'John',40,80000),"
							+"(101,'Shameer',25,90000)";
	//Create Table
	stmt.execute(createTable);
	//insert data
	stmt.executeUpdate(insert);
	// Selecting the data
				ResultSet rs = stmt.executeQuery(select);
	// iterate result set and print
				while (rs.next()) {
	System.out.println(rs.getInt("empcode")+" "+rs.getString("empname")+" "+rs.getInt("empage")+" "	+rs.getInt("empsalary"));		
	}
	//close connection
				connection.close();
									
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
}

}
