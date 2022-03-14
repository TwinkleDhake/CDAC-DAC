package Assignment_2;
import java.util.Scanner;
public class AscDescElements {
	public static void main(String args[]) 
    {
		System.out.println("Enter the Number you wish to sort");		
        for(int i=0; i<=num;i++)
        {
        	System.out.println("Enter the value of element");        	
        int[] arr = new int [i];
        }       
        int temp = 0;                
        System.out.println("Elements of original array: ");    
        for (int i = 0; i < arr.length; i++) 
        {     
            System.out.print(arr[i] + " ");    
        }               
        for (int i = 0; i < arr.length; i++) 
        {     
            for (int j = i+1; j < arr.length; j++) 
            {     
               if(arr[i] < arr[j]) 
               {    
                   temp = arr[i];    
                   arr[i] = arr[j];    
                   arr[j] = temp;    
               }     
            }     
        }       
        System.out.println();    
        System.out.println("Elements of array sorted in descending order: ");    
        for (int i = 0; i < arr.length; i++) 
        {     
            System.out.print(arr[i] + " ");    
        }    
	    for (int i = 0; i < arr.length; i++) 
	    {   
          for (int j = i+1; j < arr.length; j++) 
          {   
             if(arr[i] > arr[j]) 
             {  
                temp = arr[i];  
                arr[i] = arr[j];  
                arr[j] = temp;  
             }   
           }   
         }       
         System.out.println();  
         System.out.println("Elements of array sorted in ascending order: ");  
         for (int i = 0; i < arr.length; i++) 
         {   
           System.out.print(arr[i] + " ");  
         }  
    }  
}