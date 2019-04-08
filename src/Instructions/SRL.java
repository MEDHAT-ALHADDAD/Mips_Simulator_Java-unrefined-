package Instructions;

import Units.Instruction;
import Units.*;



public class SRL extends Instruction implements Parse{

    public SRL() {
        super("SRL", 0, 16);
    }
    @Override
    public String SetDataPath(String[] s) {
        opcode = "000000";
        rs = Parse.BtoS(Parse.parseDtoB(findReg((s[2])),5));
        rt = "00000";
        rd =  Parse.BtoS(Parse.parseDtoB(findReg(s[1]),5));
        shamt = Parse.BtoS(Parse.parseDtoB(Integer.parseInt(s[3]),5));
        func = "111001";
        return opcode +rs+rt+rd+shamt+func;
    }
}
