package Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entry.User;
import entry.comment;

public class CommentBase {
	private static final String URL = "jdbc:mysql://localhost/db_admin?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static final String username = "root";
	private static final String PWD = "root";
	static Connection connection = null;
	static PreparedStatement pStatement = null;

	public static Connection ConnectionDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");//
		return connection = DriverManager.getConnection(URL, username, PWD);
	}

	public static void insertComment(comment co) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = "insert into comment(comment,username,time,acc,step,songid) values(?,?,?,?,?,?)";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, co.getComment());
		pStatement.setString(2, co.getUsername());
		pStatement.setString(3, co.getTime());
		pStatement.setInt(4, co.getAcc());
		pStatement.setInt(5, co.getStep());
		pStatement.setInt(6, co.getSongid());
		int count = pStatement.executeUpdate();
		pStatement.close();
		connection.close();
	}

	public static ArrayList<comment> selectComment(int songid) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		ArrayList<comment> cos = new ArrayList<comment>();
		//username是添加投票的人的名字
		String sql = "select * from comment where songid= ?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, songid);
		ResultSet rSet = pStatement.executeQuery();
		while (rSet.next()) {
			int id = rSet.getInt(1);
			String comment = rSet.getString(2);
			String username = rSet.getString(3);
			String time = rSet.getString(4);
			int acc = rSet.getInt(5);
			int step = rSet.getInt(6);
			comment co = new comment(id, username, time, acc, step, comment, songid);
			cos.add(co);
		}
		pStatement.close();
		connection.close();
		return cos;
	}

	public static int selectOneID() throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		// SELECT LAST_INSERT_ID() AS maxid from t_subject
		String sql = "select * from comment order by id DESC limit 1";
		pStatement = connection.prepareStatement(sql);
		ResultSet rSet = pStatement.executeQuery();
		int result = 0;
		if (rSet.next()) {
			result = rSet.getInt("id");
		}
		pStatement.close();
		connection.close();
		return result;
	}

	public static void UpdateAcc(int nid, int flag) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = "";
		// flag=1加，flag=-1减
		if (flag == 1) {
			sql = "update comment set acc=acc+1 where id=?";
		} else {
			sql = "update comment set acc=acc-1 where id=?";
		}
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, nid);
		pStatement.executeUpdate();
		pStatement.close();
		connection.close();
	}

	public static void UpdateStep(int nid, int flag) throws ClassNotFoundException, SQLException {
		connection = ConnectionDatabase();
		String sql = "";
		// flag=1加，flag=-1减
		if (flag == 1) {
			sql = "update comment set step=step+1 where id=?";
		} else {
			sql = "update comment set step=step-1 where id=?";
		}
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, nid);
		pStatement.executeUpdate();
		pStatement.close();
		connection.close();
	}
}