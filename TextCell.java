package textExcel;

public class TextCell implements Cell{
	private String input;
	public TextCell(String input) {
		this.input = input;
	}
	
	
	public String abbreviatedCellText() {
		String revised = this.input;
		if(revised.length() < 10) {
			while(revised.length() < 10) {
				revised += " ";
			}
			//adds spaces to string until it reaches length of 10
			return revised;
		}
		else {
			return revised.substring(0, 10);
		}
		
	}
	
	public String fullCellText() {
		return input;
	}
}
