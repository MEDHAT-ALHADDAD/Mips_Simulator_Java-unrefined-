
package Units;


public class MUX{
    private DataPath input1;
    private DataPath input2;
    private DataPath output;
    private String control;
    private int n;
    
    public MUX(int n)
    {
        this.n=n;
        input1=new DataPath(n);
        input2=new DataPath(n);
        output=new DataPath(n);
        control="0";
    }
    
    private void setBits(){
        if("0".equals(control))
            output=input1;
        else if("1".equals(control))
            output=input2;
    }

    public DataPath getOutput() {
        setBits();
        return output;
    }

    public void setInput1(DataPath input1) {
        this.input1 = input1;
    }

    public void setInput2(DataPath input2) {
        this.input2 = input2;
    }

    public void setControl(String control) {
        this.control = control;
    }
    
    public void reset(){
        for(int i=0; i<n; i++)
        {
           input1.setbyte(i, 0);
        }
    }
}

