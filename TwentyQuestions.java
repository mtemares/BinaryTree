import java.util.Scanner;
public class TwentyQuestions
{
	private BinaryTree<String> tree;
	
	public TwentyQuestions()
	{
		tree = new BinaryTree<String>("apple");
		gameCycle(tree);	
	}
	
	public void gameCycle(BinaryTree<String> b)
	{
		Scanner scanner = new Scanner(System.in);
		if (b.isLeaf())
		{
			System.out.println("Is it a " + b.value());
			if (respond (scanner))
			{
				System.out.println("I win! Lets play again");
				gameCycle(tree);
			}
			else 
			{
				String object = "";
				String question = "";
				System.out.println("Please enter your object");
				object = scanner.nextLine();
				System.out.println("Please enter a question about that object");
				question = scanner.nextLine();
				BinaryTree<String> oldTree = new BinaryTree<String>(b.value());
				b = new BinaryTree<String>(question, oldTree, new BinaryTree<String>(object));
				System.out.println("Lets play again");
				gameCycle(b); //
			}
		}
		else
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
