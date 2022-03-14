package Assignment_1;
import java.util.*;
public class HMS {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Input Seconds:");
		int seconds = in.nextInt();
		int s = seconds % 60;
		int h = seconds / 60;
		int m = h % 60;
		h = h/60;
		System.out.print(h + ":" + m + ":" + s);
		System.out.print("\n");
	}
}