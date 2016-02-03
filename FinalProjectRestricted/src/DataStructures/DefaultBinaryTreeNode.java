package DataStructures;
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T>
{
	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right; //has instance fields left and right if type binary tree node to refer to left and right children
	
	/** the constructor for binary tree node**/
	public DefaultBinaryTreeNode() //the constructor
	{
		

		
	}

	/** get the data for the node**/
	public T getData()
	{
		return data;
	}
	
	/** set the data for the node**/
	public void setData(T info)
	{
		data=info;
	}
	
	/** get the left child**/
	public BinaryTreeNode<T> getLeftChild() 
	{
		return left;
	}
	
	/** get the right child**/
	public BinaryTreeNode<T> getRightChild()  
	{
		return right;
	}
	
	/** set the left child**/
	public void setLeftChild( BinaryTreeNode<T> left )
	{
		this.left=left;
	}
	
	/** set the right child**/
	public void setRightChild(BinaryTreeNode<T> right)
	{
		this.right=right;
	}
	
	/** to see if a node is a leaf, returns true if it is a leaf and returns false otherwise**/
	public boolean isLeaf()
	{
		if( this.left==null && this.right==null)
		{
			return true;
		}
		return false;
	}
}
