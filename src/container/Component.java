package container;

import java.util.ArrayList;
import java.util.List;

public class Component{
	static final int BORDER_0 = 0;
	static final int BORDER_1 = 1;
	static final int BORDER_2 = 2;
	private int positionX;
	private int positionY;
	private List<Component> items;
	private int lines;
	private int columns;
	private char[][] graphics;
	private char background;
	private int border;

	public Component() {
		this(0,0,1,1);
	}
	public Component(int columns, int lines) {
		this(0,0,columns,lines);
	}
	public Component(int positionX, int positionY, int columns, int lines) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.lines = lines;
		this.columns = columns;
		this.background = ' ';
		this.border = Component.BORDER_0;
		this.items = new ArrayList<Component>();
		
		this.graphics = new char[lines][columns];
		this.repaint();
	}
	
	public void add(Component component) {
		this.items.add(component);
	}
	public void add(Component component, int index) {
		this.items.add(index, component);
	}
	public char[][] getGraphics() {
		return graphics;
	}
	public void repaint() {
		for(int i = 0 ; i < lines ; i++) {
            for(int j = 0 ; j < columns ; j++) {
            	graphics[i][j] = background;
            }
        }
		for(Component c : items) {
			c.paint(this.graphics);
		}
	}
	private void paint(char[][] graphics) {
		this.repaint();
		for(int i = 0 ; i < this.graphics.length ; i++) {
			for(int j = 0 ; j < this.graphics[i].length ; j++) {
				graphics[this.positionX+i][this.positionY+j] = this.graphics[i][j];
			}
		}
	}
	public void remove(Component component) {
		this.items.remove(component);
	}
	public Component remove(int index) {
		Component c = this.items.get(index);
		this.items.remove(index);
		return c;
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public List<Component> getItems() {
		return items;
	}
	public void setItems(List<Component> items) {
		this.items = items;
	}
	public int getLines() {
		return lines;
	}
	public void setLines(int lines) {
		this.lines = lines;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public char getBackground() {
		return background;
	}
	public void setBackground(char background) {
		this.background = background;
	}
	public int getBorder() {
		return border;
	}
	public void setBorder(int border) {
		this.border = border;
	}
	public static int getBorder0() {
		return BORDER_0;
	}
	public static int getBorder1() {
		return BORDER_1;
	}
	public static int getBorder2() {
		return BORDER_2;
	}
	public void setGraphics(char[][] graphics) {
		this.graphics = graphics;
	}
	
	public void print() {
		this.repaint();
		String toRet = "";
		for(int i = 0 ; i < this.lines ; i++) {
			for(int j = 0 ; j < this.columns ; j++) {
				toRet += this.graphics[i][j];
			}
			toRet += '\n';
		}
		System.out.println(toRet);
	}
}
