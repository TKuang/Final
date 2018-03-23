public class Spreadsheet implements Grid
{
	private int row = 20;
	private int col = 12;
	private Cell[][] grid = new Cell[row][col];
	public Spreadsheet(){
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 12; j++) {
				grid[i][j] = new EmptyCell();
			}
		}
	}
	@Override
	public String processCommand(String command)
	{
		String[] userInput = command.split(" ", 3);
		if((userInput[0].toLowerCase().equals("clear")) && userInput.length == 2) {
			clear(userInput[1]);
		}
		else if(userInput[0].toLowerCase().equals("clear")) {
			clear();
		}
		else if(userInput.length == 1 && !userInput[0].equals("clear")) {
			SpreadsheetLocation loc = new SpreadsheetLocation(userInput[0]);
			return getCell(loc).fullCellText();
		}
		else if(userInput.length == 3){
			SpreadsheetLocation loc = new SpreadsheetLocation(userInput[0]);
			grid[loc.getRow()][loc.getCol()] = new TextCell(userInput[2]);
			return getGridText();
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
	public Cell getCell(Location loc)
	{
		return grid[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String sheet = "";
		sheet += "   ";
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
	
	public void clear(String cellName) {
		SpreadsheetLocation loc = new SpreadsheetLocation(cellName);
		grid[loc.getRow()][loc.getCol()] = new EmptyCell();
	}
	
	public void clear() {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new EmptyCell();
			}
		}
	}
}
