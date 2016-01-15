public class BST<E extends Comparable<E>>
{
	private BinaryTree<E> root;
	
	public BST(E value)
	{
		root = new BinaryTree<E>(value);
	}
	
	public boolean add(E item)
	{
	//if you hit the thing thats in that you return false and otherwise it returns true
		return add(item, root);
	}
	
	public boolean add(E item, BinaryTree<E> r)
	{
		if (item.compareTo(r.value()) == 0)
		{
			return false;	
		}
		else if (item.compareTo(r.value()) < 0)
		{
			if (r.left() == null)
			{
				r.setLeft(new BinaryTree<E> (item));
				return true;
			}
			add(item, r.left());
		}
		else if (item.compareTo(r.value()) > 0)
		{
			if (r.right() == null)
			{
				r.setRight(new BinaryTree<E> (item));
				return true;
			}
			add(item, r.right());
		}
		return true;
	}
	
	public BinaryTree<E> find(E item)
	{
		return findHelper(item, root);
	}
	
	public BinaryTree<E> findHelper(E item, BinaryTree<E> r)
	{
		if (item.compareTo(r.value()) == 0)
		{
			return r;	
		}
		else if (item.compareTo(r.value()) < 0)
		{
			return findHelper(item, r.left());
		}
		else if (item.compareTo(r.value()) > 0)
		{
			return findHelper(item, r.right());
		}
		return null;
	}
	
	public String toString()
	{
		String output = "";
		for(E i: root)
		{
			output += i;
		}
		return output;
		//return root.toString();
	}
	
	//public boolean remove(E e)
	{
	
	}
	
	public static void main(String [] args)
	{
		BST<Integer> x = new BST<Integer>(5);
		x.add(3);
		x.add(7);
		x.add(9);
		x.add(2);
		x.add(6);
		x.add(5);
		System.out.println(x);
		System.out.println(x.find(6));
	}
	
}
