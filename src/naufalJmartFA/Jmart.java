package naufalJmartFA;

import java.util.Date;


public class Jmart {
    public static long DELIVERED_LIMIT_MS = 1;
    public static long ON_DELIVERY_LIMIT_MS = 2;
    public static long ON_PROGRESS_LIMIT_MS = 3;
    public static long WAITING_CONF_LIMIT_MS = 4;

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
    public static boolean paymentTimekeeper (Payment payment){
        Date now = new Date();
        int indexOfLastRecord = payment.history.size()-1;
        Payment.Record temp = payment.history.get(indexOfLastRecord);
        Payment.Record temp2 = new Payment.Record(null,null);


        if (((temp.status == Invoice.Status.WAITING_CONFIRMATION) &&
                (now.getTime() - temp.date.getTime() > WAITING_CONF_LIMIT_MS)) ||
                ((temp.status == Invoice.Status.ON_PROGRESS) &&
                        (now.getTime() - temp.date.getTime() > ON_PROGRESS_LIMIT_MS)))
        {
            temp2.status = Invoice.Status.FAILED;
            temp2.message = "Waduh gagal!";
        }else if((temp.status == Invoice.Status.ON_DELIVERY) && (now.getTime() -
                temp.date.getTime() > ON_DELIVERY_LIMIT_MS)){
            temp2.status = Invoice.Status.DELIVERED;
            temp2.message = "Berhasil dikirim!";
        } else if ((temp.status == Invoice.Status.DELIVERED) && (now.getTime() -
                temp.date.getTime() > DELIVERED_LIMIT_MS)){
            temp2.status = Invoice.Status.FINISHED;
            temp2.message = "Selesai!";
        } else if (temp.status == null){
            return false;
        }
        payment.history.add(temp2);
        return false;
    }
//    public static List<Product> filterByAccountId (List<Product> list, int accountId, int page, int pageSize){
//
//        return Algorithm.<Product>paginate(list,page,pageSize,prod -> prod.accountId == accountId);
//    }
//    public static List<Product> filterByCategory(List<Product> list,
//                                                 ProductCategory category){
//
//        return Algorithm.<Product>collect(list,prod -> prod.category == category);
//    }
//    public static List<Product> filterByName (List<Product> list, String search, int page, int pageSize){
//
//        return Algorithm.<Product>paginate(list,page,pageSize,prod -> prod.name.toLowerCase().contains(search.toLowerCase()));
//    }
//    public static List<Product> filterByPrice(List<Product> list,
//                                                 double minPrice,
//                                              double maxPrice){
//        List<Product> newList;
//        if (minPrice == 0.0 && maxPrice == 0.0){
//            newList = Algorithm.<Product>collect(list,prod -> true);
//        }
//        else if (minPrice == 0.0) {
//            newList = Algorithm.<Product>collect(list,prod -> prod.price <= maxPrice);
//        }else if (maxPrice == 0.0){
//            newList = Algorithm.<Product>collect(list,prod -> prod.price >= minPrice);
//        }else{
//            newList = Algorithm.<Product>collect(list,prod -> (prod.price >= minPrice && prod.price <= maxPrice));
//        }
//
//        return newList;
//    }

//    public static List<Product> read(String filepath) throws FileNotFoundException {
//        JsonReader jsonReader = new JsonReader(new FileReader(filepath));
//        Product[] products = new Gson().fromJson(jsonReader,Product[].class);
//        List<Product> prod = new ArrayList<Product>();
//
//        Collections.addAll(prod, products);
//        return prod;
//    }
}
