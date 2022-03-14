package Assignment_3;

class Triangle {
	int s1,s2,s3;
	public Triangle(int side1, int side2, int side3)
	{
	    s1=side1;
	    s2=side2;
	    s3=side3;
	}
	public static void main(String args[])
	{
	    Triangle t=new Triangle(3,4,5);
	    int peri=(t.s1+t.s2+t.s3);
	    int sp=(peri/2);
	    int ar=((((sp*(sp-t.s1))*(sp-t.s2))*(sp-t.s3)));       
	    int area=(int)Math.sqrt(ar);   
	    System.out.println("Area is: "+area);
	    System.out.println("perimeter is: "+peri);
	}
}