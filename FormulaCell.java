package textExcel;

import java.util.ArrayList;
import java.util.Arrays;

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
	
	/*package textExcel;

public class FormulaCell extends RealCell{
	private Spreadsheet grid;
	public FormulaCell(String entry, Spreadsheet grid) {
		super(entry);
		this.grid = grid;
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
		double result;
		if(arr[0].toLowerCase().equals("sum")) {
			result = sum(arr[1].toLowerCase());
		}else if(arr[0].toLowerCase().equals("avg")) {
			result = avg(arr[1].toLowerCase());
	    }else{
			if(!(Character.isDigit(arr[0].charAt(0))) && !(arr[0].charAt(0) == '-')) {
				RealCell a = (RealCell) grid.getCell(new SpreadsheetLocation(arr[0]));
				result = (a.getDoubleValue());
			}else {
				result = Double.parseDouble(arr[0]);
			}
		}
		
		if(!(arr.length == 1)) {	
			for(int i = 1; i < arr.length; i+=2) {
				if(arr[i].equals("+")){
					result += getCellVal(result, arr[i+1]);
				}else if(arr[i].equals("-")) {
					result -= getCellVal(result, arr[i+1]);
				}else if(arr[i].equals("*")){
					result *= getCellVal(result, arr[i+1]);
				}else if(arr[i].equals("/")){
					result /= getCellVal(result, arr[i+1]);
				}
			}
		}
		return result;
	}
	
	public double getCellVal(double base, String ele) {
		if(!(Character.isDigit(ele.charAt(0))) && !(ele.charAt(0) == '-')){
			RealCell a = (RealCell) grid.getCell(new SpreadsheetLocation(ele));
			return a.getDoubleValue();
		}else {
			return Double.parseDouble(ele);
		}
	}
	
	public double sum(String expression) {//a1-c10
		String[] operands = expression.toLowerCase().split("-");
		int startNum = Integer.parseInt(operands[0].substring(1));
		int endNum = Integer.parseInt(operands[1].substring(1));
		char startChar = operands[0].charAt(0);
		char endChar = operands[1].charAt(0);
		double sum = 0;
		for(char i = startChar; i <= endChar; i++) {
			for(int j = startNum; j <= endNum; j++) {
				SpreadsheetLocation loc = new SpreadsheetLocation("" + i + j); 
				if(grid.getCell(loc) instanceof RealCell) {
					RealCell temp = (RealCell)(grid.getCell(loc));
					sum += temp.getDoubleValue();
				}
			}
		}
		return sum;
	}
	
	public double avg(String expression) {
		String[] operands = expression.split("-");
		int startNum = Integer.parseInt(operands[0].substring(1));
		int endNum = Integer.parseInt(operands[1].substring(1));
		char startChar = operands[0].charAt(0);
		char endChar = operands[1].charAt(0);
		double s = sum(expression);
		int totalCol = (endChar - startChar) + 1;
		int totalRow = (endNum - startNum) + 1;
		return s/(totalCol * totalRow);
	}
}
*/

	public double getDoubleValue() {
		String modified = getRealCell().substring(2, getRealCell().length()-2);
		String[] arr = modified.split(" ");
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
		double[] calc = new double[(arr.length+1)/2];
		double result = 0;
		if(arr[0].toLowerCase().equals("sum")) {
			result = sum(arr[1].toLowerCase());
		}
		else if(arr[0].toLowerCase().equals("avg")) {
			result = avg(arr[1].toLowerCase());
	   	}
		else{
	    		for(int i = 0; i < list.size(); i++) {
	    			if(list.get(i).length == 2 && !(Character.isDigit(list.get(i).charAt(0)))){
	    				SpreadsheetLocation location = new SpreadsheetLocation(list.get(i));
	    				RealCell stored = (RealCell) grid.getCell(location);
	    				calc[i] = stored.getDoubleValue();
	    				list.remove(i);
	    			}
	    			if(Character.isDigit(list.get(i).charAt(0))){
	    				calc[i] = Double.parseDouble(list.get(i));
	    				list.remove(i);
	    			}
	    	}
				result = calc[0];
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).equals("+")){
					result += calc[i+1];
				}
				else if(arr[i].equals("-")) {
					result -= calc[i+1];
				}
				else if(arr[i].equals("*")){
					result *= calc[i+1];
				}
				else if(arr[i].equals("/")){
					result /= calc[i+1];
				}
			}
		}
		return result;
	}
	
	public double sum(String input){
		String[] arr = input.split("-");
		int startrow = Integer.parseInt(arr[0].substring(1));
		int finishrow = Integer.parseInt(arr[1].substring(1));
		char startcol = arr[0].charAt(0);
		char finishcol = arr[0].charAt(0);
		double sum = 0;
		for (char i = startcol; i <= finishcol; i++){
			for(int j = startrow; j <= finishrow; j++){
				SpreadsheetLocation location = new SpreadsheetLocation("" + i + j);
				RealCell stored = (RealCell) grid.getCell(location);
				sum += stored.getDoubleValue();
				}
			}
		return sum;
		}
		
		public double avg(String input){
			double sum = sum(input);
			String[] arr = input.split("-");
			int startrow = Integer.parseInt(arr[0].substring(1));
			int finishrow = Integer.parseInt(arr[1].substring(1));
			char startcol = arr[0].charAt(0);
			char finishcol = arr[0].charAt(0);
			int row = finishrow - startrow + 1;
			int col = finishcol - startcol + 1;
			double avg = sum/(row * col);
			return avg;	
	}
}
