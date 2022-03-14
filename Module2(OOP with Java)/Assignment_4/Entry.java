package Assignment_4;
import Oct_16_2021.ConsoleInput;
class Entry {
	public static void main(String []args)
	{
		Member entry = new Member();
			
		System.out.println("Enter name of the member: ");
		String tmpName = ConsoleInput.getString();
		entry.setName(tmpName);
		System.out.println("The name of the member is : "+entry.getName());
			
		System.out.println("Enter age of the member:");
		int tmpAge = ConsoleInput.getInt();
		entry.setAge(tmpAge);
		System.out.println("The age enter is:"+entry.getAge());
			
		System.out.println("Enter  mobile number of the member; ");
		String tmpNumber = ConsoleInput.getString();
		entry.setPhoneNumber(tmpNumber);
		System.out.println("Entered  mobile number is: "+entry.getPhoneNumber());
			
		System.out.println("Enter address of the member; ");
		String tmpadress = ConsoleInput.getString();
		entry.setAddress(tmpadress);
		System.out.println("Entered address is: "+entry.getAddress());
		}
	}