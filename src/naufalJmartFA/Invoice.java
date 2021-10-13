package naufalJmartFA;

import java.util.Date;
import java.util.ArrayList;

public abstract class Invoice extends Recognizable
{
    public enum Status
    {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT,
        FINISHED, FAILED
    }
    public enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    public class Record{
        public Date date;
        public String message;
        public Status status;
    }
    
    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history;
    
    protected Invoice (int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = 0;
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
        this.date = new Date();
    }
    public abstract double getTotalPay();
}
