package entry;
public class User {
  public User() {
		super();
	}
public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
String name;
  String password;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
