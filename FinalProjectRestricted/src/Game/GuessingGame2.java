package Game;
import Reader .*;
import DataStructures .*;
import DataStructures.BinaryTreeNode;
import DataStructures.DefaultBinaryTreeNode;

import javax.swing .*;

import java.awt .*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GuessingGame2 implements ActionListener
{
	private static int FRAMELENGTH=1000; //static variables that determine how big the binary tree is
	private static int FRAMEWIDTH=800;
	CommutativeExpressionReader reader= new CommutativeExpressionReader();
	BinaryTree exprTree = CommutativeExpressionReader.readCommutativeExpr( "BinaryTree2.xml"); //gives us a binary tree
	BinaryTreeNode root=exprTree.getRoot(); //get the root of the binary tree
	
	DefaultBinaryTreeNode<String> cursor=(DefaultBinaryTreeNode<String>)root; //set the cursor which is a node to the root of the tree
	JLabel question;
	JLabel answer;
	String newString="";
	JPanel lastPanel;
	JFrame frame;
	JPanel prompt;
	JOptionPane pane= new JOptionPane();
	JButton enter;
	String oldString="";
	String s="";
	
	
	public void initGUI()
	{
		frame= new JFrame("Guessing Game"); //create a frame and call it "Guessing Game"
		frame.setSize(FRAMELENGTH,FRAMEWIDTH); //set it to the width and height
		
		
		frame.setLayout(new GridLayout(5,1)); //set the layout to a gridLayout
		
		question= new JLabel(); //create a JLabel to hold the questions
		question.setText(root.getData().toString()); //set the text of JLabel question to the data of the root
		frame.add(question); // this JLabel to the frame
		
		answer= new JLabel(); //create a new JLabel to hold the answers
		answer.setText(getLeaves(root)); //get the leaves of the tree starting at the root node
		frame.add(answer); //add the answer JPanel to the frame
		
		JButton yesButton= new JButton("Yes"); //create a JButton and set the text of the button to yes
		yesButton.addActionListener(this); //add the actionListener
		JButton noButton= new JButton("No"); //create a JButton and set the text of the button to no
		noButton.addActionListener(this); //add the actionListener
		JButton yes= new JButton("Yes, it is"); //create a JButton and set the text of the button to "Yes it is "
		yes.addActionListener(this); //add the actionListener
		JButton no= new JButton("No, it isn't");
		no.addActionListener(this);
		JPanel buttonPanel= new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2)); //create a new JPanel to add the two buttons and set it to be a 1*2 grid layout
		buttonPanel.add(yesButton); //add the yesButton and noButton
		buttonPanel.add(noButton);
		
		lastPanel=new JPanel(); //make a JPanel
		lastPanel.setLayout(new BorderLayout()); //set the lastPanel to a borderLayout
		JLabel answerCorrect= new JLabel("Is my answer correct"); //set the text of the label to 
		JPanel yesNoPanel= new JPanel(); //create a new JPanel to hold the two buttons
		yesNoPanel.setLayout(new GridLayout(1,2)); //set the panel to a gridLayout
		yesNoPanel.add(yes); //add yes button
		yesNoPanel.add(no);//add no button
		lastPanel.add(answerCorrect, BorderLayout.CENTER); //add the answerCorrect label to the lastPanel
		lastPanel.add(yesNoPanel,BorderLayout.SOUTH); //add the yesNoPanel to the south of the lastPanel
		
		
		int dialogButton = JOptionPane.YES_NO_OPTION;
		makeAnimal();
		frame.add(buttonPanel);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set it to EXIT_ON_CLOSEE
		frame.setVisible(true); //set visibilty to true
	}
	
	/** This is the actionPerformed method that takes in parameter ActionEvent e and gets info about which**/
	/** button was pressed and does the corresponding action based on whatbutton is pressed**/
	public void makeAnimal()
	{
		JFrame myFrame= new JFrame();
		JTextField newAnimal= new JTextField();
		JTextField newQuestion= new JTextField();
		JTextField newAnswer= new JTextField();
		
	}
	/** we get information about which button has been pressed and do certain things based on which button has been clicked**/
	public void actionPerformed(ActionEvent e) 
	{
		String buttonPressed=e.getActionCommand(); //get info about which button was pressed
		
		
		if(buttonPressed.equals("Yes")) //if the user pressed the yes button
		{
			//do something
			if(cursor.getLeftChild()!=null) //when the left child is not null
			{
			
				cursor=(DefaultBinaryTreeNode<String>)cursor.getLeftChild(); //move the cursor node onto it's left child
			}
			if(!cursor.isLeaf()) //if it is not a leaf, it must be a question
			{
				question.setText(cursor.getData().toString()); //get the question at the cursor and set it to the question panel
				
				s=""; //initialize our string s
				
				answer.setText(getLeaves(cursor)); //call getLeaves on cursor to get all leaves starting at cursor and set the answer panel
				
				
			}
			else //when it is a leaf
			{
				answer.setText(cursor.getData().toString()); 
				lastPanel.setVisible(true);
				frame.add(lastPanel);
			}
		}
		else if(buttonPressed.equals("No"))
		{
			if(cursor.getRightChild()!=null)
			{
			
				cursor=(DefaultBinaryTreeNode<String>)cursor.getRightChild();
			}
			if(!cursor.isLeaf())
			{
				question.setText(cursor.getData().toString());
				s="";
				answer.setText(getLeaves(cursor));
				
			}
			else //when it is a leaf
			{
				answer.setText(cursor.getData().toString());
				lastPanel.setVisible(true);
				frame.add(lastPanel);
				
				
				
				
			}
		}
		else if(buttonPressed.equals("Yes, it is")) //when the user pressed Yes it is button, have the pane pop up to tell them that the 
			//computer has won
		{
			/**pane.showMessageDialog(null,
			"Yay! I win!", "choose one", JOptionPane.YES_OPTION);**/
			pane.showMessageDialog(null,"Yay! I win!");
			refreshGame();
		}
		
	
		else if(buttonPressed.equals("No, it isn't")) //when the answer is incorrect
		{
			
			pane.showMessageDialog(null,"That's too bad! Maybe you should try the unrestricted version!");
			refreshGame();
		}
		
		
		
			
			
	}
	/** this method refreshes the game, by resetting the cursor, s, answer panel and question panel**/
	/** it also sets the visibility of prompt to false**/
	public void refreshGame()
	{
		cursor=(DefaultBinaryTreeNode<String>)root;
		s=""; //reset the string to an empty string
		answer.setText(getLeaves(root)); //set the answer text
		
		question.setText(cursor.getData());
		lastPanel.setVisible(false);
	}
	
	/** takes in a parameter of type BinaryTreeNode and gets all the leaves starting from the parameter node taken in**/
	/**uses in order traversal**/
	public String getLeaves(BinaryTreeNode node)
	{
		
		if(node.getLeftChild()!=null) //traverse the left first
		{
			
			getLeaves(node.getLeftChild());
		}
		
		
		if(node.isLeaf() ) //when it is a leaf
		{
			s+=node.getData()+" "+"\n"; //should be node not root
		}
		if(node.getRightChild()!=null)
		{
			
			
			getLeaves(node.getRightChild());
		}
		
		return s;
	}

	public static void main(String[] args)
	{
		GuessingGame2 game= new GuessingGame2(); //instantiate the game
		game.initGUI(); //call initGUI to set up the GUI
	}
	
	

}
