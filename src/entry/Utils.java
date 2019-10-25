package entry;

import java.util.ArrayList;
import java.util.HashMap;
import entry.singer;
import java.util.Map;
public class Utils {
public static Map<String,singer> Singermap=new HashMap<String, singer>();
public static Map<String,singer> getSingermap() {
	Singermap.put("a",new singer("G.E.M. 邓紫棋","image/a.jpg"));
	Singermap.put("b",new singer("周杰伦","image/b.jpg"));
	Singermap.put("c",new singer("李荣浩","image/c.jpg"));
	Singermap.put("e",new singer("陈奕迅","image/e.jpg"));
	Singermap.put("f",new singer("张学友","image/f.jpg"));
	Singermap.put("g",new singer("BEYOND","image/g.jpg"));
	Singermap.put("h",new singer("张国荣","image/h.jpg"));
	Singermap.put("i",new singer("刘德华","image/i.jpg"));
	return Singermap;
}
}
