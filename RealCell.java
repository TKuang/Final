public abstract class RealCell implements Cell{
	private String input;
	
	public RealCell(String input) {
		this.input = input;
	}
	
	public abstract double getDoubleValue();
	
	public abstract String abbreviatedCellText(); 
	
	public abstract String fullCellText();
	
	public String spaces(String value) {
		while(value.length() < 10) {
			value += " ";
		}
		return value;
	}
	
	public String getRealCell() {
		return input;
	}
}
