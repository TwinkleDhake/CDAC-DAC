package Assignment1;
import java.util.Scanner;
public class alternate_ele {
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
    
    static void alternateNode( List start) 
    { 
        int count = 0; 
      
        List  node = new List ();
        node=start;
        while (node != null)
        { 
      
            if (count % 2 == 0) 
                System.out.printf(" %d ", node.getinfo()); 
      
            count++; 
            node = node.getnext(); 
            
            if (count % 2 != 0) 
                System.out.printf(" %d ", node.getinfo()); 
      
            count++; 
            node = node.getnext(); 
        } 
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
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		List  start=null;
        start=creNode(start);
        display(start);
        System.out.println("\n Alternate node is:");
        alternateNode( start);
       // display(start);
      

	}

}