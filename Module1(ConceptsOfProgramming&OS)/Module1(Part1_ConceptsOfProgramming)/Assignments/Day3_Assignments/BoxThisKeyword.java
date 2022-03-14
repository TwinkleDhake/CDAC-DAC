package Day3_Assignments;

public class BoxThisKeyword {
	double width;
	double height;
	double depth;
	
	//parameterised constructor
	public BoxThisKeyword(double w, double h,double d)
	{
		this.width=w;
		this.height=h;
		this.depth=d;
	}
	//compute and return the volume
	double volume()
	{
		return width*height*depth;
	}

}
