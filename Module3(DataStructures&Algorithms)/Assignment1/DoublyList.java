package Assignment1;
import java.util.Scanner;
public class DoublyList {
	private int[] arr;
    private final int size=100;
    public static int cnt=0;
    public static dlist frnt=null;
    public static dlist rear=null;


    public DoublyList()
    {
        arr=new int[size];
    }

   public static void menu()
    {
        System.out.println("\n\t\t  Operations");
        System.out.println("\n\t 1. Create array");
        System.out.println("\n\t 2. Display Array");
        System.out.println("\n\t 3. sort Array");
        System.out.println("\n\t 4. Search array");
        System.out.println("\n\t 5. Exit");
        System.out.println("\n Please enter your choice (1-5)");
    }
   
   public static void srt_menu()
   {
      System.out.println("\n\t\t Sort Menu");
      System.out.println("\n\t 1. Ascending");
      System.out.println("\n\t 2. Descending");
      System.out.println("\n Please enter your choice (1-2):");
   }

   
   public static void searchelement()
   {
       Scanner scn=new Scanner((System.in));
       if(frnt==null)
       {
           System.out.println("\n Linked List is empty .....");
       }
       else
       {
           int elm, pos=0, flag=0; //element does not exist
           System.out.println("\n Enter the lement to find : ");
           elm=scn.nextInt();

           dlist node=frnt;
           while(node!=null)
           {
               ++pos;
               if(node.getinfo()==elm)
               {
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
   
   public static void sortasc()
   {
       if(frnt==null)
       {
           System.out.println("\n List id empty ....");
       }
       else
       {
           dlist node=frnt, temp;
           int t;
           while(node!=null)
           {
               temp=node.getnext();
               while(temp!=null)
               {
                   if(node.getinfo()>temp.getinfo())
                   {
                       t=node.getinfo();
                       node.setinfo(temp.getinfo());
                       temp.setinfo(t);
                   }
                   temp=temp.getnext();
               }
               node=node.getnext();
           }
       }
   }

   public static void sortdesc()
   {
       if(frnt==null)
       {
           System.out.println("\n List id empty ....");
       }
       else
       {
           dlist node=frnt, temp;
           int t;
           while(node!=null)
           {
               temp=node.getnext();
               while(temp!=null)
               {
                   if(node.getinfo()<temp.getinfo())
                   {
                       t=node.getinfo();
                       node.setinfo(temp.getinfo());
                       temp.setinfo(t);
                   }
                   temp=temp.getnext();
               }
               node=node.getnext();
           }
       }
   }
   
   
   public static void createdlist()
   {
       int tinfo;
       dlist tnode;
       String choice;
       Scanner scn=new Scanner(System.in);
       dlist node=new dlist();
       frnt=node;
       rear=node;
       node.setprev(null);
       do {
           ++cnt;
           System.out.println("\n Enter Information part :");
           tinfo=scn.nextInt();
           node.setinfo(tinfo);
           node.setnext(null);

           System.out.println("\n Do you want to create more nodes (Y/N): ");
           choice=scn.next();
        

           if(choice.toUpperCase().equals("Y"))
           {
               tnode=new dlist();
               node.setnext(tnode);
               node.getnext().setprev(node);
               node=tnode;
               rear=node;
               continue;
           }
           else
               break;
       }while(true);
   }

   public static void disptb()
   {
       if((frnt==null)&&(rear==null))
       {
           System.out.println("\n The Doubly Linked List is Empty ...");
       }
       else
       {
           dlist node=frnt;
           while(node!=null)
           {
               System.out.printf("%5d", node.getinfo());
               node=node.getnext();
           }
       }
   }

   public static void dispbt()
   {
       if((frnt==null)&&(rear==null))
       {
           System.out.println("\n The Doubly Linked List is Empty ...");
       }
       else
       {
           dlist node=rear;
           while(node!=null)
           {
               System.out.printf("%5d", node.getinfo());
               node=node.getprev();
           }
       }
   }
   
   public static void main(String[] args) {

       Scanner scn=new Scanner(System.in);
       DoublyList ob=new DoublyList();
       int ch1, ch2;

       do {
           do{
                menu();
                ch1=scn.nextInt();

                if((ch1<1)||(ch1>5))
                {
                    System.out.println("\n Invalid choice ... try again");
                    continue;
                }
                else
                    break;
           }while(true);

           switch(ch1)
           {
               case 1:
                   ob.createdlist();
                   break;
               case 2:
            	   ob.createdlist();
                   ob.disptb();
                   ob.dispbt();
                   break;
               case 3:
            	   do
                   {
                       srt_menu();
                       ch2=scn.nextInt();
                       if((ch2<1)||(ch2>3))
                       {
                           System.out.println("\n Invalid position ... try again");
                           continue;
                       }
                       else
                           break;
                   }while(true);
                   switch(ch2)
                   {
                       case 1:
                    	   ob.createdlist();
                    	   ob.sortasc();
                           ob.disptb();
                        //   ob.dispbt();
                          
                           break;
                       case 2:
                    	   ob.createdlist();
                    	   ob.sortdesc();
                           ob.disptb();
                          // ob.dispbt();
                           
                           break;
                   }
                   break;

               case 4:
            	   ob.createdlist();
            	   ob.searchelement();
                   ob.disptb();
                   //ob.dispbt();
                   
                   break;
           }
       }while(ch1<5);
    }
}