package naufalJmartFA;
import java.util.Iterator;
import java.util.function.Predicate;


public class Algorithm {
    private Algorithm(){

    }
    public static <T> int count(T[] array, T value){
        int counter = 0;
        for (T i:array){
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
    public static <T> int count(T[] array, Predicate<T> pred){
        int counter = 0;
        for (T i:array){
            if (pred.test(i)) {
                counter++;
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
    public static <T> boolean exists(T[] array, T value){
        for (T i: array){
            if (i == value){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(Iterable<T> iterable, T value){
        for (T i: iterable){
            if (i == value){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(Iterator<T> iterator, T value){
        int counter;
        for (counter = 0; iterator.hasNext();counter++){
            if (value == iterator.next()){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(T [] array, Predicate<T> pred){
        for (T i: array){
            if (pred.test(i)){
                return true;
            }

        }
        return false;
    }
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        for (T i:iterable){
            if(pred.test(i)){
                return true;
            }
        }
        return false;
    }
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
       int counter;
        for (counter = 0; iterator.hasNext();counter++){
            if (pred.test(iterator.next())){
                return true;
            }
        }
        return false;
    }


}
