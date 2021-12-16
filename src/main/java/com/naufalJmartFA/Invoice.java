package com.naufalJmartFA;

import com.naufalJmartFA.dbjson.Serializable;

import java.util.Date;

/**
 * Abstract object untuk diinherit ke Payment.
 * Juga extends Serializable.
 * @author Muhammad Naufal Faza
 */
public abstract class Invoice extends Serializable
{
    /**
     * Memiliki status dari barang-barang yang dibeli.
     */
    public enum Status
    {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT,
        FINISHED, FAILED, DELIVERED
    }

    /**
     * Memiliki rating dari barang-barang yang dibeli.
     */
    public enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }

    public int buyerId;
    public int complaintId;
    public final Date date;
    public int productId;
    public Rating rating;

    /**
     * Constructor will assign complaintId with -1, Rating.None, dan Date as time when object is created.
     * @param buyerId is the account Id of the buyer.
     * @param productId is the Id of the product.
     */
    protected Invoice (int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = -1;
        this.rating = Rating.NONE;
        this.date = new Date();
    }

    /**
     * To get how much must the buyer pay.
     * @param product the product which the buyer wants to know the total pay.
     * @return the total amount that needs to be paid.
     */
    public abstract double getTotalPay(Product product);
}
