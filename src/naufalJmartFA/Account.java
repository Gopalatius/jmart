package naufalJmartFA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable
{
    public static final String REGEX_EMAIL = 
    "^[^\\.]*((?!\\.{2,}).)[A-Za-z0-9&~_*]+(?:\\.[A-Za-z0-9&~_*]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?[a-zA-Z]";
    public static final String REGEX_PASSWORD =
    "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)((?!\\s).)*[a-zA-Z\\d]{8,}$";
    public String name;
    public String email;
    public String password;
    public Store store;
    public double balance;
    
    public Account(String name, String email, String password, double balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.store = null;
    }
    

    public boolean validate(){
        Pattern patternEmail = Pattern.compile(this.REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(this.email);
        boolean matchFoundEmail = matcherEmail.find();
        
        Pattern patternPassword = Pattern.compile(this.REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(this.name);
        boolean matchFoundPassword = matcherPassword.find();
        
        return matchFoundEmail && matchFoundPassword;
        
    }
}
