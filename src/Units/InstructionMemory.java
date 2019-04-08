package Units;

    import Instructions.*;
    import com.sun.org.apache.bcel.internal.generic.GOTO;
    import java.io.*;
    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.logging.Level;
    import java.util.logging.Logger;

public class InstructionMemory extends InstructionMemoryUnit{
    private InstructionMemoryUnit[] instructionMemory;
    private int i;
    private  final int noOfIns=28;
    private Instruction[] Instructions;
    private static int Type=0;
    private int insno=0;
    private DataPath opcode,rs,rt,rd,shamt,func,the16bit_address,the26bit_address;
    private String mainString;
    private static ArrayList<labels> labels=new ArrayList();
    public InstructionMemory() {
        this.instructionMemory = new InstructionMemoryUnit[1000];
         this.Instructions = new Instruction[noOfIns];
         Instructions[0]=new Add();
         Instructions[1]=new Addi();
         Instructions[2]=new AND();
         Instructions[3]=new ANDI();
         Instructions[4]=new BEQ();
         Instructions[5]=new BNE();
         Instructions[6]=new J();
         Instructions[7]=new JAL();
         Instructions[8]=new JR();
         Instructions[9]=new NOR();
         Instructions[10]=new OR();
         Instructions[11]=new LW();
         Instructions[12]=new SW();
         Instructions[13]=new SLL();
         Instructions[14]=new SUB();
         Instructions[15]=new SRL();
         Instructions[16]=new SLT();
         Instructions[17]=new SLTU();
         Instructions[18]=new LB();
         Instructions[19]=new LBU();
         Instructions[20]=new LH();
         Instructions[21]=new LHU();
         Instructions[22]=new SB();
         Instructions[23]=new SH();
         Instructions[24]=new ORI();
         Instructions[25]=new MUL();
         Instructions[26]=new DIV();
         Instructions[27]=new SLTI();

   //     this.Type = 0;
        this.insno=0;
        this.mainString = new String();
        this.opcode =  new DataPath(6);
        this.rs =  new DataPath(5);
        this.rt =  new DataPath(5);
        this.rd =  new DataPath(5);
        this.shamt =  new DataPath(5);
        this.func =  new DataPath(6); 
        this.the16bit_address =  new DataPath(16);
        this.the26bit_address =  new DataPath(26);
     //  labels.add(new labels(0,"label:"));
    }
    
    public void setinstruction(String file,int offset){
         FileReader f1 = null;
        try {
            f1 = new FileReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InstructionMemory.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Scanner sc = new Scanner(f1)) {
            i=0;
            while(sc.hasNextLine()){
                String temp = sc.nextLine();
                if("".equals(temp)){
                    
                }
                else{
                String[] temp1 = temp.split(",");
                
                for(int m=0;m<temp1.length;m++){
                String  replace = temp1[m].replace(",", ""); //remove the commas
                String  replace1 = replace.replace("[", ""); //remove the right bracket
                String replace2 = replace1.replace("]", ""); //remove the left bracket
                String trim = replace2.replace(" ", ""); //remove trailing spaces from partially initialized arrays
                temp1[m]=trim;
                }
                
                 if((temp1[0].charAt(temp1[0].length()-1))==':'){
                     String as=temp1[0];
                     String  replace = as.replace(":", ""); //remove the commas
                     String  replace1 = replace.replace("[", ""); //remove the right bracket
                     String replace2 = replace1.replace("]", ""); //remove the left bracket
                     String trim = replace2.replace(" ", ""); //remove trailing spaces from partially initialized arrays
                     labels templ=new labels((i),trim);
                     labels.add(templ);
                 }
                 else{
                     temp1[0]=temp1[0].toUpperCase();
                 }
                instructionMemory[i]=new InstructionMemoryUnit() ;
                instructionMemory[i].InstructionlineNo=((4*i)+offset);
                instructionMemory[i].InstructionLine=temp1;
                i++;
                }
            }
        }
    }
    
    public  void CreateMachineString(String[] instructions) {
        for (Instruction Instruction : Instructions) {
                 if (instructions[0].equals(Instruction.getName())) {
                this.mainString = Instruction.SetDataPath(instructions);
                break;
            }
        }
          if((instructions[0].charAt(instructions[0].length()-1))==':'){
              /*labels templ=new labels( getInstructionlineNo(),instructions[0]);
                labels.add(templ);
                Type=1;*/
                this.mainString= "00000000000000000000000000000000";
          }
    }    

    public static int getLabelssize() {
        return labels.size();
    }

    public static ArrayList getLabels() {
        return labels;
    }
    
    public void CreateSubDataPath(){
    //    if (Type==1){
            
    //    }
      //  else{
        //    Type=0;
        this.opcode.setBits(Parse.parseStoB(this.mainString.substring(0, 6),6));
         this.rs.setBits(Parse.parseStoB(this.mainString.substring(6, 11),5));
         this.rt.setBits(Parse.parseStoB(this.mainString.substring(11, 16),5));
         this.rd.setBits(Parse.parseStoB(this.mainString.substring(16, 21),5));
         this.shamt.setBits(Parse.parseStoB(this.mainString.substring(21, 26),5));
         this.func.setBits(Parse.parseStoB(this.mainString.substring(26, 32),6));
         this.the16bit_address.setBits(Parse.parseStoB((this.mainString.substring(16, 32)),16));
         this.the26bit_address.setBits(Parse.parseStoB((this.mainString.substring(6, 32)),26));
    }
  //  }
    public DataPath getOpcode() {
        return opcode;
    }
    
    public int getI(){
        return i;
    }

    public DataPath getRd() {
        return rd;
    }

    public DataPath getRs() {
        return rs;
    }

    public DataPath getRt() {
        return rt;
    }

    public DataPath getShamt() {
        return shamt;
    }

    public DataPath getThe16bit_address() {
        return the16bit_address;
    }

    public DataPath getThe26bit_address() {
        return the26bit_address;
    }

    public String[] getInstructionLine(int j) {
        return instructionMemory[j].InstructionLine;//fe hena mo4kela m4 3aref eh hya
    }

    public int getInstructionlineNo() {
        return InstructionlineNo;
    }
    

    public String getMainString() {
        return mainString;
    }

    public  int getNoOfIns() {
        return noOfIns;
    } 

    public DataPath getFunc() {
        return func;
    }
    
}
