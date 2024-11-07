import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException
	{
		String url="jdbc:mysql://127.0.0.1:3307/sample";
		String username= "root";
		String password= "root";
		
		Connection con= DriverManager.getConnection(url,username,password);
		
		if(con != null)
		{
			System.out.println("The connection is established 🤧");
		}
		
		else
		{
			System.out.println("Sorry bro !, These things are not new for you 🫠. Connection establishment failed !");
		}
		
		//insert
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter Username :");
		String name = sc.nextLine();
		System.out.println("Enter Password");
		String pass=sc.nextLine();
		System.out.println("Enter ID:");
		int id = sc.nextInt();
		
		String sql = "INSERT INTO USERS (username,password,id)"+"VALUES(?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2,pass);
		ps.setInt(3, id);
		
		int res = ps.executeUpdate();
		
		if(res > 0)
		{
			System.out.println("Success again. Insertion success !!!");
		}
		
		else
		{
			System.out.println("Failed successfully");
		}
		
		String query = "SELECT * FROM USERS";
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery(query); 
		while(rs.next())
		{
			System.out.println("Username :"+rs.getString("username")+"\nPassword :"+rs.getString("password")+"\nID     :"+rs.getInt("id"));
		}
	}
	
	
}
