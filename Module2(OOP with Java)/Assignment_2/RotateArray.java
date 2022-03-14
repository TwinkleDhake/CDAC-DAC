package Assignment_2;
import java.util.*; 
public class RotateArray {
	public static void main(String args[])
	 {
	    int[] array_nums = {10,20,30,40,50,60,70};
		System.out.println("Original Array: "+ Arrays.toString(array_nums)); 
		int[] new_array_nums = {array_nums[6], array_nums[5], array_nums[4],array_nums[3],array_nums[2],array_nums[1],array_nums[0]};
		System.out.println("Rotated Array: "+ Arrays.toString(new_array_nums)); 	 
	 }
}