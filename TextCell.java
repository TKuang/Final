public class TextCell implements Cell{
	private String input;
	public TextCell(String input) {
		this.input = intput;
	}
	
	
	public String abbreviatedCellText() {
		String abbr = input.substring(1, input.length()-1);
		if(abbr.length() < 10) {
			while(abbr.length() < 10) {
				abbr += " ";
			}
			return abbr;
		}else {
			return abbr.substring(0, 10);
		}
		
	}
	
	public String fullCellText() {
		return input;
	}
}
