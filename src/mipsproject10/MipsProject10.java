package mipsproject10;

    import Units.ADDER;
    import Units.ALU;
    import Units.AluControl;
    import Units.Contoller;
    import Units.DataMemory;
    import Units.DataPath;
    import Units.InstructionMemory;
    import Units.MUX;
    import Units.PC;
    import Units.Parse;
    import static Units.Parse.parseDtoB;
    import Units.RegisterFile;
    import Units.SL2;
    import Units.SignExtend;
    import java.util.Scanner;

public class MipsProject10 {
    


    public static void main(String[] args) {
       
       /*Scanner sc=new Scanner(System.in);
        int nomono;
        nomono=sc.nextInt();
         Units.Instruction.setOffset(nomono);
        //System.out.println("enter the starting address");
        //offset=sc.nextInt();
        
        PC pc=new PC(nomono);
        ADDER adder1=new ADDER();
        ADDER adder2=new ADDER();
        ALU alu=new ALU();
        SL2 sl1=new SL2();
        SL2 sl2=new SL2();
        SL2 sl3=new SL2();
        SignExtend se=new SignExtend();
        Contoller control=new Contoller();
        //AluControl aluControl =new AluControl();
        MUX mux1=new MUX(32);
        MUX mux2=new MUX(32);
        MUX mux3=new MUX(5);
        MUX mux4=new MUX(32);
        MUX mux5=new MUX(32);
        MUX mux6=new MUX(32);
        MUX mux7=new MUX(32);
        MUX mux8=new MUX(32);
        MUX mux9=new MUX(32);
        AluControl alucont=new AluControl();
        InstructionMemory im=new InstructionMemory();
        DataMemory dm=new DataMemory();
        RegisterFile rf=new RegisterFile();
        
        //the datapath
        //File file =new File("input.txt");
        int n=Parse.parseBtoD(pc.getPC().getBits());
        im.setinstruction("New Text Document.txt",n  );
        DataPath d2=new DataPath(32);
        DataPath d=new DataPath(32);
        d.setBits(parseDtoB(4,32));
        
        //load 2l data memory
        //System.out.println("load the Data Memory");
        //dm.loadData();
        
        int k=(Parse.parseBtoD(pc.getPC().getBits())-nomono)/4;//for testing
        System.out.println(k);//for testing
        
        //the instruction path
        while((k<im.getI())&&k>=0){
            
            im.CreateMachineString(im.getInstructionLine(Units.PC.getCurrent()));
            im.CreateSubDataPath();
            
            control.setInput(im.getOpcode(), im.getFunc());
            
            mux3.setControl(control.getRegDst());
            mux3.setInput1(im.getRt());
            mux3.setInput2(im.getRd());
            
            rf.setControl(control.getRegWrite());
            rf.SetRegisterFile(im.getRs(), im.getRt(), mux3.getOutput());
            se.setInput(im.getThe16bit_address());
            
            mux8.setControl(control.getShift());
            mux8.setInput2(im.getShamt());
            mux8.setInput1(rf.getRead2());
            
            mux4.setControl(control.getALUSrc());
            mux4.setInput1(mux8.getOutput());
            mux4.setInput2(se.getOutput());
            
            //alucont.Do(control.getALUop(),BtoS(im.getFunc().getBits()));
            alucont.AluControl_ctrl(im.getFunc(), control.getALUop());
            
            alu.setInp1(rf.getRead1());
            alu.setInp2(mux4.getOutput());
            alu.setSig(alucont.getSignal(),Parse.BtoS(im.getOpcode().getBits()));
//            dm.setSP(Parse.parseBtoD_unsigned((rf.getReg(28).getBits())));
            int x=Parse.parseBtoD(alu.getOutput().getBits());
            dm.setAddress(x);
            dm.setRead(control.getMemRead());
            dm.setWrite(control.getMemWrite());
            dm.store(rf.getRead2().getBits());
            
            mux5.setControl(control.getMemToReg());
            mux5.setInput1(alu.getOutput());
            mux5.setInput2(dm.load());
            
            //rf.setReg(mux5.getOutput().getBits());
            
            adder1.setInput1(pc.getPC());
            adder1.setInput2(d);
            adder1.add();
            DataPath w=new DataPath(32);
       //    w.setBits(parseDtoB((Parse.parseBtoD_unsigned(se.getOutput().getBits())),32));//2l -1 34an 2l 16 bit bytb3to fl branch zyada wa7ed
            adder2.setInput1(adder1.getOutput());
            sl2.setInput(se.getOutput());
            adder2.setInput2(sl2.getOutput());
            adder2.add();
            
            //ALU.ZeroFlag();
            String s;
            if(("1".equals(control.getBranch()))&&("1".equals(alu.getZeroFlag()+"")))
                s="1";
            else
                s="0";
            
            mux1.setControl(s);
            mux1.setInput1(adder1.getOutput());
            mux1.setInput2(adder2.getOutput());
            
            for(int i=4;i<30;i++)
                d2.setbyte(i, im.getThe26bit_address().getbyte(i-4));
            d2.setbyte(30, 0);
            d2.setbyte(31, 0);
            for(int i=0;i<4;i++)
                d2.setbyte(i, adder1.getOutput().getbyte(i));
            
            mux2.setControl(control.getJump());
            mux2.setInput1(mux1.getOutput());
            mux2.setInput2(d2);
            
            //pc.setPC(mux2.getOutput().getBits());
            //mux6.setControl(control.getJumpReg());//wronge control signal
            
            //sl3.setInput(rf.getReg(31));
            mux6.setControl(control.getPCSrc());//true control signal
            mux6.setInput1(mux2.getOutput());
            //mux6.setInput2(rf.getReg(31));
            mux6.setInput2(rf.getReg(31));//34an 2l shift left bta3t 2l $ra fl jr
            
            //mux7.setControl(control.getPCSrc());//wronge control signal
            
            mux7.setControl(control.getJumpReg());//true control signal
            mux7.setInput1(mux5.getOutput());
            mux7.setInput2(adder1.getOutput());
            
            //for lui instruction
            //lesa 3yzen n3mel instruction lui fl instructions wl instruction memory ,2na 3mltha fl control unit
            //mux9.setInput1(mux7.getOutput());
            //mux9.setInput2(se.getOutput());
            //mux9.setControl(control.getLui());
            //rf.setReg(mux9.getOutput().getBits());
            
            rf.setReg(mux7.getOutput().getBits());
            pc.setPC(mux6.getOutput().getBits());
            dm.setSP(Parse.parseBtoD(rf.getReg(29).getBits()));
            rf.resetzero();
            k=(Parse.parseBtoD(pc.getPC().getBits())-nomono)/4;//for testing the pc
            System.out.println(k);//for testing the pc
        }*/
       APP a=new APP();
       a.setVisible(true);
    }
    
}
