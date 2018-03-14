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
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return row;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return col;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
