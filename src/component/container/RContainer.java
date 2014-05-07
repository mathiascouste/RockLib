package component.container;

import java.util.ArrayList;
import java.util.List;

import layout.HazardLayout;
import layout.Layout;

import component.RComponent;

public class RContainer extends RComponent {
    protected List<RComponent> items;
    protected Layout layout;
    
    public RContainer() {
        this(new ArrayList<RComponent>());
    }
    public RContainer(List<RComponent> items) {
        super();
        this.items = items;
        this.layout = new HazardLayout();
    }
    public RContainer(RComponent item) {
        super();
        this.items = new ArrayList<RComponent>();
        this.items.add(item);
        this.layout = new HazardLayout();
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
    public void enlarge() {
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
        this.layout.placeComponents(this);
    }
    public Layout getLayout() {
        return layout;
    }
    public void setLayout(Layout layout) {
        this.layout = layout;
    }
}
