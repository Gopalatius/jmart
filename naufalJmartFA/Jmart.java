package naufalJmartFA;

public class Jmart {
    public static void main(String[] args){
        
    }
    public static Product create(){
        PriceTag priceTag = new PriceTag(100000.0d,20.0d);
        ProductCategory category = ProductCategory.BOOK;
        Product product = new Product("Harry Potter", 1, true, priceTag ,
        category);
        return product;
    }
}
