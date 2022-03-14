package Assignment1;
import java.util.Scanner;
public class SplitLinkedList {
	static int count;
    public static List creNode(List  start)
    {
        Scanner scan =new Scanner(System.in);
        int tinfo;
        List  tnext;
        List  node =new List ();
        String ch;
        
       start =node;

        do
        {
            count++;
            System.out.println("Enter the node");
            tinfo=scan.nextInt();
            node.setinfo(tinfo);
            node.setnext(null);

            System.out.println("You want to create nodes (Y/N)");
            ch=scan.next();
            if(ch.toUpperCase().equals("Y"))
            {
                tnext=new List ();
                node.setnext(tnext);
                node=tnext;
                continue;
            }
            else
            	
                break;

        }while(true);
        return start;
    }
    public static void display(List  start)
    {
        if(start!=null)
        {
        	List  node = new List ();
            System.out.println("\n list is :");
            node=start;
            while (node!=null)
            {
                System.out.print(node.getinfo()+" ");
                node = node.getnext();
            }
        }
    }
    
	 public static void searchlist(List start1,List start2)
	    {
	        Scanner scn=new Scanner((System.in));
	        if(start1==null)
	        {
	            System.out.println("\n Linked List is empty .....");
	        }
	        else
	        {
	            int elm, pos=0, flag=0; //element does not exist
	            System.out.println("\n Enter the lement to find : ");
	            elm=scn.nextInt();

	            List node=start1;
	            List newnode=start2;
	            while(node!=null)
	            {
	                ++pos;
	                if(node.getinfo()==elm)
	                {
	                	start2=node.getnext();
	             // node=node.getnext();
	                    flag=1;
	                    break;
	                }
	                else
	                    node=node.getnext();
	            }

	            if(flag==1)
	                System.out.printf("\n Element %d found at position : %d", elm, pos);
	            else
	                System.out.println("\n Element doen not exist in the List");

	        }
	    }


}