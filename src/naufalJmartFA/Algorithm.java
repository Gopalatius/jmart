package naufalJmartFA;
import java.util.Iterator;
import java.util.function.Predicate;


public class Algorithm {
    private Algorithm(){

    }
    public static <T> int count(T[] [] array, T value){
        int counter = 0;
        for (T[] i:array){
            counter++;
        }
        return counter;
    }
    public static <T> int count(Iterable<T> iterable, T value){
        int counter = 0;
        for (T i:iterable){
            counter++;
        }
        return counter;
    }
    public static <T> int count(Iterator<T> iterator, T value){
        int counter;
        for (counter = 0; iterator.hasNext();counter++){
            iterator.next();
        }
        return counter;
    }
    public static <T> int count(T[] [] array, Predicate<T> pred){
        int counter = 0;
        for (T[] i:array){
            for (T j:i){
                if (pred.test(j)){
                    counter++;
                }
            }

        }
        return counter;
    }
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
        int counter = 0;
        for (T i:iterable){
            if (pred.test(i)){
                counter++;
            }
        }
        return counter;
    }
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
        int counter;
        for (counter = 0; iterator.hasNext();counter++){
            if (pred.test(iterator.next())) {
                counter++;
            }
        }
        return counter;
    }
}
