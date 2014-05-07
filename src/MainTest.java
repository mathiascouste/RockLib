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
    	c.setMode(RContainer.MODE_LINE_AXIS);
    	
    	RComponent c2 = new RComponent(2,4);
    	c2.setBackground('+');
        c2.setBorder(RComponent.BORDER_SOLID_THIN);
    	c.add(c2);
    	
    	RLabel lab = new RLabel("hello world !");
    	c.add(lab);
        //lab.setBackground('&');
    	
    	List<String> l = new ArrayList<String>();
    	l.add("1");
    	l.add("10");
        l.add("100");
        l.add("1010");
        l.add("10100");
    	
    	RList<String> rl = new RList(l);
        lab.setBorder(RComponent.BORDER_DOTTED_THIN);
        rl.setBorder(RComponent.BORDER_DOTTED_THICK);
        //rl.setBackground(' ');
    	c.add(rl);
    	
    	c.print();
    }

}
