package Day3_Assignments;
//default constructor --> constructor with no parameters
public class BoxDefaultConstructor {
	double width;
	double height;
	double depth;
	
	//constructor for the default constructor box
	//constructor -> intialising the object variables
	BoxDefaultConstructor()
	 {
		width=70.0;
		height=40.0;
		depth=20.0;
	 }
	
	//function to compute the volume of the box
	double volume() 
	 {
	      return width*height*depth;
     }

}
