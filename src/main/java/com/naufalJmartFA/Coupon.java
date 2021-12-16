package com.naufalJmartFA;


import com.naufalJmartFA.dbjson.Serializable;

/**
 * A coupon object. It extends serializable because
 * coupons must have a serialized id.
 * @author Muhammad Naufal Faza
 */
public class Coupon extends Serializable
{
    /**
     * An enum whether the coupon is a discount or a rebate.
     */
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

    /**
     * The constructor of coupon to initialized its parameters. The used is initialized as false.
     * @param name The name of the coupon.
     * @param code The code of the coupon.
     * @param type The type of the coupon.
     * @param cut The cut of the coupon.
     * @param minimum The minimum price to apply the coupon.
     */
    public Coupon ( String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        this.used = false;
    }

    /**
     * Check whether the coupon is used.
     * @return true if the coupon is used. else, false.
     */
    public boolean isUsed(){
        return this.used;
    }

    /**
     * Check if the coupon can be apply.
     * @param price The price of the product.
     * @param discount The discount that wants to be applied to the product.
     * @return true if the adjusted price is more than or equal to the minimum priced and is not used.
     */
    public boolean canApply(double price, double discount){
        return (Treasury.getAdjustedPrice(price,discount) >= minimum && !used );
    }

    /**
     * To apply the coupon,
     * @param price The price of the product.
     * @param discount The discount of the product
     * @return the final money to be paid after applying the coupon.
     */
    public double apply(double price, double discount){
        this.used = true;
        if (type == Type.DISCOUNT){
            return Treasury.getAdjustedPrice(price, discount) * (1 - cut/100.0d);
        }else{
            return Treasury.getAdjustedPrice(price,discount) - cut;
        }
    }

}
