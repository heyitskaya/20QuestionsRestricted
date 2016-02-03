package DataStructures;
public class LinkedListNode<T> //the node class
{
	private T data;
	public LinkedListNode<T> next; //is this of type t
	
	public LinkedListNode() //nothing to implement
	{
		
	}
	public void setData(T data) //set the data of the node
	{
		this.data=data;
	}
	public T getData() //get the data of the node
	{
		return data;
	}
	public void setNext(LinkedListNode<T> node)  //set the next node of the current node
	{
		next=node;
		
	}
	public LinkedListNode<T> getNext() //get the next node
	{
		return next;
	}
	public String toString() //return a string representation of the node
	{
		return data.toString();
		
	}
	

}
