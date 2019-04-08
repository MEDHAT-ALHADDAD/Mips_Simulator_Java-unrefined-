package Units;

import static Units.Parse.BtoS;

public class AluControl 
{    
    private  DataPath Ctrl;
    private  String thisOp;    
    private String signal;

    public void AluControl_ctrl(DataPath Ctrl,String opcode)
    {
        this.Ctrl = Ctrl;
        this.thisOp = opcode;
    }
    
    public  void selectOp()
    {  
        String ctrl=BtoS(Ctrl.getBits());//fe hena mo4kela
         switch (thisOp)
         {
             case "101":
                 this.setSig("1000");
                 break; //Slti
             case "010"://ori
                 this.setSig("0001");
                 break;
             case "011"://andi
                 this.setSig("0000");
                 break;
             case "001"://branch
                 this.setSig("0110"); //Sub
                 break;
             case "111"://branch
                 this.setSig("0101"); //Sub
                 break;
             case "000"://lw,sw,etc...
                 this.setSig("0010");
                 break;
             case "100"://rtype
                 switch (ctrl)
                 {
                     case "111000":
                         this.setSig("0011");
                         break;//sll
                   case "111001":
                         this.setSig("1010");
                         break;//srl
                   case "100000":
                    this.setSig("0010");
                    break; //Add
                   case "100010":
                    this.setSig("0110");
                    break; //Sub
                   case "100100":
                    this.setSig("0000");
                    break; //And
                   case "100101":
                    this.setSig("0001");
                    break; //Or
                   case "101010":
                    this.setSig("0111");
                    break; //Slt
                   case "101011":
                    this.setSig("0100");
                    break; //Sltu
                   case "100111":
                    this.setSig("1100");
                    break; //Nor
                   case "011000":
                    this.setSig("1111");
                    break; //Mul
                   case "011010":
                    this.setSig("1110");
                    break; //Div
                }
        }
    }

    public void setSig(String signal) {
        this.signal = signal;
    }

    public String getSignal() {
        selectOp();
        return signal;
    }
    
}
