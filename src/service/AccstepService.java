package service;

import java.sql.SQLException;

import Base.IfStepAccBase;
import entry.aCCstep;

public class AccstepService {
   public static aCCstep selectIfAccOrStep(String name,int commnetid) throws ClassNotFoundException, SQLException {
	 return   IfStepAccBase.selectIfAccOrStep(name, commnetid);
   }
   public static void insertAccStep(int commentid,String username,int a,int b) throws ClassNotFoundException, SQLException {
	   IfStepAccBase.insertAccStep(commentid, username, a, b);
   }
   public static void updateAccStep(int commentid,String username,int flag,int point) throws ClassNotFoundException, SQLException {
	   IfStepAccBase.updateAccStep(commentid, username, flag,point);
   }
}
