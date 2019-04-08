package Units;

import java.util.ArrayList;
import Units.labels;

public abstract class Instruction extends RegisterFile{
 /*   protected static final int Rtype=0;
    protected static final int Itype=1;
    protected static final int Jtype=2;*/
    protected String name;
    protected int Type;
    protected int Instruction_no;
    protected String opcode,rs,rt,rd,shamt,func,the16bit_address,the26bit_address;
    protected static int offset=0;
    public Instruction(String name, int Type, int Instruction_no) {
        this.name = name;
        this.Type = Type;
        this.Instruction_no = Instruction_no;
        opcode=new String();
         rs=new String();
         rt=new String();
         shamt=new String();
         func=new String();
         the16bit_address=new String();
         the26bit_address=new String();
    }
    public void setInstruction_no(int Instruction_no) {
        this.Instruction_no = Instruction_no;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(int Type) {
        this.Type = Type;
    }
    public int getInstruction_no() {
        return Instruction_no;
    }
    public String getName() {
        return name;
    }
    public int getType() {
        return Type;
    }
    public int findReg(String s){
        for(int i=0;i<32;i++){
            if(s.equalsIgnoreCase(register[i].getname())){
                return register[i].getaddress();
            }
        }
        return -1;
    }
    public int findlabel(String s){
        ArrayList<labels> temp =InstructionMemory.getLabels();
        for(int i=0;i<InstructionMemory.getLabelssize();i++){
            labels ds =temp.get(i);
            if((ds.getLabel()).equals(s)){
                return (ds.getLineno());
            }
        }
        return -1;
    }

    public static void setOffset(int offset) {
        Instruction.offset = offset;
    }
    
    public  abstract String SetDataPath(String[] s);
}
