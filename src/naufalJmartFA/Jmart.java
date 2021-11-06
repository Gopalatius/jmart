package naufalJmartFA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;


public class Jmart {
//    class Country
//    {
//        public String name;
//        public int population;
//        public List<String> listOfStates;
//    }

    public static void main(String[] args){
        // sesuaikan dengan lokasi di sistem anda kepada city.json
        String filepath = "/My Drive/PC/Kuliah/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Testing/jmart/lib/randomProductList.json";
        try {
            List<Product> list = read(filepath);
            List<Product> filtered = filterByPrice(list,0.0, 20000.0);
            filtered.forEach(product -> System.out.println(product.price));

        }catch (Throwable t){
            t.printStackTrace();
        }

    }
    public static List<Product> filterByCategory(List<Product> list,
                                                 ProductCategory category){

        return Algorithm.<Product>collect(list,prod -> prod.category == category);
    }
    public static List<Product> filterByPrice(List<Product> list,
                                                 double minPrice,
                                              double maxPrice){
        List<Product> newList;
        if (minPrice == 0.0 && maxPrice == 0.0){
            newList = Algorithm.<Product>collect(list,prod -> 0 == 0);
        }
        else if (minPrice == 0.0) {
            newList = Algorithm.<Product>collect(list,prod -> prod.price <= maxPrice);
        }else if (maxPrice == 0.0){
            newList = Algorithm.<Product>collect(list,prod -> prod.price >= minPrice);
        }else{
            newList = Algorithm.<Product>collect(list,prod -> (prod.price >= minPrice && prod.price <= maxPrice));
        }

        return newList;
    }
    public static List<Product> read(String filepath) throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader(new FileReader(filepath));
        Product[] products = new Gson().fromJson(jsonReader,Product[].class);
        List<Product> prod = new ArrayList<Product>();

        for (int i = 0; i < products.length; i++){
            prod.add(products[i]);
        }
        return prod;
    }
}
