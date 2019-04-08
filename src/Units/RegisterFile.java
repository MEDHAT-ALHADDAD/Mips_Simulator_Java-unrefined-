package Units;

import static Units.Parse.parseDtoB;



public class RegisterFile  implements Parse{
    
    protected Registers[] register;
    private int ReadRegister1;
    private int ReadRegister2;
    private int Writeregister;
    private DataPath output1;
    private DataPath output2;
    private String control;
    
    public RegisterFile(){
         ReadRegister1=0;
         ReadRegister2=0;
         Writeregister=0;
         output1=new DataPath(32);
         output2=new DataPath(32);
         register =new Registers[32];
         for (int i = 0; i < 32; i++) {
            register[i]=new Registers();
            register[i].setvalue(parseDtoB(0,32));
        }
          register[0].setname("$0");register[0].setaddress(0);
           register[1].setname("$at");register[1].setaddress(1);
            register[2].setname("$v0");register[2].setaddress(2);
             register[3].setname("$v1");register[3].setaddress(3);
              register[4].setname("$a0");register[4].setaddress(4);
               register[5].setname("$a1");register[5].setaddress(5);
                register[6].setname("$a2");register[6].setaddress(6);
                 register[7].setname("$a3");register[7].setaddress(7);
                  register[8].setname("$t0");register[8].setaddress(8);
                   register[9].setname("$t1");register[9].setaddress(9);
                    register[10].setname("$t2");register[10].setaddress(10);
                     register[11].setname("$t3");register[11].setaddress(11);
                      register[12].setname("$t4");register[12].setaddress(12);
                       register[13].setname("$t5");register[13].setaddress(13);
                        register[14].setname("$t6");register[14].setaddress(14);
                         register[15].setname("$t7");register[15].setaddress(15);
                          register[16].setname("$s0");register[16].setaddress(16);
                           register[17].setname("$s1");register[17].setaddress(17);
                            register[18].setname("$s2");register[18].setaddress(18);
                            register[19].setname("$s3");register[19].setaddress(19);
                             register[20].setname("$s4");register[20].setaddress(20);
                              register[21].setname("$s5");register[21].setaddress(21);
                               register[22].setname("$s6");register[22].setaddress(22);
                                register[23].setname("$s7");register[23].setaddress(23);
                                 register[24].setname("$t8");register[24].setaddress(24);
                                 register[25].setname("$t9");register[25].setaddress(25);
                                 register[26].setname("$k0");register[26].setaddress(26);
                                 register[27].setname("$k1");register[27].setaddress(27);
                                 register[28].setname("$gp");register[28].setaddress(28);
                                 register[29].setname("$sp");register[29].setaddress(29);
                                 register[30].setname("$fp");register[30].setaddress(30);
                                 register[31].setname("$ra");register[31].setaddress(31);
              }
    
    public void SetRegisterFile(DataPath read1,DataPath read2,DataPath write){
        this.ReadRegister1=Parse.parseBtoD_unsigned(read1.getBits());
        this.ReadRegister2=Parse.parseBtoD_unsigned(read2.getBits());
        this.Writeregister=Parse.parseBtoD_unsigned(write.getBits());
    }
    
    public void setControl(String c){
        this.control=c;
    }
    public String getControl(){
        return control;
    }
    
    public void setReg(int i,int[] data){
        register[i].setvalue(data);
    }
    
    public void setReg(int[] data){
        if("01".equals(control))
            register[Writeregister].setvalue(data);
        else if("10".equals(control))
            register[31].setvalue(data);
    }
    public DataPath getReg(int i){
        return register[i].getvalue();
    }
    
    public DataPath getRead1(){
        output1=register[ReadRegister1].getvalue();
        return output1;
    }  
    public DataPath getRead2(){
    output2=register[ReadRegister2].getvalue();
        return output2;
    }

    public void resetzero() {
        this.register[0].setvalue(parseDtoB(0, 32));
    }
    
    
}
