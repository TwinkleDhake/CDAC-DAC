package MyPackage2;
import java.util.*;

class nba
{
    private int info;
    private int priority;
    private nba next;

    public void setinfo(int tinfo)
    {
        info=tinfo;
    }
    public int getinfo()
    {
        return(info);
    }
    public void setpriority(int tpriority)
    {
        priority=tpriority;
    }
    public int getpriority()
    {
        return(priority);
    }
    public void setnext(nba tnext)
    {
        next=tnext;
    }
    public nba getnext()
    {
        return(next);
    }
}

public class nodebasedarray {
    private static nba[] priorityarr;

    public static void menu()
    {
        System.out.println("\n \t\t\t Menu");
        System.out.println("\n \t 1. Enqueue");
        System.out.println("\n \t 2. Display");
        System.out.println("\n \t 3. Dequeue");
        System.out.println("\n \t 4. Exit");
        System.out.println("\n \t 3. Please Enter Your Choice (1-4) : ");
    }
    public static void addnode()
    {
        Scanner scn=new Scanner(System.in);
        nba newnode=new nba();
        int tinfo;
        int tpriority;
        nba tnext;
        System.out.println("\n Enter information part of the node :");
        tinfo=scn.nextInt();
        do {
            System.out.println("\n Enter priority (0(min) to 4(max)):");
            tpriority=scn.nextInt();
            if((tpriority<0)||(tpriority>4))
            {
                System.out.println("\n Invalid priority ... try again ");
                continue;
            }
            else
                break;
        }while(true);
        newnode.setinfo(tinfo);
        newnode.setpriority(tpriority);

        for(int i=0; i<priorityarr.length; ++i)
        {
            if(i==tpriority)
            {
                if(priorityarr[i]==null)
                {
                    priorityarr[i]=newnode;
                    newnode.setnext(null);
                    return;
                }
                else
                {
                    nba temp=priorityarr[i];
                    while(temp.getnext()!=null)
                        temp=temp.getnext();
                    newnode.setnext(temp.getnext());
                    temp.setnext(newnode);
                    return;
                }
            }
        }
    }

    public static void displaynba()
    {
        for(int i=0; i<priorityarr.length; ++i)
        {
            if(priorityarr[i]!=null)
            {
                System.out.println("\n Priority : " + i);
                nba temp=priorityarr[i];
                while(temp!=null) {
                    System.out.printf("%5d", temp.getinfo());
                    temp = temp.getnext();
                }
            }
            System.out.println();
        }
    }

    public static void dequeue()
    {
        for(int i=priorityarr.length-1; i>=0; --i)
        {
            if(priorityarr[i]!=null)
            {
                nba temp=priorityarr[i];
                priorityarr[i]=temp.getnext();
                return;
            }
        }
    }

    public static void main(String[] args) {
        //let 0 be low priority and 4 be high priority
        //create an array of nba reference type with size equal to the
        //hifgest priority and initalize each element to null
        Scanner scn=new Scanner(System.in);
        int choice;
        priorityarr=new nba[5];
        for(int i=0; i<priorityarr.length; ++i)
            priorityarr[i]=null;
        do {
            do {
                    menu();
                    choice=scn.nextInt();
                    if((choice<1)||(choice>4))
                    {
                        System.out.println("\n Invalid Choice ... try again");
                        continue;
                    }
                    else
                        break;
                }while(true);

            switch(choice) {
                case 1:
                    addnode();
                    break;
                case 2:
                    System.out.println("\n after inserting node \n");
                    displaynba();
                case 3:
                    dequeue();
                    break;
            }
        }while(choice<4);
    }
}
