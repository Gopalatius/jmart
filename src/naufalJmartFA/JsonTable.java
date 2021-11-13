package naufalJmartFA;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;
import java.io.*;


public class JsonTable<T> extends Vector {
    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable (Class<T> clazz, String filepath) throws IOException{
        this.filepath = filepath;
        try{
            Class<T[]> arrayOfGeneric = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] genericArray = readJson(arrayOfGeneric,filepath);
            Collections.addAll(this,genericArray);
        }catch (IOException e){
            File file = new File(filepath);
        }
    }
    public static <T> T readJson (Class<T> clazz, String filepath) throws FileNotFoundException{
        JsonReader jsonReader = new JsonReader(new FileReader(filepath));
        T readJson = gson.fromJson(jsonReader,clazz);

        return readJson;
    }
    public void writeJson () throws IOException{
        writeJson(this.gson,this.filepath);
    }
    public static void writeJson(Object object, String filepath) throws IOException{
        FileWriter fwrite = new FileWriter(filepath);
        String string = gson.toJson(object);
        fwrite.write(string);
        fwrite.close();
    }
}
