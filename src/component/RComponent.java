package component;

public class RComponent{
	// SRC=http://en.wikipedia.org/wiki/Box-drawing_character
    private static final char[] ASCII_HORIZONTAL = {' ','─','━','═','┄','┅'};
    private static final char[] ASCII_VERTICAL =   {' ','│','┃','║','┊','┇'};
    private static final char[] ASCII_CORNER_B_L = {' ','└','┗','╚','└','┗'};
    private static final char[] ASCII_CORNER_B_R = {' ','┘','┛','╝','┘','┛'};
    private static final char[] ASCII_CORNER_T_L = {' ','┌','┏','╔','┌','┏'};
    private static final char[] ASCII_CORNER_T_R = {' ','┐','┓','╗','┐','┓'};
    private static final char[] ASCII_CENTER =     {' ','┼','.','╬','.','.'};
    private static final char[] ASCII_MIDDLE_L =   {' ','├','.','╠','.','.'};
    private static final char[] ASCII_MIDDLE_R =   {' ','┤','.','╣','.','.'};
    private static final char[] ASCII_MIDDLE_B =   {' ','┴','.','╩','.','.'};
    private static final char[] ASCII_MIDDLE_T =   {' ','┬','.','╦','.','.'};
    public static final int NO_BORDER = 0;
    public static final int BORDER_SOLID_THIN = 1;
    public static final int BORDER_SOLID_THICK = 2;
    public static final int BORDER_DOUBLE_THIN = 3;
    public static final int BORDER_DOTTED_THIN = 4;
    public static final int BORDER_DOTTED_THICK = 5;
	protected int positionX;
	protected int positionY;
	protected int lines;
	protected int columns;
    protected char[][] tmpGraphics;
    protected char[][] graphics;
	protected char background;
	protected int border;

	public RComponent() {
		this(1,1);
	}
	public RComponent(int columns, int lines) {
        this.lines = lines;
        this.columns = columns;
        this.background = ' ';
        this.border = RComponent.NO_BORDER;
        
        this.adjustGraphics();
	}
	protected void adjustGraphics() {
	    this.graphics = new char[lines][columns];
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
        if(this.border!=0) {
        	this.putInTemporary();
        } else {
        	this.tmpGraphics = this.graphics;
        }
        for(int i = 0; i < this.tmpGraphics.length ; i++) {
            for(int j = 0 ; j < this.tmpGraphics[i].length ; j++) {
                graphics[this.positionX+i][this.positionY+j] = this.tmpGraphics[i][j];
            }
        }
        this.tmpGraphics = null;
	}
	private void putInTemporary() {
		this.tmpGraphics = new char[this.lines+2][this.columns+2];
		for(int i = 0 ; i < tmpGraphics.length ; i++) {
			for(int j = 0 ; j < tmpGraphics[0].length ; j++) {
				tmpGraphics[i][j] = this.background;
			}
		}
		tmpGraphics[0][0] = ASCII_CORNER_T_L[this.border];
		tmpGraphics[this.lines+1][0] = ASCII_CORNER_B_L[this.border];
		tmpGraphics[0][this.columns+1] = ASCII_CORNER_T_R[this.border];
		tmpGraphics[this.lines+1][this.columns+1] = ASCII_CORNER_B_R[this.border];
        for(int i = 1 ; i < this.columns+1 ; i++) {
        	tmpGraphics[0][i] = ASCII_HORIZONTAL[this.border];
        	tmpGraphics[this.lines+1][i] = ASCII_HORIZONTAL[this.border];
        }
        for(int i = 1 ; i < this.lines+1 ; i++) {
        	tmpGraphics[i][0] = ASCII_VERTICAL[this.border];
        	tmpGraphics[i][this.columns+1] = ASCII_VERTICAL[this.border];
        }
        for(int i = 0 ; i < graphics.length ; i++) {
			for(int j = 0 ; j < graphics[0].length ; j++) {
				tmpGraphics[i+1][j+1] = this.graphics[i][j];
			}
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
	
	public void print() {
		this.repaint();
        if(this.border!=0) {
        	this.putInTemporary();
        } else {
        	this.tmpGraphics = this.graphics;
        }
		String toRet = "";
		for(int i = 0 ; i < this.tmpGraphics.length ; i++) {
			for(int j = 0 ; j < this.tmpGraphics[0].length ; j++) {
				toRet += this.tmpGraphics[i][j];
			}
			if(i<this.tmpGraphics.length-1) {
			    toRet += '\n';
			}
		}
		this.tmpGraphics = null;
		System.out.println(toRet);
	}
}
