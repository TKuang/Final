public class FormulaCell extends RealCell{
	
  public FormulaCell(String entry) {
		super(entry);
	}
	
  public String abbreviatedCellText() {
		String finalString = getDoubleValue() + "";
		if(finalString.length() < 10) {
			return fillSpaces(finalString);
		}else {
			return finalString.substring(0, 10);
		}
		
	}

	public String fullCellText() {
		return super.getRealCell();
	}
	
	public double getDoubleValue() {
		String modified = getRealCell().substring(2, getRealCell().length()-2);
		String[] arr = modified.split(" ");
		double result = 0;
		if(arr.length == 1) {
			result = Double.parseDouble(arr[0]);
		}else {
			if(arr[1].equals("+")) {
				result = Double.parseDouble(arr[0]) + Double.parseDouble(arr[2]);
			}else if(arr[1].equals("-")) {
				result = Double.parseDouble(arr[0]) - Double.parseDouble(arr[2]);
			}else if(arr[1].equals("*")) {
				result = Double.parseDouble(arr[0]) * Double.parseDouble(arr[2]);
			}else if(arr[1].equals("/")){
				result = Double.parseDouble(arr[0]) / Double.parseDouble(arr[2]);
			}
		}
		
		if(arr.length == 1) {
			result = Double.parseDouble(arr[0]);
		}else{
			for(int i = 2; i < arr.length; i++) {
				if(arr[i].equals("+")){
					result += Double.parseDouble(arr[i+1]);
				}else if(arr[i].equals("-")) {
					result -= Double.parseDouble(arr[i+1]);
				}else if(arr[i].equals("*")){
					result *= Double.parseDouble(arr[i+1]);
				}else if(arr[i].equals("/")){
					result /= Double.parseDouble(arr[i+1]);
				}
			}
		}
		return result;
	}
