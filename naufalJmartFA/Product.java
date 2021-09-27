package naufalJmartFA;



public class Product extends Recognizable implements FileParser
{

    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;
    
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, 
    PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration){
         super(id);
         this.name = name;
         this.weight = weight;
         this.conditionUsed = conditionUsed;
         this.priceTag = priceTag;
         this.category = category;
         this.storeId = storeId;
         this.rating = new ProductRating();
     }
    
    public boolean read(String content){
        return false;
    }
    public String toString(){
        return "Name: "+name+"\nWeight: "+weight+"\nconditionUsed: "+conditionUsed+
        "\npriceTag: "+priceTag+"\ncategory: "+category+"\nrating: "+rating+
        "\nstoreId: "+storeId;
    }
    
}
