package Instructions;

import Units.Instruction;
import Units.*;
import java.util.Arrays;



public class LHU extends Instruction implements Parse{

    public LHU() {
        super("LHU", 1, 23);
    }

    
    @Override
    public String SetDataPath(String[] s) {
        opcode = "110011";
        rs = Parse.BtoS(Parse.parseDtoB(findReg(s[2]),5));
        rt =  Parse.BtoS(Parse.parseDtoB(findReg(s[1]),5));
        the16bit_address= Parse.BtoS(Parse.parseDtoB(Integer.parseInt(s[3]),16));
        return opcode +rs+rt+the16bit_address;
    }
}

