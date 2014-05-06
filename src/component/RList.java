package component;

import java.util.ArrayList;
import java.util.List;

import component.container.RContainer;

public class RList<T> extends RContainer {
    private List<T> list;
    
    public RList() {
        this(new ArrayList<T>());
    }
    public RList(List<T> list) {
        super();
        this.setList(list);
        this.mode = MODE_PAGE_AXIS;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
        this.clear();
        for(T t : list) {
            this.add(new RLabel((String)t));
        }
    }
}
