package component;

import java.util.ArrayList;
import java.util.List;

public class RComponent{
    private static final char[] ASCII_HORIZONTAL = {' ','─','=','.'};
    private static final char[] ASCII_VERTICAL =   {' ','│','║','.'};
    private static final char[] ASCII_CORNER_B_L = {' ','└','╚','.'};
    private static final char[] ASCII_CORNER_B_R = {' ','┘','╝','.'};
    private static final char[] ASCII_CORNER_T_L = {' ','┌','╔','.'};
    private static final char[] ASCII_CORNER_T_R = {' ','┐','╗','.'};
    private static final char[] ASCII_CENTER =     {' ','┼','╬','.'};
    private static final char[] ASCII_MIDDLE_L =   {' ','├','╠','.'};
    private static final char[] ASCII_MIDDLE_R =   {' ','┤','╣','.'};
    private static final char[] ASCII_MIDDLE_B =   {' ','┴','╩','.'};
    private static final char[] ASCII_MIDDLE_T =   {' ','┬','╦','.'};
    private static final int x=0;
    public static final int BORDER_0 = 0;
    public static final int BORDER_1 = 1;
    public static final int BORDER_2 = 2;
    public static final int BORDER_3 = 3;
	protected int positionX;
	protected int positionY;
	protected int lines;
	protected int columns;
    protected char[][] fore_graphics;
    protected char[][] back_graphics;
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
	    if(this.border==0) {
	        this.graphics = new char[lines][columns];
	    } else {
	        this.graphics = new char[lines+2][columns+2];
	    }
    }
    public char[][] getGraphics() {
		return graphics;
	}
	public void repaint() {
		for(int i = 0 ; i < graphics.length ; i++) {
            for(int j = 0 ; j < graphics[0].length ; j++) {
            	graphics[i][j] = background;
            }
        }
	}
	public void paint(char[][] graphics) {
        this.repaint();
        int bC = 0;
        if(border!=0) {
            bC = 1;
        }
        for(int i = 0; i < this.graphics.length ; i++) {
            for(int j = 0 ; j < this.graphics[i].length ; j++) {
                graphics[this.positionX+i+bC][this.positionY+j+bC] = this.graphics[i][j];
            }
        }
        if(this.border!=0) {
            this.paintBorder(graphics);
        }
	}
	public void paintBorder(char[][] graphics) {
        graphics[this.positionX][this.positionY] = ASCII_CORNER_T_L[this.border];
        graphics[this.positionX+this.lines+1][this.positionY] = ASCII_CORNER_B_L[this.border];
        graphics[this.positionX][this.positionY+this.columns+1] = ASCII_CORNER_T_R[this.border];
        graphics[this.positionX+this.lines+1][this.positionY+this.columns+1] = ASCII_CORNER_B_R[this.border];
        for(int i = 1 ; i < this.columns+1 ; i++) { // horizontal
            graphics[this.positionX][this.positionY+i] = ASCII_HORIZONTAL[this.border];
            graphics[this.positionX+this.lines+1][this.positionY+i] = ASCII_HORIZONTAL[this.border];
        }
        for(int i = 1 ; i < this.lines+1 ; i++) {
            graphics[this.positionX+i][this.positionY] = ASCII_VERTICAL[this.border];
            graphics[this.positionX+i][this.positionY+this.columns+1] = ASCII_VERTICAL[this.border];
        }
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
		for(int i = 0 ; i < this.graphics.length ; i++) {
			for(int j = 0 ; j < this.graphics[0].length ; j++) {
				toRet += this.graphics[i][j];
			}
			if(i<this.lines-1) {
			    toRet += '\n';
			}
		}
		System.out.println(toRet);
	}
}
