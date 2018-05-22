package textExcel;
public class FormulaCell extends RealCell{
	private Spreadsheet grid;
	public FormulaCell(String input, Spreadsheet grid) {
		super(input);
		this.grid = grid;
	}
	

	public String abbreviatedCellText() {
		String formula = getDoubleValue() + "";
		if(formula.length() < 10) {
			return spaces(formula);
			//adds spaces until formula reaches string length of 10
		}
		else {
			return formula.substring(0, 10);
		}
		
	}
	public String fullCellText() {
		return super.getRealCell();
	}
	
	public double getDoubleValue() {
		String formula = getRealCell().substring(2, getRealCell().length()-2);
		String[] arr = formula.split(" ");
		//splits formula at spaces,divided elements places in array
		double result = 0;
		if(arr[0].equals("SUM")) {
			result = sum(arr[1]);
			//if first element is "SUM", passes second element (the cell range) into sum method
		}
		else if(arr[0].equals("AVG")) {
			result = avg(arr[1]);
			//if first element is "AVG", passes second element (cell range) into avg method
	   	}
		else {
			//goes through array and restores any cell reference in array as string with numerical value
			for (int i = 0; i < arr.length; i++) {
				//checks to see if element is cell by looking for a letter in the first character and number in the second
				if (Character.isLetter(arr[i].charAt(0)) && Character.isDigit(arr[i].charAt(1))) {
					SpreadsheetLocation loc = new SpreadsheetLocation(arr[i]);
					//if conditions met, element is stored as a location
					RealCell temp = (RealCell) grid.getCell(loc);
					//calls cell from the location as casts it as real cell
					arr[i] = temp.getDoubleValue() + "";
					//stores it back into the array, but as a double cast as a string
				}
			}
		}
		result = Double.parseDouble(arr[0]);
		if(!(arr.length == 1)) {	
			for(int i = 1; i < arr.length; i+=2) {
				//incremements by two to check the operand sign
				if(arr[i].equals("+")){
					result += Double.parseDouble(arr[i+1]);
					//adds next element of array to previous if operand signals addition
				}
				if(arr[i].equals("-")) {
					result -= Double.parseDouble(arr[i+1]);
					//subtracts next element of array from previous if operand signals subtraction
				}
				if(arr[i].equals("*")){
					result *= Double.parseDouble(arr[i+1]);
					//multiplies by next element if operand signals multiplication
					
				}
				if(arr[i].equals("/")){
					result /= Double.parseDouble(arr[i+1]);
					//divides by next element if operand signals division
				}
			}
		}
		return result;
	}
	//accepts a cell range and returns its sum
	public double sum(String input) {
		String[] arr = input.split("-");
		int startRow = arr[0].charAt(1) - '0';
		int endRow = arr[1].substring(1) - '0';
		//stores the endpoints on rows in the passed in interval
		char startCol = arr[0].charAt(0).toLowerCase();
		char endCol = arr[1].charAt(0).toLowerCase();
		//stores endpoints on columns in the passed in interval
		double sum = 0;
		for(char i = startCol; i <= endCol; i++) {
			for(int j = startRow; j <= endRow; j++) {
				//for loop cycles through all cells in the given cell range
				SpreadsheetLocation loc = new SpreadsheetLocation(i + "" + j); 
				RealCell temp = (RealCell)(grid.getCell(loc));
				//stores each cell for loop runs through in temporary real cell
				sum += temp.getDoubleValue();
				//adds value of each real cell to sum
				}
			}
		return sum;
	}
	//accepts a cell range and returns its average value
	public double avg(String input) {
		double sum = sum(input);
		//passes in input into sum method to calculate sum
		String[] arr = input.split("-");
		//splits arr at dash
		int startRow = arr[0].charAt(1) - '0';
		int endRow = arr[1].substring(1) - '0';
		//stores the endpoints on rows in the passed in interval
		char startCol = arr[0].charAt(0).toLowerCase();
		char endCol = arr[1].charAt(0).toLowerCase();
		//stores endpoints on columns in the passed in interval
		int row = endRow - startRow + 1;
		//calculates number of cells in between start and ending row number
		int col = endCol - startCol + 1;
		//calculates number of cell between starting and ending column
		double avg = sum/(row * col);
		//finds total number of cells within interval by multiplying number of columns by rows, then divides from sum to find average
		return avg;	
	}
}
