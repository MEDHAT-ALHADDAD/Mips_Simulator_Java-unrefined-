package Instructions;

import Units.Instruction;
import Units.*;
import java.util.Arrays;



public class J extends Instruction implements Parse{

    public J() {
        super("J", 2, 7);
    }

    
    @Override
    public String SetDataPath(String[] s) {
        opcode = "000010";
        int temptarget = ((super.findlabel(s[1]))/4);
        the26bit_address= Parse.BtoS(Parse.parseDtoB(temptarget,26));
        return opcode+the26bit_address;
    }
}
