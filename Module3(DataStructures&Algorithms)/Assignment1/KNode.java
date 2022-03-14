package Assignment1;
import java.util.Scanner;
public class KNode {
	private static int count=0;

    public static List createList(List start)
    {
    Scanner scn=new Scanner(System.in);
    String ch;
    int tinfo;
    List tnext;

    //create the first node and a
    List node=new List();
    start=node;

        do {
        ++count;
        System.out.println("\n Enter information part of the node : ");
        tinfo=scn.nextInt();
        node.setinfo(tinfo);
        node.setnext(null);

        //ask user if want to create more nodes
        System.out.println("\n Do You want to Creaate more nodes (Y/N) : ");
        ch=scn.next();
        if(ch.toUpperCase().equals("Y"))
        {
            tnext=new List();
            node.setnext(tnext);
            node=tnext;
            continue;
        }
        else
            break;
    }while(true);

        return(start);
}

    public static void display(List start)
    {
        List node;
        if(start!=null)
        {
            node=start;
            while(node != null)
            {
                System.out.printf("%5d", node.getinfo());
                node=node.getnext();
            }
        }
        else
        {
            System.out.println("Linked List is Empty ....");
        }
    }

    public static List delfirst(List start)
    {
        if(start==null)
        {
            System.out.println("\n Linked List is empty ... cannot delete nodes");
        }
        else
        {
            List node=start;
            start=node.getnext();
            --count;
        }
        return(start);
    }

    public static List dellast(List start)
    {
        if(start==null)
        {
            System.out.println("\n Linked List is empty ... cannot delete nodes");
        }
        else
        if(count==1)
        {
            start=null;
        }
        else
        {
            //traverse the linked List till you reach the second last node and the last node
            List prv=start;
            List nxt=prv.getnext();

            while(nxt.getnext()!=null)
            {
                prv=prv.getnext();
                nxt=nxt.getnext();
            }
            prv.setnext(nxt.getnext());
            --count;
        }
        return(start);
    }

    public static List delpos(List start)
    {
        Scanner scn=new Scanner(System.in);
        if(start==null)
        {
            System.out.println("\n Linked List is empty ... cannot delete nodes");
        }
        else
        {
            int pos;
            do {
                System.out.printf("\n Enter position to delete from (1 to %d) : ", count);
                pos=scn.nextInt();

                if((pos<1)||(pos>count))
                {
                    System.out.println("\n Invalid position .... try again");
                    continue;
                }
                else
                    break;
            }while(true);

            if(pos==1)
                start=delfirst(start);
            else
            if(pos==count)
                start=dellast(start);
                //traverse the linked List till you reach the second last node and the last node
            else {
                List prv = start;
                List nxt = prv.getnext();

                for(int i=1; i<(pos-1); ++i) {
                    prv = prv.getnext();
                    nxt = nxt.getnext();
                }
                prv.setnext(nxt.getnext());
            }
            --count;
        }
        return(start);
    }

    public static void main(String[] args) {
        List start=null;
        start=createList(start);
        System.out.println("\n Before deletion of last node ..... \n");
        display(start);
        start=delpos(start);
        System.out.println("\n After deletion of last node \n");
        display(start);
    }
}