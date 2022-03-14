package Day2_Assignments;
import java.util.Scanner;
public class StudentsGradesUsingSwitch {
	public static String findGrade(int score) 
     {
	      // check score is within 0-100 or not
	      if(score < 0 || score > 100)
	         return "Invalid score"; // or throw exception
	      
	      // switch-case
	      switch(score/10) 
	      {
	        //for >= 90
	        case 1:
	           return "A+";
	           
	        // for >= 80 and <90
	        case 2:
	           return "A";
	           
	        // for >= 70 and <80
	        case 3:
	           return "B";
	           
	        // for >= 60 and <70
	        case 4:
	           return "C";
	           
	        // for >= 50 and <60
	        case 5:
	           return "D";
	           
	        // for >=40 and <50
	        case 6:
	           return "E";
	           
	        // for <40
	        default:
	           return "F";
	       }
	   }

	   public static void main(String[] args) 
	   {
	      // Creating Scanner class object to get input value
	      Scanner scan = new Scanner(System.in);
	      
	      // taking input for score
	      System.out.print("Enter score value: ");
	      int score = scan.nextInt();
	      
	      // find grade and display result
	      System.out.println("Grade = " + findGrade(score));
	      
	      // close Scanner 
	      scan.close();
	    }

}
