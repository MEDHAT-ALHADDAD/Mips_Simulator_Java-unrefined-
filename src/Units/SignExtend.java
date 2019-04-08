
package Units;

public class SignExtend {
    
    DataPath input,input8,output;

    public SignExtend() {
        this.input8=new DataPath(8);
        this.input = new DataPath(16);
        this.output = new  DataPath(32);
    }

    public void setInput(DataPath input) {
        this.input = input;
    }
    
    public void setInput8(DataPath input) {
        this.input8 = input;
    }

    public DataPath getOutput() {
        extend();
        return output;
    }
    
    public DataPath getOutput8() {
        extend8();
        return output;
    }
    
    public DataPath getOutputu() {
        extendu();
        return output;
    }
    
    public DataPath getOutput8u() {
        extend8u();
        return output;
    }
        
    private void extend(){
        for(int i=0;i<16;i++){
            output.setbyte(i, input.getbyte(0));
        }
        for(int i=16,j=0;i<output.getSize();i++,j++){
            output.setbyte(i, input.getbyte(j));
        }
    }
    
    private void extend8(){
        for(int i=0;i<24;i++){
            output.setbyte(i, input8.getbyte(0));
        }
        for(int i=24,j=0;i<output.getSize();i++,j++){
            output.setbyte(i, input8.getbyte(j));
        }
    }
    
    private void extendu(){
        for(int i=0;i<16;i++){
            output.setbyte(i, 0);
        }
        for(int i=16,j=0;i<output.getSize();i++,j++){
            output.setbyte(i, input.getbyte(j));
        }
    }
    
    private void extend8u(){
        for(int i=0;i<24;i++){
            output.setbyte(i, 0);
        }
        for(int i=24,j=0;i<output.getSize();i++,j++){
            output.setbyte(i, input8.getbyte(j));
        }
    }
}