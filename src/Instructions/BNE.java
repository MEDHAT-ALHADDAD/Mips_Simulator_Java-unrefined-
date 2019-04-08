package Instructions;

import Units.Instruction;
import Units.*;



public class BNE extends Instruction implements Parse{
    public BNE() {
        super("BNE", 1, 6);
    }

    
    @Override
    public String SetDataPath(String[] s) {
        opcode = "000101";
         rs = Parse.BtoS(Parse.parseDtoB(findReg(s[1]),5));
        rt =  Parse.BtoS(Parse.parseDtoB(findReg(s[2]),5));
        int tempcurrent=PC.getCurrent();
        int temptarget = super.findlabel(s[3]);
        int Value = ((temptarget - (tempcurrent*4) - 4)/4);
        the16bit_address= Parse.BtoS(Parse.parseDtoB(Value,16));
        return opcode +rs+rt+the16bit_address;
    }
}
