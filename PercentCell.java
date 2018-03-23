public PercentCell extends RealCell {
  
	public PercentCell(String entry){
		super(entry);
	}
	
	public String abbreviatedCellText() {
		String abbreviated = super.getRealCell().substring(0, super.getRealCell().indexOf('.')) + "%";
		return super.fillSpaces(abbreviated);
	}
	
	public String fullCellText() {
		return (getDoubleValue() * 0.01) + "";
	}
	
	public double getDoubleValue() {
		double percent = Double.parseDouble(super.getRealCell().substring(0, super.getRealCell().length()-1));
		return percent;
	}
		
}
