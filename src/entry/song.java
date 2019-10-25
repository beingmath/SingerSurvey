package entry;

public class song {
  String name;
  String album;
  String time;
  int id;
  String mid;
public song(int id,String name, String album, String time,String mid) {
	super();
	this.name = name;
	this.album = album;
	this.time = time;
	this.id = id;
	this.mid = mid;
}
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public String getName() {
	return name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public song(int id,String name, String album, String time) {
	super();
	this.id=id;
	this.name = name;
	this.album = album;
	this.time = time;
}
public void setName(String name) {
	this.name = name;
}
public String getAlbum() {
	return album;
}
public void setAlbum(String album) {
	this.album = album;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public song(String name, String album, String time) {
	super();
	this.name = name;
	this.album = album;
	this.time = time;
}
}
