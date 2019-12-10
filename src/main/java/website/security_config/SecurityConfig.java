package website.security_config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

	public static final String ROLE_TEACHER = "TECHER";
    public static final String ROLE_STUDENT = "STUDENT";
	
    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }
    
    private static void init() {
        List<String> urlPatterns1 = new ArrayList<String>();
 
        urlPatterns1.add("/userInfo");
        urlPatterns1.add("/teacherTask");
 
        mapConfig.put(ROLE_TEACHER, urlPatterns1);
 
        List<String> urlPatterns2 = new ArrayList<String>();
 
        urlPatterns2.add("/userInfo");
        urlPatterns2.add("/studentTask");
 
        mapConfig.put(ROLE_STUDENT, urlPatterns2);
    }
    
    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }
 
    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}
