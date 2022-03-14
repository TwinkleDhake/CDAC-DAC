package Assignment_1;
import java.util.Scanner;
public class AddnIntegers {
	public static void main(String args[])
    {
	/*	Scanner sc = new Scanner(System.in);
		System.out.print("Enter n numbers: ");
		int n = sc.nextInt();
		int sum = 0;
		for(int i=0; i<=n; i++)
		{
			sum +=i;
		}
		System.out.println("Sum of " + n + " Numbers: " + sum);
	 }

}*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the n numbers: ");
		int num=sc.nextInt();
		int arr[]=new int[num]; 
		for(int i=0;i<num;i++) 
		{
		  arr[i]=sc.nextInt(); 
        }
		for(int i=0;i<num;i++)
		{
   		   System.out.print(arr[i]+" "); 
		}
			int sum = 0;
		for (int i = 0; i < num; i += 1)
			sum += arr[i];
			System.out.println("\nThe total sum is: " + sum );
	}
}