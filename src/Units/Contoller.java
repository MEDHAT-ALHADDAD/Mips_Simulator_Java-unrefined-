package Units;

import java.util.Arrays;

public class Contoller {
   private String ALUOp, RegDst, ALUSrc, Branch, Jump, JumpReg,PCSrc, RegWrite, MemWrite, MemRead, MemToReg,shiftlogic,lui;

    public Contoller() {
       reset();
    }

    public void setInput(DataPath opc,DataPath fun){
        String opcode=Parse.BtoS(opc.getBits());
        String funct =Parse.BtoS(fun.getBits());
        reset();
       switch (opcode) {
           case "000000"://rtype
            switch (funct) {
                case "000000"://label,nop
                    reset();
                  break;
                case "001000"://jr
                 PCSrc="1";
                 break;
                case "111000":
                case "111001":
                    shiftlogic="1";
                    RegDst="1";
                    RegWrite="01";
                    ALUOp ="100";
                    break;
                default: //rest rtype
                    RegDst = "1";
                    RegWrite = "01";
                    ALUOp = "100";
                    break;
        }
break;
               //lw,lb,lbu,lh,lhu
           case "100011":
               MemRead="001";//lw
                ALUSrc = "1";
               MemToReg = "1";
               RegWrite = "01";
               break;
               /*case"001111"://liu
                   lui="1";
                   RegWrite="01";
                   break;*/
               case"110000":
                    ALUSrc = "1";
               MemToReg = "1";
               RegWrite = "01";
                   MemRead="100";//lb
                   break;
                   case"110001":
                        ALUSrc = "1";
               MemToReg = "1";
               RegWrite = "01";
                       MemRead="011";//lbu
                       break;
                       case"110010":
                            ALUSrc = "1";
               MemToReg = "1";
               RegWrite = "01";
                       MemRead="010";//lh
                       break;
                       case"110011":
                            ALUSrc = "1";
               MemToReg = "1";
               RegWrite = "01";
                       MemRead="101";//lhu
                       break;
               //sw,sb,sh
               case"101011"://sw
                   ALUSrc = "1";
                   MemWrite="10";
                       break;
                       case"101100":
                   ALUSrc = "1";
                   MemWrite="01";
                       break;
                       case"101101":
                   ALUSrc = "1";
                   MemWrite="11";
                       break;
           case "000100":
               //bne
               Branch = "1";
               ALUOp = "001";
               break;
           case "000101":
                //bne
               Branch = "1";
               ALUOp = "111";
               break;
           case "001000":
           case "001100":
           case "001101":
           case"110110":
               // addi, andi, ori q,slti
               ALUSrc = "1";
               
               RegWrite = "01";
        switch (opcode) {
            case "001000":
                ALUOp = "000";//addi
                break;
            case "001100":
                ALUOp = "011";//andi
                break;
            case "001101":
                ALUOp = "010";//ori
                break;
            case"110110":
                ALUOp="101";//slti
                break;
            default:
                break;
        }
               break;
           case "000010":
               // j, jal
               Jump = "1";
               break;
           case "000011":
               Jump = "1";
               RegWrite = "10";
               JumpReg="1";
               break;
           default:
               break;
       }
    }
    
    private void reset(){
        ALUOp = "000";
        RegDst = "0";
        ALUSrc = "0";
        shiftlogic="0";
        Branch = "0";
        Jump = "0";
        JumpReg = "0";
        PCSrc = "0";
        RegWrite = "00";
        MemWrite = "0";
        MemRead = "0";
        MemToReg = "0";
    }
    
    public String getALUop(){
        return this.ALUOp;
    }
    
    public String getLui(){
        return lui;
    }
    
    public String getShift(){
        return this.shiftlogic;
    }
    
    public String getRegDst(){
        return this.RegDst;
    }
    
    public String getALUSrc(){
        return this.ALUSrc;
    }
    
    public String getBranch(){
        return this.Branch;
    }
    
    public String getJump(){
        return this.Jump;
    } 
    
    public String getJumpReg(){
        return this.JumpReg;
    }
    
    public String getPCSrc(){
        return this.PCSrc;
    }
    
    public String getRegWrite(){
        return this.RegWrite;
    }
    
    public String getMemWrite(){
        return this.MemWrite;
    }
    
    public String getMemRead(){
        return this.MemRead;
    }
    
    public String getMemToReg(){
        return this.MemToReg;
    }
}
