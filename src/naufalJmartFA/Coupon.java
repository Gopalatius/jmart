package naufalJmartFA;




public class Coupon extends Serializable
{
    public enum Type
    {
    DISCOUNT, REBATE
    }
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public Coupon ( String name, int code, Type type, double cut, double minimum){
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
    public boolean canApply(double price, double discount){
        return (Treasury.getAdjustedPrice(price,discount) >= minimum && !used );
    }
    public double apply(double price, double discount){
        this.used = true;
        if (type == Type.DISCOUNT){
            return Treasury.getAdjustedPrice(price, discount) * (1 - cut/100.0d);
        }else{
            return Treasury.getAdjustedPrice(price,discount) - cut;
        }
    }

}
