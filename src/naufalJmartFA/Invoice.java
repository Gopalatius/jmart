package naufalJmartFA;

import java.util.Date;
import java.util.ArrayList;

public abstract class Invoice extends Serializable
{
    public enum Status
    {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT,
        FINISHED, FAILED, DELIVERED
    }
    public enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }

    public int buyerId;
    public int complaintId;
    public final Date date;
    public int productId;
    public Rating rating;
    
    protected Invoice (int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = -1;
        this.rating = Rating.NONE;
        this.date = new Date();
    }
    public abstract double getTotalPay(Product product);
}
