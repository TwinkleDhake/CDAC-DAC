package Assignment_4;

class Rectangle {
	int length,breadth;
	public Rectangle(int l, int b)
	{
		length = l;
		breadth = b;
	}
	void print_area()
	{
		System.out.println(length*breadth);
	}
	void print_perimeter()
	{
		System.out.println(2*length+breadth);
	}
}