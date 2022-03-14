package Assignment2;
import java.util.Scanner;
public class Question6 {
	public static BST insertNode(BST root,int tinfo)
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
				node.setRight(insertNode(node.getRight(), tinfo));
				
				return node;
			} 
			else
			{
				node.setLeft(insertNode(node.getLeft(), tinfo));
				return node;
			}
			
		}
	}
	
	
	public static BST find_max(BST root)
	{
		BST node=root;
		if(node==null)
		{
			return node;
		}
		else
		{
			if(node.getRight()!=null)
			return find_max(node.getRight());
			else
			return node;	
		}
	}
	
	public static BST find_min(BST root)
	{
		BST node=root;
		if(node==null)
		{
			return node;
		}
		else
		{
			if(node.getLeft()!=null)
			return find_min(node.getLeft());
			else
			return node;	
		}
	}
	
	public static int sum_ele(BST root)
	{
		BST node =root;
		int sum = node.getInfo();
		if(node.getInfo()==0)
		{
			return sum;
		}
		else
		{
			if(node.getRight()!=null  )
			{
			 sum=sum+sum_ele(node.getRight());
			
			}
			if (node.getLeft()!=null)
			{
			sum=sum+sum_ele(node.getLeft());
				
			}
			
			return sum;
			
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
    	System.out.println("1.Insert Ele in Bst");
    	System.out.println("2.Find max ");
    	System.out.println("3.Find min ");
    	System.out.println("4.Sum of all ele ");
    	System.out.println("5.Display Bst");
    }
    
    public static void sub_menu()
    {
    	System.out.println("1.Display InOrder");
    	System.out.println("2.Display PreOrder");
    	System.out.println("3.Display PostOrder");

    }
    
    public static void main(String[] args) {
        BST root=null;
        int tinfo;
        int ch;
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
        	            root=insertNode(root,tinfo);

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
        	  		BST node=find_max(root);
        	  		System.out.println("Max ele : "+node.getInfo());
        	  	}break;
        	  	
        		case 3 :
        	  	{
        	  		BST node=find_min(root);
        	  		System.out.println("Min ele : "+node.getInfo());
        	  	}break;
        	  	
        		case 4 :
        		{
        			System.out.println("Sum of all element in bst :");
        			System.out.println(sum_ele(root));
        		}break;
        		
        		case 5 :
        		{
        			sub_menu();
        			int ch3=scan.nextInt();
        			switch(ch3)
        			{
	        			case 1:
	        			{
	        				System.out.println("Bst in Inorder :");
	        				show_inorder(root);
	        				System.out.println();
	        			}break;
	        			case 2:
	        			{
	        				System.out.println("Bst in Preorder :");
	        				show_preorder(root);
	        				System.out.println();
	        			}break;
	        			case 3 :
	        			{
	        				System.out.println("Bst in Postorder :");
	        				show_postorder(root);
	        				System.out.println();
	        			}break;
        			}
        		}
             }
        
           
        }while(true);
    }
}
