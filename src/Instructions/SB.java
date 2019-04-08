package Instructions;

import Units.Instruction;
import Units.*;



public class SB extends Instruction implements Parse{

    public SB() {
        super("SB", 1, 24);
    }

    
    @Override
    public String SetDataPath(String[] s) {
        opcode = "101100";
        rt = Parse.BtoS(Parse.parseDtoB(findReg(s[1]),5));
        rs =  Parse.BtoS(Parse.parseDtoB(findReg(s[2]),5));
        the16bit_address= Parse.BtoS(Parse.parseDtoB(Integer.parseInt(s[3]),16));
        return opcode +rs+rt+the16bit_address;
    }
}
