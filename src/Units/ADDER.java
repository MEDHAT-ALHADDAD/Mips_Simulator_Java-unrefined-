package Units;
public class ADDER {
    private  DataPath input1;
    private  DataPath input2;
    private   DataPath output;

    public ADDER() {
        input1=new DataPath(32);
        input2=new DataPath(32);
        output=new DataPath(32);
    }
    
    public void add(){
        int temp1 =Parse.parseBtoD(input1.getBits());
        int temp2 =Parse.parseBtoD(input2.getBits());
        int tempo=temp1+temp2;
        output.setBits(Parse.parseDtoB(tempo,32));
    }  

    public DataPath getOutput() {
        return output;
    }
 

    public void setInput1(DataPath input1) {
        this.input1 = input1;
    }

    public void setInput2(DataPath input2) {
        this.input2 = input2;
    }
    
    
    public   void reset(){
        for(int i=0;i<input1.getSize();i++){
            input1.setbyte(i, 0);
            input2.setbyte(i, 0);
            output.setbyte(i, 0);
        }
    }
}
