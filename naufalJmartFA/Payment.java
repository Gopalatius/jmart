package naufalJmartFA;



public class Payment extends Invoice implements Transactor
{
    public int productCount;
    public Shipment shipment;
    
    public Payment (int id, int buyerId, int productId, int productCount,
    Shipment shipment){
        super(id, buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
        
    }
    
    public boolean read (String content){
        return false;
    }
    public boolean validate(){
        return false;
    }
    public Invoice perform(){
        return null;
    }
    
}
