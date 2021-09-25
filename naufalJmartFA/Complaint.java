package naufalJmartFA;



public class Complaint extends Transaction implements FileParser
{
    public int paymentId;
    public String desc;
    
    public Complaint (int id, Payment payment, String desc){
        super(id,0,0);
        this.paymentId = payment.id;
        this.desc = desc;
        
    }
    public Complaint (int id, int buyerId, int storeId, int paymentId, String
    desc){
        super(id,buyerId,storeId);
        this.paymentId = paymentId;
        this.desc = desc;
    }
    public boolean read (String content){
        return false;
    }
    public boolean write (Object content){
        return false;
    }
    public Object newInstance(String content){
        return null;
    }
    
}
