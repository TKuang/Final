package textExcel;

public abstract class RealCell implements Cell{
	private String input;
	public RealCell(String input) {
		this.input = input;
	}
	
	public abstract double getDoubleValue();
	
	
	public abstract String abbreviatedCellText(); 
		
	
	
	public abstract String fullCellText();
	
	public String spaces(String input) {
		while(input.length() < 10) {
			input += " ";
		}
		return input;
	}
	
	public String getRealCell() {
		return input;
	}
}
