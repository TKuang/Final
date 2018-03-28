package textExcel;

public class SpreadsheetLocation implements Location
{
	private String cell = "";
    public SpreadsheetLocation(String cell) {
    	this.cell = cell;
    }
	
	@Override
    public int getRow()
    {
        // TODO Auto-generated method stub
		int rowNum = Integer.parseInt(cell.substring(1));
        return rowNum - 1;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
    	char colLetter = Character.toLowerCase(cell.charAt(0));
        return ((int)colLetter - 'a');
    }

}
