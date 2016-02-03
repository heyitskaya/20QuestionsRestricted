package DataStructures;
import java.util.HashSet;
import java.util .*;


public class LinkedList<T>
{
	private LinkedListNode<T> head; //head node
	/** the constructor**/
	public LinkedList() 
	{
		head=null; //initialize the head to null
		 
	}
	
	/** get the data of the head of this list**/
	public T getFirst() 
	{
		if(head!=null) //if the head is not null
		{
			return head.getData(); //return the data stored in head
		}
		else
		{
			
			return null; //else return null because our head is null
		}
	}

	/** get head node of the list**/
	public LinkedListNode<T> getFirstNode() 
	{
		if(head!=null)
		{
			return head;
		}
		else
		{
			
			return null;
		}
		
	}
	/**get the data stored in the tail node of the list**/
	public T getLast() 
	{
		LinkedListNode<T> cursor= new LinkedListNode<T>();
		cursor=head; //have cursor start traversing from head
		if(head==null) //if the list is empty
		{
			return null;
		}
		while(cursor.getNext()!=null)
		{
			cursor=cursor.getNext(); //keep on moving down the list
		}
		//when the next one is null that means we've reached the end of our list
		return cursor.getData();
	}
	
	/** get the tail node of the list**/
	public LinkedListNode<T> getLastNode() 
	{
		LinkedListNode<T> cursor= new LinkedListNode<T>();
		cursor=head; //have cursor start traversing from head
		if(head==null)
		{
			return null;
		}
		while(cursor.getNext()!=null)
		{
			cursor=cursor.getNext(); //keep on moving down the list
		}
		//when the next one is null that means we've reached the end of our list
		return cursor;
		
	}
	
	/**insert a new node with data at the head**/
	public void insertFirst(T data) 
	{
		LinkedListNode<T> newNode= new LinkedListNode<T>();
		newNode.setData(data); //make a new node and set the data
		newNode.setNext(head); //have newNode point to the next node head points to 
		head=newNode;
		
	}
	
	/** make a node with the data and add this node after the currentNode**/
	public void insertAfter(LinkedListNode<T> currentNode, T data) 
	{
		LinkedListNode<T> newNode= new LinkedListNode<T>(); //make a new node with the data
		newNode.setData(data);
		LinkedListNode<T> cursor= new LinkedListNode<T>(); //have a cursor node
		cursor=head; //initialize it to the head
		LinkedListNode<T> temp= new LinkedListNode<T>();
		while( cursor!=null) //when we haven't found the node and can still traverse
			// linked list
		{
			
			if(cursor.equals(currentNode)) //when we have found the node we are looking for
			{
				temp=cursor.getNext(); //get the node after cursor node
				cursor.setNext(newNode); //have cursor point to currentNode
				newNode.setNext(temp); //then have currentNode point to temp
			}
			cursor=cursor.getNext(); //move the cursor down the list
		}
		
	}
	
	/** insert a new node with data at the tail of this list**/
	public void insertLast(T data) 
	{
		LinkedListNode<T> cursor= new LinkedListNode<T>(); //have a cursor node
		cursor=head; //initialize it to the head
		LinkedListNode<T> node= new LinkedListNode<T>();
		if(head==null) //if the list is empty
		{
			insertFirst(data);
		}
		else
		{
			while(cursor.getNext()!=null)
			{
				cursor=cursor.getNext(); 
			}
		//once we have gotten out of the while loop cursor references the last node
			insertAfter(cursor,data);
		}
		
		
	}
	
	/** remove the first node**/
	public void deleteFirst() 
	{
		if(head==null)
		{
			System.out.println("null");
		}
		
		head=head.getNext(); //have head equal to the one after it
		
	}
	
	/**remove the last node**/
	public void deleteLast() 
	{
		LinkedListNode<T> cursor= new LinkedListNode<T>(); //have a cursor node
		cursor=head; //initialize it to the head
		while(cursor.getNext().getNext()!=null) 
		{
			cursor=cursor.getNext();
			
		}
		//when you break out of the while loop you are at the second node to last
		cursor.setNext(null); 
	}
	
	/** remove node following currentNode if no node exists do nothing**/
	public void deleteNext(LinkedListNode<T> currentNode) 
	{
		LinkedListNode<T> cursor= new LinkedListNode<T>();
		cursor=head;
		LinkedListNode<T> temp= new LinkedListNode<T>();
		temp=cursor; //we have found 
		
		while(cursor.getNext()!=null)
		{
			cursor=cursor.getNext();
			if(cursor.equals(currentNode))
			{
				temp=cursor;
			}
			if(cursor.getNext()==null)
			{
				//do nothing
			}
			
		}
		temp.setNext(temp.getNext().getNext());
		
	}
	

	 /** return number of nodes in this list**/
	public int size()
	{
		if(head.equals(null)) //this is when the list has no nodes
		{
			return 0;
		}
		int count=1; //when at least the head is not null, we have at least one node so initialize count to 1

		LinkedListNode<T> cursor= new LinkedListNode<T>(); //have a cursor node
		cursor=head; //initialize it to the head
		while(cursor.getNext()!=null) //when the next one is not null
		{
			cursor=cursor.getNext(); //move it down the list
			count++; //increase our count
		}
		return count; //when we break out of the while loop we have traversed the entire linked list
		//and return count
		
	}
	/**Gives a string representation of this linkedlist**/
	public String toString()
	{
		
		String line=""; //have and empty string
		LinkedListNode<T> cursor= head; //have a cursor node
		
		while(cursor!=null) //when the cursor is not null
		{
			line+= cursor.getData() + "->"; //add the data of the currentNode to the string
			
			
			cursor=cursor.getNext(); //move it to the next node in the list
			
		}
		
		System.out.println(line); 
		return line; //return this string
		
		
	}

	/**checks to see of the list is empty, returns true if it is**/
	public boolean isEmpty() 
	{
		if(head==null) //if the head is null, it means that the head is empty
		{
			
			return true; //therefore return true
		}
		
		return false; //else the list is not empty, and we return false
		
	}
/**	public LinkedList<T> deleteDuplicates(LinkedList<T> list)
	{
		LinkedListNode<T> n=list.getFirstNode();
		HashSet<Integer> set= new HashSet<Integer>();
		LinkedListNode<T> previous= n; //have another cursor
		//start traversing the list
		n=n.getNext();
		set.add((Integer)previous.getData());
		set.add((Integer)n.getData());
		
		while(n.getNext()!=null)
		{
			
			if(set.contains(n.getData()))
			{
				System.out.println(previous.getData());
				
				previous.setNext(n.getNext());//delete the node
				
			}
			else
			{
				set.add((Integer)n.getData()); //add it to the set
				set.add((Integer)previous.getData());
			}
			previous=previous.getNext();
			n=n.getNext();
			
		}
		return list;
		
	}**/
	public LinkedList<T> deleteDups(LinkedList<T> list) /** look at this again**/
	{
		
		HashSet<Integer> set= new HashSet<Integer>();
		LinkedListNode previous=null;
		LinkedListNode<T> n= list.getFirstNode();
		while(n!=null)
		{
			if(set.contains(n.getData()))
			{
				previous.setNext(n.getNext());
			}
			else
			{
				set.add((Integer)n.getData());
				//previous=n;
			}
			previous=n;
			n=n.next;
			
		}
		return list;
	}
	public boolean findCorruption(LinkedList<T> list)
	{
		LinkedListNode<T> turtle=list.getFirstNode();
		LinkedListNode<T> rabbit= list.getFirstNode();
		return true;
		
	}
	public LinkedListNode<T> getMid(LinkedListNode<T> start, LinkedListNode<T> end)
	{
		LinkedListNode<T> cursor1= start;
		LinkedListNode<T> cursor2=start; //this cursor will move 2 for every one cursor 1 moves
		while(cursor2!=end)
		{
			cursor1=cursor1.getNext();
			cursor2=cursor2.getNext().getNext();
			
			System.out.println("Cursor 2 is "+cursor2.getData().toString());
		}
		return cursor1;
	}
	public List<Integer> countSmaller(int[] nums) 
    {
        ArrayList<Integer> list= new ArrayList<Integer>();
        int cursor1=0;
        int cursor2=0;
        int length= nums.length; //get the length of the array
        System.out.println("The length is "+length);
        for(int k=0;k<length;k++)
        {
        	//System.out.println(k);
        	int numOccurences=0; 
            cursor1=nums[k];
            if(k+1>=length)
            {
            	list.add(k,0);
            }
            else
            {
            	cursor2=nums[k+1]; //cursor 2 always starts at one ahead of cursor 1
            	System.out.println("Cursor1 is "+cursor1);
            	System.out.println("Cursor2 is"+cursor2);
            }
            for(int i=k+1;i<length;i++)
            {
            	
            	
                if(cursor1>cursor2)
                {
                	
                    numOccurences++;
                    System.out.println("Numoccurences is "+numOccurences);
                }
                
            }
            list.add(k,numOccurences);
            
        }
        return list;
    }
	
	public static void main(String[] args)
	{
		int[] intArray= new int[]{5,2,6,1};
		
		LinkedList<Integer> list= new LinkedList<Integer>();
		list.insertLast(1);
		//list.insertLast(1);
		
		list.insertLast(2);
		//list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		list.insertLast(5);
		
		//list.insertLast(3);
		//list.insertLast(3);
		//list.insertLast(1);
		//list.deleteDuplicates(list);
		//list.toString();
		System.out.println("Before "+list);
		System.out.println("The new list looks like "+list.deleteDups(list));
		//list.getFirstNode().setNext(list.getFirstNode().getNext().getNext());
		System.out.println("The middle element is "+list.getMid(list.getFirstNode(),list.getLastNode()).toString());
		System.out.println("The string is "+list.countSmaller(intArray).toString());
		
	}
	
	
		
		

	
}
