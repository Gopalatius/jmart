package naufalJmartFA;



public class Complaint extends Transaction implements FileParser
{
    public String date;
    public String desc;
    
    public Complaint (int id, String desc){
        super(id, 0, 0);
        this.desc = desc;
        this.date = "";
    }
    public boolean read(String content){
        return false;
    }
    
}
