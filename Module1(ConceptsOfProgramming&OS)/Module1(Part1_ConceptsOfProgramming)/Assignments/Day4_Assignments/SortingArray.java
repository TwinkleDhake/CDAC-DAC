package Day4_Assignments;
import java.util.Arrays;
//sorting array
public class SortingArray {
	public static void main(String args[])
	{
		int arr[]= {29,39,49,59,10,20};
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
}
