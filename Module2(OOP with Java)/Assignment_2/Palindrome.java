package Assignment_2;
import java.util.*;
public class Palindrome {
	public static void main(String[] args)
	 {
	        Scanner in = new Scanner(System.in);	
	        System.out.print("Input a positive integer: ");
	        int n = in.nextInt(); 
	        System.out.printf("Is %d is a palindrome number?\n",n);
			System.out.println(palindrome(n)); 
	 } 
     private static boolean palindrome(int num) 
	 {
	        String str = String.valueOf(num);
	        int i = 0;
	        int j = str.length() - 1;
	        while (i < j) {
	            if (str.charAt(i++) != str.charAt(j--)) 
	            {
	                return false;
	            }
	        }
	        return true;
      }
}