package Units;

public class  DataPath{
    private int [] bits;
    private int size;
    public DataPath(int size){
        this.size=size;
        this.bits=new int[size];
        for(int i=0; i<size; i++){
            this.bits[i]=0;
        }   
    }
    
    public int[] getBits(){
        return this.bits;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void setBits(int []bits){
      //  this.bits=new int[size];
        System.arraycopy(bits, 0, this.bits, 0, size);
    }
    
     public int getbyte(int i){
        return this.bits[i];
    }
     
     public void setbyte(int i,int value){
        this.bits[i]=value;
    }
    
    public void reset(){
        for(int i=0; i<this.size;i++)
            this.bits[i]=0;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof DataPath))
            return false;
        DataPath c=(DataPath)o;
        return (this.size==c.getSize())&&(this.bits==c.getBits());
    }
   @Override
   public String toString(){
        char[] temp=new char[this.size+1];
       for(int i=0;i<size;i++){
           temp[i]=(char)this.bits[i];
       }
       String s=String.valueOf(temp);
       return s;
   }
}
