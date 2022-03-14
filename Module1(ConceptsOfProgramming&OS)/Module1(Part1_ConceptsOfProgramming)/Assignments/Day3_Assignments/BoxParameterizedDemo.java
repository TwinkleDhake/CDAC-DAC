package Day3_Assignments;

public class BoxParameterizedDemo {
	public static void main(String args[])
	{
		//create and initialise objects
		BoxParameterized myboxparameterized=new BoxParameterized(25.0,16.0,7.0);
		
		double calculatevolume=myboxparameterized.volume();
		System.out.println("Volume of the box : " + calculatevolume);
	}
}
