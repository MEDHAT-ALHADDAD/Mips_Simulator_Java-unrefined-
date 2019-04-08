package Instructions;

import Units.Instruction;
import Units.*;
import java.util.Arrays;



public class JR extends Instruction implements Parse{

    public JR() {
        super("JR", 0, 9);
    }
    @Override
    public String SetDataPath(String[] s) {
        opcode = "000000";
        rs = Parse.BtoS(Parse.parseDtoB(findReg((s[1])),5));
        rt =   "00000";
        rd = "00000";
        shamt = "00000";
        func = "001000";
        return opcode +rs+rt+rd+shamt+func;
    }
}
