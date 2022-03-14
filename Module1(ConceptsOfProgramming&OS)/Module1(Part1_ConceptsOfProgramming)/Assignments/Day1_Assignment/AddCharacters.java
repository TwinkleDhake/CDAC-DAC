package Day1_Assignment;
import java.util.Scanner;
public class AddCharacters {
	public static void main(String args[])
	{
		  Scanner scr = new Scanner(System.in); 
		    System.out.print("Enter a char : "); 
		    char ch1 = scr.next().charAt(0);
		    char ch2 = scr.next().charAt(0);
		    System.out.println("Entered char : "+ch1+ch2); 
	}
}
