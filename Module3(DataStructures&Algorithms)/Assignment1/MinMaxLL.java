package Assignment1;
import java.util.Scanner;
public class MinMaxLL {
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
    
    static int maxEle(List start) 
    { 
       int max = Integer.MIN_VALUE; 
       List  node = new List ();
        node=start;
        while (node != null)
        { 
            if (max < node.getinfo()) 
            	
                max = node.getinfo(); 
                node = node.getnext(); 
        } 
        return max; 
    } 
       
    static int minEle(List start) 
    { 
        int min = Integer.MAX_VALUE; 
      
        List  node = new List ();
        node=start;
        while (node != null) 
        { 
          if (min > node.getinfo()) 
            	
                min = node.getinfo(); 
                node = node.getnext();  
        } 
        return min; 
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
        System.out.println("\n maximum element");
        System.out.println(maxEle(start));
        System.out.println("\n minimum element");
       System.out.println(minEle(start));
       // display(start);
      

	}

}