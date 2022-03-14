package Day2_Assignments;
import java.util.Scanner;
public class SquareRootUsingSqrtMethod {
	public static void main(String[] args) 
	{

	      //declare variables
	      double number = 0;
	      double squareRoot = 0;

	      //read input from console
	      Scanner scan = new Scanner(System.in);
	      System.out.print("Enter a number: ");
	      number = scan.nextDouble();

	      //find sqrt() value
	      squareRoot = Math.sqrt(number);

	      //display result
	      System.out.println("Square root "
			+ "value = "+ squareRoot);

	      //close Scanner class object
	      scan.close();
	   }
}
