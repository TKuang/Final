import java.io.FileNotFoundException;
import java.util.Scanner;
// Update this file with your own code.

public class TextExcel
{
	public static void main(String[] args)
	{
	    Scanner input = new Scanner(System.in);
	    String userInput = "";
	    boolean finish = false;
	    while(!finish) {
	    	userInput = input.nextLine();
	    	if(userInput.equals("quit")) {
	    		finish = true;
	    	}
	    }
	}
}
