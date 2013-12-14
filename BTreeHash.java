public class BTreeHash {
	/**
	 * Inserts Node into the Btree corresponding to the calculated 'hashcode'
	 * @param key
	 * @param value
	 * @param btreeh
	 * @param hashcode5
	 */
	public void BTreeHashInsert(int key,int value,BTree[] btreeh,int hashcode5)
	{
		btreeh[hashcode5].BTreeInsert(key,value);
	}
	
	
	/**
	 * Searches Node from the Btree corresponding to the calculated 'hashcode'
	 * @param key
	 * @param btreeh
	 * @param hashcode6
	 */
	public void BTreeHashSearch(int key,BTree[] btreeh,int hashcode6)
	{
		btreeh[hashcode6].BTreeSearch(key);
		
	}
	
		
	
}
