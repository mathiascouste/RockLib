import java.util.*;

import component.*;
import component.*;
import component.container.*;



public class MainTest {
    public static void main(String[] args) {
        
    	RContainer c = new RContainer();
        c.setColumns(100);
        c.setLines(10);
    	c.setBackground(' ');
    	c.setMode(RContainer.MODE_PAGE_AXIS);
    	
    	RComponent c2 = new RComponent(5,5);
    	c2.setBackground('+');
        //c2.setBorder(RComponent.BORDER_1);
    	RComponent c3 = new RComponent(2,3);
    	c3.setBackground('-');
    	c.add(c2);
    	c.add(c3);
    	
    	RLabel lab = new RLabel("hello world !");
    	c.add(lab);
    	
    	List<String> l = new ArrayList<String>();
    	l.add("1");
    	l.add("10");
        l.add("100");
        l.add("1010");
    	
    	RList<String> rl = new RList(l);
    	
    	c.add(rl);
    	    	
    	c.print();
    }

}
