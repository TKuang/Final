public ValueCell extends RealCell{
  
  	public ValueCell(String entry) {
		  super(entry);
	}
	public String abbreviatedCellText() {
		String text = Double.toString(getDoubleValue());
		if(text.length() < 10) {
			if(!text.contains(".")) {    //checks if its a whole number 
				text += ".0";
			}
			return super.fillSpaces(text);
		}else {	
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
