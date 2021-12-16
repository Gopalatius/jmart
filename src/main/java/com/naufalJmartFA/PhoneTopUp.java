package com.naufalJmartFA;

/**
 * A feature to do PhoneTopUp
 * @author Muhammad Naufal Faza
 */
public class PhoneTopUp extends Invoice {
    public String phoneNumber;
    public Status status;

    /**
     * The constructor to assign to the instance variables.
     * @param buyerId The ID of the parameter.
     * @param productId The ID of the product.
     * @param phoneNumber The phone number that wants to be topped up.
     */
    public PhoneTopUp(int buyerId, int productId, String phoneNumber){
        super(buyerId,productId);
        this.phoneNumber = phoneNumber;

    }

    /**
     * Overrided function
     * @param product the product which the buyer wants to know the total pay.
     * @return the totalPay
     */
    @Override
    public double getTotalPay(Product product){
        return product.price* (1-product.discount);
    }

}
