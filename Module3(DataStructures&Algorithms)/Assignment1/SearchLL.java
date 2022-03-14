package Assignment1;
import java.util.Scanner;
public class SearchLL {
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

    public static void search(List  start) {
    	
        Scanner sc = new Scanner(System.in);
        
        if (start == null) {
            System.out.println("list is empty");
        }
        else 
        {
            int pos = 0, elm;
            List  node = start;
            System.out.println("\n Enter the element want to search");
            elm = sc.nextInt();
            while (node!= null) {
                ++pos;
             if (node.getinfo() == elm)
             {
               System.out.println("\n Element found at :" + pos);
             }
                node = node.getnext();
            }
          
            }
        }
    
       public static void freq(List  start) {
    	
        Scanner sc = new Scanner(System.in);
        
        if (start == null) {
            System.out.println("list is empty");
        }
        else 
        {
            int pos = 0, elm, freq = 0;
            List  node = start;
            System.out.println("\n Enter the element want to get frequency");
            elm = sc.nextInt();
            while (node!= null) {
                ++pos;
             if (node.getinfo() == elm)
              {
                 ++freq;
              }
                node = node.getnext();
            }
             System.out.println("\n Given Element frequency is :" + freq);
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
    
     public static void main(String args[])
    {
    	List  start=null;
        start=creNode(start);
        display(start);
        search(start);
        freq(start);

    }
}