package Instructions;

import Units.Instruction;
import Units.*;



public class BEQ extends Instruction implements Parse{
    public BEQ() {
        super("BEQ", 1, 5);
    }

    
    @Override
    public String SetDataPath(String[] s) {
        opcode = "000100";
        rs = Parse.BtoS(Parse.parseDtoB(findReg(s[1]),5));
        rt =  Parse.BtoS(Parse.parseDtoB(findReg(s[2]),5));
        int tempcurrent=PC.getCurrent();
        int temptarget = super.findlabel(s[3]);
        int Value = ((temptarget - (tempcurrent*4) - 4)/4);
        the16bit_address= Parse.BtoS(Parse.parseDtoB(Value,16));
        return opcode +rs+rt+the16bit_address;
    }


   
}
