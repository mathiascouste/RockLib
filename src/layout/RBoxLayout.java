package layout;

import component.RComponent;
import component.container.RContainer;

public class RBoxLayout implements Layout{
    public static final int LINE_AXIS = 0;
    public static final int PAGE_AXIS = 1;
    private int mode;
    public RBoxLayout(int mode) {
        this.mode = mode;
    }
    @Override
    public void placeComponents(RContainer container) {
        int pos = 0;
        switch(this.mode) {
        case LINE_AXIS:
            for(RComponent c : container.getItems()) {
                c.setPositionY(pos);
                c.setPositionX(0);
                pos+=c.getColumns();
            }
            container.enlarge();
            break;
        case PAGE_AXIS:
            for(RComponent c : container.getItems()) {
                c.setPositionX(pos);
                c.setPositionY(0);
                pos+=c.getLines();
            }
            container.enlarge();
            break;
        default:;
        }
    }
    
}
