package naufalJmartFA;



public abstract class Transaction extends Recognizable
{
    public enum Rating
    {
    NONE, BAD, NEUTRAL, RATING;
    }
    public String time;
    public int buyerId;
    public int storeId;
    public Rating rating;
    
    protected Transaction (int id, int buyerId, int storeId){
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
        this.rating = Rating.NONE;
        this.time = "Time";
    }
    protected Transaction (int id, Account buyer, Store store){
        super(id);
        this.buyerId = buyer.id;
        this.storeId = store.id;
    }
}

