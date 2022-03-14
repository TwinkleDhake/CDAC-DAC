package Assignment_5;
import java.io.File;
public class FileSize {
	//Write a Java program to get file size in bytes, kb, mb
          public static void main(String[] args) 
	      {
	        File file = new File("F:\\JavaFile\\First.txt");
	        
	        if(file.exists())
	        {
	        System.out.println(filesize_in_Bytes(file));
	        System.out.println(filesize_in_mb(file));
	        System.out.println(filesize_in_kb(file));
	       
	        }
	        else 
	        System.out.println("File doesn't exist");
	         
	    }
	 
	     private static String filesize_in_Bytes(File file)
	     {
	        return file.length()+" bytes";
	    }
	    
	    private static String filesize_in_mb(File file)
	    {
	        return (double) file.length()/(1024*1024)+" mb";
	    }
	    
	    private static String filesize_in_kb(File file) 
	    {
	        return (double) file.length()/1024+"  kb";
	    }
	 
	 }