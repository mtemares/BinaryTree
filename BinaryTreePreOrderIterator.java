import java.util.Iterator;
import java.lang.Iterable;
public class BinaryTreePreOrderIterator<E> implements Iterator<E>
{
	
	private Queue<E> traversal;
	
	/*
	Iterator constructor for tree
	@param tree Tree to iterate
	*/
	public BinaryTreePreOrderIterator(BinaryTree<E> tree)
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
			traversal.offer(tree.value());
			helper(tree.right());
		}
		else if (tree.right() == null)
		{
			traversal.offer(tree.value());
			helper(tree.left());
		}
		else
		{
			traversal.offer(tree.value());
			helper(tree.left());
			helper(tree.right());
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
