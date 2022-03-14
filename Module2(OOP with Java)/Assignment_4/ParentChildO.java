package Assignment_4;

public class ParentChildO {
	public static void main(String args[])
	{
		ParentClass objParentClass = new ParentClass();
		ChildClass objChildClass = new ChildClass();
		objParentClass.pmethod();
		objChildClass.cmethod();
		objChildClass.pmethod();
	}
}