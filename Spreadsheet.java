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
		String[] input = command.split(" ", 3);
		if((input[0].toLowerCase().equals("clear")){
			if(input.length == 2) {
				clear(input[1]);
				}
			clear();
		}
		else if(input.length == 1) {
			SpreadsheetLocation location = new SpreadsheetLocation(input[0]);
			return getCell(location).fullCellText();
		}
		else if(input.length == 3){
			SpreadsheetLocation location = new SpreadsheetLocation(input[0]);
			grid[location.getRow()][location.getCol()] = new TextCell(input[2]);
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
	
	public void clear(String cell) {
		SpreadsheetLocation location = new SpreadsheetLocation(cell);
		grid[location.getRow()][location.getCol()] = new EmptyCell();
	}
	
	public void clear() {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new EmptyCell();
			}
		}
	}
}
