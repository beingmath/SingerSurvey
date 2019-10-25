package action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entry.User;
import entry.aCCstep;
import entry.comment;
import entry.singer;
import entry.song;
import service.AccstepService;
import service.CommentService;
import service.SingerService;
import service.SongService;

@Controller
public class Singeraction {
	singer singer;

	@RequestMapping(value = "/infof")
	public String info(@RequestParam String mid) throws ClassNotFoundException, SQLException {
		singer = SingerService.SelectSingerByMid(mid);
		System.out.println(singer.getInfo() + "-" + singer.getImage() + "-" + singer.getMid());
		return "info.jsp";
	}

	@ResponseBody
	@RequestMapping(value = "/getInfo")
	public singer getInfo() {
		System.out.println(singer.getInfo() + "-" + singer.getImage() + "-" + singer.getMid());
		return singer;
	}

	@ResponseBody
	@RequestMapping(value = "/query")
	public song getcommentInfo(@RequestParam int id) throws SQLException, Exception {
		song song = SongService.SelectSongById(id);
		return song;
	}

	@ResponseBody
	@RequestMapping(value = "/insertComment")
	public int insertComment(@RequestParam String comment, @RequestParam int id, HttpSession session)
			throws SQLException, Exception {
		User user = (User) session.getAttribute("user");
		String name = user.getName();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(d);
		// String username, String time, int acc, int step, String comment
		comment co = new comment(name, format, 0, 0, comment, id);
		CommentService.insertComment(co);
		int id1 = CommentService.selectOneId();
		return id1;
	}

	@ResponseBody
	@RequestMapping(value = "/selectComment")
	public ArrayList<comment> selectComment(@RequestParam int id) throws ClassNotFoundException, SQLException {
		ArrayList<comment> Comments = CommentService.selectComment(id);
		return Comments;
	}

	@ResponseBody
	@RequestMapping(value = "/acc")
	public void acc(@RequestParam int nid, @RequestParam String name) throws ClassNotFoundException, SQLException {
		CommentService.UpdateAcc(nid, 1);
		aCCstep as = AccstepService.selectIfAccOrStep(name, nid);
		if (as == null) {
			// 用户没点过赞，表中没有他的记录
			AccstepService.insertAccStep(nid, name, 1, 0);
		} else {
			// 用户点过赞，表中有他的数据，现在再点赞
			AccstepService.updateAccStep(nid, name, 1, 1);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/toggleacc")
	public void toggleacc(@RequestParam int nid, @RequestParam String name)
			throws ClassNotFoundException, SQLException {
		CommentService.UpdateAcc(nid, -1);
		AccstepService.updateAccStep(nid, name, 1, 0);
	}

	@ResponseBody
	@RequestMapping(value = "/step")
	public void step(@RequestParam int nid, @RequestParam String name) throws ClassNotFoundException, SQLException {
		CommentService.UpdateStep(nid, 1);
		aCCstep as = AccstepService.selectIfAccOrStep(name, nid);
		if (as == null) {
			AccstepService.insertAccStep(nid, name, 0, 1);
		} else {
			AccstepService.updateAccStep(nid, name, 0, 1);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/togglestep")
	public void togglestep(@RequestParam int nid, @RequestParam String name)
			throws ClassNotFoundException, SQLException {
		CommentService.UpdateStep(nid, -1);
		AccstepService.updateAccStep(nid, name, 0, 0);
	}
	@ResponseBody
	@RequestMapping(value = "/selectIfAccstep")
	public aCCstep selectIfAccstep(@RequestParam int commentid, @RequestParam String username)
			throws ClassNotFoundException, SQLException {
		aCCstep as = AccstepService.selectIfAccOrStep(username, commentid);
		if (as != null) {
			return AccstepService.selectIfAccOrStep(username, commentid);
		} else {
			as = new aCCstep(0, 0);
			return as;
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws ClassNotFoundException, SQLException {
		session.invalidate();
		return "redirect:index.html";
	}
}
