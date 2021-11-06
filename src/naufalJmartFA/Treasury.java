package naufalJmartFA;



public class Treasury
{
    public static final double COMMISSION_MULTIPLIER = 0.05d;

    public static final double BOTTOM_PRICE = 20000.0d;

    public static final double BOTTOM_FEE = 1000.0d;



    public static double getDiscountedPrice(double price, double discount){
        if (discount > 100.0d){
            discount = 100.0d;
        }
        if (discount == 100.0d){
            return 0.0d;
        }else{
            return (price * (1 - discount/100.0d));
        }
    }

    public static double getAdminFee(double price, double discount){
        if (getDiscountedPrice(price,discount) < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }else{
            return getDiscountedPrice(price,discount) * COMMISSION_MULTIPLIER;
        }
    }

    public static double getAdjustedPrice(double price, double discount){
        return getDiscountedPrice(price, discount) + getAdminFee(price,discount);
    }

}
