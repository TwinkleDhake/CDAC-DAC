package Assignment_3;

class Rectangle {
	int l1=4,b1=5,l2=5,b2=8;
	public static void main(String[] args)
	{
	   Rectangle rect=new Rectangle();
	   System.out.println("Area of Rectangle 1 is : " + rect.Area(rect.l1,rect.b1));
	   System.out.println("Area of Rectangle 2 is : " + rect.Area(rect.l2,rect.b2));
	}
	public int Area(int length,int breadth)
	{
	   return length*breadth;   
	}

}
