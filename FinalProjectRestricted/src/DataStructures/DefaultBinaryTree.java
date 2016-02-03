package DataStructures;
public class DefaultBinaryTree<T> implements BinaryTree<T>
{
	private DefaultBinaryTreeNode<T> root;
	
	private static DefaultBinaryTree<String> tree;
	private LinkedList<T> random= new LinkedList<T>();
	private LinkedList<T> list= new LinkedList<T>();
	
	/** nothing to write in the constructor**/
	public DefaultBinaryTree () //constructor
	{
		
	}
	/** getter for the root, returns the root**/
	public BinaryTreeNode<T> getRoot() 
	{
		return root;
	}
	
	/** set the root of the tree**/
	public void setRoot (BinaryTreeNode<T> root) 
	{
		this.root=(DefaultBinaryTreeNode<T>)root;
	}
	
	
	/** checks to see if the tree is empty by checking the root**/
	public boolean isEmpty() 
	{
		if(root==null)
		{
			return true;
		}
		return false;
	}
	
	/**left, node, right kicks off inorderTraversal and returns a linkedlist**/
	public LinkedList<T> inorderTraversal() 
	{
		LinkedList<T> myList= new LinkedList<T>();
		
		inorderTraversal(getRoot(),myList);
		return myList;
		
	}
	
	 /** this should be find**/
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal)
	{
		//left 
		//node
		//right
		if(node!=null)
		{
			
			if(node.getLeftChild()!=null) //traverse the left first
			{
				
			
				inorderTraversal(node.getLeftChild(),traversal);
			}
			
			
			traversal.insertLast(node.getData()); //should be node not root
			
			
			if(node.getRightChild()!=null)
			{
				
				
				inorderTraversal(node.getRightChild(),traversal);
			}
		}
	}
	
	/**node, left, right kicks off preorderTraversal and returns a linked list**/
	public LinkedList<T> preorderTraversal() 
	{
		
		if(getRoot()!=null) //when the root is not null
		{
			
			preorderTraversal(getRoot(),list);
		}
		return list;
	}
	
	 /** traverse the tree pre order traversal, root left right**/
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal)
	{
		if(node!=null)
		{
			traversal.insertLast(node.getData()); //we insert the root no matter what
			
			if(node.getLeftChild()!=null) //process the left subtree
			{
				preorderTraversal(node.getLeftChild(),traversal);
			}
			
			if(node.getRightChild()!=null) //process the right subtree
			{
				preorderTraversal(node.getRightChild(),traversal);
			}
		}
	}
		
		
	
	
	/** a method to kick off the post order traversal, returns a linked list**/
	public LinkedList<T> postorderTraversal() 
	{
		LinkedList<T> temp= new LinkedList<T>();
		postorderTraversal(getRoot(),temp );
		return temp;
		
	}
	
	/** traverses the binary tree left, right,root**/
	private void postorderTraversal(BinaryTreeNode<T>node, LinkedList<T> traversal) 
	{
		//left
		//right
		//root
		if(node!=null)
		{
			if(node.getLeftChild()!=null) //process left subtree
			{
				postorderTraversal(node.getLeftChild(),traversal); //traverse the left subtree
				
			}
			
			if(node.getRightChild()!=null) //process right subtree
			{
				
				postorderTraversal(node.getRightChild(),traversal);
			}
			
			traversal.insertLast(node.getData()); //process the root
		}
	}
	
	/** calls the inorderTraversal and returns a string**/
	public String inorderString() 
	{
		LinkedList<T> temp= new LinkedList<T>();
		temp=inorderTraversal();
		return inorderTraversal().toString();
		
	}
	
	/** calls method preorderTraversal and returns a string**/
	public String preorderString() 
	{
		LinkedList<T> temp= new LinkedList<T>();
		temp=preorderTraversal();
		
		return temp.toString();
	}
	
	/**calls method postorderTraversal and returns a string**/
	public String postorderString() 
	{
		LinkedList<T> temp= new LinkedList<T>();
		temp=postorderTraversal();
		return temp.toString();
	}
	

	
}
