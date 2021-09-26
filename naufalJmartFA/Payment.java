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
    public Payment (int id, int buyerId, int storeId, int productId,
    ShipmentDuration shipmentDuration){
        super(id, buyerId, storeId);
        this.productId = productId;
        this.shipmentDuration = shipmentDuration;
    }
    public boolean read (String content){
        return false;
    }
    public boolean validate(){
        return false;
    }
    public Transaction perform(){
        return null;
    }
}
