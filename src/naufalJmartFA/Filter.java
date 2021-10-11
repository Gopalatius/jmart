package naufalJmartFA;

import java.util.ArrayList;

public class Filter
{
    public static ArrayList<Treasury> filterPriceTag(Treasury[] list,
    int value, boolean less){
        ArrayList<Treasury> priceTag = new ArrayList<Treasury>();
        for (Treasury i:list){
            if (less == true){
                if (i.getAdjustedPrice(2000,20) < value){
                    priceTag.add(i);
                }
            }else{
                if (i.getAdjustedPrice(2000,20) >= value){
                    priceTag.add(i);
                }
            }
        }
        return priceTag;
    }
    public static void filterProductRating(ArrayList<ProductRating> list,
    double value, boolean less){
        ArrayList<ProductRating> productRating = new ArrayList<ProductRating>();
        for (int i = 0; i < list.size(); i++){
            ProductRating pro = list.get(i);
            if (less == true){
                if (pro.getAverage() >= value){
                    list.remove(i);
                }
            }else{
                if (pro.getAverage() < value){
                    list.remove(i);
                }
            }
        }
    }
}
