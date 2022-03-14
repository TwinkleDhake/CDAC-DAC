package Day4_Assignments;
import java.util.Arrays;
public class Concatenate2Array {
	 public static void main(String[] args)  
	 {
	        int[] Array1 = {00,10,20,30,40,50};
	        int[] Array2 = {60,70,80,90,100};
	        int lenArray1 = Array1.length;
	        int lenArray2 = Array2.length;
	        int[] concate = new int[lenArray1 + lenArray2];
	        System.arraycopy(Array1, 0, concate, 0, lenArray1);  
	        System.arraycopy(Array2, 0, concate, lenArray1, lenArray2);  
	        System.out.println("Array1: " + Arrays.toString(Array1));
	        System.out.println("Array2: " + Arrays.toString(Array2));
	        System.out.println("Concatenated Array: " + Arrays.toString(concate)); 
	    }  
}
