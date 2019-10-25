package entry;

public class comment {
int id;
String username;
int songid;
String time;
public comment(String username, String time, int acc, int step, String comment,int songid) {
	super();
	this.username = username;
	this.time = time;
	this.acc = acc;
	this.step = step;
	this.comment = comment;
	this.songid=songid;
}

public comment(int id, String username, String time, int acc, int step, String comment,int songid ) {
	super();
	this.id = id;
	this.username = username;
	this.time = time;
	this.acc = acc;
	this.step = step;
	this.comment = comment;
	this.songid=songid;
}
public int getSongid() {
	return songid;
}

public void setSongid(int songid) {
	this.songid = songid;
}
int acc;
int step;

String comment;
public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public comment() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public int getAcc() {
	return acc;
}
public void setAcc(int acc) {
	this.acc = acc;
}
public int getStep() {
	return step;
}
public void setStep(int step) {
	this.step = step;
}
}
