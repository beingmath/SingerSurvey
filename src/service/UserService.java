package service;

import java.sql.SQLException;

import Base.UserBase;
import entry.User;

public class UserService {
	//注册时查询此username是否被注册了
   public static User selectUserByName(String name) throws ClassNotFoundException, SQLException {
	   User user = UserBase.SelectByName(name);
	   return user;
   }
   public static void inserUser(User user) throws ClassNotFoundException, SQLException {
	   UserBase.insertUser(user);
   }
   public static boolean selectUser(User user) throws Exception {
        boolean selectUser = UserBase.selectUser(user);
        return selectUser;
   }
}
