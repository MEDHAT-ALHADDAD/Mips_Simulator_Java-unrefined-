/*package Instructions;

import Units.*;


public  class Instructions{
    
    private static final int noOfIns=17;
    private Instruction[] Instructions;
    private int Type;
    private int insno;
    private DataPath opcode,rs,rt,rd,shamt,func,the16bit_address,the26bit_address;
    private String mainString;
    
    public Instructions() {
        this.Instructions = new Instruction[noOfIns];
        this.Type = 0;
        this.insno=0;
        this.mainString = new String();
        this.opcode =  new DataPath(6);
        this.rs =  new DataPath(5);
        this.rt =  new DataPath(5);
        this.rd =  new DataPath(5);
        this.shamt =  new DataPath(5);
        this.func =  new DataPath(6);        this.the16bit_address =  new DataPath(16);
        this.the26bit_address =  new DataPath(26);
    }
    
    public  void CreateMachineString(String[] instructions) {
        for(int i=0;i<Instructions.length;i++){
            if(instructions[0].equals(Instructions[i].getName()))
            {
              this.mainString =  Instructions[i].SetDataPath(instructions);
            }
            
        }   
    } 
    public void CreateSubDataPath(){
        this.opcode.setBits(Parse.parseDtoB(Integer.parseInt(this.mainString.substring(0, 5)),6));
         this.rs.setBits(Parse.parseDtoB(Integer.parseInt(this.mainString.substring(6, 10)),5));
         this.rt.setBits(Parse.parseDtoB(Integer.parseInt(this.mainString.substring(11, 15)),5));
         this.rd.setBits(Parse.parseDtoB(Integer.parseInt(this.mainString.substring(16, 20)),5));
         this.shamt.setBits(Parse.parseDtoB(Integer.parseInt(this.mainString.substring(21, 25)),5));
         this.func.setBits(Parse.parseDtoB(Integer.parseInt(this.mainString.substring(26, 31)),6));
         this.the16bit_address.setBits(Parse.parseDtoB(Integer.parseInt(this.mainString.substring(16, 31)),16));
         this.the26bit_address.setBits(Parse.parseDtoB(Integer.parseInt(this.mainString.substring(6, 31)),26));
    }
    public DataPath getRS(){
        return this.rs;
    }
    public DataPath getRT(){
        return this.rt;
    }
    public DataPath getRD(){
        return this.rd;
    }
    public DataPath getshamt(){
        return this.shamt;
    }
    public DataPath getfunc(){
        return this.func;
    }
    public DataPath get16(){
        return this.the16bit_address;
    }
    public DataPath get26(){
        return this.the26bit_address;
    }
}



*/