package textExcel;

public class ValueCell extends RealCell{
	  
  	public ValueCell(String input) {
		  super(input);
	}
  	public String abbreviatedCellText() {
		String revised = Double.toString(getDoubleValue());
		if(revised.length() < 10) {
			if(!revised.contains(".")) {    
				revised += ".0";
			}
			return super.spaces(revised);
		}
		else {	
			return revised.substring(0,10);
		}
	}
	
	public String fullCellText() {
		return getRealCell();
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(getRealCell());
	}
	
}
