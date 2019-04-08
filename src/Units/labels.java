package Units;
public class labels {
    private int lineno;
    private String label;

    public labels(int lineno, String label) {
        this.lineno = (lineno*4)+Units.Instruction.offset;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public int getLineno() {
        return lineno;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLineno(int lineno) {
        this.lineno = (lineno*4)+Units.Instruction.offset;
    }
    
}
