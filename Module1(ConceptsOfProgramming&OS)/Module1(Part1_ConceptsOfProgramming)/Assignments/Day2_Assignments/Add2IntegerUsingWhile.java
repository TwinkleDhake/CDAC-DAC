package Day2_Assignments;
import java.util.Scanner;
public class Add2IntegerUsingWhile {
	public static void main(String[] arg)
	{
	  int a,b,c;
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter first number");
	  a=sc.nextInt();
	  System.out.println("Enter second number");
	  b=sc.nextInt();
	  
	  while(a--!=0)
	  {
	    b++;
	  }
	    System.out.println("Addition of two numbers is : "+b);
	}
}
