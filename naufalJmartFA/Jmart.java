package naufalJmartFA;

public class Jmart {
    public static void main(String[] args){
        
    }
    
    public static Product createProduct(){
        PriceTag priceTag = new PriceTag(100000.0d,20.0d);
        ProductCategory category = ProductCategory.BOOK;
        Product product = new Product("Harry Potter", 1, true, priceTag ,
        category);
        return product;
    }
    public static Coupon createCoupon(){
        Coupon coupon = new Coupon("Diskon hehe",123,Coupon.Type.DISCOUNT,
        50,30000);
        return coupon;
        
    }
    public static ShipmentDuration createShipmentDuration(){
        ShipmentDuration shipmentDuration = new ShipmentDuration(ShipmentDuration.NEXT_DAY,
        ShipmentDuration.REGULER);
        return shipmentDuration;
    }
}
