//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String cellName;
	public SpreadsheetLocation(String cellName) {
    		this.cellName = cellName;
    }
	
	@Override
    public int getRow()
    {
        // TODO Auto-generated method stub
	int row = Integer.parseInt(cellName.substring(1)) - 1;
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
    	char letter = Character.toLowerCase(cellName.charAt(0));
        int column = (int)Letter - 'a';
	return column;
    }

}
