package Assignment1;
import java.util.Scanner;
public class ModifyCL {
	static int count;
	public static List creNode(List start)
	{
     Scanner scan =new Scanner(System.in);

		int tinfo;
		List tnext;
		List node =new List();
		String ch;
		start =node;
		
		do
		{
			count++;

			System.out.println("Enter the information part of node");
			
			tinfo=scan.nextInt();
			node.setinfo(tinfo);
			node.setnext(null);
			
			System.out.println("You want to create  nodes (Y/N)");
			ch=scan.next();
			  
			if(ch.toUpperCase().equals("Y"))
			{
				//create node
				tnext=new List();
				
				node.setnext(tnext);
				node=tnext;
				continue;
				
			}
			else
				break;
			
		}while(true);
		return start;
		
	}
	
	public static List insFirst(List start)
	{
		Scanner scan =new Scanner(System.in);
		List newnode = new List();
		int tinfo;
		System.out.println("\nEnetr the new node information");
		tinfo=scan.nextInt();
		newnode.setinfo(tinfo);
		
		newnode.setnext(start);
		start=newnode;
		count++;
		return start;	
	}
	
	public static List insLast(List start)
	{
		Scanner scan =new Scanner(System.in);
		List newnode = new List();
		System.out.println("\nEnter the new node information");
		int tinfo=scan.nextInt();

		if(start==null)
		{
			start=newnode;
			newnode.setinfo(tinfo);
			newnode.setnext(null);
		}
		else
		{
			List node= start;
			
            while(node.getnext()!=null)
                node=node.getnext();

            node.setnext(newnode);
			newnode.setinfo(tinfo);
			newnode.setnext(null);

		}
		count++;
		return(start);
	}
	
	
	public static List insPos(List start,int pos)
	{
		Scanner scan =new Scanner(System.in);
		List newnode = new List();
		int tinfo;
	
		do
		{
			if(pos<=0||pos>count)
			{
				System.out.println("\ninvalid position try again");
				continue;
			}
			else
				break;
		}while(true);
		
		if(pos==1)
		{
			start= insFirst(start);
		}
		else if(pos==count)
		{
			start=insLast(start);
		}
		else
		{
			System.out.println("\nEnter the information of node");
			tinfo=scan.nextInt();
			newnode.setinfo(tinfo);
			
			List node=start;
			for(int i=1;i<pos;i++)
			{
				node=node.getnext();
			}
			newnode.setnext(node.getnext());
			node.setnext(newnode);
		}
		count++;
		return start;
	}

	
	public static List searchEle(List start)
	{
		Scanner scan =new Scanner(System.in);
		if(start==null)
		{
			System.out.println("List is empty");
		}
		else
		{
			int pos=0,ele,flag=0;
			List node=start;
			
			System.out.println("\nEnter the element after which you want to insert new element ");
			ele=scan.nextInt();
			while(node.getnext()!=null)
			{
				pos++;
				
				if(node.getinfo()==ele)
				{
					flag=1;
					insPos(start,pos);
					break;
				}
				node=node.getnext();
			}
			
		}
		return start;
		
	}
	
	public static void display(List start)
	{
		if(start!=null)
		{
			List node = new List();
			System.out.println("\nCurrent list is :");
			node=start;
			while (node!=null)
			{
				System.out.print(node.getinfo()+" ");
				node = node.getnext();
			}		
		}
	}
	
	public static void main(String args[])
	{
		List start=null;
		start=creNode(start);
		display(start);
		start=searchEle(start);
		System.out.println("List after insertion of node");
		display(start);
	}
}