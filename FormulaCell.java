public class FormulaCell extends RealCell{
	
  public FormulaCell(String input) {
		super(input);
	}
	
  public String abbreviatedCellText() {
		String display = getDoubleValue() + "";
		if(display.length() < 10) {
			return fillSpaces(display);
		}
	  	else {
			return display.substring(0, 10);
		}
		
	}

	public String fullCellText() {
		return super.getRealCell();
	}
	
	public double getDoubleValue() {
		String formula = getRealCell().substring(2, getRealCell().length()-2);
		String[] arr = formula.split(" ");
		double result = 0;
		if(arr.length == 1) {
			result = Double.parseDouble(arr[0]);
		}
		else {
			for(int i = 2; i < arr.length; i++) {
				if(arr[1].equals("+")) {
					result = Double.parseDouble(arr[0]) + Double.parseDouble(arr[2]) 
					result += Double.parseDouble(arr[i+1]);
				}
				else if(arr[1].equals("-")) {
					result = Double.parseDouble(arr[0]) - Double.parseDouble(arr[2]) 
					result -= Double.parseDouble(arr[i+1]);
				}
				else if(arr[1].equals("*")) {
					result = Double.parseDouble(arr[0]) * Double.parseDouble(arr[2]) 
					result *= Double.parseDouble(arr[i+1]);
				}
				else if(arr[1].equals("/")){
					result = Double.parseDouble(arr[0]) / Double.parseDouble(arr[2]) 
					result /= Double.parseDouble(arr[i+1]);
				}
			}
		}
		return result;
	}
