package naufalJmartFA;



public class Payment extends Transaction implements FileParser
{
    public int productId;
    public ShipmentDuration shipmentDuration;
    public Payment (int id, int buyerId, Product product, ShipmentDuration
    shipmentDuration){
        super(id,buyerId, 0);
        this.productId = product.id;
        this.shipmentDuration = shipmentDuration;
        
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
