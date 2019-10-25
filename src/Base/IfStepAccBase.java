package Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entry.aCCstep;
import entry.singer;

public class IfStepAccBase {
	private static final String URL = "jdbc:mysql://localhost/db_admin?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static final String username = "root";
	private static final String PWD = "root";
	static Connection connection = null;
	static PreparedStatement pStatement = null;

	public static Connection ConnectionDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");//
		return connection = DriverManager.getConnection(URL, username, PWD);
	}

	public static aCCstep selectIfAccOrStep(String name, int commnetid) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		aCCstep as = null;
		String sql = "select acc,step from ifaccstep where commentid=? and username=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, commnetid);
		pStatement.setString(2, name);
		ResultSet rSet = pStatement.executeQuery();
		while (rSet.next()) {
			int acc = rSet.getInt(1);
			int step = rSet.getInt(2);
			as = new aCCstep(acc, step);
		}
		pStatement.close();
		connection.close();
		rSet.close();
		return as;
	}

	public static void insertAccStep(int commentid, String username, int a, int b)
			throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = "insert into ifaccstep(commentid,username,acc,step) values(?,?,?,?)";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, commentid);
		pStatement.setString(2, username);
		pStatement.setInt(3, a);
		pStatement.setInt(4, b);
		int count = pStatement.executeUpdate();
		pStatement.close();
		connection.close();
	}

	public static void updateAccStep(int commentid, String username, int flag,int point)
			throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = null;
		//1修改acc,0修改step
		if (flag == 1) {
			if(point==1) {
				sql = "update ifaccstep set acc=1 where commentid=? and username=?";
			}else {
			sql = "update ifaccstep set acc=0 where commentid=? and username=?";}
		} else {
			if(point==1) {
			sql = "update ifaccstep set step=1 where commentid=? and username=?";}
			else {
				sql = "update ifaccstep set step=0 where commentid=? and username=?";
			}
		}
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, commentid);
		pStatement.setString(2, username);
		pStatement.executeUpdate();
		pStatement.close();
		connection.close();
	}
}
