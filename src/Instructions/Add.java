package Instructions;

import Units.Instruction;
import Units.*;
import java.util.Arrays;



public class Add extends Instruction implements Parse{

    public Add() {
        super("ADD", 0, 1);
    }
    
    @Override
    public String SetDataPath(String[] s) {
        opcode = "000000";
        int asd=findReg((s[2]));
    String jo = Arrays.toString(Parse.parseDtoB(asd,5));
        String replace = jo.replace(",", ""); //remove the commas
        String replace1 = replace.replace("[", ""); //remove the right bracket
        String replace2 = replace1.replace("]", ""); //remove the left bracket
         String trim = replace2.replace(" ", ""); //remove trailing spaces from partially initialized arrays
         rs=trim;
     jo = Arrays.toString(Parse.parseDtoB(findReg(s[3]),5));
     replace = jo.replace(",", ""); //remove the commas
         replace1 = replace.replace("[", ""); //remove the right bracket
         replace2 = replace1.replace("]", ""); //remove the left bracket
          trim = replace2.replace(" ", ""); //remove trailing spaces from partially initialized arrays
         rt=trim;
       jo = Arrays.toString(Parse.parseDtoB(findReg(s[1]),5));
        replace = jo.replace(",", ""); //remove the commas
         replace1 = replace.replace("[", ""); //remove the right bracket
         replace2 = replace1.replace("]", ""); //remove the left bracket
          trim = replace2.replace(" ", ""); //remove trailing spaces from partially initialized arrays
         rd=trim;
        shamt = "00000";
        func = "100000";
        return opcode +rs+rt+rd+shamt+func;
    }
}
