package textExcel;

public class ValueCell extends RealCell{
	  
  	public ValueCell(String input) {
		  super(input);
	}
  	public String abbreviatedCellText() {
		String text = Double.toString(getDoubleValue());
		if(text.length() < 10) {
			if(!text.contains(".")) {    
				text += ".0";
			}
			return super.spaces(text);
		}
		else {	
			return text.substring(0,10);
		}
	}
	
	public String fullCellText() {
		return getRealCell();
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(getRealCell());
	}
	
}
