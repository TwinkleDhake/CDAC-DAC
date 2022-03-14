package Assignment_5;
import java.io.File;
public class FDNames {
	//Write a Java program to get a list of all file/directory names from the given.
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			File objFile=new File("F:\\JavaFile");
			
			File [] arrFiles=objFile.listFiles();
			
			for(File file: arrFiles)
			{
				if(file.isDirectory());
				System.out.println("["+file.getName()+"]");
				//System.out.println(file.getName());
			}
		}
	}