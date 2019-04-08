package Units;


public  class Registers {
     private String name;
     private int address;
     private DataPath value=new DataPath(32);


     
     public void setname(String name){
         this.name=name;
     }
      public String getname(){
         return this.name;
     }
       public void setaddress(int address){
         this.address=address;
     }
       public int getaddress(){
         return this.address;
     }
       public void setvalue(int[] d1){
         this.value.setBits(d1);
     }
        public void setvaluebit(int place,int d1){
         this.value.setbyte(place,d1);
     }
         public DataPath getvalue(){
         return this.value;
     }
        public int getvaluebit(int address){
         return this.value.getbyte(address);
     }
}
