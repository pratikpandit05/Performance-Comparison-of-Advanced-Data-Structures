
public class AVLHash {
	
	
	/**
	 * Inserts node in the AVLTree according to their hashcode
	 * @param key
	 * @param value
	 * @param hashtable
	 * @param hashcode1
	 */
	public static void AVLHashInsert(int key,int value,Node[] hashtable,int hashcode1)
	{
		AVL avltree=new AVL();
		hashtable[hashcode1]=avltree.avlInsert(key,value,hashtable[hashcode1]);									//Values inserted
	}
	
	/**
	 * Searches all the 1000000 nodes in the AVLTrees according to their hashcode
	 * @param key
	 * @param hashtable
	 * @param hashcode2
	 */
	public static void AVLHashSearch(int key,Node[] hashtable,int hashcode2)
	{	
		AVL avltree=new AVL();
		Node search=avltree.search(key,hashtable[hashcode2]);													//Values searched
	}
	
	
	/**
	 * Calls the postOrder of AVLTree
	 * @param n
	 */
	public void postOrder(Node n) 
	{
		AVL avltree=new AVL();																					
		avltree.postOrder(n);																					//Call
	}
	
	
	
	/**
	 * Calls the inOrder tree method of AVLTree
	 * @param n
	 */
	public void inOrder(Node n) 
	{
		AVL avltree=new AVL();
		avltree.inOrder(n);																						//Call
	}
	
	
}
	


