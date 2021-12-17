package com.naufalJmartFA;


/**
 * Class treasury to count discount price, admin fee, and adjusted price
 * @author Muhammad Naufal Faza
 */
public class Treasury
{
    public static final double COMMISSION_MULTIPLIER = 0.05d;

    public static final double BOTTOM_PRICE = 20000.0d;

    public static final double BOTTOM_FEE = 1000.0d;


    /**
     * Function to get discounted price according to the discount
     * @param price The price of the product
     * @param discount The discount that wanted to be applied to the product
     * @return The discounted price
     */
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

    /**
     * Function to get admin fee
     * @param price The price of the product
     * @param discount The discount of the product
     * @return The admin fee
     */
    public static double getAdminFee(double price, double discount){
        if (getDiscountedPrice(price,discount) < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }else{
            return getDiscountedPrice(price,discount) * COMMISSION_MULTIPLIER;
        }
    }

    /**
     * Function to get the adjusted price because of the discount and the admin fee
     * @param price The price of the product
     * @param discount The discount of the product
     * @return The discounted price + Admin fee
     */
    public static double getAdjustedPrice(double price, double discount){
        return getDiscountedPrice(price, discount) + getAdminFee(price,discount);
    }

}
