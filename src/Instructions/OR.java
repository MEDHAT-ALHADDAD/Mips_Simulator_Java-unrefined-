package Instructions;

import Units.Instruction;
import Units.*;



public class OR extends Instruction implements Parse{

    public OR() {
        super("OR", 0, 11);
    }
    @Override
    public String SetDataPath(String[] s) {
        opcode = "000000";
        rs = Parse.BtoS(Parse.parseDtoB(findReg((s[2])),5));
        rt =  Parse.BtoS(Parse.parseDtoB(findReg(s[3]),5));
        rd =  Parse.BtoS(Parse.parseDtoB(findReg(s[1]),5));
        shamt = "00000";
        func = "100101";
        return opcode +rs+rt+rd+shamt+func;
    }
}
