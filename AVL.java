import java.io.PrintStream;


public class AVL {
	
	/**
	 * Searches the AVLTree for the key value 'key'
	 * If not found, it prints "Not found"
	 * The search recursively searches the 'left' child of the Node if the 'key' is less than the 'key' of the current Node
	 * It searches recursively the 'right' child of the Node if the 'key' is greater than the 'key' of current Node
	 * @param key
	 * @param n
	 * @return
	 */
	public Node search(int key, Node n)
	{
		if (n==null)												//Not found
			{
			System.out.println("Node not found");			
			return null;
			}
		
		else if (key<n.getKey())									//Key is less, so check left child
				return search(key,n.getLeft()); 
		
		else if (key>n.getKey())									//Key is greater, so check right child
				return search(key,n.getRight());	
			
		return n;													//returns value of thr node
	}
	
	
	
	/**
	 * Returns height of the Node
	 * If the node is invalid then returns -1 
	 * @param n
	 * @return
	 */
	public static int calch(Node n)
	{
		if (n==null)												//Invalid node
			return -1;												//Return -1
		else return n.getHeight();									//Calls getHeight to find height of node
	}
	
	
	
	/**
	 * Simple Right rotate function (Case 1).
	 * It updates 'height' of all the nodes affected
	 * @param x
	 * @return
	 */
	public static Node singleRRotate(Node x)
	{
		Node y;
		y=x.getLeft();																
		x.setLeft(y.getRight());													
		y.setRight(x);
		int temp1=Math.max(calch(x.getLeft()),calch(x.getRight()));					//Height calculations
		x.setHeight(1+temp1);
	    int temp2=Math.max(calch(y.getLeft()),x.getHeight());						//Height calculations		
	    y.setHeight(1+temp2);
		return y;
	}
	
	
	
	/**
	 * Simple Left rotate function (Case 1).
	 * It updates 'height' of all the nodes affected
	 * @param x
	 * @return
	 */
	public static Node singleLRotate(Node x)
	{
		Node y;
		y=x.getRight();
		x.setRight(y.getLeft());
		y.setLeft(x);
		int temp1=Math.max(calch(x.getLeft()),calch(x.getRight()));						//Height calculations
		x.setHeight(temp1+1);
		int temp2= Math.max(x.getHeight(),calch(y.getLeft()));							//Height calculations
		y.setHeight(temp2+1);
		return y;
	}
	
	
	/**
	 * Double Rotation by calling 'Left Rotate' first followed by 'Right Rotate'
	 * @param x
	 * @return
	 */
	public static Node doubleRRotate(Node x)
	{	Node y;
		Node temp;
		temp = singleLRotate(x.getLeft());												//Simple Left rotate
		x.setLeft(temp);
		y=singleRRotate(x);																//Simple Right rotate
		return y;
	}
	
	
	
	
	/**
	 * Double Rotation by calling 'Right Rotate' first followed by 'Left Rotate'
	 * @param x
	 * @return
	 */
	public static Node doubleLRotate(Node x)
	{	Node y;
		Node temp;
		temp = singleRRotate(x.getRight());												//Simple Right rotate 
		x.setRight(temp);
		y=singleLRotate(x);																//Simple Left rotate
		return y;
	}
	
	
	/**
	 * Insertion function.
	 * Checks if the 'key' of node to be inserted is smaller than or greater than the current Node.
	 * Traverses the Tree using 'getLeft' or 'getRight' of the Node depending on the key. 
	 * Creates a new Node of type 'Node' when it finds an empty slot, and inserts it there.
	 * Then checks the balance of the tree. If tree is unbalanced, then rotates depending on the balance.
	 * Calculates the height of the inserted Node and returns the root of the tree
	 * @param key
	 * @param value
	 * @param n
	 * @return
	 */
	public Node avlInsert(int key,int value, Node n)
	{	Node node;
		if (n==null)												//Empty slot so insert
			n=new Node(key,value);									
		
		else if (key<n.getKey())									//Key is lesser so traverse left
		{
			node=avlInsert(key,value,n.getLeft());	 				//Recursive Insert procedure
			n.setLeft(node);										
			int temp1=calch(n.getLeft());							//Height Calculations		
			int temp2=calch(n.getRight());							//Height Calculations	
			if(temp1-temp2==2)										//Unbalanced
				{
				Node n1=n.getLeft();
				if (key<n1.getKey())						
					n=singleRRotate(n);								//Single rotation needed 
				else n=doubleRRotate(n);							//Double rotation needed
				}
		}
		
		else if (key>n.getKey())									//Key is greater so traverse right
		{
			node=avlInsert(key,value,n.getRight());				
			n.setRight(node);
			int temp1=calch(n.getLeft());							//Height Calculations
			int temp2=calch(n.getRight());							//Height Calculations
			if(temp2-temp1==2)										//Unbalanced
				{
				Node n1=n.getRight();
				if (key>n1.getKey())
					n=singleLRotate(n);								//Single rotation needed
				else n=doubleLRotate(n);							//Double rotation needed
				}
		}
		int temp1= calch(n.getLeft());
		int temp2= calch(n.getRight());
		n.setHeight(1+Math.max(temp1,temp2));
		return n;				
	}
	
	
	/**
	 * Recursively traverses left child then right child. 
	 * Prints 'left child' then 'parent', then 'right child'.
	 * Prints all nodes in sorted order.
	 * @param n
	 */
	public void inOrder(Node n) 
	{
		
		if(n.getLeft()!=null)
			inOrder(n.getLeft());
		//System.out.print(n.getValue()+" ");
		Dictionary.AVLIo.printf(n.getValue()+" ");
		if(n.getRight()!=null) 
			inOrder(n.getRight());
	}
	
	
	/**
	 * Recursively traverses left child then right child. 
	 * Prints 'left child' then 'right child', then 'parent'.
	 * @param n
	 */
	public void postOrder(Node n) 
	{
		if(n.getLeft()!=null)
			postOrder(n.getLeft());
		if(n.getRight()!=null) 
			postOrder(n.getRight());
		Dictionary.AVLPo.printf(n.getValue()+" ");
		//System.out.print(n.getValue()+" ");
	}
	
	public void inOrderh(Node n) 
	{
		
		if(n.getLeft()!=null)
			inOrderh(n.getLeft());
		//System.out.print(n.getValue()+" ");
		Dictionary.AVLhashIo.printf(n.getValue()+" ");
		if(n.getRight()!=null) 
			inOrderh(n.getRight());
	}
	
	
	/**
	 * Recursively traverses left child then right child. 
	 * Prints 'left child' then 'right child', then 'parent'.
	 * @param n
	 */
	public void postOrderh(Node n) 
	{
		if(n.getLeft()!=null)
			postOrderh(n.getLeft());
		if(n.getRight()!=null) 
			postOrderh(n.getRight());
		Dictionary.AVLhashPo.printf(n.getValue()+" ");
		//System.out.print(n.getValue()+" ");
	}
}
