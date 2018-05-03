package textExcel;
public class FormulaCell extends RealCell{
	private Spreadsheet grid;
	public FormulaCell(String input, Spreadsheet grid) {
		super(input);
		this.grid = grid;
	}
	

	public String abbreviatedCellText() {
		String display = getDoubleValue() + "";
		if(display.length() < 10) {
			return spaces(display);
		}
		else {
			return display.substring(0, 10);
		}
		
	}
	public String fullCellText() {
		return super.getRealCell();
	}

	public double getDoubleValue() {
		String input = getRealCell().substring(2, getRealCell().length()-2);
		String[] arr = input.split(" ");
		double result = 0;
		if(arr[0].toLowerCase().equals("sum")) {
			result = sum(arr[1].toLowerCase());
		}
		else if(arr[0].toLowerCase().equals("avg")) {
			result = avg(arr[1].toLowerCase());
	   	}
		else{
			for (int i = 0; i<arr.length; i++) {
				if (Character.isLetter(arr[i].charAt(0)) && Character.isDigit(arr[i].charAt(1))) {
					RealCell temp = (RealCell) grid.getCell(new SpreadsheetLocation(arr[i]));
					arr[i] = temp.getDoubleValue() + "";
				}
			}
			result = Double.parseDouble(arr[0]);
		}
		
		if(!(arr.length == 1)) {	
			for(int i = 1; i < arr.length; i+=2) {
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
	
	public double sum(String input) {//a1-c10
		String[] arr = input.split("-");
		int startRow = Integer.parseInt(arr[0].substring(1));
		int endRow = Integer.parseInt(arr[1].substring(1));
		char startCol = arr[0].charAt(0);
		char endCol = arr[1].charAt(0);
		double sum = 0;
		for(char i = startCol; i <= endCol; i++) {
			for(int j = startRow; j <= endRow; j++) {
				SpreadsheetLocation loc = new SpreadsheetLocation("" + i + j); 
				RealCell stored = (RealCell)(grid.getCell(loc));
				sum += stored.getDoubleValue();
				}
			}
		return sum;
	}
	public double avg(String input) {
		double sum = sum(input);
		String[] arr = input.split("-");
		int startRow = Integer.parseInt(arr[0].substring(1));
		int endRow = Integer.parseInt(arr[1].substring(1));
		char startCol = arr[0].charAt(0);
		char endCol = arr[1].charAt(0);
		int row = endRow - startRow + 1;
		int col = endCol - startCol + 1;
		double avg = sum/(row * col);
		return avg;	
	}
}
