package Assignment_3;

class Student2 {
	  int Roll_Sam=1;
	  int Roll_John=2;
	  long Phone_no_Sam = 988886327;
      long Phone_no_John = 761452358;
	  String Adrress_Sam="CST Mumbai";
	  String Address_John="Linking Road - Bandra(Mumbai)";
	public static void main(String[] args)
	{
	    Student2 sam=new Student2();
	    Student2 john=new Student2();
	    System.out.println("Sam : " + sam.Roll_Sam + ", " + sam.Phone_no_Sam + ", " + sam.Adrress_Sam);
	    System.out.println("John : " + john.Roll_John + ", " + john.Phone_no_John + ", " + john.Address_John);
	 }
}