package Base;
import entry.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UserBase {
	private static final String URL = "jdbc:mysql://localhost/db_admin?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static final String username = "root";
	private static final String PWD = "root";
	static Connection connection = null;
	static PreparedStatement pStatement = null;
	public static Connection ConnectionDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");//
		return connection = DriverManager.getConnection(URL, username, PWD);

}
	public static User SelectByName(String name) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		User stu = null;
		String sql = "select * from muser where name=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, name);
		ResultSet rSet = pStatement.executeQuery();
		while (rSet.next()) {
			String uname = rSet.getString(1);
			String password = rSet.getString(2);
			stu = new User(uname, password);
		}
		pStatement.close();
		connection.close();
		return stu;

	}
	public static boolean selectUser(User user) throws Exception {
		connection = ConnectionDatabase();
		User stu = null;
		String sql = "select * from muser where name= ? and password= ?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, user.getName());
		pStatement.setString(2, user.getPassword());
		ResultSet rSet = pStatement.executeQuery();
		if(rSet.next()) {
			return true;
		}
		pStatement.close();
		connection.close();
		return false;

	}
	public static Boolean insertUser(User stu) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = "insert into muser(name,password) values(?,?)";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, stu.getName());
		pStatement.setString(2, stu.getPassword());
		int count = pStatement.executeUpdate();
		if (count > 0) {
			pStatement.close();
			connection.close();
			return true;
		} else {
			pStatement.close();
			connection.close();
			return false;
		}
	}

}
