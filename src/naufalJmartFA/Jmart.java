package naufalJmartFA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;


public class Jmart {


    public static void main(String[] args){
        // sesuaikan dengan lokasi di sistem anda kepada city.json
//        String filepath = "/My Drive/PC/Kuliah/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Testing/jmart/lib/randomProductList.json";

        try {
            String filepath = "a/b/c/account.json";

            JsonTable<Account> tableAccount = new JsonTable<>(Account.class,filepath);
            tableAccount.add(new Account("name","email","password", 0));
            tableAccount.writeJson();

            tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.forEach(account -> System.out.println(account.toString()));
        }catch (Throwable t){
            t.printStackTrace();
        }

    }
    public static List<Product> filterByAccountId (List<Product> list, int accountId, int page, int pageSize){

        return paginate(list,page,pageSize,prod -> prod.accountId == accountId);
    }
    public static List<Product> filterByCategory(List<Product> list,
                                                 ProductCategory category){

        return Algorithm.<Product>collect(list,prod -> prod.category == category);
    }
    public static List<Product> filterByName (List<Product> list, String search, int page, int pageSize){

        return paginate(list,page,pageSize,prod -> prod.name.toLowerCase().contains(search.toLowerCase()));
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
        List<List<Product>> newList = new ArrayList<List<Product>>();
        List<Product> filteredList = new ArrayList<Product>();
        for (int i = 0; i < list.size(); i++){
            if (pred.test(list.get(i))){
                filteredList.add(list.get(i));
            }
        }
        final int ukuran = filteredList.size();
        for (int i = 0; i < ukuran; i += pageSize){
                newList.add(new ArrayList<Product>(list.subList
                        (i, Math.min(ukuran,i + pageSize))));

        }

        return newList.get(page);
    }
    public static List<Product> read(String filepath) throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader(new FileReader(filepath));
        Product[] products = new Gson().fromJson(jsonReader,Product[].class);
        List<Product> prod = new ArrayList<Product>();

        Collections.addAll(prod, products);
        return prod;
    }
}
