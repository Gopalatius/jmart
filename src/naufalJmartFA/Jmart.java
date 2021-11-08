package naufalJmartFA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;


public class Jmart {


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
    public static List<Product> filterByAccountId (List<Product> list, int accountId, int page, int pageSize){
        // tarok di array dulu
        Product[] tempList = new Product[list.size()];
        tempList = ((ArrayList<Product>) list).toArray(tempList);

        //filter
        ArrayList<Product> newList = new ArrayList<Product>();
        for (Product i : tempList){
            if (i.accountId == accountId){
                newList.add(i);
            }
        }

        //paginate
        Product[][] subArray = new Product[newList.size()/pageSize][pageSize];

        List<Product> retList = new ArrayList<Product>();

        Collections.addAll(retList, subArray[page]);

        return retList;
    }
    public static List<Product> filterByCategory(List<Product> list,
                                                 ProductCategory category){

        return Algorithm.<Product>collect(list,prod -> prod.category == category);
    }
    public static List<Product> filterByName (List<Product> list, String search, int page, int pageSize){
        // tarok di array dulu
        Product[] tempList = new Product[list.size()];
        tempList = ((ArrayList<Product>) list).toArray(tempList);

        //filter
        ArrayList<Product> newList = new ArrayList<Product>();
        String temp = null;
        for (Product i : tempList){
            temp = i.name;
            temp = temp.toLowerCase();
            if (temp.contains(search)){
                newList.add(i);
            }
        }
        //paginate
        Product[][] subArray = new Product[newList.size()/pageSize][pageSize];

        List<Product> retList = new ArrayList<Product>();

        Collections.addAll(retList, subArray[page]);

        return retList;
    }
    public static List<Product> filterByPrice(List<Product> list,
                                                 double minPrice,
                                              double maxPrice){
        List<Product> newList;
        if (minPrice == 0.0 && maxPrice == 0.0){
            newList = Algorithm.<Product>collect(list,prod -> true);
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
    private static List<Product> paginate (List<Product> list, int page, int pageSize, Predicate<Product> pred){

//        List<Product> newList = Algorithm.<Product>collect(list,prod -> pred);


        return null;
    }
    public static List<Product> read(String filepath) throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader(new FileReader(filepath));
        Product[] products = new Gson().fromJson(jsonReader,Product[].class);
        List<Product> prod = new ArrayList<Product>();

        Collections.addAll(prod, products);
        return prod;
    }
}
