package Day3_Assignments;

public class StackDemo {
	public static void main(String args[])
	{
		Stack mystack1=new Stack();
		
		//push some numbers onto the stack
		mystack1.push(10);
		mystack1.push(20);
		mystack1.push(30);
		mystack1.push(40);
		
		//pop numbers off the stack
		System.out.println(mystack1.pop());
		System.out.println(mystack1.pop());
		System.out.println(mystack1.pop());
	}
}
