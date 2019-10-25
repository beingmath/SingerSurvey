package service;

import java.sql.SQLException;
import java.util.ArrayList;

import Base.CommentBase;
import entry.comment;

public class CommentService {
	public static void insertComment(comment co) throws ClassNotFoundException, SQLException {
		CommentBase.insertComment(co);
	}

	public static ArrayList<comment> selectComment(int songid) throws ClassNotFoundException, SQLException {
		return CommentBase.selectComment(songid);
	}

	public static int selectOneId() throws ClassNotFoundException, SQLException {
		return CommentBase.selectOneID();
	}

	public static void UpdateAcc(int nid, int flag) throws ClassNotFoundException, SQLException {
		CommentBase.UpdateAcc(nid, flag);
	}

	public static void UpdateStep(int nid, int flag) throws ClassNotFoundException, SQLException {
		CommentBase.UpdateStep(nid,flag);
	}
}
