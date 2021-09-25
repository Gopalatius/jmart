package naufalJmartFA;



public class Product extends Recognizable
{

    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;
    
    public Product(int id, int storeId, String name, int weight, boolean 
    conditionUsed, PriceTag priceTag, ProductCategory category){
         super(id);
         this.name = name;
         this.weight = weight;
         this.conditionUsed = conditionUsed;
         this.priceTag = priceTag;
         this.category = category;
         this.storeId = storeID;
         rating = new ProductRating();
     }
    public Product (int id, Store store, String name, int weight, boolean
    conditionUsed, PriceTag priceTag, ProductCategory category){
        super(id,store);
        this.name = name;
         this.weight = weight;
         this.conditionUsed = conditionUsed;
         this.priceTag = priceTag;
         this.category = category;
         this.storeId = storeID;
         rating = new ProductRating();
    }
    
}
