package Instructions;

import Units.Instruction;
import Units.*;
import java.util.Arrays;



public class JAL extends Instruction implements Parse{

    public JAL() {
        super("JAL", 2, 8);
    }

    
    @Override
    public String SetDataPath(String[] s) {
        opcode = "000011";
        int temptarget =((super.findlabel(s[1]))/4);
        the26bit_address= Parse.BtoS(Parse.parseDtoB(temptarget,26));
        return opcode+the26bit_address;
    }
}
