package naufalJmartFA;



public class PriceTag
{
    public final double COMMISSION_MULTIPLIER = 0.05d;
    
    public final double BOTTOM_PRICE = 20000.0d;
    
    public final double BOTTOM_FEE = 1000.0d;
    
    public double discount;
    
    public double price;
    
    public PriceTag(double price){
        this.price = price;
    }
    
    public PriceTag(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
    
    public double getDiscountedPrice(){
        if (discount > 100.0d){
            discount = 100.0d;
        }
        if (discount == 100.0d){
            return 0.0d;
        }else{
            return (price * (1 - discount/100));
        }
    }
    
    public double getAdminFee(){
        if (getDiscountedPrice() < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }else{
            return getDiscountedPrice() * COMMISSION_MULTIPLIER;
        }
    }
    
    public double getAdjustedPrice(){
        return getDiscountedPrice() + getAdminFee();
    }
    
}
