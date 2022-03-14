package Day4_Assignments;

public class Highest2HighestNumArray {
	public static void main(String[] args) 
	{
		  int numArr[] = {2, 5, 14, 1, 26, 65, 123, 6};
		  // Assign lowest possible int value
		  int firstNum = Integer.MIN_VALUE;
		  int secondNum = Integer.MIN_VALUE;
		  
		  for(int i = 0; i < numArr.length; i++){
		   if(firstNum < numArr[i]){
		    secondNum = firstNum;
		    firstNum = numArr[i];
		   }else if(secondNum < numArr[i]){
		    secondNum = numArr[i];
		   } 
		  }
		  System.out.println("Top two numbers : First -  " 
		     + firstNum + " Second " + secondNum);
		 }

}
