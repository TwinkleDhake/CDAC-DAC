package Assignment_5;
import java.io.File;
public class Ques6 {
	       public static void main(String[] args) {
	        // Create a File object
	        File file_dir = new File("F:\\JavaFile\\First.txt");
	        
	         if (file_dir.canWrite()) 
		           {
		            System.out.println(" can write \n");
		           } 
	         else
		          {
		            System.out.println(" cannot write \n");
		          }
	         if (file_dir.canRead()) 
		           {
		            System.out.println(" can read \n");
		           } 
	         else
		          {
		            System.out.println(" cannot read \n");
		          }  
	      }
}