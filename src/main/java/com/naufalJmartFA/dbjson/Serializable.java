package com.naufalJmartFA.dbjson;

import java.util.HashMap;
import java.util.Map;

public class Serializable implements Comparable<Serializable>
{
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    public final int id;

    protected Serializable()
    {
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id)
    {
        return mapCounter.put(clazz, id);
    }
    public static <T extends Serializable> Integer getClosingId(Class<T> clazz)
    {
        return mapCounter.get(clazz);
    }
    public boolean equals(Object other)
    {
        return other instanceof Serializable && ((Serializable) other).id == id;
    }
    public boolean equals(Serializable other)
    {
        return other.id == id;
    }

    @Override
    public int compareTo(Serializable other)
    {
        return Integer.compare(this.id, other.id);
    }
}
//public class Serializable implements Comparable<Serializable>
//{
//    public final int id;
//    private static Map<Class<?>,Integer> mapCounter = new HashMap();
//    protected Serializable(){
////        if (mapCounter.get(this.getClass()) == null){
////            Integer counter = 0;
////            mapCounter.put(this.getClass(),counter);
////            id = 0;
////        }else{
////            Integer counter = mapCounter.get(this.getClass());
////            mapCounter.put(this.getClass(), ++counter);
////            id = counter;
////        }
//        Integer counter = mapCounter.get(getClass());
//        counter = counter == null? 0 : counter + 1;
//        mapCounter.put(getClass(),counter);
//        this.id = counter;
//
//    }
//
//    public int compareTo(Serializable other){
//        return Integer.compare(this.id, other.id);
//    }
//
//    @Override
//    public boolean equals(Object other){
////        if (other instanceof Serializable){
////            Serializable serializable = (Serializable) other;
////            return (serializable.id == this.id);
////        }else{
////           return false;
////        }
//        return (other instanceof Serializable) && (((Serializable) other).id == this.id);
//
//    }
//
//    public static <T extends Serializable> Integer getClosingId(Class<T> clazz){
//
//        return mapCounter.get(clazz);
//    }
//    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id){
////        mapCounter.replace(clazz,id);
////        return mapCounter.get(clazz);
//        return mapCounter.put(clazz,id);
//    }
//    public boolean equals (Serializable other){
//        return (this.id == other.id);
//    }
//
//}
