import java.util.Scanner;
public class TwentyQuestions
{
	private BinaryTree<String> tree;
	/*
	Constructor - makes a new tree with the first object
	*/
	public TwentyQuestions()
	{
		tree = new BinaryTree<String>("apple");
		gameCycle(tree);	
	}
	
	
	/*
	GameCycle is recursive and runs the game 
	@param BinaryTree<String> b BinaryTree of type String that is read and played with
	@return void
	*/
	public void gameCycle(BinaryTree<String> b)
	{
		Scanner scanner = new Scanner(System.in);
		if (b.isLeaf()) //if its a leaf it checks if that is the object
		{
			System.out.println("Is it a " + b.value());
			if (respond (scanner)) //if you say yes then the game won
			{
				System.out.println("I win! Lets play again");
				gameCycle(tree);
			}
			else //if you say no then you have to enter your object and ask a new question about it
			{
				String object = "";
				String question = "";
				System.out.println("Please enter your object");
				object = scanner.nextLine();
				System.out.println("Please enter a question about that object");
				question = scanner.nextLine();
				BinaryTree<String> oldTree = new BinaryTree<String>(b.value());
				b = new BinaryTree<String>(question, oldTree, new BinaryTree<String>(object)); //set tree with new object and question
				System.out.println("Lets play again");
				gameCycle(b); //
			}
		}
		else //if its not a node it goes down the tree according to your responses
		{
			System.out.println(b.value());
			if (respond (scanner))
			{
				gameCycle(b.right());
			}
			else 
			{
				gameCycle(b.left());
			}
		}	
	}
	
	/*
	Sees if you say yes or no 
	@param Scanner k what you type
	@return boolean whether you said yes or no
	*/
	public static boolean respond(Scanner k)
	{
		String input = k.nextLine();
		if (input.equals("Yes"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main (String [] args)
	{
		TwentyQuestions x = new TwentyQuestions();
	}
	
	//make a txt 
	//hard code a first question
	//add to text file
	//store at end of each
	//read at beginning of file
}
