package Day2_Assignments;

public class DownwardTrianglePattern {
	public static void main(String args[])  
	{  
	   int rows=5;      
	     //inner loop  
	     for (int i= rows-1; i>=0 ; i--)  
	       {  
	          //outer loop  
	          for (int j=0; j<=i; j++)  
	          {  
	             //prints star and space  
	             System.out.print("*" + " ");  
	          }  
	          //shifts cursor in next line after printing individual line  
	          System.out.println();  
	        }  
	 }  

}
