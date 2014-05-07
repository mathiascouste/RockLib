import java.util.*;

import layout.RBoxLayout;

import component.*;
import component.container.*;



public class MainTest {
    private MainTest(){}
    public static void main(String[] args) {
        RContainer main = new RContainer();
        main.setLayout(new RBoxLayout(RBoxLayout.LINE_AXIS));
        main.setBorder(RContainer.BORDER_SOLID_THIN);
        RContainer mone = new RContainer();
        mone.setLayout(new RBoxLayout(RBoxLayout.LINE_AXIS));
        mone.setBorder(RContainer.BORDER_SOLID_THIN);
        RContainer mine = new RContainer();
        mine.setLayout(new RBoxLayout(RBoxLayout.LINE_AXIS));
        mine.setBorder(RContainer.BORDER_SOLID_THIN);

        main.add(mone);
        main.add(mine);
        
        main.print();
    }

}
