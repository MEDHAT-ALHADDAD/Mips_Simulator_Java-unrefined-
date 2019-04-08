package Instructions;

import Units.Instruction;
import Units.*;



public class ORI extends Instruction implements Parse{

    public ORI() {
        super("ORI", 1, 19);
    }

    
    @Override
    public String SetDataPath(String[] s) {
        opcode = "001101";
        rs =Parse.BtoS(Parse.parseDtoB(findReg(s[2]),5));
        rt = Parse.BtoS(Parse.parseDtoB(findReg(s[1]),5));
        the16bit_address=Parse.BtoS(Parse.parseDtoB(Integer.parseInt(s[3]),16));
        return opcode +rs+rt+the16bit_address;
    }
}
