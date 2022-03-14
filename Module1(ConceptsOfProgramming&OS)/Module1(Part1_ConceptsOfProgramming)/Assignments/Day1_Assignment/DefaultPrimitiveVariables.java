package Day1_Assignment;

class Test {
	int k;
	double d;
	float f;
	boolean istrue;
	String p;

	public void printValue() 
	{
		System.out.println("int default value = "+ k);
		System.out.println("double default value = "+ d);
		System.out.println("float default value = "+ f);
		System.out.println("boolean default value = "+ istrue);
		System.out.println("String default value = "+ p);
	}

}
public class DefaultPrimitiveVariables
{
	public static void main(String argv[]) 
	{
		Test test = new Test();
		test.printValue();
	}
}
  
