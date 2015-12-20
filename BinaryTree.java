/*
This is a binary tree data structure.
@author Madeline Temares
@version 12/18/15
*/

import java.util.Iterator;
import java.lang.Iterable;

public class BinaryTree<E> implements Iterable<E>
{

	protected E value;
	protected BinaryTree<E> left;
	protected BinaryTree<E> right;
	
	/*
	Constructor that takes in value and left and right binary trees.
	@param v Value of the binary tree.
	@param l Left binary tree
	@param r Right binary tree
	*/
	
	public BinaryTree(E v, BinaryTree<E> l, BinaryTree<E> r)
	{
		value = v;
		left = l;
		right = r;
	}
	
	
	/*
	Constructor that takes in value.
	@param v Value of the binary tree.
	*/
	public BinaryTree(E v)
	{
		value = v;
		left = null; //sets left and right to null
		right = null;
	}
	
	/*
	Default constructor.
	*/
	public BinaryTree()
	{
		value = null; //sets value, left, and right to null
		left = null;
		right = null;
	}
	
	
	/*
	Accessor to left
	@return BinaryTree<E> Left binary tree
	*/
	public BinaryTree<E> left()
	{
		return left;
	}
	
	/*
	Accessor to right
	@return BinaryTree<E> Right binary tree
	*/
	public BinaryTree<E> right()
	{
		return right;
	}
	
	/*
	Accessor to value
	@return E value
	*/
	public E value()
	{
		return value;
	}
	
	/*
	Modifier for left
	@param node Tree to be set to left
	@return void
	*/
	public void setLeft(BinaryTree<E> node)
	{
		left = node;
	}
	
	/*
	Modifier for right
	@param node Tree to be set to right
	@return void
	*/
	public void setRight(BinaryTree<E> node)
	{
		right = node;
	}
	
	/*
	Modifier for value
	@param val Value to be set
	@return void
	*/
	public void setValue(E val)
	{
		value = val;
	}
	
	/*
	Checks whether or not the tree is a leaf - meaning that there are no branches from that tree
	@return boolean Whether or not the tree is a leaf
	*/
	public boolean isLeaf()
	{
		if (left == null && right == null)
		{
			return true;
		}
		return false;
	}
	
	/*
	Size of tree
	@return int Size of tree
	*/
	public int size()
	{
		if (isLeaf())
		{
			return 1;
		}
		if (left == null)
		{
			return 0;
		}
		else if (right == null)
		{
			return 0;
		}
		return (1 + left.size() + right.size()); //recursive
		
	}
	
	/*
	Height of tree
	@return int Height of tree
	*/
	public int height()
	{
		if (isLeaf())
		{
			return 0;
		}
		if (left == null)
		{
			return 1 + right.height();
		}
		if (right == null)
		{
			return 1 + left.height();
		}	
		else
		{
			return 1 + Math.max(left.height(), right.height()); //recursive
		}
	}
	
	/*
	Whether or not tree is full - true if adding a node to tree would increase its height
	@return boolean Whether or not tree is full
	*/
	public boolean isFull()
	{
		if (isLeaf())
		{
			return true;
		}
		if (left == null || right == null)
		{
			return false;
		}
		return left.isFull() && right.isFull() && right.height() == left.height(); //recursive
		
	}
	
	/*
	Whether or not tree is balanced - return true if the difference of heights of 
	subtrees at every node is no greater than 1
	@return boolean Whether or not tree is balanced
	*/
	
	public boolean isBalanced()
	{
		if (isLeaf())
		{
			return true;
		}
		else if (left == null && right.isLeaf())	
		{
			return true;
		}
		else if (right == null && left.isLeaf())
		{
			return true;
		}
		else if (left == null && !(right.isLeaf()))	
		{
			return false;
		}
		else if (right == null && !(left.isLeaf()))
		{
			return false;
		}
		else if (left.height() == right.height())
		{
			return left.isBalanced() && right.isBalanced();
		}
		else if (left.height() == (right.height() + 1))
		{
			return left.isBalanced() && right.isBalanced();
		}
		else if ((left.height() + 1) == right.height())
		{
			return left.isBalanced() && right.isBalanced(); //recursive
		}
		return false;
	}
	
	/*
	Whether or not tree is complete - return true if tree has minimal height and any 
	holes in the tree appear in the last level to the right
	@return boolean Whether or not tree is complete
	*/
	public boolean isComplete()
	{
		if (isLeaf()) 
		{
			return true;
		}
		if (left == null)
		{
			return false;
		}
		if (right == null)
		{
			return left.isLeaf();
		}
		if (left.height() == (right.height() + 1))
		{
			if (left.isComplete() && right.isFull())
			{
				return true;
			}
		}
		if (left.height() == right.height())
		{
			if (left.isFull() && right.isComplete()) //recursive
			{
				return true;
			}
		}
		return false;
	}
	
	/*
	ToString method - uses commas and parentheses to depict tree and levels
	@return String String representation of binary tree
	*/
	public String toString()
	{
		String output = "";
		output += value;
		if (isLeaf())
		{
			//output += ",";
		}
		else if (left == null)
		{
			output += "," + right.toString() + ")";	
		}
		else if (right == null)
		{
			output += "(" + left.toString() + ")";
		}
		else
		{
			output += "(" + left.toString() + "," + right.toString() + ")"; //recursive
		}
		return output;
	}
	
	/*
	Preorder Iterator
	@return Iterator<E>
	*/
	public Iterator<E> preorderIterator()
	{
		return new BinaryTreePreOrderIterator(this);
	}
	
	/*
	Inorder Iterator
	@return Iterator<E>
	*/
	public Iterator<E> inorderIterator()
	{
		return new BinaryTreeInOrderIterator(this);
	}
	
	/*
	Postorder Iterator
	@return Iterator<E>
	*/
	public Iterator<E> postorderIterator()
	{
		return new BinaryTreePostOrderIterator(this);
	}
	
	/*
	Iterator
	@return Iterator<E>
	*/
	public Iterator<E> iterator()
	{
		return inorderIterator();
	}
}
