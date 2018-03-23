public abstract class RealCell implements Cell{
	private String entry;
	public RealCell(String entry) {
		this.entry = entry;
	}
	
	public abstract double getDoubleValue();
	
	
	public abstract String abbreviatedCellText(); 
		
	
	
	public abstract String fullCellText();
	
	public String fillSpaces(String input) {
		while(input.length() < 10) {
			input += " ";
		}
		return input;
	}
	
	public String getRealCell() {
		return entry;
	}
}
