public class FormulaCell extends RealCell{
	
  public FormulaCell(String entry) {
		super(entry);
	}
	
	public String abbreviatedCellText() {
		return "";
	}
	
	public String fullCellText() {
		return super.getRealCell();
	}
	
	public double getDoubleValue() {
		return 0;
	}
}
