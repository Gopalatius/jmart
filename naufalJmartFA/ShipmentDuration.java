package naufalJmartFA;


public class ShipmentDuration
{
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1 << 0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1 << 1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1 << 2);
    public static final ShipmentDuration REGULER = new ShipmentDuration(1 << 3);
    public static final ShipmentDuration KARGO = new ShipmentDuration(1 << 4);
    
    private final int bit;
    
    private ShipmentDuration(int bit){
        this.bit =  bit;
    }
    
    public ShipmentDuration(ShipmentDuration... args){
        int bitTemp = 0;
        for (ShipmentDuration S:args){
            bitTemp |= S.bit;
            
        }
        this.bit = bitTemp;
    }
    
    public boolean isDuration(ShipmentDuration reference){
        return ((this.bit & reference.bit) != 0);
    }
    

    
}
