package naufalJmartFA;


public interface FileParser
{
    boolean read(String content);
    default boolean write(Object content){
        return false;
    }
    static Object newInstance(String content){
        return null;
    }
}
