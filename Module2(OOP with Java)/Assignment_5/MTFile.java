package Assignment_5;
import java.io.File;
import java.util.Date;
public class MTFile {
	//Write a Java program to get last modified time of a file.
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        File objfile = new File("First.txt");
		    Date date=new Date(objfile.lastModified());
		System.out.println("\n file last modified on: "+date);	   
	}
}