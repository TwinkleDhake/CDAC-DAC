package Assignment_4;

public class RectangleSquareO {
	public static void main(String args[])
	{
		Rectangle objRectangle = new Rectangle (4, 5);
		Square objSquare = new Square (4);
		objRectangle.print_area();
		objRectangle.print_perimeter();
		objSquare.print_area();
		objSquare.print_perimeter();
	}
}