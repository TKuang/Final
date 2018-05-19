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
        return Integer.parseInt(cell.substring(1)) - 1;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return (int)Character.toLowerCase(cell.charAt(0)) - 'a';
    }

}
