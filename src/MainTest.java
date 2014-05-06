import container.Component;


public class MainTest {
    public static void main(String[] args) {
    	Component c = new Component(10,10);
    	c.setBackground('a');
    	Component c2 = new Component(2,2,5,5);
    	c2.setBackground('+');
    	Component c3 = new Component(4,4,2,5);
    	c3.setBackground('-');
    	c.add(c2);
    	c.add(c3);
    	c.print();
    }

}
