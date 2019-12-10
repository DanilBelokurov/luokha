package website.database;

import java.util.HashMap;
import java.util.Map;

import website.model.User;

public class DataBase {
	
	private static final Map<String, User> db = new HashMap<String, User>();
	
	static {
		initDataBase();
	}
	
	private static void initDataBase() {
		
		db.put("Kate",new User("Kate", "Tesla", User.ROLE_T));
		
		db.put("Danil",new User("Danil", "1234", User.ROLE_S));
		
		db.put("Luokha",new User("Luokha", "Richmond_hyinya", User.ROLE_S));
	}
	
	public static User findUser(String username, String password) {
		User user = db.get(username);
		
		if(user != null && user.getPassword().equals(password))
			return user;
		else
			return null;
	}
	
	public static void addUser(String username, String password, String role) {
		
		if (!db.containsKey(username)) {
			db.put(username, new User(username,password,role));
		}
	}

}
