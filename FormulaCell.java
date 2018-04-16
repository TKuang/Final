package textExcel;	

public class FormulaCell extends RealCell{
	public FormulaCell(String input) {
		super(input);
	}
	
	public String abbreviatedCellText() {
		String display = getDoubleValue() + "";
		if(display.length() < 10) {
			return spaces(display);
		}else {
			return display.substring(0, 10);
		}
		
	}

	public String fullCellText() {
		return super.getRealCell();
	}
	
	public double getDoubleValue() {
		String formula = getRealCell().substring(2, getRealCell().length()-2);
		String[] arr = formula.split(" ");
		for (int i = 0; i < arr.length; i++){
			if (arr[i] instanceof Cell){
				SpreadsheetLocation location = new SpreadsheetLocation(arr[i]);
				RealCell stored = getCell(location).fullCellText();
				arr[i] = getDoubleValue(stored);
			}
		}
		double result = Double.parseDouble(arr[0]);
		if(arr.length != 1) {
			for(int i = 1; i < arr.length; i++) {
				if(arr[i].equals("+")){
					result += Double.parseDouble(arr[i+1]);
				}
				else if(arr[i].equals("-")) {
					result -= Double.parseDouble(arr[i+1]);
				}
				else if(arr[i].equals("*")){
					result *= Double.parseDouble(arr[i+1]);
				}
				else if(arr[i].equals("/")){
					result /= Double.parseDouble(arr[i+1]);
				}
			}
		}
		return result;
	}
}
