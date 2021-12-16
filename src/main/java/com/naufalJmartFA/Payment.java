package com.naufalJmartFA;

import java.util.ArrayList;
import java.util.Date;

/**
 * Class payment for the payment that has been done by the account.
 * @author Muhammad Naufal Faza
 */
public class Payment extends Invoice
{
    public ArrayList<Record> history = new ArrayList<Record>();
    public int productCount;
    public Shipment shipment;

    /**
     * The constructor to assign the parameter.
     * @param buyerId the ID of the account.
     * @param productId the ID of the prodcut.
     * @param productCount how many products.
     * @param shipment what shipment plans is used.
     */
    public Payment (int buyerId, int productId, int productCount,
                    Shipment shipment){
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;

    }

    /**
     * The payment has record history. This is for that.
     */
    public static class Record{
        public final Date date;
        public String message;
        public Status status;

        /**
         * The constructor to assign the parameter to the instance variables.
         * @param status the status of the Record.
         * @param message the message of the Record.
         */
        public Record (Status status, String message){
            this.date = new Date();
            this.message = message;
            this.status = status;
        }
    }

    /**
     * The overrided function
     * @param product the product which the buyer wants to know the total pay.
     * @return the amount that needs to be paid.
     */
    @Override
    public double getTotalPay (Product product){
        return product.price* (1-product.discount);
    }
    
}
