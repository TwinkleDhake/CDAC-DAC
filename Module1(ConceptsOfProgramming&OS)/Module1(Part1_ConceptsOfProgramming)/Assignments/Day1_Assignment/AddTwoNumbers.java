package Day1_Assignment;

import java.util.Scanner;

public class AddTwoNumbers {
	 public static void main(String[] args) 
	 {
		 Scanner sc=new Scanner(System.in);
			
			//reading two values
			System.out.print("Enter 2 values");
			int a=sc.nextInt();
			int b=sc.nextInt();
			//call the funtion
			//a and b-> actual parameters
			//num1=a
			//num2=b
			add(a,b);
	}
		//declaration function
		//num1 and num2=formal parameters
	    public static void add(int num1,int num2)
	    {
			int result=num1+num2;
			System.out.println("result : "+result);
	    }

}
