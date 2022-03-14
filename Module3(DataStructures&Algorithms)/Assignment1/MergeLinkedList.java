package Assignment1;
import java.util.Scanner;
public class MergeLinkedList {
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
    
     
    public static void mergelist(List start,List start1) 
    {
            
    		  if (start == null || start1 == null)
    		  {
    		     System.out.println("Invalid not merge");
    		  }
    		  else
    		  {
    			  List node=new List();
    			  node=start;
    			  while(node.getnext()!=null)
    			  {
    				  node=node.getnext();
    			  }
    			  node.setnext(start1);
    		  }
    }
   

    public static void display(List  start)
    {
        if(start!=null)
        {
        	List  node = new List ();
           // System.out.println("\n list is :");
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
    	List  start=null,start1=null;
    
       System.out.println("\n 1St list is:");
       start=creNode(start);
       display(start);
       
       System.out.println("\n 2nd list is:");
       start1=creNode(start1);
       display(start1);
       
       System.out.println("\n Merge list is:");
       mergelist(start,start1);
       display(start);
       
       
       
    }
}