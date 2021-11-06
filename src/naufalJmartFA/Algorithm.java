package naufalJmartFA;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.Comparator;




public class Algorithm {
    private Algorithm(){

    }

    public static <T> List<T> collect (T[] array, T value){
        List<T> list = new ArrayList<T>();
        if (value.equals(value)){
            for (int i = 0; i < array.length; i++){
                list.add(array[i]);
            }
        }
        return list;
    }
    public static <T> List<T> collect (Iterable<T> iterable, T value){
        List<T> list = new ArrayList<T>();
        if (value.equals(value)){
            for (T i : iterable){
                list.add(i);
            }
        }
        return list;
    }
    public static <T> List<T> collect (Iterator<T> iterator, T value){
        List<T> list = new ArrayList<T>();
        if (value.equals(value)) {
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
        }
        return list;
    }
    public static <T> List<T> collect (T[] array, Predicate<T> pred){
        List<T> list = new ArrayList<T>();
        for (T i: array){
            if (pred.test(i)){
                list.add(i);
            }
        }
        return list;
    }
    public static <T> List<T> collect (Iterable<T> iterable, Predicate<T> pred){
        List<T> list = new ArrayList<T>();
        for (T i: iterable){
            if (pred.test(i)){
                list.add(i);
            }
        }
        return list;
    }
    public static <T> List<T> collect (Iterator<T> iterator, Predicate<T> pred){
        List<T> list = new ArrayList<T>();
        T obj;
        while (iterator.hasNext()) {
            obj = iterator.next();
            if (pred.test(obj)) {
                list.add(obj);
            }
        }
        return list;
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
        while (iterator.hasNext()){
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

        while (iterator.hasNext()){
            if (pred.test(iterator.next())){
                return true;
            }
        }
        return false;
    }
    public static <T> T find (T[] array, T value){
        for (T i: array){
            if (i == value){
                return i;
            }
        }
        return null;
    }
    public static <T> T find (Iterable<T> iterable, T value){
        for (T i: iterable){
            if (i == value){
                return i;
            }
        }
        return null;
    }
    public static <T> T find (Iterator<T> iterator, T value){
        T temp;
        while (iterator.hasNext()){
            temp = iterator.next();
            if (value == temp){
                return temp ;
            }
        }
        return null;
    }
    public static <T> T find (T[] array, Predicate<T> pred){
        for (T i: array){
            if (pred.test(i)){
                return i;
            }
        }
        return null;
    }
    public static <T> T find (Iterable<T> iterable, Predicate<T> pred){
        for (T i: iterable){
            if (pred.test(i)){
                return i;
            }
        }
        return null;
    }
    public static <T> T find (Iterator<T> iterator, Predicate<T> pred){
        T temp;
        while (iterator.hasNext()){
            temp = iterator.next();
            if (pred.test(temp)){
                return temp ;
            }
        }
        return null;
    }
    public static <T extends Number> T max (T first, T second){
        if (first.doubleValue() > second.doubleValue()){
            return first;
        }else{
            return second;
        }
    }
    public static <T extends Number> T max (T[] array){
        T terbesar = array[0];
        for (T i : array){
            if (i.doubleValue() > terbesar.doubleValue()){
                terbesar = i;
            }
        }
        return terbesar;
    }
    public static <T extends Number> T max (Iterable<T> iterable) {
        boolean flag = false;
        T terbesar = null;
        for (T i : iterable) {
            if (!flag) {
                flag = true;
                terbesar = i;
            } else if (i.doubleValue() > terbesar.doubleValue()) {
                terbesar = i;
            }
        }
        return terbesar;
    }
    public static <T extends Number> T max (Iterator<T> iterator) {

        T terbesar = null;
        T temp;
        for (int counter = 0; iterator.hasNext(); counter++){
            temp = iterator.next();
            if (counter == 0){
                terbesar = temp;
            }else if(temp.doubleValue() > terbesar.doubleValue()){
                terbesar = temp;
            }
        }
        return terbesar;
    }
    public static <T extends Number> T max (T first, T second, Comparator<?super T> comparator) {

        T terbesar;
        if (comparator.compare(first,second) > 0){
            terbesar = first;
        }else{
            terbesar = second;
        }
        return terbesar;
    }
    public static <T extends Number> T max (T[] array, Comparator<?super T> comparator) {

        T terbesar = array[0];
        for (T i:array){
            if (comparator.compare(i,terbesar)>0){
                terbesar = i;
            }
        }
        return terbesar;
    }
    public static <T extends Number> T max (Iterable<T> iterable, Comparator<?super T> comparator) {
        boolean flag = false;
        T terbesar = null;
        for (T i : iterable) {
            if (!flag) {
                flag = true;
                terbesar = i;
            } else if (comparator.compare(i,terbesar) > 0) {
                terbesar = i;
            }
        }
        return terbesar;
    }
    public static <T extends Number> T max (Iterator<T> iterator, Comparator<?super T> comparator) {

        T terbesar = null;
        T temp;
        for (int counter = 0; iterator.hasNext(); counter++){
            temp = iterator.next();
            if (counter == 0){
                terbesar = temp;
            }else if(comparator.compare(temp,terbesar) > 0){
                terbesar = temp;
            }
        }
        return terbesar;
    }

    public static <T extends Number> T min (T first, T second){
        if (first.doubleValue() < second.doubleValue()){
            return first;
        }else{
            return second;
        }
    }

    public static <T extends Number> T min (T[] array){
        T terkecil = array[0];
        for (T i : array){
            if (i.doubleValue() < terkecil.doubleValue()){
                terkecil = i;
            }
        }
        return terkecil;
    }
    public static <T extends Number> T min (Iterable<T> iterable) {
        boolean flag = false;
        T terkecil = null;
        for (T i : iterable) {
            if (!flag) {
                flag = true;
                terkecil = i;
            } else if (i.doubleValue() < terkecil.doubleValue()) {
                terkecil = i;
            }
        }
        return terkecil;
    }
    public static <T extends Number> T min (Iterator<T> iterator) {

        T terkecil = null;
        T temp;
        for (int counter = 0; iterator.hasNext(); counter++){
            temp = iterator.next();
            if (counter == 0){
                terkecil = temp;
            }else if(temp.doubleValue() < terkecil.doubleValue()){
                terkecil = temp;
            }
        }
        return terkecil;
    }
    public static <T extends Number> T min (T first, T second, Comparator<?super T> comparator) {

        T terkecil;
        if (comparator.compare(first,second) < 0){
            terkecil = first;
        }else{
            terkecil = second;
        }
        return terkecil;
    }
    public static <T extends Number> T min (Iterable<T> iterable, Comparator<?super T> comparator) {
        boolean flag = false;
        T terkecil = null;
        for (T i : iterable) {
            if (!flag) {
                flag = true;
                terkecil = i;
            } else if (comparator.compare(i,terkecil) < 0) {
                terkecil = i;
            }
        }
        return terkecil;
    }
    public static <T extends Number> T min (Iterator<T> iterator, Comparator<?super T> comparator) {

        T terkecil = null;
        T temp;
        for (int counter = 0; iterator.hasNext(); counter++){
            temp = iterator.next();
            if (counter == 0){
                terkecil = temp;
            }else if(comparator.compare(temp,terkecil) < 0){
                terkecil = temp;
            }
        }
        return terkecil;
    }

}
