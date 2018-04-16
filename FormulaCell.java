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
		double result = 0;
		if(arr[0].toLowerCase().equals("avg")){
			result = avg(arr[]);
		}
		else if(arr[0].toLowerCase().equals("sum")){
			result = avg(arr[]);
		}
		else {
			for (int i = 0; i < arr.length; i++){
				SpreadsheetLocation location = new SpreadsheetLocation(arr[i]);
				if (grid.getCell(location) instanceof Cell){
					RealCell stored = (RealCell) grid.getCell(location);
					arr[i] = stored.getDoubleValue();
				}
			}
			result = Double.parseDouble(arr[0]);
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
		
		public double sum(int[] input){
			String[] arr = imput.split("-");
			int startrow = Integer.parseInt(arr[0].substring(1));
			int finishrow = Integer.parseInt(arr[1].substring(1));
			char startcol = arr[0].charAt(0);
			char finishcol = arr[0].chartAt(0);
			double sum = 0;
			for (char i = startcol; i <= finishcol; i++){
				for(int j = startrow; j <= finishrow; j++){
					SpreadsheetLocation location = new SpreadsheetLocation("" + i + j);
					if (grid.getCell(location) instanceof Cell){
						RealCell stored = (RealCell) grid.getCell(location);
						sum += stored.getDoubleValue();
					}
				}
			}
			return sum;
		}
					
			
			
}
