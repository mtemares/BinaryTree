public class BinaryTreeRunner<E>
{
	
	public static void main(String[] args)
	{
		BinaryTree<Integer> a = new BinaryTree<Integer>(0);
		BinaryTree<Integer> b = new BinaryTree<Integer>(1);
		BinaryTree<Integer> c = new BinaryTree<Integer>(2);
		BinaryTree<Integer> d = new BinaryTree<Integer>(3);
		BinaryTree<Integer> e = new BinaryTree<Integer>(4);
		BinaryTree<Integer> f = new BinaryTree<Integer>(5);
		BinaryTree<Integer> g = new BinaryTree<Integer>(6);
		BinaryTree<Integer> h = new BinaryTree<Integer>(7);
		BinaryTree<Integer> i = new BinaryTree<Integer>(8);
		
		a.setLeft(b);
		a.setRight(c);
		
		b.setLeft(d);
		b.setRight(e);
		
		c.setLeft(f);
		c.setRight(g);
		
		//d.setLeft(h);
		//h.setLeft(i);
		
		System.out.println(a.isFull());
		System.out.println(a.size());
		
		System.out.println(a.isBalanced());
		
		System.out.println(a.isComplete());
		
		System.out.println(a);
		
		for (int x: a)
		{
			System.out.println(x);
		}
	}
}
