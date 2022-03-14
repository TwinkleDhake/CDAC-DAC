package Day2_Assignments;

public class SwitchCaseLogicalOperators {
	public static void main()
	{
	   var number = prompt("Type in any number!");
	   switch(true)
	   {
	       case (number < 50):
	       console.log("case in which number is less than 50");
	       break;
	       default:
	       console.log("case in which number is not less than 50");
	       break;
	    }
	}
}
