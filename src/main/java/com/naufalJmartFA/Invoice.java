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
     * Constructor dari Invoice yang akan mengisi complaintId dengan -1, Rating.None, dan Date menjadi waktu ketika
     * object payment nanti dibuat.
     * @param buyerId id dari pembeli.
     * @param productId id dari product.
     */
    protected Invoice (int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = -1;
        this.rating = Rating.NONE;
        this.date = new Date();
    }

    /**
     * Sebuah fungsi abstract untuk mendapatkan harga total dari product.
     * @param product product yang ingin diketahui harga totalnya.
     * @return harga totalnya.
     */
    public abstract double getTotalPay(Product product);
}
