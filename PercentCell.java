package textExcel;

public class PercentCell extends RealCell{
	private String input;
	public PercentCell(String input){
		super(input);
	}
	
	public String abbreviatedCellText() {
		String text = super.getRealCell().substring(0, super.getRealCell().indexOf('.')) + "%";
		return super.spaces(text);
	}
	
	public String fullCellText() {
		return getDoubleValue() * 0.01 + "";
	}
	
	public double getDoubleValue() {
		String percent = super.getRealCell().substring(0, super.getRealCell().length()-1);
		double doubPercent = Double.parseDouble(percent);
		return doubPercent;
	}
		
}
