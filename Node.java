public class Node {
	
	
	//Declaration
	private int key, value;
	private Node left;
	private Node right;
	private int height;
	
	
	
	/**
	 * Constructor
	 * @param key
	 * @param value
	 */
	public Node(int key,int value)
	{
		this.value=value;
		this.key=key;
		left=null;
		right=null;
		height=0;
	}
	
	
	/**
	 * Returns 'value' of the node
	 * @return
	 */
	public int getValue()
	{
		return value;
	}
	
	
	
	/**
	 * Sets 'value' of the node
	 * @param value
	 */
	public void setValue(int value)
	{
		this.value=value;
	}
	
	
	/**
	 * Returns 'key' of the node
	 * @return
	 */
	public int getKey()
	{
		return key;
	}
	
	
	
	/**
	 * Sets 'key' of the node
	 * @param key
	 */
	public void setKey(int key)
	{
		this.key=key;
	}
	
	
	
	/**
	 * Returns 'left' child of the nod
	 * @return
	 */
	public Node getLeft()
	{
		return left;
	}
	
	
	/**
	 * Sets 'left' child of the node
	 * @param l
	 */
	public void setLeft(Node l)
	{
		this.left=l;
	}
	
	
	
	
	/**
	 * Sets 'right'child of the node
	 * @param r
	 */
	public void setRight(Node r)
	{
		this.right=r;
	}
	
	
	
	/**
	 * Returns 'right' child of the node
	 * @return
	 */
	public Node getRight()
	{
		return right;
	}
	
	
	
	/**
	 * Sets the 'height' of the Node
	 * @param h
	 */
	public void setHeight(int h)
	{
		this.height=h;
	}
	
	
	
	
	/**
	 * Returns the 'height' of the Node
	 * @return
	 */
	public int getHeight()
	{
		return height;
	}
}	


