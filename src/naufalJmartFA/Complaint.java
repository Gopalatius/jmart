package naufalJmartFA;

import java.util.Date;
import java.text.SimpleDateFormat;


public class Complaint extends Recognizable
{
    public final Date date;
    public String desc;
    
    public Complaint (String desc){
        this.desc = desc;
        this.date = new Date();
    }
    public boolean read(String content){
        return false;
    }
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDesc = formatter.format(this.date);
        
        return "Complaint{date="+strDesc+", desc='"+this.desc+"'}";
    }
}
