package naufalJmartFA;




public class Coupon extends Recognizable implements FileParser
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
    
    public Coupon (int code, String name, Type type, double cut, double minimum){
        super(code);
        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        this.used = false;
    }
    public boolean isUsed(){
        return this.used;
    }
    public boolean canApply(PriceTag priceTag){
        return (priceTag.getAdjustedPrice() >= minimum && used == false );
    }
    public double apply(PriceTag priceTag){
        this.used = true;
        if (type == Type.DISCOUNT){
            return priceTag.getAdjustedPrice() * (1 - cut/100.0d);
        }else{
            return priceTag.getAdjustedPrice() - cut;
        }
    }
    public boolean read (String content){
        return false;
    }
    
}
