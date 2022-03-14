package Assignment2;
import java.util.Scanner;
public class Question7 {
	public static BST createTree(BST root,int tinfo)
	{
		Scanner scan = new Scanner(System.in);
		BST node =root;
		if(node==null)
		{
			BST tnode = new BST();
			  
			tnode.setInfo(tinfo);
			tnode.setLeft(null);
			tnode.setRight(null);
			                         
			return tnode;
		}
		else
		{
			
			if(tinfo>node.getInfo())
			{
				node.setRight(createTree(node.getRight(), tinfo));
				
				return node;
			} 
			else
			{
				node.setLeft(createTree(node.getLeft(), tinfo));
				return node;
			}
			
		}
	}
	
	public static void show_inorder(BST root)
    {
        BST node=root;
        if(node==null)
        {
            return;
        }
        else
        {
            show_inorder(node.getLeft());
        	System.out.print(node.getInfo()+" ");
            show_inorder(node.getRight());
        }
    }

    public static void show_preorder(BST root)
    {
        BST node=root;
        if(node==null)
        {
            return;
        }
        else
        {
        	System.out.print(node.getInfo()+" ");
            show_preorder(node.getLeft());
            show_preorder(node.getRight());
        }
    }

    public static void show_postorder(BST root)
    {
        BST node=root;
        if(node==null)
        {
            return;
        }
        else
        {
            show_postorder(node.getLeft());
            show_postorder(node.getRight());
        	System.out.print(node.getInfo()+" ");
        }
    }
    

    public static void menu()
    {
    	System.out.println("1.Create 1st tree");
    	System.out.println("2.Create 2nd tree ");
    	System.out.println("3.Merge tree (2nd tree into 1st tree)");
    	System.out.println("4.Display Bst ");
    }
    
    public static void sub_menu()
    {
    	System.out.println("\t1.Display InOrder");
    	System.out.println("\t2.Display PreOrder");
    	System.out.println("\t3.Display PostOrder");

    }
    
    public static void main(String[] args) {
    	int size=20;
    	int arr[] = new int[size];
        BST root1=null;
        BST root2=null;
        int tinfo;
        int ch;
        int count=0;
        Scanner scan=new Scanner(System.in);
        
        do {
        	menu();
        	ch=scan.nextInt();
        	switch(ch)
             {
        	  	case 1 :
        	  	{
        	  		do
        	  		{
        	  			System.out.println("\n Enter Information : ");
        	            tinfo=scan.nextInt();
        	            root1=createTree(root1,tinfo);

        	            System.out.println("\n Do you want to continue (Y/N) :");
        	            String ch1=scan.next();
        	            if(ch1.toUpperCase().equals("Y"))
        	                continue;
        	            else
        	                break;
        	  		}while(true);
        	  	}break;
        	  	
        	  	case 2 :
        	  	{
        	  		
        	  		do
        	  		{
        	  			
        	  			System.out.println("\n Enter Information : ");
        	            tinfo=scan.nextInt();
        	            arr[count]=tinfo;
        	            count++;
        	            root2=createTree(root2,tinfo);

        	            System.out.println("\n Do you want to continue (Y/N) :");
        	            String ch1=scan.next();
        	            if(ch1.toUpperCase().equals("Y"))
        	            {
        	            	
        	                continue;
        	            }
        	            else
        	                break;
        	  		}while(true);
        	  	}break;
        	  	case 3:
        	  	{
        	  		for (int i=0;i<count;i++)
        	  		{
        	  			root1= createTree(root1,arr[i]);
        	  		}
        	  		System.out.println("TREE 2 is merge in TREE 2 SUCCESFULLY");
        	  	}break;
        		case 4 :
        		{
        			sub_menu();
        			int ch3=scan.nextInt();
        			switch(ch3)
        			{
	        			case 1:
	        			{
	        				System.out.println("Bst in Inorder :");
	        				show_inorder(root1);
	        				System.out.println();
	        				System.out.println();
	        			}break;
	        			case 2:
	        			{
	        				System.out.println("Bst in Preorder :");
	        				show_preorder(root1);
	        				System.out.println();
	        				System.out.println();
	        			}break;
	        			case 3 :
	        			{
	        				System.out.println("Bst in Postorder :");
	        				show_postorder(root1);
	        				System.out.println();
	        				System.out.println();
	        			}break;
        			}
        		}
             }
        
           
        }while(true);
    }
}
