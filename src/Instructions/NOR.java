package Instructions;

import Units.Instruction;
import Units.*;
import java.util.Arrays;



public class NOR extends Instruction implements Parse{

    public NOR() {
        super("NOR", 0, 10);
    }
    @Override
    public String SetDataPath(String[] s) {
        opcode = "000000";
        rs = Parse.BtoS(Parse.parseDtoB(findReg((s[2])),5));
        rt =  Parse.BtoS(Parse.parseDtoB(findReg(s[3]),5));
        rd =  Parse.BtoS(Parse.parseDtoB(findReg(s[1]),5));
        shamt = "00000";
        func = "100111";
        return opcode +rs+rt+rd+shamt+func;
    }
}
