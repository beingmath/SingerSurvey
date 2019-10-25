package service;

import java.sql.SQLException;
import java.util.ArrayList;

import Base.SongBase;
import entry.song;

public class SongService {
 public static ArrayList<song> SelectSongBySid(String sid) throws ClassNotFoundException, SQLException{
	 return SongBase.SelectSongByMid(sid);
 }
 public static song SelectSongById(int id) throws SQLException, Exception {
	 return SongBase.SelectSongById(id);
 }
}
