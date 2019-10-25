package entry;
import java.util.List;
import java.util.Map;
public class singer {
 String mid;
 String info;
 String image;
 List<song> songs;
public String getMid() {
	return mid;
}
public singer(String mid, String info, String image) {
	super();
	this.mid = mid;
	this.info = info;
	this.image = image;
}
public void setMid(String mid) {
	this.mid = mid;
}
public singer( String info, String image) {
	this.info = info;
	this.image = image;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public List<song> getSongs() {
	return songs;
}
public void setSongs(List<song> songs) {
	this.songs = songs;
}
}
