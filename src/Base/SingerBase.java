package Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entry.User;
import entry.singer;

public class SingerBase {
	private static final String URL = "jdbc:mysql://localhost/db_admin?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static final String username = "root";
	private static final String PWD = "root";
	static Connection connection = null;
	static PreparedStatement pStatement = null;
	public static Connection ConnectionDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");//
		return connection = DriverManager.getConnection(URL, username, PWD);
}
	public static singer SelectByMid(String sid) throws ClassNotFoundException, SQLException   {
		connection = ConnectionDatabase();
		singer sin=null;
		String sql = "select * from singer where sid=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, sid);
		ResultSet rSet = pStatement.executeQuery();
		while (rSet.next()) {
			String info = rSet.getString(2);
			String image = rSet.getString(3);
			sin = new singer(sid, info,image);
		}
		pStatement.close();
		connection.close();
		return sin;
	}
}
