package textExcel;

public class TextCell implements Cell{
	private String input;
	public TextCell(String input) {
		this.input = input;
	}
	
	
	public String abbreviatedCellText() {
		String text = this.input;
		if(text.length() < 10) {
			while(text.length() < 10) {
				text += " ";
			}
			return text;
		}
		else {
			return text.substring(0, 10);
		}
		
	}
	
	public String fullCellText() {
		return input;
	}
}
