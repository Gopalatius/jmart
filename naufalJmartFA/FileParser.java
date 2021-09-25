package naufalJmartFA;


public interface FileParser
{
    boolean read(String content);
    public boolean write(Object content);
    public Object newInstance(String content);
}
