package naufalJmartFA;



public class Shipment implements FileParser
{
     public class MultiDuration
    {
        public final byte bit;
        
        public MultiDuration(Duration... args){
            byte bitTemp = 0;
            for (Duration S:args){
                bitTemp |= S.bit;
                
            }
            this.bit = bitTemp;
        }
        
        public boolean isDuration(Duration reference){
            return ((this.bit & reference.bit) != 0);
        }
    }
    public class Duration
    {
        public final Duration INSTANT = new Duration((byte)(1 << 0));
        public final Duration SAME_DAY = new Duration((byte)(1 << 1));
        public final Duration NEXT_DAY = new Duration((byte)(1 << 2));
        public final Duration REGULER = new Duration((byte)(1 << 3));
        public final Duration KARGO = new Duration((byte)(1 << 4));
        
        public final byte bit;
        
        private Duration(byte bit){
            this.bit =  bit;
        }
    }
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public Shipment(String address, int shipmentCost, Duration duration,
    String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
    public boolean read (String content){
        return false;
    }
}
