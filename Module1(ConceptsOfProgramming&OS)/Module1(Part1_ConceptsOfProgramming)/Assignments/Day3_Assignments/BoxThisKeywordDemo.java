package Day3_Assignments;

public class BoxThisKeywordDemo {
	public static void main(String args[])
	{
		//create and initialise objects
		BoxThisKeyword myboxthiskeyword=new BoxThisKeyword(7.0,8.0,9.0);
		
		double calculatevolume=myboxthiskeyword.volume();
		System.out.println("Volume of the box : " + calculatevolume);
	}

}
