import java.util.TreeMap;


public class RBHash {
	/**
	 * Inserts node into the 'hashcode' corresponding Red-Black Tree using TreeMap functionality
	 * @param key
	 * @param value
	 * @param tm
	 * @param hashcode3
	 */
	public void RBHashInsert(int key,int value,TreeMap<Integer, Integer> tm[],int hashcode3)
	{	
		tm[hashcode3].put(key,value);
	}
	
	/**
	 * Searches node in the 'hashcode' corresponding Red-Black tree using TreeMap functionality 
	 * @param key
	 * @param tm
	 * @param hashcode4
	 */
	public void RBHashSearch(int key,TreeMap<Integer, Integer> tm[],int hashcode4)
	{
		tm[hashcode4].get(key);
	}
	
}
