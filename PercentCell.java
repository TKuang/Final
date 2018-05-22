package textExcel;

public class PercentCell extends RealCell{
	private String input;
	public PercentCell(String input){
		super(input);
	}
	
	public String abbreviatedCellText() {
		String revised = super.getRealCell().substring(0, super.getRealCell().indexOf('.'));
		return super.spaces(revised + "%");
	}
	
	public String fullCellText() {
		return getDoubleValue() * 0.01 + "";
	}
	
	public double getDoubleValue() {
		String percent = super.getRealCell();
		return Double.parseDouble(percent);
	}
		
}
