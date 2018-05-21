package textExcel;

public class Spreadsheet implements Grid
{
	private int row = 20;
	private int col = 12;
	private Cell[][] grid = new Cell[row][col];
	public Spreadsheet(){
		clear();  //constructs empty grid
	}
	@Override
	public String processCommand(String userInput)
	{
		String[] content = userInput.split(" ", 3);
		if((content[0].toLowerCase().equals("clear"))){
			if(content.length == 2) {
				SpreadsheetLocation location = new SpreadsheetLocation(content[1]);
				grid[location.getRow()][location.getCol()] = new EmptyCell();
				}
				//clears single cell if user input specifies cell to clear
			else {
				clear();
				//clears every cell, constructs empty grid
			}
		}
		else if(content.length == 1) {	
			SpreadsheetLocation location = new SpreadsheetLocation(content[0]);
			return getCell(location).fullCellText();
			//returns cell content if user input only asks for cell
		}
		else if(content.length == 3){
		//if user input is in the formate "cell" = "value"
			String stored = content[2];
			SpreadsheetLocation location = new SpreadsheetLocation(content[0]);
			if(stored.contains("\"")) {
				grid[location.getRow()][location.getCol()] = new TextCell(stored);
				//constructs new text cell
			}
			else if(stored.contains("%")) {
				grid[location.getRow()][location.getCol()] = new PercentCell(stored);
				//constructs new percent cell
			}
			else if(stored.contains("(")) {
				grid[location.getRow()][location.getCol()] = new FormulaCell(stored, this);
				//constructs new formula cell
			}
			else {
				grid[location.getRow()][location.getCol()] = new ValueCell(stored);
				//constructs new value cell
			}
		}
		else {
			return "Invalid input";
		}
		
		return getGridText();
	}
	@Override
	public int getRows()
	{
		return row;
	}

	@Override
	public int getCols()
	{
		return col;
	}

	@Override
	public Cell getCell(Location location)
	{
		return grid[location.getRow()][location.getCol()];
	}

	@Override
	public String getGridText()
	{
		String sheet = "   ";
		for(char i = 'A'; i <= 'L'; i++) {
			sheet += ("|" + i + "         ");
		}
		sheet += "|\n";
		for(int i = 0; i < grid.length; i++) {
			if(i < 9) {
				sheet += i + 1 + "  ";
				
			}
			else {
				sheet += i + 1 + " ";
			}
			for(int j = 0; j < grid[i].length; j++) {
				sheet += "|" + grid[i][j].abbreviatedCellText();
			}
			sheet += "|\n";
		}
		return sheet;
	}
	public void clear() {
		//constructs a 20x12 2D array of empty cells
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new EmptyCell();
			}
		}
	}
}
