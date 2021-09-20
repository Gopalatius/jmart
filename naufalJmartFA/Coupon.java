package naufalJmartFA;




public class Coupon
{
    public enum Type
    {
    DISCOUNT, REBATE;
    }
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public Coupon (String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        used = false;
    }
    public boolean isUsed(){
        return used;
    }
    public boolean canApply(PriceTag priceTag){
        if (priceTag.getAdjustedPrice() >= minimum && used == false ){
            return true;
        }else{
            return false;
        }
    }
    public double apply(PriceTag priceTag){
        used = true;
        if (type == Type.DISCOUNT){
            return priceTag.getAdjustedPrice() * (1 - cut/100.0d);
        }else{
            return priceTag.getAdjustedPrice() - cut;
        }
    }
}
