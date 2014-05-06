package component;

import java.util.ArrayList;
import java.util.List;

public class RComponent{
    public static final int BORDER_0 = 0;
    public static final int BORDER_1 = 1;
    public static final int BORDER_2 = 2;
	protected int positionX;
	protected int positionY;
	protected int lines;
	protected int columns;
	protected char[][] graphics;
	protected char background;
	protected int border;

	public RComponent() {
		this(1,1);
	}
	public RComponent(int columns, int lines) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.lines = lines;
        this.columns = columns;
        this.background = ' ';
        this.border = RComponent.BORDER_0;
        
        this.adjustGraphics();
	}
	protected void adjustGraphics() {
	    this.graphics = new char[lines][columns];
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
	}
	public void paint(char[][] graphics) {
		this.repaint();
		for(int i = 0 ; i < this.graphics.length ; i++) {
			for(int j = 0 ; j < this.graphics[i].length ; j++) {
				graphics[this.positionX+i][this.positionY+j] = this.graphics[i][j];
			}
		}
		this.paintBorder(graphics);
	}
	public void paintBorder(char[][] graphics2) {
        
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
	public int getLines() {
	    if(this.border==0) {
	        return lines;
	    } else {
	        return lines+2;
	    }
	}
	public void setLines(int lines) {
		this.lines = lines;
		this.adjustGraphics();
	}
	public int getColumns() {
        if(this.border==0) {
            return columns;
        } else {
            return columns+2;
        }
	}
	public void setColumns(int columns) {
		this.columns = columns;
		this.adjustGraphics();
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
