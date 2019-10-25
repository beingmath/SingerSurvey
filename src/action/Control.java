package action;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import Base.UserBase;
import entry.User;
import service.UserService;
@SessionAttributes(value="user")//把studnet2,student3对象保存到session作用域当中
//@SessionAttributes(types=Student.class)//把studnet类型对象保存到session作用域当中
@Controller
public class Control {
	@RequestMapping(value = "/abc")
	// @RequestParam在处理方法入参处使用 @RequestParam 可以把请求参 数传递给请求方法
	public String ad(@RequestParam int id) {
		return "success.jsp";
	}
	@RequestMapping(value = "/Login")
	// @RequestParam在处理方法入参处使用 @RequestParam 可以把请求参 数传递给请求方法
	public String Login(User user1,Map ma) throws Exception {
			boolean	 flag = UserBase.selectUser(user1);
			if(flag) {
				ma.put("user", user1);
				return "redirect:show.jsp";
			}else {
				return "redirect:index.html";
			}
	}
	@ResponseBody
	@RequestMapping(value = "/registerw")
	public String register(@RequestParam String name,@RequestParam String pwd) throws ClassNotFoundException, SQLException {
		if(name.trim().equals("")||pwd.trim().equals("")) {
			return "null";
		}else {
		User user = UserService.selectUserByName(name);
		if(user==null) {
			//可以注册，将user数据插入数据库中中，注册成功
			UserService.inserUser(new User(name,pwd));
			return "true";
		}else {
			return "false";
		}
		}
	}
}
