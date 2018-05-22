package textExcel;

public class ValueCell extends RealCell{
	  
  	public ValueCell(String input) {
		  super(input);
	}
  	public String abbreviatedCellText() {
		String value = Double.toString(getDoubleValue());
		if(value.length() < 10) {
			if(!value.contains(".")) {    
				value += ".0";
				//adds ".0" to the string if it doesn't contain a decimal
			}
			return super.spaces(value);
			//adds spaces to string until it reaches the length of 20
		}
		else {	
			return value.substring(0,10);
		}
	}
	
	public String fullCellText() {
		return getRealCell();
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(getRealCell());
		//casts real cell in a double
	}
	
}
