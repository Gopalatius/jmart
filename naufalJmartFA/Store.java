package naufalJmartFA;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Store extends Recognizable implements FileParser
{
    public static final String REGEX_NAME = "";
    public static final String REGEX_PHONE = "[0-9]{9,12}";
    public String name;
    public String address;
    public String phoneNumber;
    public Store(int accountId, String name, String address, String phoneNumber)
    {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public Store(Account account, String name, String address, String phoneNumber)
    {
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public boolean validate(){
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(this.phoneNumber);
        boolean matchFoundPhone = matcherPhone.find();
        
        
        return matchFoundPhone;
    }
    public boolean read(String content){
        return false;
    }
    public String toString(){
        return "name: "+name+"\naddress: "+address+"\nphoneNumber: "+phoneNumber;
    }

}
