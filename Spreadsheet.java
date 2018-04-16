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
	public String processCommand(String command)
	{
		String[] content = command.split(" ", 3);
		if((content[0].toLowerCase().equals("clear"))){
			if(content.length == 2) {
				SpreadsheetLocation location = new SpreadsheetLocation(content[1]);
				grid[location.getRow()][location.getCol()] = new EmptyCell();
				}
			else {
				clear();
			}
		}
		else if(content.length == 1) {	
			SpreadsheetLocation location = new SpreadsheetLocation(content[0]);
			return getCell(location).fullCellText();
		}
		else if(content.length == 3){
			String stored = content[2];
			SpreadsheetLocation location = new SpreadsheetLocation(input[0]);
			if(stored.contains("\"")) {
				grid[location.getRow()][location.getCol()] = new TextCell(stored);
			}
			else if(stored.contains("%")) {
				grid[location.getRow()][location.getCol()] = new PercentCell(stored);
			}
			else if(stored.contains("(")) {
				grid[location.getRow()][location.getCol()] = new FormulaCell(stored);
			else {
				grid[location.getRow()][location.getCol()] = new ValueCell(stored);
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
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new EmptyCell();
			}
		}
	}
}
