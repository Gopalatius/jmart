package naufalJmartFA;

public class Jmart {
    public static void main(String[] args){
        
    }
    public static int getPromo(){
        return 0;
    }
    public static String getCustomer(){
        return "oop";
    }
    public static float getDiscountPercentage(int before, int after){
        if (before < after){
            return 0.0f;
        }else{
            return (before - after)/10.0f;
        }
    }
    public static int getDiscountedPrice(int price, float discountPercentage){
        if (discountPercentage > 100.0f){
            return 0;
        }else{
            return (int) (price * ( 1 - (discountPercentage / 100.0f)));   
        }
    }
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        return (int) (discountedPrice / ( 1.0f - (discountPercentage / 100.0f)));
    }
    public static float getCommissionMultiplier(){
        return 0.05f;
    }
    public static int getAdjustedPrice(int price){
        return (int) (price * (1 + getCommissionMultiplier()));
    }
    public static int getAdminFee(int price){
        return (int) (price * getCommissionMultiplier());
    }
}
