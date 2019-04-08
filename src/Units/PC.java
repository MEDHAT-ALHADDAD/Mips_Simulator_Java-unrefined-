package Units;

import static Units.Parse.parseDtoB;


public class PC implements Parse{
    private DataPath d1;
    private static int counter;
    private static  int current;
    
    public PC(int startAddress){
        this.d1 =new DataPath(32);
        d1.setBits(parseDtoB(startAddress,32));
    }
    
    public int getCounter(){
        return counter;
    }
    
    public DataPath getPC(){
        return d1;
    }
    
    public void setPC(int[] value){
        this.d1.setBits(value);
        current=(((Parse.parseBtoD(d1.getBits()))-Units.Instruction.offset)/4);
    }

    public static int getCurrent() {
        
        return current;
    }
    
    
     public void InstructionCounterPlus(){
        counter++;
    }
    
    public void rest(){
        counter=0;
        for(int i=0; i<32; i++){
            this.d1.setbyte(i, 0);
        }
    }
    
    
}
