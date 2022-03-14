package Assignment1;
import java.util.Scanner;
public class RevLinkedList {
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
    
    public static void reverse(List start)
    {
    	 if(start==null)
         {
             System.out.println("\n List id empty ....");
         }
         else
         {
             List node=start, temp;
             int t;
             while(node!=null)
             {
                 temp=node.getnext();
                 while(temp!=null)
                 {
                     t=node.getinfo();
                     node.setinfo(temp.getinfo());
                     temp.setinfo(t);
                     
                     temp=temp.getnext();
                 }
                 node=node.getnext();
             }
         }
    		
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List  start=null;
        start=creNode(start);
        display(start);
        reverse(start);
        display(start);

	}

}