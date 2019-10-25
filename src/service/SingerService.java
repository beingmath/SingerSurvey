package service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Base.SingerBase;
import entry.singer;

public class SingerService {
  public static singer SelectSingerByMid(String sid) throws ClassNotFoundException, SQLException {
	 return SingerBase.SelectByMid(sid);
  }
}
