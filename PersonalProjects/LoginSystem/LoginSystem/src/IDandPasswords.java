import java.util.HashMap;

public class IDandPasswords {

    HashMap<String,String> logininfo = new HashMap<>();

    IDandPasswords(){
        logininfo.put("admin", "admin");
        logininfo.put("user", "user");
        logininfo.put("guest", "guest");
        logininfo.put("root", "root");
    }

    protected HashMap getLoginInfo(){
        return logininfo;
    }
}
