package Day3_Assignments;
//demonstrate parameterised constructor
public class BoxParameterized {
	double width;
	double height;
	double depth;
	
	//parameterised constructor
	public BoxParameterized(double w, double h,double d)
	{
		width=w;
		height=h;
		depth=d;
	}
	//compute and return the volume
	double volume()
	{
		return width*height*depth;
	}

}
