package component;


public class RLabel extends RComponent {
    private String label;
    
    public RLabel() {
        this("");
    }
    public RLabel(String label) {
        super(label.length(),1);
        this.label = label;
    }
    public void repaint() {
        this.setColumns(this.label.length());
        this.setLines(1);
        super.repaint();
        for(int i = 0 ; i < this.label.length() ; i++) {
            this.graphics[0][i] = this.label.charAt(i);
        }
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
        this.setColumns(this.label.length());
        this.setLines(1);
    }
    public String toString() {
        return "RList>"+this.label;
    }
}
