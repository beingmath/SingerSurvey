package Base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entry.singer;
import entry.song;
public class SongBase {
	private static final String URL = "jdbc:mysql://localhost/db_admin?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static final String username = "root";
	private static final String PWD = "root";
	static Connection connection = null;
	static PreparedStatement pStatement = null;
	public static Connection ConnectionDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");//
		return connection = DriverManager.getConnection(URL, username, PWD);
}
	public static ArrayList<song> SelectSongByMid(String sid) throws ClassNotFoundException, SQLException   {
		connection = ConnectionDatabase();
		ArrayList<song> songs=new ArrayList<song>();
		String sql = "select * from music where mid=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, sid);
		ResultSet rSet = pStatement.executeQuery();
		while (rSet.next()) {
			song sin=null;
			int sids=rSet.getInt(1);
			String name = rSet.getString(2);
			String album = rSet.getString(3);
			String time = rSet.getString(4);
			sin = new song(sids,name,album,time);
			songs.add(sin);
		}
		pStatement.close();
		connection.close();
		return songs;
	}
	public static song SelectSongById(int id) throws Exception, SQLException {
		connection = ConnectionDatabase();
		song song=null;
		String sql = "select * from music where id=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1,id);
		ResultSet rSet = pStatement.executeQuery();
		if(rSet.next()) {
			int sids=rSet.getInt(1);
			String name = rSet.getString(2);
			String album = rSet.getString(3);
			String time = rSet.getString(4);
			String mid=rSet.getString(5);
			song=new song(sids,name,album,time,mid);
		}
		return song;
	}
}
