package Assignment_5;
import java.io.*;
public class DCreation {
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			//File obj=new File("F:\\CDAC\\Today");
			//obj.mkdirs();
		//	System.out.println("Directory created:");		
				File obj=new File("F:\\JavaFile\\First.txt");
				
				if(!obj.exists())
				{
					System.out.println("no such file to open");
					return;
					
				}
				try(FileInputStream fis=new FileInputStream(obj))
				{
					int size=(int) obj.length();
					byte [] data=new byte[size];
					fis.read(data);
					String tmpData=new String (data);
					System.out.println("Content of the file:\n");
					System.out.println(tmpData);
				}catch(IOException e)
				{
					e.printStackTrace();
				}
				
				
			}
}