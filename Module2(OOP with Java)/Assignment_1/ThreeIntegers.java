package Assignment_1;
import java.util.*;
public class ThreeIntegers {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter 1st Number: ");
		int a = in.nextInt();
		System.out.print("Enter 2nd Number: ");
		int b = in.nextInt();
		System.out.print("Enter 3rd Number: ");
		int c = in.nextInt();
		System.out.print("The Result is: " + test(a, b, c, true));
		System.out.print("\n");
	}
    public static boolean test(int d, int e, int f, boolean abc)
    {
    	if(abc)
    		return (f>e);
    	    return (e>d && f>e);
    }
}