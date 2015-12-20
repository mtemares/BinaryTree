import java.util.Iterator;
import java.lang.Iterable;
public class BinaryTreePostOrderIterator<E> implements Iterator<E>
{
	
	private Queue<E> traversal;
	
	/*
	Iterator constructor for tree
	@param tree Tree to iterate
	*/
	public BinaryTreePostOrderIterator(BinaryTree<E> tree)
	{
		traversal = new LinkedList<E>();
		helper(tree);
	} 
	
	/*
	Helper method - traverses tree and puts it into Queue in correct order
	@param tree Tree to be traversed through
	@return void
	*/
	public void helper(BinaryTree<E> tree)
	{
		if (tree.isLeaf())
		{
			traversal.offer(tree.value());
		}
		else if (tree.left() == null)
		{
			helper(tree.right());
			traversal.offer(tree.value());
		}
		else if (tree.right() == null)
		{
			helper(tree.left());
			traversal.offer(tree.value());
		}
		else
		{
			helper(tree.left());
			helper(tree.right());
			traversal.offer(tree.value());
		}
	}
	
	/*
	Has next?
	@return boolean Has next?
	*/
	public boolean hasNext()
	{	
		return !(traversal.isEmpty());
	}
	
	
	/*
	Next item in binary tree
	@return E next item
	*/
	public E next()
	{
		return traversal.poll();
	}
}
