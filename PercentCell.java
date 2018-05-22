package textExcel;

public class PercentCell extends RealCell{
	private String input;
	public PercentCell(String input){
		super(input);
	}
	
	public String abbreviatedCellText() {
		String percent = super.getRealCell().substring(0, super.getRealCell().indexOf('.'));
		//stores whole number of the percentage as it is (this method doesn't round the value)
		return super.spaces(percent + "%");
		//adds a percent sign to stored percentage value and adds spaces to it until it reaches length of 10
	}
	
	public String fullCellText() {
		return getDoubleValue() * 0.01 + "";
		//returns the percentage in decimal format (out of 1 instead of 100)
	}
	
	public double getDoubleValue() {
		String percent = super.getRealCell();
		return Double.parseDouble(percent);
		//returns percentage as a double
	}
		
}
