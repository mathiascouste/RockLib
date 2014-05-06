package component.container;

import java.util.ArrayList;
import java.util.List;

import component.RComponent;

public class RContainer extends RComponent {
    public static final int MODE_HAZARD = 0;
    public static final int MODE_LINE_AXIS = 1;
    public static final int MODE_PAGE_AXIS = 2;
    protected List<RComponent> items;
    protected int mode;
    
    public RContainer() {
        this(new ArrayList<RComponent>());
    }
    public RContainer(List<RComponent> items) {
        super();
        this.items = items;
        this.mode = MODE_HAZARD;
    }
    public RContainer(RComponent item) {
        super();
        this.items = new ArrayList<RComponent>();
        this.items.add(item);
        this.mode = 0;
    }
    
    public void add(RComponent component) {
        this.items.add(component);
    }
    public void add(RComponent component, int index) {
        this.items.add(index, component);
    }
    public void repaint() {
        for(RComponent c : items) {
            if(c instanceof RContainer) {
                ((RContainer)c).placeComponents();
            }
        }
        this.placeComponents();
        super.repaint();
        for(RComponent c : items) {
            c.paint(this.graphics);
        }
    }
    public void remove(RComponent component) {
        this.items.remove(component);
    }
    public RComponent remove(int index) {
        RComponent c = this.items.get(index);
        this.items.remove(index);
        return c;
    }
    public List<RComponent> getItems() {
        return items;
    }
    public void setItems(List<RComponent> items) {
        this.items = items;
    }
    public void clear() {
        this.items.clear();
    }
    protected void enlarge() {
        int x=0;
        int y=0;
        for(RComponent c : this.items) {
            if(x < c.getLines()+c.getPositionX()) {
                x = c.getLines()+c.getPositionX();
            }
            if(y < c.getColumns()+c.getPositionY()) {
                y = c.getColumns()+c.getPositionY();
            }
        }
        if(this.lines < x) {
            this.lines = x;
        }
        if(this.columns < y) {
            this.columns = y;
        }
        this.adjustGraphics();
    }
    
    public void placeComponents() {
        int pos = 0;
        switch(this.mode) {
        case MODE_HAZARD:break;
        case MODE_LINE_AXIS:
            for(RComponent c : this.items) {
                c.setPositionY(pos);
                c.setPositionX(0);
                pos+=c.getColumns();
            }
            this.enlarge();
            break;
        case MODE_PAGE_AXIS:
            for(RComponent c : this.items) {
                c.setPositionX(pos);
                c.setPositionY(0);
                pos+=c.getLines();
            }
            this.enlarge();
            break;
        default:;
        }
    }
    public int getMode() {
        return mode;
    }
    public void setMode(int mode) {
        this.mode = mode;
    }
}
