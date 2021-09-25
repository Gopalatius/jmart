package naufalJmartFA;



public class Complaint extends Transaction implements FileParser
{
    boolean read (String content){
        return false;
    }
    boolean write (String content){
        return false;
    }
    public Object newInstance(String content);
}
