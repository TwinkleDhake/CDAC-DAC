package Day3_Assignments;

public class BoxDefaultConstructorDemo {
	public static void main(String args[])
	{
		//create and initialise box objects
		BoxDefaultConstructor myboxdefaultconstructor=new BoxDefaultConstructor();
		
		//calling the volume function
		//to calculate the volume of the object
		double calculateVolume=myboxdefaultconstructor.volume();
		
		System.out.println("Volume of the box = "+calculateVolume);
		
	}

}
