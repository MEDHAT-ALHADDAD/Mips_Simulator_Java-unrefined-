package Instructions;

import Units.Instruction;
import Units.*;
import java.util.Arrays;



public class LB extends Instruction implements Parse{

    public LB() {
        super("LB", 1, 20);
    }

    
    @Override
    public String SetDataPath(String[] s) {
        opcode = "110000";
        rs = Parse.BtoS(Parse.parseDtoB(findReg(s[2]),5));
        rt =  Parse.BtoS(Parse.parseDtoB(findReg(s[1]),5));
        the16bit_address= Parse.BtoS(Parse.parseDtoB(Integer.parseInt(s[3]),16));
        return opcode +rs+rt+the16bit_address;
    }
}
