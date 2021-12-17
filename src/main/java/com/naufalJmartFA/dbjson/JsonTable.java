package com.naufalJmartFA.dbjson;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;
import java.io.*;

/**
 * Class to read from Json
 * @param <T> generic
 * @author Netlab
 */
public class JsonTable<T> extends Vector<T>
{
    /**
     * A gson so to read from Json.
     */
    private static final Gson gson = new Gson();
    public final String filepath;

    /**
     * Constructor
     * @param clazz the json file that can be assigned to a class
     * @param filepath filepath of the json
     * @throws IOException Input/Output exception.
     */
    @SuppressWarnings("unchecked")
    public JsonTable(Class<T> clazz, String filepath) throws IOException
    {
        this.filepath = filepath;
        try
        {
            Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] loaded = readJson(arrayType, filepath);
            if (loaded != null)
                Collections.addAll(this, loaded);
        }
        catch (FileNotFoundException e) {}
    }

    /**
     * Write to Json
     * @throws IOException Input/Output exception.
     */
    public void writeJson() throws IOException
    {
        writeJson(this, this.filepath);
    }

    /**
     * Write to json
     * @param object the object that want to be written to json
     * @param filepath the filepath of where the json file is.
     * @throws IOException Input/Output Exception.
     */
    public static void writeJson(Object object, String filepath) throws IOException
    {
        File file = new File(filepath);
        if (!file.exists())
        {
            File parent = file.getParentFile();
            if (parent != null)
                parent.mkdirs();
            file.createNewFile();
        }
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }

    /**
     * Reading from json
     * @param clazz what class does it expected to read
     * @param filepath where the filepath of the json file
     * @param <T> generic
     * @return the variable that just been read from the json file
     * @throws FileNotFoundException exception if the file is not found
     */
    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);
    }
}


//public class JsonTable<T> extends Vector<T> {
//    public final String filepath;
//    private static final Gson gson = new Gson();
//
//    public JsonTable (Class<T> clazz, String filepath) throws IOException{
//        this.filepath = filepath;
//        try{
//            Class<T[]> arrayOfGeneric = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
//            T[] genericArray = readJson(arrayOfGeneric,filepath);
//            if (genericArray != null){
//                Collections.addAll(this,genericArray);
//            }
//
//        }catch (IOException e){
//            File file = new File(filepath);
//            File dir = file.getParentFile();
//            dir.mkdirs();
//
//            file.createNewFile();
//        }
//    }
//    public static <T> T readJson (Class<T> clazz, String filepath) throws FileNotFoundException{
//        JsonReader jsonReader = new JsonReader(new FileReader(filepath));
//        T readJson = gson.fromJson(jsonReader,clazz);
//
//        return readJson;
//    }
//    public void writeJson () throws IOException{
//        writeJson(this,this.filepath);
//    }
//    public static void writeJson(Object object, String filepath) throws IOException{
//        FileWriter fwrite = new FileWriter(filepath);
//        String string = gson.toJson(object);
//        fwrite.write(string);
//        fwrite.close();
//    }
//}
