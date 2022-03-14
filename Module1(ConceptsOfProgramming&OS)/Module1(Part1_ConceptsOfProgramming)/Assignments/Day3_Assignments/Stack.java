package Day3_Assignments;
//default constructor with Stack implementation
public class Stack {
	int stack1[]=new int[5];
	int tos;
	
	//default constructor 
	//Initialise top of stack
	
	Stack()
	{
		//stack is empty
		tos=-1;
	}
	
	//Push an item onto the stack
	void push(int item)
	{
		//stack is overflow / full
		if(tos==4)
		{
			System.out.println("Stack is full");
		}
		else
		{
			//incremeting the stack pointer and 
			//then adding the elements onto the stack
			stack1[++tos]=item;
		}
	}
	
	//Pop an item from the stack
	int pop()
	{
		//check stack is empty or not
		if(tos<0)
		{
			System.out.println("Stack underflow");
			return 0;
		}
		else
		{
			//popping the elements
			//then decrementing the pointer
			return stack1[tos--];
		}
	}

}
