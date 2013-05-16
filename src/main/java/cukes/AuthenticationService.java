package cukes;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
	
	public AuthenticationService() {
		super();
		System.out.println("Create Auth Service");
	}

	private Map<String, String> users = new HashMap<String, String>(); 
	{
		users.put("john.doe", "pass");
		users.put("mark.twain", "pwd");
	}
	
	private Map<String, String> sessions = new HashMap<String, String>(); 
	
	
	public void register(String username, String password) {
		users.put(username, password);
	}
	
	public boolean exists(String username) {
		return users.get(username) != null;
	}
	
	public String login(String username, String password) throws Exception {
		String accountPassword = users.get(username);
		if (accountPassword == null) {
			throw new Exception("User " + username + " doesn't exist");
		}
		if (!accountPassword.equals(password)) {
			throw new Exception("Wrong password for user " + username);
		}
		String sessionId = System.currentTimeMillis() + "";
		sessions.put(sessionId, username);
		return sessionId;
	}
	
	public void logout(String username) {
		
	}
}
